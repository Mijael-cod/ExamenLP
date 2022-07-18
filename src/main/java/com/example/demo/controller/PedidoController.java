package com.example.demo.controller;

import com.example.demo.entity.Pedido;
import com.example.demo.servicios.PedidoService;
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


/**
 *
 * @author mijael
 */

@Controller
@RequestMapping("/prod")

public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;
    
    @GetMapping("/all")
    public String listarPed(Model model){
        model.addAttribute("pedidos", pedidoService.readAll());
        return "prod/listarPed";
    }
    @GetMapping("/form")
    public String createPed(Model model){
        model.addAttribute("titulo", "Registrar Pedido");
        model.addAttribute("pedidos", new Pedido());
        return "prod/formPed";
    }
    
    @PostMapping("/add")
    public String savePed(@Valid @ModelAttribute Pedido ped, BindingResult result, Model model, RedirectAttributes attributes){
        pedidoService.create(ped);
        return "redirect:/prod/all";
    }
    @GetMapping("/del/{id}")
    public String deletePed(Model model, @PathVariable("id") Integer idped ){
        pedidoService.delete(idped);
        return "redirect:/prod/all";
    }
    @GetMapping("/edit/{id}")
    public String editPed(Model model, @PathVariable("id") Integer idped ){
        Pedido pedido = pedidoService.read(idped);
        model.addAttribute("titulo", "Modificar Pedido");
        model.addAttribute("pedidos", pedido);
        return "prod/formPed";
    }
    @PostMapping("/{id}")
    public String readPed(Model model, @PathVariable("id") Integer idped ){
        model.addAttribute("prod", pedidoService.read(idped));
        return "redirect:/prod";
    }
    
}