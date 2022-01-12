package com.singraul.boot.sum.dao;

import org.springframework.stereotype.Repository;

@Repository
public class SumDaoImpl implements SumDao {

	@Override
	public int sum(int x, int y) {
		System.out.println("Repository : inside sum(int x, int y)");
		return x+y;
	}

}
