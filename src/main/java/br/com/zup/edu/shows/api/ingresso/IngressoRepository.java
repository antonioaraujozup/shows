package br.com.zup.edu.shows.api.ingresso;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface IngressoRepository extends JpaRepository<Ingresso,Long> {

    boolean existsByNumeroAndDataEvento(String numero, LocalDate dataEvento);

}
