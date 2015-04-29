package com.takebus.dao;

import java.util.*;

import com.takebus.model.Schedule;

public enum ScheduleDao {

	instance;
	
	private Map<String, Schedule> schedulePool = new HashMap<String, Schedule>();
	
	private ScheduleDao() {
		Schedule s1 = new Schedule(1, "CBT423", 1, "7:20am", 2, "11:30am", 1, 15, 50);
		Schedule s2 = new Schedule(2, "CBT523", 1, "12:50am", 2, "5:00pm", 1, 15, 50);
		Schedule s3 = new Schedule(3, "CBT623", 1, "5:50pm", 2, "10:00pm", 1, 15, 50);
		Schedule s4 = new Schedule(4, "CBT723", 1, "10:30pm", 2, "2:00am", 1, 15, 50);
		
		Schedule s5 = new Schedule(5, "CBT134", 2, "8:00am", 1, "12:00pm", 1, 15, 50);
		Schedule s6 = new Schedule(6, "CBT723", 2, "10:30pm", 1, "2:00am", 1, 15, 50);
		Schedule s7 = new Schedule(7, "CBT234", 2, "1:00pm", 1, "4:30pm", 1, 15, 50);
		Schedule s8 = new Schedule(8, "CBT334", 2, "6:00pm", 1, "9:30pm", 1, 15, 50);
		Schedule s9 = new Schedule(9, "CBT13834", 2, "8:30pm", 1, "12:00pm", 1, 15, 50);
		
		
		schedulePool.put("1", s1);
		schedulePool.put("2", s2);
		schedulePool.put("3", s3);
		schedulePool.put("4", s4);
		schedulePool.put("5", s5);
		schedulePool.put("6", s6);
		schedulePool.put("7", s7);
		schedulePool.put("8", s8);
		schedulePool.put("9", s9);
	}
	
	public Map<String, Schedule> getModel() {
		return schedulePool;
	}
}