package com.example.LP2_T2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LP2_T2.model.Producto;
import com.example.LP2_T2.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {
	
	private final ProductoRepository productoRepostory;
	
	
	public List<Producto> getAll(){
		return productoRepostory.findAll();
	}

}
