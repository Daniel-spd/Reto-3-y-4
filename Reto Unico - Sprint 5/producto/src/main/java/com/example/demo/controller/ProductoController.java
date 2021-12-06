package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Producto> producto = productoService.findById(id);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(producto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Producto productoDetalle, @PathVariable Long id){
		Optional<Producto> producto = productoService.findById(id);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(productoDetalle, producto.get());
		producto.get().setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Producto> producto = productoService.findById(id);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		productoService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Producto> readAll(){
		List<Producto> productos = StreamSupport
				.stream(productoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return productos;
	}
}