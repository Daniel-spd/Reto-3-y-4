package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	@Query(value = "SELECT * FROM producto pt WHERE pt.id = :id", nativeQuery = true)
	public List<Producto> findIdentificadorById(Long id);
	
	@Query("SELECT pt FROM Producto pt WHERE pt.id = :id")
	public List<Producto> findIdentificadorQueryById(Long id);
}