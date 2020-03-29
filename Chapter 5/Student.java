public abstract class Student {
	// (1) instance variables
	// Since they are declared 'protected', this class
	// AND any of its subclasses can see these variables
	// But, its better to leave variables 'private' and add
	// getters and setters to Student
	protected String name; 
	protected int studentID; 

	// (2) instance method
	// will be inherited (or overridden) by subclasses
	public abstract String sayHi();
	
	// will be inherited (or overridden) by subclasses
	public String registerForClasses() {
		return "...registers for classes.";
	}

}
