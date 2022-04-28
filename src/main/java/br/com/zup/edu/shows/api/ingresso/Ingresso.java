package br.com.zup.edu.shows.api.ingresso;

import javax.persistence.*;
import java.time.LocalDate;

@Table(uniqueConstraints = {
        @UniqueConstraint(name = "Unique_Ingresso_numero_data_evento",
                columnNames = {"numero", "dataEvento"})
})
@Entity
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCliente;

    @Column(nullable = false, length = 11)
    private String cpfCliente;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private LocalDate dataEvento;

    public Ingresso(String nomeCliente, String cpfCliente, String numero, LocalDate dataEvento) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.numero = numero;
        this.dataEvento = dataEvento;
    }

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Ingresso() {
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }
}
