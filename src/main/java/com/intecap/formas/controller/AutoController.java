package com.intecap.formas.controller;

import com.intecap.formas.modelo.Auto;
import com.intecap.formas.serviceInterface.IAutoService;
import net.bytebuddy.implementation.bytecode.ShiftRight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AutoController {
@Autowired
    private IAutoService service;
    @GetMapping("/listar")
    public String listar_auto(Model model) {
        model.addAttribute("autos", service.listar_auto());
        return "index";
    }

    @GetMapping("/listar/{id}")
    public String listarIdAuto (@PathVariable int id, Model model){
        model.addAttribute("autos", service.listarIdAuto(id));
        return "form";
    }


    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("autos", new Auto());
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar (Auto a, Model model){
        int id = service.guardar(a);
        if (id==0){
            return "form";
        }
        return "redirect:/listar";
    }

    @GetMapping("/delete/{id}")
    public String borrar (@PathVariable int id, Model model){
        service.borrar(id);
        return "redirect:/listar";
    }
}
