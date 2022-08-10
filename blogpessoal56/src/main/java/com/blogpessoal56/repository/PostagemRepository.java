package com.blogpessoal56.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.blogpessoal56.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
}
