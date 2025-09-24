public class EmployeeTest{
	public static void main(String args[]){
		String employeeName;
		Employee employee = new Employee("Dawood", 23456, 40000, "adv");
		employee.display();
		employeeName = employee.getEmployee();
		System.out.println("The name of the employee: " + employeeName);		
	}
}