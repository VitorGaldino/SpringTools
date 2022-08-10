package com.blogpessoal56.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpessoal56.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
public Optional<Usuario> findByUsuario(String usuario);
}