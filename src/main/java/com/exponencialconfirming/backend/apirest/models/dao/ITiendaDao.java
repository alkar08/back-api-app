package com.exponencialconfirming.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.exponencialconfirming.backend.apirest.models.entity.Tienda;

public interface ITiendaDao extends CrudRepository<Tienda, Long> {
	  
}
