package semestralniPrace;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import actions.ExitGameAction;
import actions.GetSettingForNewGameAction;

/**
 * Menu aplikace obsahuji polozku pro novou hru a ukonceni hry
 * @author Petr
 *
 */
public class MenuBar extends JMenuBar {
    
    /**
     * 
     */
    private static final long serialVersionUID = 4452448783385185028L;

    public MenuBar() {
        add(game());
    }


    private JMenu game() {
        JMenu game = new JMenu("Game");

        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new GetSettingForNewGameAction());

        JMenuItem exitGame = new JMenuItem("Exit");
        exitGame.addActionListener(new ExitGameAction());
        game.add(newGame);
        game.add(exitGame);
        return game;
    }


    /**
     * v menu mela byt puvodne i napoveda ale nezbyl cas ji dodelat
     * @return
     */
    private JMenu help() {
        JMenu help = new JMenu("Help");

        JMenuItem rule = new JMenuItem("Rules");
        JMenuItem about = new JMenuItem("About");

        help.add(rule);
        help.add(about);
        return help;
    }
    
}
