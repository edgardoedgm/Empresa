package com.example.Empresa.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Empresa.Repository.ClientesRepository;
import com.example.Empresa.modelos.Cliente;
import com.example.Empresa.service.ClienteService;

@Service
public class ClientesServiceImpl implements ClienteService {

	@Autowired
	private ClientesRepository clientesRepository;

	@Override
	public List<Cliente> findAll() {

		return clientesRepository.findAll();
	}

	@Override
	public void save(Cliente cliente) {
		clientesRepository.save(cliente);

	}

	@Override
	public Cliente findById(Long id) {

		return clientesRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Cliente cliente) {
		clientesRepository.delete(cliente);

	}

	@Override
	public Cliente findByNombre(String nombre) {
		
		return clientesRepository.findByNombre(nombre);
	}

}
