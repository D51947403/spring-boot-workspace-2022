package com.singraul.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.singraul.coupon.model.Coupon;
import com.singraul.coupon.repos.CouponRepo;

@Controller
public class CouponController {

	@Autowired
	CouponRepo couponRepo;


	@GetMapping("/index")
	public String openIndex() {
		return "index";
	}

	
	@GetMapping("/createCoupon")
	// spring expression language 
	// AOP programming 
	@PreAuthorize(value = "hasRole('ADMIN')")
	public String createCoupon() {
		return "createCoupon";
	}

	@PostMapping("/saveCoupon")
	public String saveCoupon(Coupon coupon) {
		couponRepo.save(coupon);
		return "createdResponse";
	}

	@GetMapping("/getCoupon")
	public ModelAndView getCoupon() {
		ModelAndView mav = new ModelAndView("showCoupon");
		mav.addObject("couponList", couponRepo.findAll());
		return mav;
	}
}
