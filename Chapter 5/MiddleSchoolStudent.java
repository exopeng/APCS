// *** (5) Declare MiddleSchoolStudent is-a Student
public class MiddleSchoolStudent extends Student {
	// instance variables 
	//name, studentID inherited from Student

	
	// constructors
	public MiddleSchoolStudent(String name, int id) {
		this.name = name;
		this.studentID = id;
	}
	
	// instance methods 
	// registerForClasses() inherited from Student


	public String sayHi() {
		return "HI";
	}
}
