package com.singraul.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.product.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
