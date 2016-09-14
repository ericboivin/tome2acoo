package tome2acoo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class InputParser {

	private Map<Integer, Player> players = new HashMap<>();
	private Map<Integer, Match> matches = new HashMap<>();

	public static void main(String[] args) {
		InputParser p = new InputParser();
		p.parseInput();
	}

	public void parseInput() {

		try {
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("canNats2016.json");

			JsonNode rootNode = new ObjectMapper().readTree(in);

			Iterator<JsonNode> cardsIterator = rootNode.getElements();

			while (cardsIterator.hasNext()) {
				JsonNode root = cardsIterator.next();
				JsonNode participantsNode = root.get("Participant:#");
				if (participantsNode != null) {
					Iterator<JsonNode> participantsIterator = participantsNode.getElements().next().iterator();
					players = new HashMap<>();
					while (participantsIterator.hasNext()) {
						Player player = new Player();
						JsonNode participantNode = participantsIterator.next();
						player.setFirstName(participantNode.get("first_name").getTextValue());
						player.setLastName(participantNode.get("last_name").getTextValue());
						player.setId(participantNode.get("pk").getIntValue());
						players.put(player.getId(), player);

					}
					JsonNode matchesNode = root.get("MatchParticipant:#");
					Iterator<JsonNode> matchesIterator = matchesNode.getElements().next().iterator();
					matches = new HashMap<>();
					while (matchesIterator.hasNext()) {
						MatchResult result = new MatchResult();
						JsonNode matchNode = matchesIterator.next();

						result.setPoints_earned(matchNode.get("points_earned").getIntValue());
						result.setParticipantPK(matchNode.get("participant_pk").getIntValue());
						result.setId(matchNode.get("pk").getIntValue());

						Match match;

						if (matches.containsKey(matchNode.get("match_pk").getIntValue())) {
							match = matches.get(matchNode.get("match_pk").getIntValue());
							match.setScorePlayer2(result);
						} else {
							match = new Match();
							match.setScorePlayer1(result);
						}

						matches.put(matchNode.get("match_pk").getIntValue(), match);
						players.get(result.getParticipantPK()).addPoints(result.getPoints_earned());
					}
					
					for (Player player : players.values()) {
						player.setSos(calculateSOS(player));
					}
					
					List<Player> rankedPlayers = new ArrayList<Player>(players.values());

					Collections.sort(rankedPlayers, new Comparator<Player>() {

						public int compare(Player p1, Player p2) {
							if (p1.getPoints() < p2.getPoints()) {
								return 1;
							} else if (p1.getPoints() == p2.getPoints() && p1.getSos() < p2.getSos()) {
								return 1;
							}
							// TODO: Extended SoS tiebreaker
							return -1;
						}
					});

					int rank = 1;
					System.out.println("rank;player;prestige;sos;corp_identity;runner_identity");
					for (Player player : rankedPlayers) {
						
						System.out.println(rank + ";" + player.getFirstName() + " " + player.getLastName() + ";"
								+ player.getPoints() + ";" + player.getSos() + ";;");
						rank++;
					}
					// rank;player;prestige;sos;corp_identity;runner_identity

				}
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Match> getAllMatchesForPlayer(Player player) {
		List<Match> results = new ArrayList<Match>();

		for (Match match : matches.values()) {
			if (match.getScorePlayer1().getParticipantPK() == player.getId() || match.getScorePlayer2() != null
					&& match.getScorePlayer2().getParticipantPK() == player.getId()) {
				results.add(match);
			}
		}
		return results;
	}

	private float calculateSOS(Player player) {
		float sos = 0;
		List<Match> results = getAllMatchesForPlayer(player);
		List<Player> opponents = new ArrayList<Player>();

		for (Match match : results) {
			if (match.getScorePlayer2() == null) {
				// bye, no SOS
			} else {
				if (match.getScorePlayer1().getParticipantPK() == player.getId()) {
					opponents.add(players.get(match.getScorePlayer2().getParticipantPK()));
				} else {
					opponents.add(players.get(match.getScorePlayer1().getParticipantPK()));
				}
			}
		}

		for (Player opponent : opponents) {
			sos += opponent.averagePoints();
		}
		return sos / opponents.size();

	}

	private float calculateRoundAverage(Player player) {
		int numberMatches = returnMatchesForThisPlayer(player.getId()).size();

		return player.averagePoints() / numberMatches;

	}

	private List<Match> returnMatchesForThisPlayer(int player_id) {
		List<Match> results = new ArrayList<Match>();

		for (Match match : matches.values()) {

		}

		return results;
	}
}
