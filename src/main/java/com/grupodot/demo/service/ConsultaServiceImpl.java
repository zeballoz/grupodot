package com.grupodot.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupodot.demo.dao.ConsultaDao;
import com.grupodot.demo.dao.PartnerDao;
import com.grupodot.demo.entidades.Consulta;
import com.grupodot.demo.entidades.Partner;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private PartnerDao partnerDao;

	@Autowired
	private ConsultaDao consultaDao;

	@Override
	@Transactional(readOnly = true)
	public Consulta obtenerTasaInteresMasBaja(double monto) {
		try {

			Partner partner = partnerDao.obtenerTasaInteresMasBaja(monto).get(0);

			double pagoTotal = monto * (1 + 36 * ((partner.getTasa()) / 100));
			double cuota = pagoTotal / 36;
			double cuotaR = Math.round(cuota*100.0)/100.0;
			Consulta consulta = new Consulta(partner, cuotaR, pagoTotal);

			return consulta;
			
		} catch (Exception e) {
			return null;
		}

	
	}

	@Override
	@Transactional
	public Consulta save(Consulta consulta) {
		// TODO Auto-generated method stub
		return consultaDao.save(consulta);
	}

}
