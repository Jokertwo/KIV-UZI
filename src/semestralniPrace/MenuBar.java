package semestralniPrace;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Actions.ExitGameAction;
import Actions.NewGameAction;


public class MenuBar extends JMenuBar {
    
    /**
     * 
     */
    private static final long serialVersionUID = 4452448783385185028L;
    private Gui frame;
    
    public MenuBar(Gui frame) {
        this.frame = frame;
        add(game());
        add(help());
    }


    private JMenu game() {
        JMenu game = new JMenu("Game");

        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new NewGameAction(this.frame));

        JMenuItem exitGame = new JMenuItem("Exit");
        exitGame.addActionListener(new ExitGameAction());
        game.add(newGame);
        game.add(exitGame);
        return game;
    }


    private JMenu help() {
        JMenu help = new JMenu("Help");

        JMenuItem rule = new JMenuItem("Rules");
        JMenuItem about = new JMenuItem("About");

        help.add(rule);
        help.add(about);
        return help;
    }
    
}
