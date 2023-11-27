package com.example.Empresa.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Empresa.modelos.Cliente;
import com.example.Empresa.serviceImpl.ClientesServiceImpl;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClientesServiceImpl clientesServiceImpl;
	
	
	@GetMapping("/clientes")
	public List<Cliente> index() {
		return clientesServiceImpl.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente indexid(@PathVariable Long id) {
		return clientesServiceImpl.findById(id);
	}
	
	@GetMapping("/clientes/nombre/{nombre}")
	public Cliente indexnombre(@PathVariable String nombre) {
		return (Cliente) clientesServiceImpl.findByNombre(nombre);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		cliente.setCreateAt(new Date());
		this.clientesServiceImpl.save(cliente);
		return cliente;
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente currentCliente = this.clientesServiceImpl.findById(id);
		currentCliente.setNombre(cliente.getNombre());
		currentCliente.setApellido(cliente.getApellido());
		currentCliente.setEmail(cliente.getEmail());
		this.clientesServiceImpl.save(currentCliente);
		return currentCliente;

}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Cliente currentCliente = this.clientesServiceImpl.findById(id);
		this.clientesServiceImpl.delete(currentCliente);
	}
}