package br.edu.ifsul.cstsi.springdata.salas;

import br.edu.ifsul.cstsi.springdata.sessoes.Sessao;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Sala")
@Table(name = "salas")
public class Sala {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nrosala;
    private int capacidade;

    public int conSala() {
        return 0;
    }
    @OneToMany(mappedBy = "sala")
    private List<Sessao> sessoes;
}
