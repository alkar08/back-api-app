package com.exponencialconfirming.backend.apirest.models.services;

import java.util.List;

import com.exponencialconfirming.backend.apirest.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
	public Producto saveProducto(Long tiendaId, Producto producto);
	
	public List<Producto> findProductoByTiendaId(Long tiendaId);
	
	public Producto findProductoById(Long tiendaId, Long productoId);
	
	public Producto updateProducto(Long tiendaId, Long productoId, Producto dataProducto);
	
	public Producto save(Producto producto);
	
	public void deleteProducto(Long tiendaId, Long productoId);

}
