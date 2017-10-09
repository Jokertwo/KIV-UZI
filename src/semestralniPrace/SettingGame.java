package semestralniPrace;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;


public class SettingGame extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 8533696883753184050L;

    private JRadioButton playerVsPlayer;
    private JRadioButton playerVsComp;
    
    private JComboBox<String> difficulty;
    
    private JPanel panel;
    private ButtonGroup group;
    
    private String[] listOfDifficulty = {"Easy", "Medium","Hard"};


    public SettingGame() {
        setLayout(new MigLayout("w 300,h 300"));
        init();
        
        add(playerVsComp);
        add(difficultyLevel(), "wrap");
        add(playerVsPlayer,"wrap");
        
        
    }


    private void init() {
        group = new ButtonGroup();
        playerVsComp = new JRadioButton("Player vs Computer",true);
        playerVsPlayer = new JRadioButton("Player vs Player");

        group.add(playerVsComp);
        group.add(playerVsPlayer);
        
    }
    
    private JPanel difficultyLevel(){
        panel = new JPanel();
        difficulty = new JComboBox<String>(listOfDifficulty);
        panel.add(difficulty);
                
        return panel;
    }

}
