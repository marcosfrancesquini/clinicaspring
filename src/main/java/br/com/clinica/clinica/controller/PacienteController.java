package br.com.clinica.clinica.controller;

import br.com.clinica.clinica.entity.Paciente;
import br.com.clinica.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pacientes") // /pacientes/...
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Método para abrir o formulário de criação de pacientes
    @GetMapping("/criar") // /pacientes/criar
    public String criarForm(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "paciente/formularioPaciente"; // view: templates/paciente/formularioPaciente.html
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Paciente paciente) {
        pacienteService.save(paciente);
        return "redirect:/pacientes/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Paciente> pacientes = pacienteService.findAll();
        model.addAttribute("pacientes", pacientes);
        return "paciente/listaPaciente"; // view: templates/paciente/listaPaciente.html
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        pacienteService.deleteById(id);
        return "redirect:/pacientes/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Paciente paciente = pacienteService.findById(id);
        model.addAttribute("paciente", paciente);
        return "paciente/formularioPaciente";
    }
}
