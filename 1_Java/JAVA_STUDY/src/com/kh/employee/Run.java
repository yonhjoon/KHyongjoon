package com.kh.employee;

public class Run {

	public static void main(String[] args) {
		Employeeas El = new Employeeas();
		El.setEmpNo(100);
		El.setEmpName("홍길동");
		El.setDept("영업부");
		El.setJob("과장");
		El.setAge(25);
		El.setGender('남');
		El.setSalary(2500000);
		El.setBonusPoint(0.05);
		El.setPhone("010-1234-5678");
		El.setAddress("서울시 강남구");
		
//		System.out.println("번호(empNo) : " + El.getEmpNo() + 
//						   "\n이름(empName) : " + El.getEmpName() +
//						   "\n부서(dept) : " + El.getDept() + 
//						   "\n직급(job) : " + El.getJob() +
//						   "\n나이(age) : " + El.getAge() +
//						   "\n성별(gender) : " + El.getGender() + 
//						   "\n월급(salary) : " + El.getSalary()+
//						   "\n보너스(bonusPoint) : " + El.getBonusPoint() + 
//						   "\n핸드폰 번호(phone) : " + El.getPhone() +
//						   "\n거주지(address) : " + El.getAddress() + " 입니다.");

		System.out.println(El.getEmpNo());
		System.out.println(El.getEmpName());
		System.out.println(El.getDept());
		System.out.println(El.getJob());
		System.out.println(El.getAge());
		System.out.println(El.getGender());
		System.out.println(El.getSalary());
		System.out.println(El.getBonusPoint());
		System.out.println(El.getPhone());
		System.out.println(El.getAddress());
	
	
	
	
	}

}
