package com.EasyParking.controller;

import com.EasyParking.repository.OperadorRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@Slf4j
public class OperadorController {

    @Autowired
    private OperadorRepository operadorRepository;

    @GetMapping("/")
    public String inicio (Model model){
        var operadores = operadorRepository.findAll();
        log.info("Buscar todos los registros");
        model.addAttribute("operadores",operadores);
        return "index";
    }
}
