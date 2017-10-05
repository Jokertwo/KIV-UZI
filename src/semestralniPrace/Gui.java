package semestralniPrace;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;



public class Gui extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public JMenuBar createMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu game = new JMenu("Game");
        
        
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new NewGame());
        
        JMenuItem exitGame = new JMenuItem("Exit");
        exitGame.addActionListener(new ExitGame());
        
        game.add(newGame);
        game.add(exitGame);
        
        JMenu help = new JMenu("Help");
        
        JMenuItem rule = new JMenuItem("Rules");
        JMenuItem about = new JMenuItem("About");
        
        
        
        help.add(rule);
        help.add(about);
        
        menuBar.add(game);
        menuBar.add(help);
        
        return menuBar;
    }
    

    public Gui() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300,300);
        
       
        
        setJMenuBar(createMenu());
        JButton button = new JButton("Pokus");
        JButton prdbrd = new JButton("ble");
        JButton button2 = new JButton("Prd");
        
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("w 300,h 300"));
        panel.add(prdbrd);
        panel.add(button2,"wrap");
        
        panel.add(button,"span 2 ,pushx,growx");

        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(panel);
                add(new JPanel().add(new GameDesk()));              
                pack();
                
                
            }
        });
        
        add(panel);
       
        pack();
        
        setVisible(true);
        setLocationRelativeTo(null);
        addWindowListener();

    }


    public void addWindowListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (exitDialog()) {
                    System.exit(0);
                }
            }
        });
    }
    
    public boolean exitDialog(){
        if(JOptionPane.showConfirmDialog(null,
            "Are you sure to close this window?", "Really Closing?",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            return true;
        }
        return false;
    }
    class NewGame implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            add(new JPanel().add(new GameDesk()));  
            pack();
        }
        
    }
    class ExitGame implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(exitDialog()){
                System.exit(0);
            }
            
        }
        
    }
}
