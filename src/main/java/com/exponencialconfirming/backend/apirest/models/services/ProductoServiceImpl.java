package com.exponencialconfirming.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpStatusCodeException;

import com.exponencialconfirming.backend.apirest.models.dao.IProductoDao;
import com.exponencialconfirming.backend.apirest.models.dao.ITiendaDao;
import com.exponencialconfirming.backend.apirest.models.entity.Producto;
import com.exponencialconfirming.backend.apirest.models.entity.Tienda;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDao productoDao;

	@Autowired
	private ITiendaDao tiendaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public Producto saveProducto(Long tiendaId, Producto producto) {
		Tienda tienda = tiendaDao.findById(tiendaId).orElse(null);
		producto.setTienda(tienda);
		Producto nuevoProducto = productoDao.save(producto);
		return nuevoProducto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findProductoByTiendaId(Long tiendaId) {

		List<Producto> productos = productoDao.findByTiendaId(tiendaId);
		return productos;
	}

	@SuppressWarnings("serial")
	@Override
	@Transactional(readOnly = true)
	public Producto findProductoById(Long tiendaId, Long productoId) {
		Tienda tienda = tiendaDao.findById(tiendaId).orElse(null);
		Producto producto = productoDao.findById(productoId).orElse(null);

		if (!producto.getTienda().getId().equals(tienda.getId())) {
			throw new HttpStatusCodeException(HttpStatus.BAD_REQUEST, "El producto no pertene a la tienda") {
			};
		}

		return producto;
	}

	@SuppressWarnings("serial")
	@Override
	@Transactional
	public Producto updateProducto(Long tiendaId, Long productoId, Producto dataProducto) {
		Tienda tienda = tiendaDao.findById(tiendaId).orElse(null);
		Producto producto = productoDao.findById(productoId).orElse(null);

		if (!producto.getTienda().getId().equals(tienda.getId())) {
			throw new HttpStatusCodeException(HttpStatus.BAD_REQUEST, "El producto no pertene a la tienda") {	
			};
		}
		
		producto.setNombre(dataProducto.getNombre());
		producto.setDescripcion(dataProducto.getDescripcion());
		producto.setPrecio(dataProducto.getPrecio());
		
		Producto productoActualizado = productoDao.save(producto);
		return productoActualizado;

	}

	@SuppressWarnings("serial")
	@Override
	@Transactional
	public void deleteProducto(Long tiendaId, Long productoId) {
		Tienda tienda = tiendaDao.findById(tiendaId).orElse(null);
		Producto producto = productoDao.findById(productoId).orElse(null);
		if (!producto.getTienda().getId().equals(tienda.getId())) {
			throw new HttpStatusCodeException(HttpStatus.BAD_REQUEST, "El producto no pertene a la tienda") {	
			};
		}
		
		productoDao.delete(producto);
		
	}

}
