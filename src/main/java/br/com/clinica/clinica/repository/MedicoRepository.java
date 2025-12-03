package br.com.clinica.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinica.clinica.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer>{ //integer e a chave primaria{
    
}
