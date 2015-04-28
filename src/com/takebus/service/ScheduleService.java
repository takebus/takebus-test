package com.takebus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;
import com.takebus.model.Schedule;

@Path("/schedule")
public class ScheduleService {
	
	@POST
	@Path("/getschedule")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getSchedule(@FormParam("departure") String departure,
							  @FormParam("arrival") String arrival,
							  @FormParam("departureDate") String departureDate,
							  @FormParam("returnDate") String returnDate) {
		
		System.out.println("getSchedule() called");
		
		String schedules = null;
		String schedulesDep = null;
		String schedulesArr = null;
		Map<String, String> returnSchedules;
		
		if (!isNotNull(returnDate) && isNotNull(departure) && isNotNull(arrival) && departure.equals("New York, NY") && arrival.equals("Albany, NY")) {
			schedulesDep = constructJSON(generateScheduleNA());
			
			returnSchedules = new HashMap<>();
			returnSchedules.put("departure", schedulesDep);
			
			Gson gson = new Gson();
			schedules = gson.toJson(returnSchedules);

			return schedules;
		}
		else if (!isNotNull(returnDate) && isNotNull(departure) && isNotNull(arrival) && departure.equals("Albany, NY") && arrival.equals("New York, NY")) {
			schedulesDep = constructJSON(generateScheduleAN());
			
			returnSchedules = new HashMap<>();
			returnSchedules.put("departure", schedulesDep);
			
			Gson gson = new Gson();
			schedules = gson.toJson(returnSchedules);

			return schedules;
		}
		else if (isNotNull(returnDate) && isNotNull(departure) && isNotNull(arrival) && departure.equals("New York, NY") && arrival.equals("Albany, NY")) {
			schedulesDep = constructJSON(generateScheduleNA());
			schedulesArr = constructJSON(generateScheduleAN());
			
			returnSchedules = new HashMap<>();
			returnSchedules.put("departure", schedulesDep);
			returnSchedules.put("return", schedulesArr);
			
			Gson gson = new Gson();
			schedules = gson.toJson(returnSchedules);
			
			System.out.println(schedules);
		}
		else if (isNotNull(returnDate) && isNotNull(departure) && isNotNull(arrival) && departure.equals("Albany, NY") && arrival.equals("New York, NY")) {
			schedulesDep = constructJSON(generateScheduleAN());
			schedulesArr = constructJSON(generateScheduleNA());
			
			returnSchedules = new HashMap<>();
			returnSchedules.put("deparutre", schedulesDep);
			returnSchedules.put("return", schedulesArr);
			
			Gson gson = new Gson();
			schedules = gson.toJson(returnSchedules);
			
			System.out.println(schedules);
		}
		else {
			JSONObject jobj = new JSONObject();
			try {
				jobj.put("schedule", "not found");
				schedules = jobj.toString();
				System.out.println(schedules);
			} 
			catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return schedules;	
	}
	
	private ArrayList<Schedule> generateScheduleAN() {
		System.out.println("generateScheduleAN() called");
		
		ArrayList<Schedule> schedules = new ArrayList<>();
		
		Schedule schedule1 = new Schedule("7:20am", "11:30am", "Capital Bus Tours", "CBT583", 
										  "$15", "1400 Washington Ave", "3 Allen St", "4h10m",
										  "50");
		
		Schedule schedule2 = new Schedule("7:20am", "11:00am", "Capital Bus Tours", "CBT583", 
				  						  "$15", "1400 Washington Ave", "888 6th Ave", "3h40m",
				  						  "50");
		
		Schedule schedule3 = new Schedule("8:00am", "11:00am", "Capital Bus Tours", "CBT583", 
				  						  "$15", "217 Central Ave", "888 6th Ave", "3h",
				  						  "42");
		
		Schedule schedule4 = new Schedule("8:00am", "11:30am", "Capital Bus Tours", "CBT583", 
				  						  "$15", "217 Central Ave", "3 Allen St", "3h30m",
				  						  "34");
		
		Schedule schedule5 = new Schedule("12:50pm", "5:00pm", "Capital Bus Tours", "CBT683", 
				  						  "$15", "1400 Washington Ave", "3 Allen St", "4h10m",
				  						  "15");
		
		Schedule schedule6 = new Schedule("12:50pm", "4:30pm", "Capital Bus Tours", "CBT683", 
				  						  "$15", "1400 Washington Ave", "888 6th Ave", "3h40m",
				  						  "9");

		Schedule schedule7 = new Schedule("1:30pm", "4:30pm", "Capital Bus Tours", "CBT683", 
				  						  "$15", "217 Central Ave", "888 6th Ave", "3h",
				  						  "38");

		Schedule schedule8 = new Schedule("1:30pm", "5:00pm", "Capital Bus Tours", "CBT683", 
				  						  "$15", "217 Central Ave", "3 Allen St", "3h30m",
				  						  "19");
		
		Schedule schedule9 = new Schedule("5:50pm", "10:00pm", "Capital Bus Tours", "CBT783", 
				  						  "$15", "1400 Washington Ave", "3 Allen St", "4h10m",
				  						  "29");

		Schedule schedule10 = new Schedule("5:50pm", "9:30pm", "Capital Bus Tours", "CBT783", 
				  						  "$15", "1400 Washington Ave", "888 6th Ave", "3h40m",
				  						  "30");

		Schedule schedule11 = new Schedule("6:30pm", "9:30pm", "Capital Bus Tours", "CBT783", 
				  						  "$15", "217 Central Ave", "888 6th Ave", "3h",
				  						  "42");

		Schedule schedule12 = new Schedule("6:30pm", "10:00pm", "Capital Bus Tours", "CBT783", 
				  						  "$15", "217 Central Ave", "3 Allen St", "3h30m",
				  						  "23");
		
		Schedule schedule13 = new Schedule("10:30pm", "2:00am", "Capital Bus Tours", "CBT883", 
				  						   "$15", "217 Central Ave", "3 Allen St", "3h30m",
				  						   "12");

		Schedule schedule14 = new Schedule("10:30pm", "1:30am", "Capital Bus Tours", "CBT883", 
				  						   "$15", "217 Central Ave", "888 6th Ave", "3h",
				  						   "2");
		
		schedules.add(schedule1);
		schedules.add(schedule2);
		schedules.add(schedule3);
		schedules.add(schedule4);
		schedules.add(schedule5);
		schedules.add(schedule6);
		schedules.add(schedule7);
		schedules.add(schedule8);
		schedules.add(schedule9);
		schedules.add(schedule10);
		schedules.add(schedule11);
		schedules.add(schedule12);
		schedules.add(schedule13);
		schedules.add(schedule14);		
		
		return schedules;
	}
	
	private ArrayList<Schedule> generateScheduleNA() {
		System.out.println("generateScheduleNA() called");
		
		ArrayList<Schedule> schedules = new ArrayList<>();
		
		Schedule schedule1 = new Schedule("8:00am", "12:00pm", "Capital Bus Tours", "CBT134", 
										  "$15", "3 Allen St", "1400 Washington Ave", "4h",
										  "13");
		
		Schedule schedule2 = new Schedule("8:00am", "11:30am", "Capital Bus Tours", "CBT134", 
				  						  "$15", "3 Allen St", "217 Central Ave", "3h30m",
				  						  "13");
		
		Schedule schedule3 = new Schedule("8:30am", "11:30am", "Capital Bus Tours", "CBT134", 
				  						  "$15", "888 6th Ave", "217 Central Ave", "3h",
				  						  "29");
		
		Schedule schedule4 = new Schedule("8:30am", "12:00am", "Capital Bus Tours", "CBT134", 
				  						  "$15", "888 6th Ave", "1400 Washington Ave", "3h30m",
				  						  "30");
		
		Schedule schedule5 = new Schedule("1:00pm", "4:30pm", "Capital Bus Tours", "CBT234", 
				  						  "$15", "3 Allen St", "1400 Washington Ave", "3h30m",
				  						  "28");

		Schedule schedule6 = new Schedule("1:00pm", "4:00pm", "Capital Bus Tours", "CBT234", 
				  						  "$15", "3 Allen St", "217 Central Ave", "3h",
				  						  "8");

		Schedule schedule7 = new Schedule("1:30pm", "4:00pm", "Capital Bus Tours", "CBT234", 
				  						  "$15", "888 6th Ave", "217 Central Ave", "2h30m",
				  						  "21");

		Schedule schedule8 = new Schedule("1:30pm", "4:30pm", "Capital Bus Tours", "CBT234", 
				  						  "$15", "888 6th Ave", "1400 Washington Ave", "3h",
				  						  "30");
		
		Schedule schedule9 = new Schedule("6:00pm", "9:30pm", "Capital Bus Tours", "CBT334", 
										  "$15", "3 Allen St", "1400 Washington Ave", "3h30m",
										  "43");

		Schedule schedule10 = new Schedule("6:00pm", "9:00pm", "Capital Bus Tours", "CBT334", 
										  "$15", "3 Allen St", "217 Central Ave", "3h",
										  "33");

		Schedule schedule11 = new Schedule("6:30pm", "9:00pm", "Capital Bus Tours", "CBT334", 
										  "$15", "888 6th Ave", "217 Central Ave", "2h30m",
										  "15");

		Schedule schedule12 = new Schedule("6:30pm", "9:30pm", "Capital Bus Tours", "CBT334", 
										  "$15", "888 6th Ave", "1400 Washington Ave", "3h",
										  "29");
		
		Schedule schedule13 = new Schedule("8:30pm", "12:00am", "Capital Bus Tours", "CBT13834", 
										  "$15", "3 Allen St", "1400 Washington Ave", "3h30",
										  "50");

		Schedule schedule14 = new Schedule("8:30pm", "11:30pm", "Capital Bus Tours", "CBT13834", 
										  "$15", "3 Allen St", "217 Central Ave", "3h",
										  "50");

		Schedule schedule15 = new Schedule("9:00pm", "11:30pm", "Capital Bus Tours", "CBT13834", 
										  "$15", "888 6th Ave", "217 Central Ave", "2h30m",
										  "36");

		Schedule schedule16 = new Schedule("9:00pm", "12:00am", "Capital Bus Tours", "CBT13834", 
										  "$15", "888 6th Ave", "1400 Washington Ave", "3h",
										  "49");
		
		schedules.add(schedule1);
		schedules.add(schedule2);
		schedules.add(schedule3);
		schedules.add(schedule4);
		schedules.add(schedule5);
		schedules.add(schedule6);
		schedules.add(schedule7);
		schedules.add(schedule8);
		schedules.add(schedule9);
		schedules.add(schedule10);
		schedules.add(schedule11);
		schedules.add(schedule12);
		schedules.add(schedule13);
		schedules.add(schedule14);		
		schedules.add(schedule15);
		schedules.add(schedule16);
		
		return schedules;
	}
	
	private static boolean isNotNull(String txt) {
		return txt != null && txt.trim().length() >= 0 ? true : false;
	}
	
	private String constructJSON(ArrayList<Schedule> schedules) {
		System.out.println("constructJSON() called");
		
		Gson gson = new Gson();
		String jsonArray = gson.toJson(schedules);
		
		return jsonArray;
	}
}
