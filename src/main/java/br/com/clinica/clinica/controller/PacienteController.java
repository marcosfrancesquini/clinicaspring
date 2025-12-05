package br.com.clinica.clinica.controller;

import br.com.clinica.clinica.entity.Paciente;
import br.com.clinica.clinica.entity.Exame;
import br.com.clinica.clinica.service.PacienteService;
import br.com.clinica.clinica.service.ExameService;
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

    @Autowired
    private ExameService exameService; // <-- novo

    // ---------- CRUD PACIENTE ----------

    // formulário de criação
    @GetMapping("/criar") // /pacientes/criar
    public String criarForm(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "paciente/formularioPaciente"; // templates/paciente/formularioPaciente.html
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
        return "paciente/listaPaciente"; // templates/paciente/listaPaciente.html
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

    // ---------- EXAMES DO PACIENTE (N:N) ----------

    // abrir tela para gerenciar exames de um paciente
    @GetMapping("/{id}/exames")
    public String mostrarExamesPaciente(@PathVariable Integer id, Model model) {

        Paciente paciente = pacienteService.findById(id);
        List<Exame> todosExames = exameService.findAll();

        model.addAttribute("paciente", paciente);
        model.addAttribute("todosExames", todosExames);

        return "paciente/examesPaciente"; // templates/paciente/examesPaciente.html
    }

    // salvar exames selecionados para o paciente
    @PostMapping("/{id}/exames")
    public String salvarExamesPaciente(@PathVariable Integer id,
                                       @RequestParam(name = "examesIds", required = false) List<Integer> examesIds) {

        Paciente paciente = pacienteService.findById(id);

        if (examesIds != null && !examesIds.isEmpty()) {
            List<Exame> examesSelecionados = exameService.findAllById(examesIds);
            paciente.setExames(examesSelecionados);
        } else {
            // se nenhum exame foi selecionado, limpa a lista
            paciente.getExames().clear();
        }

        pacienteService.save(paciente);

        return "redirect:/pacientes/listar";
    }
}

