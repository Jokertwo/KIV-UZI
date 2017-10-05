package semestralniPrace;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Gui extends JFrame{

    
    
   /**
     * 
     */
    private static final long serialVersionUID = 1L;


public Gui(){
     setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
     setLayout(new BorderLayout());
     add(new GameDesk(),BorderLayout.CENTER);
     pack();
     setVisible(true);
     setLocationRelativeTo(null);
     addWindowListener();
     
 }
    
    
  public void addWindowListener() {
  addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(java.awt.event.WindowEvent windowEvent) {
          if (JOptionPane.showConfirmDialog(null,
              "Are you sure to close this window?", "Really Closing?",
              JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
              System.exit(0);
          }
      }
  });
}   
}
