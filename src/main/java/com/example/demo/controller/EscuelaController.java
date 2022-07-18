package com.example.demo.controller;

import com.example.demo.entity.Escuela;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.servicios.EscuelaService;

/**
 *
 * @author mijaell
 */


@Controller
@RequestMapping("/cate")

public class EscuelaController {
    
    @Autowired
    private EscuelaService escuelaService;
    
    @GetMapping("/all")
    public String listarEsc(Model model){
        //String keyword = "Yogurt";
        model.addAttribute("escuela", escuelaService.readAll());
        return "cate/listarEsc";
    }
    
    @GetMapping("/form")
    public String createEsc(Model model){
        model.addAttribute("titulo", "Registrar Escuela");
        model.addAttribute("escuela", new Escuela());
        return "prod/formEsc";
    }
    
    @PostMapping("/add")
    public String saveEsc(@Valid @ModelAttribute Escuela esc, BindingResult result, Model model, RedirectAttributes attributes){
        escuelaService.create(esc);
        //model.addAttribute("categorias", categoriaService.readAll());
        return "redirect:/prod/all";
    }
    
    @GetMapping("/del/{id}")
    public String deleteEsc(Model model, @PathVariable("id") Integer idesc ){
        escuelaService.delete(idesc);
        return "redirect:/prod/all";
    }
    
    @GetMapping("/edit/{id}")
    public String editEsc(Model model, @PathVariable("id") Integer idesc ){
        Escuela escuela = escuelaService.read(idesc);
        model.addAttribute("titulo", "Modificar Escuela");
        model.addAttribute("escuela", escuela);
        return "prod/formEsc";
    }
    
    @PostMapping("/{id}")
    public String readEsc(Model model, @PathVariable("id") Integer idesc ){
        model.addAttribute("prod", escuelaService.read(idesc));
        return "redirect:/prod";
    }
    
}