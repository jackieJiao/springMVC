package com.sinoway.zero.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.zero.bean.Lygj_dg_detail;
import com.sinoway.zero.repository.Lygj_dg_detailRepository;
import com.sinoway.zero.service.DGService1;




@Service
public class DGService1Imple implements DGService1 {
	@Autowired
	private Lygj_dg_detailRepository dgRepo;
	
	@Transactional
	@Override
	public Lygj_dg_detail ins(Lygj_dg_detail lygj_dg_detail) {
		return dgRepo.save(lygj_dg_detail);
	}

}
