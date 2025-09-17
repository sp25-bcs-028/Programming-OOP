public class Student{
	String id = "SP25-BCS-";
	String name;
	String gender;
	String dateOfBirth;
	String address;
	static int counter = 0;
	public Student(){
	}
	public Student(String name, String gender, String dateOfBirth, String address){
		setName(name);
		counter++;
		setId(counter);
		setGender(gender);
		setDateOfBirth(dateOfBirth);
		setAddress(address);
	}
	public Student(Student s){
		this.id = s.id;
		this.name = s.name;
		this.gender = s.gender;
		this.dateOfBirth = s.dateOfBirth;
		this.address = s.address;
	} 
	public void setName(String name){
		this.name = name;
	}
	public void setId(int a){
		this.id = id + String.format("%03d", a);
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public void setDateOfBirth(String dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getName(){
		return name;
	}
	public String getId(){
		return id;
	}
	public String getGender(){
		return gender;
	}
	public String getDateOfBirth(){
		return dateOfBirth;
	}
	public String getAddress(){
		return address;
	}
	public String toString(){
		return String.format("%-5s %-20s %-5s %-5s %-5s", name, id, gender, dateOfBirth, address);
	}
	public boolean equals(Object O){
		Student s = (Student)O;
		String tempId = s.getId();
		boolean b=this.id.equals(tempId);
		return b;
	}
}