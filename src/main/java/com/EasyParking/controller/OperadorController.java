package com.EasyParking.controller;

import com.EasyParking.entity.Operador;
import com.EasyParking.service.OperadorService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class OperadorController {

    @Autowired
    private OperadorService operadorService;

    @GetMapping("/")
    public String inicio(Model model) {
        var operadores = operadorService.listarOperador();
        log.info("Buscar todos los registros");
        model.addAttribute("operadores", operadores);
        return "Operador";
    }

    @GetMapping("/agregar")
    public String agregar(Operador operador) {
        return "AgregarOperador";
    }

    @PostMapping("/guardar")
    public String guardar(Operador operador) {
        operadorService.guardar(operador);
        log.info("operador guardado");
        return "redirect:/";
    }

    @GetMapping("/editar/{idoperador}")
    public String editar(Operador operador, Model model) {
        operador = operadorService.encontrarOperador(operador);
        model.addAttribute("operador", operador);
        log.info("operador encontrado");
        return "AgregarOperador";
    }

    @GetMapping("/eliminar")
    public String eliminar(Operador operador) {
        operadorService.eliminarOperador(operador);
        return "redirect:/";
    }
}
