package br.edu.ifsul.cstsi.springdata.filmes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme,Long> {

}
