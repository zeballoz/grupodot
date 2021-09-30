package com.grupodot.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grupodot.demo.entidades.Consulta;
import com.grupodot.demo.entidades.MensajeError;
import com.grupodot.demo.service.ConsultaService;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {

	// Dependency injection
	@Autowired
	private ConsultaService consultaService;
	
	
	
	// Create a new partner
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Consulta consulta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.save(consulta));
	}
	

	// Calculate loan
	@GetMapping("/{monto}")
	@ResponseBody
	public ResponseEntity<?> calcularPrestamo(@PathVariable double monto) {
		
		Consulta consulta = consultaService.obtenerTasaInteresMasBaja(monto);
		
		
		MensajeError mensajeError=new MensajeError("Socio no disponible");
		//create(consulta);
		if (consulta == null) {
			return ResponseEntity.ok(mensajeError);
		} else {
			return ResponseEntity.ok(consulta);
		}
	}

}
