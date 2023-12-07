package br.edu.ifsul.cstsi.springdata.ingressos;

import br.edu.ifsul.cstsi.springdata.sessoes.Sessao;
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