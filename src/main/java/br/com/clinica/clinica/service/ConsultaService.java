package br.com.clinica.clinica.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.clinica.clinica.entity.Consulta;
import br.com.clinica.clinica.repository.ConsultaRepository;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public void deleteById(Integer id) {
        consultaRepository.deleteById(id);
    }

    public Consulta findById(Integer id) {
        return consultaRepository.findById(id).orElse(null);
    }
}
