package tome2acoo;

public class Match {
	private int id;
	private int round;
	private MatchResult scorePlayer1;
	private MatchResult scorePlayer2;
	
	public MatchResult getOpponentResult(int player_id){
		if (scorePlayer2 == null){
			return null; //Bye
		}
		if (scorePlayer1.getParticipantPK() == player_id){
			return scorePlayer2;
		}else{
			return scorePlayer1;
		}
	}
	
	public MatchResult getScorePlayer1() {
		return scorePlayer1;
	}
	public void setScorePlayer1(MatchResult scorePlayer1) {
		this.scorePlayer1 = scorePlayer1;
	}
	public MatchResult getScorePlayer2() {
		return scorePlayer2;
	}
	public void setScorePlayer2(MatchResult scorePlayer2) {
		this.scorePlayer2 = scorePlayer2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
}
