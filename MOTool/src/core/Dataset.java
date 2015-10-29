/**
 *  MOTool - Organization Tool for Olympiads in Mathematics
 *  Copyright (C) 2015  Felix Eckardt, Tim Büchner
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published
 *  by the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package core;

import java.util.ArrayList;

public class Dataset {

	boolean saved = false;
	int year;
	String location;
	int[][] prices = {{0,0,0},	//grade  5
					  {0,0,0},	//grade  6
					  {0,0,0},	//grade  7
					  {0,0,0},	//grade  8
					  {0,0,0},	//grade  9
					  {0,0,0},	//grade 10
					  {0,0,0},	//grade 11
					  {0,0,0}};	//grade 12
	ArrayList<Participant> participants;
	//TODO Urkunden

	public Dataset() {}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
		saved = false;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
		saved = false;
	}

	/**
	 * @return the prices
	 */
	public int[][] getPrices() {
		return prices;
	}

	/**
	 * @param prices the prices to set
	 */
	public void setPrices(int[][] prices) {
		this.prices = prices;
		saved = false;
	}

	/**
	 * @return the participants
	 */
	public ArrayList<Participant> getParticipants() {
		return participants;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(ArrayList<Participant> participants) {
		this.participants = participants;
		saved = false;
	}

	/**
	 * @return the saved
	 */
	public boolean isSaved() {
		return saved;
	}

	/**
	 * @param saved the saved to set
	 */
	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	public void addParticipant(int id, String surname, String forename, int grade, String school, int[] points, int position,
			int price, boolean attendance, String room) {
		participants.add(new Participant(id, surname, forename, grade, school, points, position, price, attendance, room));
	}

	public void addParticipant(int id, String surname, String forename, int grade, String school) {
		participants.add(new Participant(id, surname, forename, grade, school));
	}
	
	public void removeParticipant(int id) {
		for(Participant participant : participants) {
			if(participant.getId()==id) {
				participants.remove(participant);
				break;
			}
		}
	}

}
