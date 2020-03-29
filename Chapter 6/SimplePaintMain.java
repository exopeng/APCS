import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class SimplePaintMain {
	 /**
     * This main routine allows this class to be run as a program.
     */
    public static void main(String[] args) {
        JFrame window = new JFrame("Simple Paint");
        JPanel container = new JPanel();
        //container.setLayout(new FlowLayout());
        
        ColorPanel color = new ColorPanel();
        SimplePaintPanel content = new SimplePaintPanel();
       
        SimplePaintListener listener = new SimplePaintListener(content, color);
        container.setLayout(new BorderLayout());
        
        container.add(content, BorderLayout.CENTER);
        container.add(color, BorderLayout.EAST);
       
        JMenuBar menuBar = new JMenuBar();
        
        JMenu simplePaintMenu = new JMenu("Simple Paint");
        JMenu editMenu = new JMenu("Edit");
        
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem undo = new JMenuItem("Undo");
        
        //register listener: component.addXXXListener(listener)
        quit.addActionListener(listener);
        undo.addActionListener(listener);
        
        simplePaintMenu.add(quit);
        editMenu.add(undo);
        
        menuBar.add(simplePaintMenu);
        menuBar.add(editMenu);
        
        window.setJMenuBar(menuBar);
        
        window.setContentPane(container);
        window.setSize(700,380);
        window.setLocation(100,100);
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setVisible(true);
       
        content.requestFocusInWindow();
    }
}
