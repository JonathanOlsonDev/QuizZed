package QuizZed;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow {
	
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel; 

   public MainWindow(){
      prepareWindow();
      showMenu();
   }
   
   private void prepareWindow(){
      mainFrame = new JFrame("QuizZed by JDO");
      mainFrame.setSize(800,800);
      mainFrame.setLocationRelativeTo(null);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(350,100);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });
      
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   
   private void showMenu(){
	   
      //create a menu bar
      final JMenuBar menuBar = new JMenuBar();

      //create menus
      JMenu fileMenu = new JMenu("File");
      JMenu testMenu = new JMenu("Test"); 
      JMenu helpMenu = new JMenu("Help");
     
      //create menu items
      JMenuItem newMenuItem = new JMenuItem("New Quiz");
      newMenuItem.setMnemonic(KeyEvent.VK_N);
      newMenuItem.setActionCommand("NewQuiz");

      JMenuItem openMenuItem = new JMenuItem("Open Quiz");
      openMenuItem.setActionCommand("OpenQuiz");

      JMenuItem saveQuizMenuItem = new JMenuItem("Save Quiz");
      saveQuizMenuItem.setActionCommand("SaveQuiz");

      JMenuItem exitMenuItem = new JMenuItem("Exit");
      exitMenuItem.setActionCommand("Exit");

      JMenuItem startMenuItem = new JMenuItem("Start Test");
      startMenuItem.setActionCommand("StartTest");

      JMenuItem saveTestMenuItem = new JMenuItem("Save Test");
      saveTestMenuItem.setActionCommand("SaveTest");

      JMenuItem abortMenuItem = new JMenuItem("Abort Test");
      abortMenuItem.setActionCommand("AbortTest");

      JMenuItem statsMenuItem = new JMenuItem("Test Stats");
      statsMenuItem.setActionCommand("QuizStats");
      
      JMenuItem helpMenuItem = new JMenuItem("Help");
      helpMenuItem.setActionCommand("HelpWindow");
      
      JMenuItem aboutMenuItem = new JMenuItem("About");
      aboutMenuItem.setActionCommand("AboutWindow");
      
      MenuItemListener menuItemListener = new MenuItemListener();

      
      //create menu listeners
      //file
      newMenuItem.addActionListener(menuItemListener);
      openMenuItem.addActionListener(menuItemListener);
      saveQuizMenuItem.addActionListener(menuItemListener);
      exitMenuItem.addActionListener(menuItemListener);
      
      //test
      startMenuItem.addActionListener(menuItemListener);
      saveTestMenuItem.addActionListener(menuItemListener);
      abortMenuItem.addActionListener(menuItemListener);
      statsMenuItem.addActionListener(menuItemListener);
      
      //help
      helpMenuItem.addActionListener(menuItemListener);
      aboutMenuItem.addActionListener(menuItemListener);

      //add menu items to menus
      //file menu
      fileMenu.add(newMenuItem);
      fileMenu.add(openMenuItem);
      fileMenu.add(saveQuizMenuItem);
      fileMenu.addSeparator();
      fileMenu.add(exitMenuItem);        
      
      //test menu
      testMenu.add(startMenuItem);
      testMenu.add(saveTestMenuItem);
      testMenu.add(abortMenuItem);
      testMenu.add(statsMenuItem);
      
      //about menu
      helpMenu.add(helpMenuItem);
      helpMenu.add(aboutMenuItem);
      
      //add menu to menubar
      menuBar.add(fileMenu);
      menuBar.add(testMenu);
      menuBar.add(helpMenu);

      //add menubar to the frame
      mainFrame.setJMenuBar(menuBar);
      mainFrame.setVisible(true);     
   }
   
   class MenuItemListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {            
         statusLabel.setText(e.getActionCommand() + " JMenuItem clicked.");
      }    
   }
}
