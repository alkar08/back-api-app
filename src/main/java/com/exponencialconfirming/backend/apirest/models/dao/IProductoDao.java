package com.exponencialconfirming.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.exponencialconfirming.backend.apirest.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{
	
	public List<Producto> findByTiendaId(Long tiendaId);

}
