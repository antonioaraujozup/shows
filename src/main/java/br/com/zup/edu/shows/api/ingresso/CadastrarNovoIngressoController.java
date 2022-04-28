package br.com.zup.edu.shows.api.ingresso;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarNovoIngressoController {

    private final IngressoRepository repository;

    public CadastrarNovoIngressoController(IngressoRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/ingressos")
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid IngressoRequest request, UriComponentsBuilder uriComponentsBuilder) {

        if (repository.existsByNumeroAndDataEvento(request.getNumero(), request.getDataEvento())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Ingresso com número informado já existente para a data informada");
        }

        Ingresso ingresso = request.toModel();

        repository.save(ingresso);

        URI location = uriComponentsBuilder.path("/ingressos/{id}")
                .buildAndExpand(ingresso.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
