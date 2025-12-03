package br.com.clinica.clinica.service;

import br.com.clinica.clinica.entity.Exame;
import br.com.clinica.clinica.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;

    public Exame save(Exame exame) {
        return exameRepository.save(exame);
    }

    public List<Exame> findAll() {
        return exameRepository.findAll();
    }

    public void deleteById(Integer id) {
        exameRepository.deleteById(id);
    }

    public Exame findById(Integer id) {
        return exameRepository.findById(id).orElse(null);
    }
}
