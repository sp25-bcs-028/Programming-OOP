public class Employee{
	private String name;
	private int socialSecurityNumber;
	private int salary;
	private String address;
	public Employee(String name, int socialSecurityNumber, int salary, String address){
		setEmployee(name, socialSecurityNumber, salary, address);
	}
	public void display(){
		System.out.println("The name of the Employee is: " + name);
		System.out.println("The Social Security Number of the Employee is: " + socialSecurityNumber);
		System.out.println("The salary of the Employee is: " + salary);
		System.out.println("The address of the Employee is: " + address);
	}
	public void setEmployee(String name, int socialSecurityNumber, int salary, String address){
		this.name = name;
		this.socialSecurityNumber = socialSecurityNumber;
		this.salary = salary;
		this.address = address;
	}
	public String getEmployee(){
		return name;
	} 
}