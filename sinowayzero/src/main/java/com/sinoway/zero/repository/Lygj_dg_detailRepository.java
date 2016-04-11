package com.sinoway.zero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sinoway.zero.bean.Lygj_dg_detail;
@Component
public interface Lygj_dg_detailRepository extends JpaRepository<Lygj_dg_detail,String> {
	
}
