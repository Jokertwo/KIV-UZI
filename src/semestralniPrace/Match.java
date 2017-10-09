package semestralniPrace;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import actions.MatchAction;
import net.coobird.thumbnailator.Thumbnails;


public class Match extends JToggleButton {

    /**
     * 
     */
    private static final long serialVersionUID = 286040224829902214L;

    private int group;
    static ImageIcon icon;
    static ImageIcon selectIcon;
    static {
        try {
            BufferedImage match = ImageIO.read(new File("res/Match_Icon.png"));
            match = Thumbnails.of(match).forceSize(30, 50).asBufferedImage();

            BufferedImage select = ImageIO.read(new File("res/2000px-Cancelled_cross.svg.png"));
            select = Thumbnails.of(select).forceSize(30, 30).asBufferedImage();

            BufferedImage selectedMatch = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = selectedMatch.createGraphics();
            g.drawImage(match, 0, 0, null);
            g.drawImage(select, 0, match.getHeight() / 2 - select.getHeight() / 2, null);
            g.dispose();

            icon = new ImageIcon(match);
            selectIcon = new ImageIcon(selectedMatch);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public Match(int group) {
        super(new MatchAction(group));
        this.group = group;

        setIcon(icon);
        setSelectedIcon(selectIcon);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusable(false);
    }


    public int getGroup() {
        return this.group;
    }

}
