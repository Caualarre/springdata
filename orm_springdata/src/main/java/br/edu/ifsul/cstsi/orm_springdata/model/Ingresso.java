package br.edu.ifsul.cstsi.orm_springdata.model;

import jakarta.persistence.*;

@Entity(name = "Ingresso")
@Table(name = "ingressos")
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tipo;

    public int getIng() {
        return 0;
    }
    @ManyToOne
    @JoinColumn(name = "sessao_id")
    private Sessao sessao;
}
