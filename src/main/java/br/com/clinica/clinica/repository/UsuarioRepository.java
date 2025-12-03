package br.com.clinica.clinica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinica.clinica.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Optional<Usuario> findByLoginUsuario(String loginUsuario);

}