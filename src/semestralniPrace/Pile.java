package semestralniPrace;

import java.util.ArrayList;
import java.util.List;

public class Pile {

	private List<Match> matches;

	public Pile(int countOfMatches) {		
		init(countOfMatches);
	}
	
	private void init(int countOfMatches){
		matches = new ArrayList<>();
		for(int i = 0; i < countOfMatches; i++){
			matches.add(new Match(Integer.toString(i)));
		}
	}
	public int getCountOfMatches(){
		return matches.size();
	}

	public void removeMatch(int number) {

		for(int i = 0 ; i < number; i++){
			matches.remove(matches.size()-1);
		}
	}

}
