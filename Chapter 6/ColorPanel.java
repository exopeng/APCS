import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class ColorPanel extends JPanel {
	JButton white;
	JButton red;
	JButton green;
	JButton blue;
	JButton cyan;
	JButton magenta;
	JButton yellow;
	JButton clear;
	JButton custom;
	
	public ColorPanel() {
		this.setLayout(new GridLayout(9, 1));
		white = new JButton("White");
		red = new JButton("Red");
		green = new JButton("Green");
		blue = new JButton("Blue");
		cyan = new JButton("Cyan");
		magenta = new JButton("Magenta");
		yellow = new JButton("Yellow");
		clear = new JButton("Clear");
		custom = new JButton("Custom");
		
		this.add(white);
		this.add(red);
		this.add(green);
		this.add(blue);
		this.add(cyan);
		this.add(magenta);
		this.add(yellow);
		this.add(clear);
		this.add(custom);
	}

	

	public JButton getWhite() {
		return white;
	}

	public JButton getRed() {
		return red;
	}

	public JButton getGreen() {
		return green;
	}

	public JButton getBlue() {
		return blue;
	}

	public JButton getCyan() {
		return cyan;
	}

	public JButton getMagenta() {
		return magenta;
	}

	public JButton getYellow() {
		return yellow;
	}

	public JButton getClear() {
		return clear;
	}

	public JButton getCustom() {
		return custom;
	}
}
