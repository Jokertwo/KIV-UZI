package semestralniPrace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import net.miginfocom.swing.MigLayout;

/**
 * nastaveni hry
 * @author Petr
 *
 */
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
    private JSpinner countOfPile;
    private JSpinner matchInPile;

    private String[] listOfDifficulty = { Helper.EASY, Helper.MEDIUM, Helper.HARD };


    public SettingGame() {
        setLayout(new MigLayout("w 300,h 300"));
        init();

        add(playerVsComp);
        add(difficultyLevel(), "wrap,growx,pushx");
        add(playerVsPlayer, "wrap");

        add(new JSeparator(JSeparator.HORIZONTAL), "span 2, wrap, growx,pushx");

        add(new JLabel("Number of pile : "));
        add(countOfPile, "wrap ,growx,pushx , gapy 15 2");
        add(new JLabel("Number of matches in pile : "));
        add(matchInPile, "growx,pushx , wrap ,gapy 0 15");
        add(startGameButton(),"dock south");

    }


    private void init() {
        group = new ButtonGroup();
        playerVsComp = new JRadioButton("Player vs Computer", true);
        playerVsPlayer = new JRadioButton("Player vs Player");

        matchInPile = new JSpinner(integerModel());
        countOfPile = new JSpinner(integerModel());

        ((DefaultEditor) matchInPile.getEditor()).getTextField().setEditable(false);
        ((DefaultEditor) countOfPile.getEditor()).getTextField().setEditable(false);

        group.add(playerVsComp);
        group.add(playerVsPlayer);

        addListenerToPlayervsComp();
        addListenerToPlayerVsPlayer();
    }
    private JButton startGameButton(){
        JButton start = new JButton();
        start.setText("Start");
        start.addActionListener(new SettingNewGame());
        return start;
    }


    private JPanel difficultyLevel() {
        panel = new JPanel();
        difficulty = new JComboBox<String>(listOfDifficulty);
        panel.add(difficulty);

        return panel;
    }


    private SpinnerModel integerModel() {
        SpinnerModel model = new SpinnerNumberModel(6, 1, Helper.maxMatch, 1);
        return model;
    }


    private void addListenerToPlayervsComp() {
        playerVsComp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                difficulty.setEnabled(true);

            }
        });
    }


    private void addListenerToPlayerVsPlayer() {
        playerVsPlayer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                difficulty.setEnabled(false);

            }
        });
    }
    
    private class SettingNewGame implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Helper.gameSetting.put(Helper.OPONENT, getDifficulty());
            Helper.gameSetting.put(Helper.NUMBER_OF_MATCH,matchInPile.getValue().toString());
            Helper.gameSetting.put(Helper.NUMBER_OF_PILE, countOfPile.getValue().toString());
            new NewGame();
        }
        
        private String getDifficulty(){
            if(playerVsPlayer.isSelected()){
                return Helper.PLAYER;
            }
            else{
                return (String)difficulty.getSelectedItem();
            }
        }
        
    }
}
