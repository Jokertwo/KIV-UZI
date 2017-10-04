package semestralniPrace;

import java.util.ArrayList;
import java.util.List;


public class Pile {

    private List<Match> matches;
    private int group;
    private boolean isEnable = true;


    public Pile(int countOfMatches,int group) {
        this.group = group;
        init(countOfMatches,group);
        
    }


    private void init(int countOfMatches,int group) {
        matches = new ArrayList<>();
        for (int i = 0; i < countOfMatches; i++) {
            matches.add(new Match(Integer.toString(i),group));
        }
    }
    
    public List<Match> getMatches(){
        return matches;
    }


    public int getCountOfMatches() {
        return matches.size();
    }


    public void removeMatch(int number) {

        for (int i = 0; i < number; i++) {
            matches.remove(matches.size() - 1);
        }
    }
    
    public void setMatchDisable(){
        for(Match item: matches){
            item.setEnabled(false);
        }
        isEnable = false;
    }
    
    public void setMatchEnable(){
        for(Match item : matches){
            item.setEnabled(true);
        }
        isEnable = true;
    }
    public boolean getIsEnable(){
        return this.isEnable;
    }
    public int getGroup(){
        return this.group;
    }

}
