/**
 * 
 */
package com.jasper.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jasper.service.UserService;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * @author KhanhBQ
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private EmpServiceImpl empServiceImpl;

	@Async
	@Scheduled(fixedDelay = 20 * 1000, initialDelay = 0)
	@Override
	public void exportToPdf() throws JRException, FileNotFoundException {
		// Load jrxml
		InputStream reportSrcFile = new FileInputStream(
				new File("C:\\Users\\Laptop\\Desktop\\WORK\\Demo\\JasperReportA4.jrxml"));
		JasperDesign jasperDesign = JRXmlLoader.load(reportSrcFile);

		// Compile file
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

		// Tham số truyền vào báo cáo.
		JRBeanCollectionDataSource beanDataSource = new JRBeanCollectionDataSource(empServiceImpl.getAll());
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("BeanDataSource", beanDataSource);
		JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

		// Đảm bảo thư mục đầu ra tồn tại.
		JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\Laptop\\Desktop\\WORK\\Demo\\JasperReport.pdf");

		System.out.print("Exported to pdf!: C:\\Users\\Laptop\\Desktop\\WORK\\Demo\\JasperReport.pdf");
	}

}
