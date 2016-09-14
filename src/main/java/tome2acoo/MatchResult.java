package tome2acoo;

public class MatchResult {
	private int id;
	private int participant_pk;
	private int points_earned;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParticipantPK() {
		return participant_pk;
	}
	public void setParticipantPK(int participant_pk) {
		this.participant_pk = participant_pk;
	}
	public int getPoints_earned() {
		return points_earned;
	}
	public void setPoints_earned(int points_earned) {
		this.points_earned = points_earned;
	}
	public int getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	private int player_id;
}
