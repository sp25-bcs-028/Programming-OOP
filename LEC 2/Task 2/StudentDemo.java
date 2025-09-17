public class StudentDemo{
	public static void main(String args[]){
		Student s1 = new Student("Ahmed", "Male", "12-3-2007", "LahoreABC");
		Student s2 = new Student("Ali", "Male", "1-3-2007", "QasurABC");
		Student temp = new Student(s1);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(temp);
		if(s1.equals(temp)){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
}