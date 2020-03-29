import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class SubKillerMain {
	public static void main(String[] args) {
        JFrame window = new JFrame("Sub Killer Game");
        
        
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        
        
        window.setSize(600, 480);
        window.setLocation(100,100);
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ScorePanel scorePanel = new ScorePanel();
        SubKillerPanel content = new SubKillerPanel(scorePanel);
       
        SubKillerListener listener = new SubKillerListener(content,scorePanel);
        
        
        container.add(content, BorderLayout.CENTER);
        container.add(scorePanel, BorderLayout.SOUTH);
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu subKillerMenu = new JMenu("SubKiller");
        JMenu optionsMenu = new JMenu("Options");
        
        JMenuItem about = new JMenuItem("About");
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem restart = new JMenuItem("Restart");
        
        //register listener: component.addXXXListener(listener)
        about.addActionListener(listener);
        quit.addActionListener(listener);
        restart.addActionListener(listener);
        
        subKillerMenu.add(about);
        subKillerMenu.add(quit);
        
        optionsMenu.add(restart);
        
        menuBar.add(subKillerMenu);
        menuBar.add(optionsMenu);
        
        window.setJMenuBar(menuBar);
        window.setContentPane(container);
        
        window.setResizable(false);  // User can't change the window's size.
        window.setVisible(true);
        //content.requestFocusInWindow();
    }
}
 