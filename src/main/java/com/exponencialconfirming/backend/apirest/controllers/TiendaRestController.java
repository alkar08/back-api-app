package com.exponencialconfirming.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exponencialconfirming.backend.apirest.models.entity.Tienda;
import com.exponencialconfirming.backend.apirest.models.services.ITiendaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TiendaRestController {
	
	
	@Autowired
	private ITiendaService tiendaService;
	
	@GetMapping("/tiendas")
	public List<Tienda> index(){
		//return tiendaService.findAll();
		return tiendaService.findAll();
	}
	
	@GetMapping("/tiendas/{id}")
	public Tienda show(@PathVariable Long id) {
		return tiendaService.findById(id);
	}
	
	@PostMapping("/tiendas")
	@ResponseStatus(HttpStatus.CREATED)
	public Tienda create(@RequestBody Tienda tienda) {
		return tiendaService.save(tienda);
	}
	
	@PutMapping("/tiendas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Tienda update(@RequestBody Tienda tienda, @PathVariable Long id) {
		Tienda tiendaActual = tiendaService.findById(id);
		tiendaActual.setNombre(tienda.getNombre());
		return tiendaService.save(tiendaActual);
	}
	
	@DeleteMapping("/tiendas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		tiendaService.delete(id);
	}
}
