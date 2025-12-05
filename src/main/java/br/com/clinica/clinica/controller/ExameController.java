package br.com.clinica.clinica.controller;

import br.com.clinica.clinica.entity.Exame;
import br.com.clinica.clinica.entity.Paciente;
import br.com.clinica.clinica.service.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exames") // /exames/...
public class ExameController {

    @Autowired
    private ExameService exameService;

    // Método para abrir o formulário de criação de exames
    @GetMapping("/criar") // /exames/criar
    public String criarForm(Model model) {
        model.addAttribute("exame", new Exame());
        return "exame/formularioExame"; // view: templates/exame/formularioExame.html
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Exame exame) {
        exameService.save(exame);
        return "redirect:/exames/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Exame> exames = exameService.findAll();
        model.addAttribute("exames", exames);
        return "exame/listaExame"; // view: templates/exame/listaExame.html
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        exameService.deleteById(id);
        return "redirect:/exames/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Exame exame = exameService.findById(id);
        model.addAttribute("exame", exame);
        return "exame/formularioExame";
    }

    // ---------- NOVO: listar pacientes vinculados a um exame ----------

    @GetMapping("/{id}/pacientes")
    public String listarPacientesDoExame(@PathVariable Integer id, Model model) {

        Exame exame = exameService.findById(id);
        if (exame == null) {
            return "redirect:/exames/listar";
        }

        List<Paciente> pacientes = exame.getPacientes(); // ManyToMany

        model.addAttribute("exame", exame);
        model.addAttribute("pacientes", pacientes);

        return "exame/pacientesExame"; // templates/exame/pacientesExame.html
    }
}
    