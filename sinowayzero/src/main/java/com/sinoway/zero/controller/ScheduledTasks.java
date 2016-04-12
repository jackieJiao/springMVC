package com.sinoway.zero.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sinoway.zero.bean.Lygj_dg_detail;
import com.sinoway.zero.service.DGService1;

@Component
public class ScheduledTasks {
	@Autowired
	private DGService1 dgService1;
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {

		Lygj_dg_detail dg = new Lygj_dg_detail();
		dg.setSphone("1233333");
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		dg.setCreatedate(ts);
		dg.setDgtype("1");
		dg.setNphone("13833336666");
		dg.setTcmoney("200");
		dgService1.ins(dg);
		System.out.println("已插入数据");
	}
}