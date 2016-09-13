package tome2acoo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class InputParser {

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
					Map<Integer, Player> players = new HashMap<>();
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
					List<MatchResult> results = new ArrayList<MatchResult>();
					while (matchesIterator.hasNext()) {
						MatchResult result = new MatchResult();
						JsonNode matchNode = matchesIterator.next();
						result.setPoints_earned(matchNode.get("points_earned").getIntValue());
						result.setParticipantPK(matchNode.get("participant_pk").getIntValue());
						result.setId(matchNode.get("pk").getIntValue());
						result.setMatchPK(matchNode.get("match_pk").getIntValue());
						results.add(result);
						players.get(result.getParticipantPK()).addPrestige(result.getPoints_earned());
					}
					

					for(Player player : players.values()){
						System.out.println(";"+player.getFirstName()+ " "+ player.getLastName()+";"+player.getPrestige()+";;;"+player.averagePoints());
					}
					//rank;player;prestige;sos;corp_identity;runner_identity 

				}
				// Identity identity = new Identity();
				/*
				 * identity.setName(node.get("name").getTextValue());
				 * identity.setSide(node.get("side").getTextValue());
				 * identity.setFaction(node.get("faction").getTextValue());
				 * identity.setCode(node.get("code").getTextValue());
				 * //identities.put(identity.getCode(),identity);
				 * 
				 */
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
