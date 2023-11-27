package com.example.Empresa.service;

import java.util.List;

import com.example.Empresa.modelos.Cliente;

public interface ClienteService {

	public List<Cliente> findAll();

	public void save(Cliente cliente);

	public Cliente findById(Long id);

	public void delete(Cliente cliente);
	
	public Cliente findByNombre(String nombre);

}
