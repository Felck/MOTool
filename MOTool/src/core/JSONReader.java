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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.sound.midi.Patch;

public class JSONReader {

	JsonParser jsonParser;

	public JSONReader(String jsonFile) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(jsonFile);
		jsonParser = Json.createParser(fis);
	}

	public Dataset parseDataset() throws Exception { // TODO exception handling
		Dataset dataset = new Dataset();
		while (jsonParser.hasNext()) {
			Event event = jsonParser.next();
			switch (event) {
			case KEY_NAME:
				switch (jsonParser.getString()) {
				case "year":
					jsonParser.next();
					dataset.setYear(jsonParser.getInt());
					break;
				case "location":
					jsonParser.next();
					dataset.setLocation(jsonParser.getString());
					break;
				case "prices":
					int[][] prices = new int[8][3];
					for (int grade = 0; grade < 8; grade++) {
						for (int i = 0; i < 3; i++) {
							// skip everything until VALUE_NUMBER
							while (jsonParser.next() != Event.VALUE_NUMBER)
								;
							prices[grade][i] = jsonParser.getInt();
						}
					}
					dataset.setPrices(prices);
					break;
				case "participants":
					System.out.println("participants");
					ArrayList<Participant> participants = new ArrayList<Participant>();
					event = jsonParser.next();
					while (event != Event.END_ARRAY) {
						switch (event) {
						case START_OBJECT:
							participants.add(parseParticipant());
							break;
						default:
							break;
						}
						event = jsonParser.next();
					}
					dataset.setParticipants(participants);
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		}
		return dataset;
	}

	Participant parseParticipant() {
		Participant participant = new Participant();
		Event event = jsonParser.next();
		while (event != Event.END_OBJECT) {
			if (event == Event.KEY_NAME) {
				switch (jsonParser.getString()) {
				case "id":
					jsonParser.next();
					participant.setId(jsonParser.getInt());
					break;
				case "surname":
					jsonParser.next();
					participant.setSurname(jsonParser.getString());
					break;
				case "forename":
					jsonParser.next();
					participant.setForename(jsonParser.getString());
					break;
				case "grade":
					jsonParser.next();
					participant.setGrade(jsonParser.getInt());
					break;
				case "school":
					jsonParser.next();
					participant.setSchool(jsonParser.getString());
					break;
				case "points":
					int[] points = new int[4];
					for (int i = 0; i < 4; i++) {
						// skip everything until VALUE_NUMBER
						while (jsonParser.next() != Event.VALUE_NUMBER)
							;
						points[i] = jsonParser.getInt();
					}
					participant.setPoints(points);
					break;
				case "position":
					jsonParser.next();
					participant.setPosition(jsonParser.getInt());
					break;
				case "price":
					jsonParser.next();
					participant.setPrice(jsonParser.getInt());
					break;
				case "attendance":
					if (jsonParser.next() == Event.VALUE_TRUE) {
						participant.setAttendance(true);
					} else {
						participant.setAttendance(false);
					}
					break;
				case "room":
					jsonParser.next();
					participant.setRoom(jsonParser.getString());
					break;
				default:
					break;
				}
			}
			event = jsonParser.next();
		}

		return participant;
	}

}
