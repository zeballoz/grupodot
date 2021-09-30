package com.grupodot.demo.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupodot.demo.dao.PartnerDao;
import com.grupodot.demo.entidades.Partner;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerDao partnerDao;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Partner> findAll() {
		return partnerDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Partner> findAll(Pageable pageable) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Partner> finById(long id) {
		return partnerDao.findById(id);
	}

	@Override
	@Transactional
	public Partner save(Partner partner) {
		// TODO Auto-generated method stub
		return partnerDao.save(partner);
	}

	@Override
	@Transactional
	public void deleteById(long id) {

		partnerDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Partner> obtenerTasaInteresMasBaja(double monto) {

		Optional<Partner> partner = Optional.ofNullable(partnerDao.obtenerTasaInteresMasBaja(monto).get(0));
		return partner;
	}

}
