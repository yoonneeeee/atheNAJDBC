package com.kh.jdbc.day04.pstmt.employee.controller;

import java.util.List;

import com.kh.jdbc.day04.pstmt.employee.model.dao.EmployeeDAO;
import com.kh.jdbc.day04.pstmt.employee.model.service.EmployeeService;
import com.kh.jdbc.day04.pstmt.employee.model.vo.Employee;

public class EmployeeController {
	
	
	private EmployeeService eService;
	
	public EmployeeController() {
	eService = new EmployeeService();	
	}
//	EmployeeDAO eDao;

	public List<Employee> printAllEmp() {
		List<Employee> eList = eService.selectList();
		return eList;
	}

	public int insertEmployee(Employee emp) {
		int result = eService.insertEmployee(emp);
		return result;
	}

	public int deleteEmployee(String empId) {
		int result = eService.deleteEmployee(empId);
		return result;
	}

	public Employee selectOneById(String empId) {
		Employee result = eService.selectOne(empId);
		return result;
	}

	public int updateEmployee(Employee emp) {
		int result = eService.updateEmployee(emp);
		return result;
	}

}
