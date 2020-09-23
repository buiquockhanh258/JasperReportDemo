/**
 * 
 */
package com.jasper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasper.entities.Emp;
import com.jasper.repository.EmpRepository;
import com.jasper.service.EmpService;

/**
 * @author KhanhBQ
 *
 */
@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpRepository repo;
	
	@Override
	public List<Emp> getAll() {
		return (List<Emp>) repo.findAll();
	}

}
