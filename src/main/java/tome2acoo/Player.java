package tome2acoo;

import java.util.ArrayList;
import java.util.List;

public class Player {
	int id;
	String firstName;
	String lastName;
	int rank;
	int prestige;
	String sos;
	String corp;
	String runner;
	List<Integer> matches = new ArrayList<>();
	
	
	public void addPrestige(int points) {
		prestige += points;
		addMatch(points);
	}
	
	public String getName(){
		return firstName = " " + lastName;
	}
	
	public void addMatch(int points){
		matches.add(points);
	}
	
	public float averagePoints(){
		float total = 0;
		int count = 1;
		for(int result : matches){
			total += result;
			count++;
		}
		return total/count;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getPrestige() {
		return prestige;
	}
	public void setPrestige(int prestige) {
		this.prestige = prestige;
	}
	public String getSos() {
		return sos;
	}
	public void setSos(String sos) {
		this.sos = sos;
	}
	public String getCorp() {
		return corp;
	}
	public void setCorp(String corp) {
		this.corp = corp;
	}
	public String getRunner() {
		return runner;
	}
	public void setRunner(String runner) {
		this.runner = runner;
	}
}
