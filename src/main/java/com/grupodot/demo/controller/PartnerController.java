package com.grupodot.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupodot.demo.entidades.Partner;
import com.grupodot.demo.service.PartnerService;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {

	// Dependency injection
	@Autowired
	private PartnerService partnerService;

	// Create a new partner
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Partner partner) {
		return ResponseEntity.status(HttpStatus.CREATED).body(partnerService.save(partner));
	}

	// read an partner
	@GetMapping("/{id}")
	public ResponseEntity<?> ready(@PathVariable Long id) {

		Optional<Partner> oPartner = partnerService.finById(id);

		if (!oPartner.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(oPartner);
		}
	}

}
