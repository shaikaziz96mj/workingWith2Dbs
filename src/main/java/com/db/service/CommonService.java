package com.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.db.domain.ResponseObject;
import com.db.domain.mysql.Students;
import com.db.domain.postgre.Products;
import com.db.repo.mysql.StudentRepository;
import com.db.repo.postgre.ProductRepository;

@Service
public class CommonService implements ICommonService {
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ResponseObject getAllStudentsDetails() {
		try {
			List<Students> studentList=studentRepository.findAll();
			if(studentList.isEmpty()) {
				return new ResponseObject(null, "No students to display", HttpStatus.OK);
			}else {
				return new ResponseObject(studentList, null, HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseObject(null, e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}

	@Override
	public ResponseObject getAllProductDetails() {
		try {
			List<Products> productList=productRepository.findAll();
			if(productList.isEmpty()) {
				return new ResponseObject(null, "No products to display", HttpStatus.OK);
			}else {
				return new ResponseObject(productList, null, HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseObject(null, e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
