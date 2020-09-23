/**
 * 
 */
package com.jasper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jasper.entities.Emp;
import com.jasper.service.impl.EmpServiceImpl;

/**
 * @author KhanhBQ
 *
 */
@RestController
public class EmpController {
	@Autowired
	private EmpServiceImpl empServiceImpl;
	
	@GetMapping("/get")
	public List<Emp> getAll(){
		return empServiceImpl.getAll();
	}
}
