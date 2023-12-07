package br.edu.ifsul.cstsi.springdata.sessoes;

import br.edu.ifsul.cstsi.springdata.filmes.Filme;
import br.edu.ifsul.cstsi.springdata.ingressos.Ingresso;
import br.edu.ifsul.cstsi.springdata.salas.Sala;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity(name = "Sessao")
@Table(name = "sessoes")
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dt_sessao;
    private Time hor_sessao;
    private  double valor_inteira;
    private double valor_meia;
    private int encerrada;

    public String selSessao() {
        return null;
    }
    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;
    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;
    @OneToMany(mappedBy = "sessao")
    private List<Ingresso> ingressos;
}