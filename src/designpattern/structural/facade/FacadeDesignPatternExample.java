/**
 * 
 */
package designpattern.structural.facade;

/**
 * 
 * https://refactoring.guru/design-patterns/facade
 * 
 * Facade is a structural design pattern that provides simplified interface to a library, framework or a complex set of classes.
 * 
 * 
 * @author 91978
 *
 */
public class FacadeDesignPatternExample {

	/**
	 * 
	 */
	public FacadeDesignPatternExample() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeClient client = new EmployeeClient(new EmployeeFacade(new EmployeeDAO()));
		client.employeeFacade.getEmployee();
		
		
	}

}

class EmployeeDAO{
	
	public void getEmpolyee() {
		System.out.println("Get Employee.");
	}
	
	public void createEmployee() {
		System.out.println("Create Employee.");
	}
	
	public void updateEmployee() {
		
	}
	
	public void removeEmployee() {
		
	}
	
	/*
	 * *
	 * *
	 * *
	 *
	 */
	
}

class EmployeeFacade {
	
	EmployeeDAO dao;
	
	public EmployeeFacade(EmployeeDAO dao) {
		this.dao=dao;
	}
	
	public void getEmployee() {
		this.dao.getEmpolyee();
	}
	
	public void createEmployee() {
		this.dao.createEmployee();
	}
	
}


class EmployeeClient{
	
	EmployeeFacade employeeFacade;
	
	public EmployeeClient(EmployeeFacade employeeFacade) {
		this.employeeFacade=employeeFacade;
	}
	
}