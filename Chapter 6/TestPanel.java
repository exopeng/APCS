import java.awt.*; 
import javax.swing.*;

public class TestPanel extends JPanel {

	// #1: see it works, even if blank.
	// But what do we want JPanel object to do? 
	
	// 1 - Can draw on JPanel object (won't do today)
	// 2 - (Today:) JPanel object can be used as a CONTAINER for other JComponents (Buttons, etc)
	
	// As a container, TestPanel (which is-a JPanel object) can HAVE other JComponents

	
	public TestPanel() {
		JButton open = new JButton("Open");
		JButton close = new JButton("Close");
//		this.add(open);
//		this.add(close);
		
		// Nothing happened!
		// Because we need to add the JComponents to the container, our JPanel object
		
		
		// What if we want to fix the layout?  Using a LayoutManager
		// means you don't worry about coordinates -- it resizes it for you!
		this.setLayout(new BorderLayout());
		
		//create 2 more containers
		JPanel northContainer = new JPanel();
		JPanel southContainer = new JPanel();
		
		
		// Syntax: container.add(component);
		northContainer.add(open);
		northContainer.add(close);
		
		this.add(northContainer, BorderLayout.NORTH);
		
		

		//default is FlowLayout
		//you can set the Layout style of this smaller container as well

		southContainer.setLayout(new GridLayout(2,3));
		JButton prev = new JButton("Previous");
		JButton play = new JButton("Play");
		JButton next = new JButton("Next");
		JButton rewind = new JButton("Rewind");
		JButton pause = new JButton("Pause");
		JButton forward = new JButton("Forward");

		southContainer.add(prev);
		southContainer.add(play);
		southContainer.add(next);
		southContainer.add(rewind);
		southContainer.add(pause);
		southContainer.add(forward);
		//Aha! haven't added optionPanel to the TestPanel object
		this.add(southContainer, BorderLayout.SOUTH);
		
	}
	
}
