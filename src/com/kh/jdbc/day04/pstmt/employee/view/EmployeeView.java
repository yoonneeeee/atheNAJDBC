package com.kh.jdbc.day04.pstmt.employee.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day04.pstmt.employee.controller.EmployeeController;
import com.kh.jdbc.day04.pstmt.employee.model.vo.Employee;

public class EmployeeView {
	private int mainMenu() {
			Scanner sc = new Scanner(System.in);
			System.out.println("==== 사원 관리 프로그램 ====");
			System.out.println("1. 사원 전체 출력");
			System.out.println("2. 사원 정보 입력");
			System.out.println("3. 사원 정보 수정");
			System.out.println("4. 사원 정보 삭제");
			System.out.println("0. 프로그램 종료");
	//		System.out.println("1. 사원 전체 출력");
	//		System.out.println("1. 사원 전체 출력");
	//		System.out.println("1. 사원 전체 출력");
			System.out.print("메뉴 선택 : ");
			int choice = sc.nextInt();
			return choice;
		}

	EmployeeController empController;
	public EmployeeView() {
		empController = new EmployeeController();
	}

	public void startApp() {
		// TODO Auto-generated method stub
		end: while (true) {
			int menu = mainMenu();
			switch (menu) {
			case 1:		//1. 사원 전체 출력
				List<Employee> eList = empController.printAllEmp();
				this.showAllEmp(eList);
				break;
			case 2 : 	// 2. 사원 정보 입력
				Employee emp = inputEmpInfo();
				int result = empController.insertEmployee(emp);
				if(result>0) {
					printMessage("등록 성공");
				}else {
					printMessage("등록 실패..");
				}
				break;
			case 3 : 	//3. 사원 정보 수정 : empid를 입력받아 정보 확인 후 정보 수정
				String empId = inputEmpId();
				emp = empController.selectOneById(empId);
				if(emp != null) {
					emp= modifyEmpInfo();
					emp.setEmpId(empId);
					result = empController.updateEmployee(emp);
					if(result>0) {
						printMessage("수정 성공");
					}else {
						printMessage("수정 실패..");
					}
				}else {
					printMessage("존재하지 않는 정보입니다.");
				}
				break;	
			case 4 : 
				empId = inputEmpId();
				result = empController.deleteEmployee(empId);
				if(result>0) {
					printMessage("삭제 성공");
					}else {
					printMessage("삭제 실패..");
					}
				break;
			case 0:
				printMessage("프로그램이 종료되었습니다.");
				break end;
			}
		}
	}
	
	private Employee modifyEmpInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==== 사원 정보 수정 ====");
		System.out.print(" 이메일 : ");
		String email = sc.next();
		System.out.print(" 전화번호 : ");
		String phone = sc.next();
		System.out.print(" 부서코드 : ");
		String deptCode = sc.next();
		System.out.print(" 급여 : ");
		int salary = sc.nextInt();
		System.out.print(" 보너스율 : ");
		double bonus = sc.nextDouble();
		System.out.print(" 관리자 : ");
		String managerId  = sc.next();
		Employee emp = new Employee();
		emp.setEmail(email);
		emp.setPhone(phone);
		emp.setDeptCode(deptCode);
		emp.setSalary(salary);
		emp.setBonus(bonus);
		emp.setManagerId(managerId);
		
		return emp;
	}

	private String inputEmpId() {
		Scanner sc = new Scanner(System.in);
		System.out.print(" 사번 입력 : ");
		return sc.next();
		
	}

	private Employee inputEmpInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==== 사원 정보 입력 ====");
		System.out.print("사번 : ");
		String empId = sc.next();
		System.out.print("사원명 : ");
		String empName = sc.next();
		System.out.print("주민번호 : ");
		String empNo = sc.next();
		System.out.print("직급코드 : ");
		String jobCode = sc.next();
		System.out.print("급여등급 : ");
		String salLevel = sc.next();
		Employee emp = new Employee(); // 모든 값을 리턴할 수 없으므로 엠프로이 객체 생성
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setEmpNo(empNo);
		emp.setJobCode(jobCode);
		emp.setSalLevel(salLevel);
		return emp;
	}

	private void showAllEmp(List<Employee> eList) {
		System.out.println("==== 사원 전체 정보 출력 ====");
		for(Employee emp : eList) {
			System.out.printf("이름 : %s\t 사번 : %s\t 이메일 : %s\t 전화번호 : %s\t 입사일자 : %s\t 퇴직여부 : %s\n", emp.getEmpName(), emp.getEmpId(), emp.getEmail(), emp.getPhone(), emp.getHireDate(), emp.getEntYn());
		}
	}

	private void printMessage(String message) {
		System.out.println("[서비스 결과] :" + message);
		
	}

}
