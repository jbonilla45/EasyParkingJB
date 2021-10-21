package com.EasyParking.controller;

import com.EasyParking.entity.Operador;
import com.EasyParking.service.OperadorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@Slf4j
public class OperadorController {

    @Autowired
    private OperadorService operadorService;

    @GetMapping("/")
    public String inicio() {

        return "home";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Operador> operadores = operadorService.listarOperador();
        log.info("Buscar todos los registros");
        model.addAttribute("operadores", operadores);
        model.addAttribute("totalOperadores", operadores.size());
        return "Operador";
    }

    @GetMapping("/agregar")
    public String agregar(Operador operador) {
        return "AgregarOperador";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Operador operador, Errors errors) {
        if (errors.hasErrors()){
            return "home";
        }
        operadorService.guardar(operador);
        log.info("operador guardado");
        return "redirect:/listar";
    }

    @GetMapping("/editar/{idoperador}")
    public String editar(Operador operador, Model model) {
        operador = operadorService.encontrarOperador(operador);
        model.addAttribute("operador", operador);
        log.info("operador encontrado");
        return "AgregarOperador";
    }

    @GetMapping("/eliminar/{idoperador}")
    public String eliminar(Operador operador) {
        operadorService.eliminarOperador(operador);
        log.info("operador eliminado");
        return "redirect:/listar";
    }
}
