package com.db.repo.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.domain.mysql.Students;

public interface StudentRepository extends JpaRepository<Students, Integer> {

}