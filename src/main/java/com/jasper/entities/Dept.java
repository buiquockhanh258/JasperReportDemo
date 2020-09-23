/**
 * 
 */
package com.jasper.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author KhanhBQ
 *
 */
@Entity
public class Dept implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int deptno;
	private String dname;
	private String loc;
	@OneToMany(mappedBy = "dept")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Emp> emp;

	public Dept(int deptno, String dname, String loc, List<Emp> emp) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		this.emp = emp;
	}

	/**
	 * @return the deptno
	 */
	public int getDeptno() {
		return deptno;
	}

	/**
	 * @param deptno the deptno to set
	 */
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	/**
	 * @return the dname
	 */
	public String getDname() {
		return dname;
	}

	/**
	 * @param dname the dname to set
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}

	/**
	 * @return the loc
	 */
	public String getLoc() {
		return loc;
	}

	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}

	/**
	 * @return the emp
	 */
	public List<Emp> getEmp() {
		return emp;
	}

	/**
	 * @param emp the emp to set
	 */
	public void setEmp(List<Emp> emp) {
		this.emp = emp;
	}

	public Dept() {
	}
}
