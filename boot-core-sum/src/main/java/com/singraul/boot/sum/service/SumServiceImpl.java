package com.singraul.boot.sum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singraul.boot.sum.dao.SumDao;
@Service
public class SumServiceImpl implements SumService {

	@Autowired
	private SumDao sumDao;

	@Override
	public int sum(int x, int y) {
		System.out.println("Service : inside sum(int x, int y)");
		return sumDao.sum(x, y);
	}

}
