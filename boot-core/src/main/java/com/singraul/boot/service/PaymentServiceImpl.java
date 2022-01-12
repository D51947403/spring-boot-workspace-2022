package com.singraul.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singraul.boot.dao.PaymentDao;
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentDao paymentDao;

	public PaymentDao getPaymentDao() {
		return paymentDao;
	}

	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}
	
	

}
