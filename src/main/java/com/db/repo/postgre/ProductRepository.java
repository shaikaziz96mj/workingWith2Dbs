package com.db.repo.postgre;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.domain.postgre.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
