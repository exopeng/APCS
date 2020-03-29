// *** (6) Declare HighSchoolStudent is-a Student
public class HighSchoolStudent extends Student {
	// (7) can add extra attributes (variables)
	private String collegesApplyingTo;
	//name, studentID inherited from Student

	public HighSchoolStudent(String name, int id, String colleges) {
		this.name = name; // call the constructor of the superclass, Student.
		this.studentID = id;
		collegesApplyingTo = colleges;
	}	
	
	//registerForClasses() inherited from Student

	// Override the inherited version from Student
	public String sayHi() {
		return "'sup I'm a High Schooler.";
	}
	
	//Add extra functionality
	public void takeSAT() {
		System.out.println("...takes SAT.");
	}

}
