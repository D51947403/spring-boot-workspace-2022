package com.singraul.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.singraul.coupon.model.Coupon;
import com.singraul.coupon.repos.CouponRepo;

@RestController
@RequestMapping("/coupon-rest-api")
@CrossOrigin
public class CouponRestController {

	@Autowired
	CouponRepo couponRepo;

	@RequestMapping(value = "/coupon", method = RequestMethod.POST)
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponRepo.save(coupon);
	}

	@RequestMapping(value = "/coupon/{code}", method = RequestMethod.GET)
	public Coupon getCouponByCode(@PathVariable("code") String code) {
		return couponRepo.getCouponByCode(code);
	}
}
