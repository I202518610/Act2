package com.example.LP2_T2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.LP2_T2.model.Inventario;
import com.example.LP2_T2.service.InventarioService;
import com.example.LP2_T2.service.ProductoService;
import com.example.LP2_T2.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("inventario")
@RequiredArgsConstructor
public class InventarioController {
	
	private final InventarioService inventarioService;
	private final ProductoService productoService;
	
	
	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("inventarios", inventarioService.getAll());
		return "inventario/listado";
	}
	
	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("productos", productoService.getAll());
		model.addAttribute("inventario", new Inventario());
		return "inventario/nuevo";
	}
	
	@PostMapping("crear")
	public String registrar(@ModelAttribute Inventario inventario,
			RedirectAttributes flash) {
		var response = inventarioService.create(inventario);
		flash.addFlashAttribute("alert", Alert.sweetToast(response.mensaje(), "success",4000));
		
		return "redirect:/inventario/listado";
	}
	
	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id,
			Model model) {
		model.addAttribute("productos", productoService.getAll());
		model.addAttribute("inventario", inventarioService.getOne(id));
		return "inventario/edicion";
	}
	
	
	@PostMapping("actualizar")
	public String actualizar(@ModelAttribute Inventario inventario,
			RedirectAttributes flash) {
		var response = inventarioService.update(inventario);
		flash.addFlashAttribute("alert", Alert.sweetToast(response.mensaje(), "success",4000));
		
		return "redirect:/inventario/listado";
	}
	
	

	

}
