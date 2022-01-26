package com.singraul.coupon.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.coupon.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon getCouponByCode(String code);


}
