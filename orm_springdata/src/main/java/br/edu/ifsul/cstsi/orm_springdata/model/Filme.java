package br.edu.ifsul.cstsi.orm_springdata.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.List;

@Entity(name = "Filme")
@Table(name = "filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String titulo;
    private Time duracao;

    public String conFilme() {
        return null;
    }
    @OneToMany(mappedBy = "filme")
    private List<Sessao> sessoes;
}
