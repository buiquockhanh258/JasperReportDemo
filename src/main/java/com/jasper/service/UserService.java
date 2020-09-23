/**
 * 
 */
package com.jasper.service;

import java.io.FileNotFoundException;

import net.sf.jasperreports.engine.JRException;

/**
 * @author KhanhBQ
 *
 */
public interface UserService {
	void exportToPdf() throws JRException, FileNotFoundException;
}
