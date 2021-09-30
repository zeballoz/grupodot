package com.grupodot.demo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consultas")
public class Consulta implements Serializable {


	private static final long serialVersionUID = 987704865338663456L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="partner")
	private Partner partner;
	
	@Column(name="cuotaMensual")
	private Double cuotaMensual;
	
	@Column(name="pagoTotal")
	private Double pagoTotal;
	
	//builder
	public Consulta( Partner partner, Double cuotaMensual, Double pagoTotal) {
		this.partner = partner;
		this.cuotaMensual = cuotaMensual;
		this.pagoTotal = pagoTotal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Partner getNombre() {
		return partner;
	}

	public void setNombre(Partner partner) {
		this.partner = partner;
	}

	public Double getCuotaMensual() {
		return cuotaMensual;
	}

	public void setCuotaMensual(Double cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}

	public Double getPagoTotal() {
		return pagoTotal;
	}

	public void setPagoTotal(Double pagoTotal) {
		this.pagoTotal = pagoTotal;
	}


}
