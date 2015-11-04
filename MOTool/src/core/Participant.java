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

public class Participant {

	int id;
	String surname;
	String forename;
	int grade;
	String school;
	int[] points;
	int position;
	int price;			//0 = no price, 1-3 = price 1-3, 4 = appreciation
	boolean attendance;
	String room;

	public Participant() {}

	public Participant(int id, String surname, String forename, int grade, String school, int[] points, int position,
			int price, boolean attendance, String room) {
		this.id = id;
		this.surname = surname;
		this.forename = forename;
		this.grade = grade;
		this.school = school;
		this.points = points;
		this.position = position;
		this.price = price;
		this.attendance = attendance;
		this.room = room;
	}

	public Participant(int id, String surname, String forename, int grade, String school) {
		this.id = id;
		this.surname = surname;
		this.forename = forename;
		this.grade = grade;
		this.school = school;
		this.points = new int[]{0,0,0,0};
		this.position = 0;
		this.price = 0;
		this.attendance = true;
		this.room = "None";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the forename
	 */
	public String getForename() {
		return forename;
	}

	/**
	 * @param forename the forename to set
	 */
	public void setForename(String forename) {
		this.forename = forename;
	}

	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/**
	 * @return the points
	 */
	public int[] getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int[] points) {
		this.points = points;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the attendance
	 */
	public boolean isAttendance() {
		return attendance;
	}

	/**
	 * @param attendance the attendance to set
	 */
	public void setAttendance(boolean attendance) {
		this.attendance = attendance;
	}

	/**
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(String room) {
		this.room = room;
	}

}
