import java.awt.Graphics;

//purely abstract no code 
//a contract, if you implement Drawable, you must
//implement the following methods
public interface Drawable {
	//only constants are allowed(no variables) assumes public static final
	int RAND_FACTOR = 200;
	
	
	//public abstract is implied
	void draw(Graphics g);
}
