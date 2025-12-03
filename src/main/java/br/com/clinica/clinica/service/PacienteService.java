package br.com.clinica.clinica.service;

import br.com.clinica.clinica.entity.Paciente;
import br.com.clinica.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public void deleteById(Integer id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente findById(Integer id) {
        return pacienteRepository.findById(id).orElse(null);
    }
}
