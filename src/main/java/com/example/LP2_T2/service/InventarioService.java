package com.example.LP2_T2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LP2_T2.dto.ResultadoResponse;
import com.example.LP2_T2.model.Inventario;
import com.example.LP2_T2.repository.InventarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioService {
	
	private final InventarioRepository inventarioRepository;
	
	public List<Inventario> getAll(){
		return inventarioRepository.findAllByOrderByNumeroDesc();
	}
	
	@Transactional
	public ResultadoResponse create (Inventario inventario) {
		try {
			var registrado = inventarioRepository.save(inventario);
			var mensaje = String.format("Inventario con Id %d registrado", registrado.getNumero());
			return new ResultadoResponse(true, mensaje);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transaccion");
		}
	}
	
	public Inventario getOne(Integer id) {
		return inventarioRepository.findById(id).orElse(null);		
	}
	
	@Transactional
	public ResultadoResponse update(Inventario producto) {
		try {
			var registrado = inventarioRepository.save(producto);
			var mensaje = String.format("Inventario con Id %d actualizado", registrado.getNumero());
			return new ResultadoResponse(true, mensaje);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transaccion");
		}
	}
	

	
	
}
