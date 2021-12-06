package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import com.example.demo.util.JWTUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
    private ProductoService productoService;

    @Autowired
    private JWTUtil jwtUtil;
    
    @PostMapping
	public ResponseEntity<?> createtoken(@RequestBody Producto productoDetalle){
		List<Producto> producto = productoService.findIdentificadorById(productoDetalle.getId());
		if(producto!=null && producto.size()>0) {
			String tokenJwt = jwtUtil.getJWTToken(producto.get(0).getIdentificadorProducto()+"");
            String resp = "{\"token\":\""+tokenJwt+"\"}";
            return ResponseEntity.ok(resp);
		} 
		return ResponseEntity.notFound().build();
	}
}