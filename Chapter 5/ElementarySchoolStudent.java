// *** (3) make it so this class inherits from Student
// in other words, declare ElementarySchoolStudent is-a Student
public class ElementarySchoolStudent extends Student{
	// instance variables
	private String favoriteCartoon;
	//name, studentID inherited from Student
	
	// constructor
	public ElementarySchoolStudent(String name, int id, String cartoon) {
		this.name = name; // call the constructor of the superclass, Student.
		this.studentID = id;
		favoriteCartoon  = cartoon;
	}
	
	// instance methods
	
	//registerForClasses() inherited from Student

	
	// (4) Override the inherited version from Student
	public String sayHi() {
		return "Hiya I'm an Elementary school student!";
	}
	
	// (5) Can add extra functionality
	public String playKickball() {
		return "...plays kickball.";
	}

}
