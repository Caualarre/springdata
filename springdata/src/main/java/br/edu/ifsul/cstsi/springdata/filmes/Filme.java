package br.edu.ifsul.cstsi.springdata.filmes;

import br.edu.ifsul.cstsi.springdata.sessoes.Sessao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalTime;
import java.util.List;

@Entity(name = "Filme")
@Table(name = "filmes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String titulo;
    private String duracao;
//SÓ PRA DAR COMMIT
    @OneToMany(mappedBy = "filme",fetch = FetchType.EAGER)
    private List<Sessao> sessoes;
}
