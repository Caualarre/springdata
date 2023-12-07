package br.edu.ifsul.cstsi.springdata.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository rep;

    public Filme insert(Filme filme) {
        Assert.isNull(filme.getId(),"Não foi possível inserir o registro");
        return rep.save(filme);
    }
    public Filme update(Filme filme) {
        Assert.notNull(filme.getId(),"Não foi possível atualizar o registro");

        // Busca o produto no banco de dados
        Optional<Filme> optional = rep.findById(filme.getId());
        if(optional.isPresent()) {
            Filme db = optional.get();
            // Copiar as propriedades
            db.setTitulo(filme.getTitulo());
            db.setDuracao(filme.getDuracao());

            // Atualiza o produto
            rep.save(db);

            return db;
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public Filme getFilmeById(Long id) {
        Optional<Filme> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
    public void delete(Long id) {
        rep.deleteById(id);
    }
}
