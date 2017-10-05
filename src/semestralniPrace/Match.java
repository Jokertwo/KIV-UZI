package semestralniPrace;

import java.awt.Dimension;
import javax.swing.JToggleButton;
import Actions.MatchAction;


public class Match extends JToggleButton {

    /**
     * 
     */
    private static final long serialVersionUID = 286040224829902214L;

    private int group;


    public Match(String title,int group,Pile pile) {
        super(new MatchAction(title,group));
        this.group = group;
        setToolTipText(Integer.toString(this.group));
        setPreferredSize(new Dimension(70, 30));

    }
    public int getGroup(){
        return this.group;
    }
    
    

}
