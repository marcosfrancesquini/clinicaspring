package br.com.clinica.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.clinica.clinica.entity.Consulta;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    // Se Medico tem campo "id", use assim:
    List<Consulta> findByMedicoIdOrderByDataConsultaAsc(Integer id);
}
