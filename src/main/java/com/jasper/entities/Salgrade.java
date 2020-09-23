/**
 * 
 */
package com.jasper.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author KhanhBQ
 *
 */
@Entity
public class Salgrade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int grade;
	private int losal;
	private int hisal;

	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 * @return the losal
	 */
	public int getLosal() {
		return losal;
	}

	/**
	 * @param losal the losal to set
	 */
	public void setLosal(int losal) {
		this.losal = losal;
	}

	/**
	 * @return the hisal
	 */
	public int getHisal() {
		return hisal;
	}

	/**
	 * @param hisal the hisal to set
	 */
	public void setHisal(int hisal) {
		this.hisal = hisal;
	}

	public Salgrade(int grade, int losal, int hisal) {
		this.grade = grade;
		this.losal = losal;
		this.hisal = hisal;
	}

	public Salgrade() {
	}
}
