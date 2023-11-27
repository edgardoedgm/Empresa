package com.example.Empresa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Empresa.modelos.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findByNombre(@Param("nombre") String nombre);

}
