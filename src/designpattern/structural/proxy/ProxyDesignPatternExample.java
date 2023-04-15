/**
 * 
 */
package designpattern.structural.proxy;

/**
 * @author 91978
 *
 *Structural design patters explains how to assemble objects and classes into larger structures, while keeping these structures flexible and efficient.
 *
 *Proxy is a structural design pattern that lets you provide a substitute or placeholder for a real object.
 * Proxy controls the acces to the real object, allowing you to perform something before or after a request gets through the real object.
 *
 */
public class ProxyDesignPatternExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeCreateDao employeeCreateDao = new EmployeeCreateProxyDaoImpl(new EmployeeCreateRealDaoImpl());
		
		employeeCreateDao.createEmployee("USER");
		
		employeeCreateDao.createEmployee("ADMIN");
		
	}

}

interface EmployeeCreateDao{
	
	boolean createEmployee(String client);
	
}

class EmployeeCreateRealDaoImpl implements EmployeeCreateDao{

	@Override
	public boolean createEmployee(String client) {
		System.out.println("Employee created");
		return true;
	}
	
}

class EmployeeCreateProxyDaoImpl implements EmployeeCreateDao{

	private EmployeeCreateDao employeeCreateDao;
	
	public EmployeeCreateProxyDaoImpl(EmployeeCreateDao employeeCreateDao) {
		this.employeeCreateDao = employeeCreateDao;
	}
	
	@Override
	public boolean createEmployee(String client) {
		if("ADMIN".equals(client)) {
			return employeeCreateDao.createEmployee(client);
		}else {
			System.out.println("ACCESS DENIED");
		}
		return false;
		
	}
	
}
