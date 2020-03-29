
public class Scoreboard {
	Score[] score = new Score[13];
	public Scoreboard() {
		score[0] = new OnesScore();
		score[1] = new TwosScore();
		score[2] = new ThreesScore();
		score[3] = new FoursScore();
		score[4] = new FivesScore();
		score[5] = new SixesScore();
		score[6] = new ChanceScore();
		score[7] = new FourOfAKindScore();
		score[8] = new FullHouseScore();
		score[9] = new LargeStraightScore();
		score[10] = new SmallStraightScore();
		score[11] = new ThreeOfAKindScore();
		score[12] = new YahtzeeScore();
	}
	
	public String checkScore(YahtzeeDice dice) {
		String scoreboard = "Potential Scores: " + "\n";
		for (int i = 0; i < score.length; i++) {
			if (score[i].getTaken() == false) {
				//scoreboard += score[i].getName() + " (" + (i+1) + ") : " + score[i].calculateScore(dice) + " ";
				scoreboard += String.format("%-20s", (i+1) + ": " + score[i].getName() + " (" + 
						score[i].calculateScore(dice) + ")");
			}
			//if (i % 4 == 0 && i != 0) {
			//	scoreboard += "\n"; 
			//}
			
		}
		return scoreboard;
	}
	
	public String getScores() {
		String scoreboard = "";
		int total = 0;
		for (int i = 0; i < score.length; i++) {
			//scoreboard += score[i].getName() + " (" + (i+1) + ") : " + score[i].getVal() + " ";
			scoreboard += String.format("%-20s", (i+1) + ": " + score[i].getName() + " (" + 
					score[i].getVal() + ")");
			total += score[i].getVal();
			//if (i % 4 == 0 && i != 0) {
			//	scoreboard += "\n"; 
			//}
		}
		scoreboard += "Total score: " + total;
		return scoreboard;
	}
	
	public String changeScore(int index, YahtzeeDice dice) {
		index--;
		if (score[index].getTaken()) {
			return "Sorry, this category has already been taken";
		}
		int val = score[index].calculateScore(dice);
		score[index].setVal(val);
		score[index].setTaken(true);
		return "Great, that hasn't been taken";
	}
	
	
}
