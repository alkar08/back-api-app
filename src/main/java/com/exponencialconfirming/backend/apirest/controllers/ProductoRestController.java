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

import com.exponencialconfirming.backend.apirest.models.entity.Producto;
import com.exponencialconfirming.backend.apirest.models.services.IProductoService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductoRestController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto> index(){
		return productoService.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public Producto show(@PathVariable Long id) {
		return productoService.findById(id);
	}
	
	
	@GetMapping("/tiendas/{tiendaId}/productos")
	public List<Producto> showProductosByTiendaId(@PathVariable Long tiendaId) {
		return productoService.findProductoByTiendaId(tiendaId);
	}
	
	@GetMapping("/tiendas/{tiendaId}/productos/{productoId}")
	public Producto findProductoById(@PathVariable Long tiendaId, @PathVariable Long productoId) {
		return productoService.findProductoById(tiendaId, productoId);
	}
	
	
	@PostMapping("/tiendas/{tiendaId}/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@PathVariable Long tiendaId, @RequestBody Producto producto) {
		return productoService.saveProducto(tiendaId, producto);
	}
	
	@PutMapping("/tiendas/{tiendaId}/productos/{productoId}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@PathVariable Long tiendaId, @PathVariable Long productoId, @RequestBody Producto dataProducto) {
		return productoService.updateProducto(tiendaId, productoId, dataProducto);
	}
	
	@DeleteMapping("/tiendas/{tiendaId}/productos/{productoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long tiendaId, @PathVariable Long productoId) {
		productoService.deleteProducto(tiendaId, productoId);
	}

}
