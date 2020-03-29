import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PlainPanel extends JPanel {
	public PlainPanel() {
		this.setLayout(new BorderLayout());
		JPanel southContainer = new JPanel();
		southContainer.setLayout(new GridLayout(2,1));
		JPanel southContainerNorth = new JPanel();
		JPanel southContainerSouth = new JPanel();
		
		southContainerNorth.setLayout(new GridLayout(1,1));
		southContainerSouth.setLayout(new GridLayout(1,1));
		
		JButton prev = new JButton("Previous");
		JButton next = new JButton("Next");
		JButton sub = new JButton("Submit");
		
		southContainerNorth.add(prev);
		southContainerNorth.add(next);
		southContainerSouth.add(sub);
		
		southContainer.add(southContainerNorth);
		southContainer.add(southContainerSouth);
		this.add(southContainer, BorderLayout.SOUTH);
		
		FramedPanel pan = new FramedPanel(Color.RED);
		FramedPanelMouseListener listener = new FramedPanelMouseListener(pan);
		this.add(pan, BorderLayout.CENTER);
		
	}
}
