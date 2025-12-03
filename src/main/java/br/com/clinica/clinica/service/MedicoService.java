package br.com.clinica.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinica.clinica.entity.Medico;
import br.com.clinica.clinica.repository.MedicoRepository;

@Service
public class MedicoService {

    // Injeção de dependência do repositório de médicos
    @Autowired
    private MedicoRepository medicoRepository; 

    // Método para salvar médico
    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    // Método para listar todos os médicos
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    // Método para excluir um médico pelo ID
    public void deleteById(Integer id) {
        medicoRepository.deleteById(id);
    }

    // Método para buscar médico pelo ID
    public Medico findById(Integer id) {
        return medicoRepository.findById(id).orElse(null);
    }
}
