/**
 * 
 */
package com.jasper.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.jasper.entities.Emp;

/**
 * @author KhanhBQ
 *
 */
public interface EmpRepository extends CrudRepository<Emp, Serializable> {

}
