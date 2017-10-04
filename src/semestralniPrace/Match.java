package semestralniPrace;

import java.awt.Dimension;
import javax.swing.JToggleButton;


public class Match extends JToggleButton {

    /**
     * 
     */
    private static final long serialVersionUID = 286040224829902214L;

    private int group;


    public Match(String title,int group) {
        super(title);
        this.group = group;
        setToolTipText(Integer.toString(this.group));
        setPreferredSize(new Dimension(70, 30));
        addActionListener(new MatchAction(this));
    }
    public int getGroup(){
        return this.group;
    }
    
    

}
