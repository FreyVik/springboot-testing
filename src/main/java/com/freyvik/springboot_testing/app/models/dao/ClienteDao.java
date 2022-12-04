package com.freyvik.springboot_testing.app.models.dao;

import java.util.List;

import com.freyvik.springboot_testing.app.models.entity.Cliente;

public interface ClienteDao {
	
	public List<Cliente> findAll();

	public void save(Cliente cliente);
}
