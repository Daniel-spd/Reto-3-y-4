package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Producto;

public interface ProductoService {
	public List<Producto> findAll();
	public Page<Producto> findAll(Pageable paginable);
	public Optional<Producto> findById(Long id);
	public List<Producto> findIdentificadorById(Long id);
	public Producto save(Producto producto);
	public void deleteById(Long id);
}