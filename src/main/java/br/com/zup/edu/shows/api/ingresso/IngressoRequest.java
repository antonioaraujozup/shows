package br.com.zup.edu.shows.api.ingresso;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class IngressoRequest {

    @NotBlank
    private String nomeCliente;

    @NotNull
    @CPF
    private String cpfCliente;

    @NotBlank
    private String numero;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEvento;

    public IngressoRequest(String nomeCliente, String cpfCliente, String numero, LocalDate dataEvento) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.numero = numero;
        this.dataEvento = dataEvento;
    }

    public IngressoRequest() {
    }

    public Ingresso toModel() {
        return new Ingresso(nomeCliente,cpfCliente,numero,dataEvento);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }
}
