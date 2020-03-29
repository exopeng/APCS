// "Specification" or "template" for SmallSchoolClassroom 
// (9) objects...remember they don't exist yet!
public class SmallSchoolClassroom {
	// Instance variables - describing what SmallSchoolClassroom
	// objects will have
	Student[] students = new Student[4];
	
	// Constructor - describing how you will initialize your 
	// variables when SmallSchoolClassroom is created
	public SmallSchoolClassroom(){
		students[0] = new ElementarySchoolStudent("Joe", 13445, "Sponge Bob");
		students[1] = new MiddleSchoolStudent("Joey", 15542);
		students[2] = new HighSchoolStudent("Joseph", 18748, "UCLA, UW");
		students[3] = new HighSchoolStudent("Joseph", 18748, "UCLA, UW");
	}
	
	
	// Mixing static code inside SmallSchoolClassroom specification.  Mr. S
	// recommended not doing this, b/c it leads to confusion.  But oh well...
	public static void main(String[] args) {
		// A Student object can point to ANY type of Student
		System.out.println("**Testing a Student object that can point to any Student subclass object**");
		// *** (10) Declare a variable that can point to ANY type of Student, called s1
		Student s1;
		
		//System.out.println(s1.sayHi());
		
		s1 = new ElementarySchoolStudent("Kate", 9384, "Daniel Tiger");
		System.out.println(s1.sayHi()); // --> "Hiya I'm an Elementary school student!"
		
		s1 = new MiddleSchoolStudent("Karla", 9855);
		System.out.println(s1.sayHi()); // --> "hello I'm a generic student."
		
		s1 = new HighSchoolStudent("Kelly", 93111, "Texas, UofA");
		System.out.println(s1.sayHi()); // --> "'sup I'm a High Schooler."
		
		System.out.println("**Testing for loop containing different Student subclasses**");
		SmallSchoolClassroom classroom1 = new SmallSchoolClassroom();
		SmallSchoolClassroom classroom2 = new SmallSchoolClassroom();

		// ***(11)Wait, what the?? Why doesn't it work?  Didn't I define Student[] students above?
		// Oh no!  Not the static error again! What am I missing? 
		for(int i = 0; i < classroom1.students.length; i++) {
			// Polymorphism at work.  sayHi()'s action will depend on what 
			// type of Student it is...Java just handles it!  
			System.out.println(classroom1.students[i].sayHi());
		}
		// ***(12) What if I decide I don't want generic Student() objects in there
		// anymore?  What if I don't want to describe sayHi() in the superclass b/c
		// I want to force all subclasses to implement their own version? 
		
		// ***(13) If I want to perform subclass-specific actions, but Java thinks everyone
		// is just a "Student", what do I have to do? 
		((HighSchoolStudent)s1).takeSAT(); // s1 last pointed to HighSchoolStudent, so takeSAT() should work??
		
		if (s1 instanceof HighSchoolStudent ) {
			System.out.println("YAY");
		}
	}

}
