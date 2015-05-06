package com.takebus.dao;

import java.util.*;

import com.takebus.model.BusOperator;
import com.takebus.model.Duration;
import com.takebus.model.Schedule;
import com.takebus.model.ScheduleDetail;
import com.takebus.model.Station;

public enum ScheduleDetailDao {

	instance;
	
	private Map<String, ScheduleDetail> scheduleDetailPool = new HashMap<String, ScheduleDetail>();
	
	private ScheduleDetailDao() {
		
		Station s1 = StationDao.instance.getModel().get("1");
		Station s2 = StationDao.instance.getModel().get("2");
		Station s3 = StationDao.instance.getModel().get("3");
		Station s4 = StationDao.instance.getModel().get("4");
		
		List<Station> ds1 = new ArrayList<Station>();
		s1.setTime("7:20am");
		s2.setTime("8:00am");
		ds1.add(s1);
		ds1.add(s2);
		List<Station> as1 = new ArrayList<Station>();
		s3.setTime("11:00");
		s4.setTime("11:30");
		as1.add(s3);
		as1.add(s4);
		
		Duration d1_13 = new Duration(1, "7:20am", 3, "11:00am", "3h40m");
		Duration d1_14 = new Duration(1, "7:20am", 4, "11:30am", "4h10m");
		Duration d1_23 = new Duration(2, "8:00am", 3, "11:00am", "3h");
		Duration d1_24 = new Duration(2, "8:00am", 4, "11:30am", "3h30m");	
		List<Duration> ld1 = new ArrayList<Duration>();
		ld1.add(d1_13);
		ld1.add(d1_14);
		ld1.add(d1_23);
		ld1.add(d1_24);
		
		List<Station> ds2 = new ArrayList<Station>();
		s1.setTime("12:50pm");
		s2.setTime("1:30pm");
		ds2.add(s1);
		ds2.add(s2);
		List<Station> as2 = new ArrayList<Station>();
		s3.setTime("4:30pm");
		s4.setTime("5:00pm");
		as2.add(s3);
		as2.add(s4);
	
		Duration d2_13 = new Duration(1, "12:50pm", 3, "4:30pm", "3h40m");
		Duration d2_14 = new Duration(1, "12:50pm", 4, "5:00pm", "4h10m");
		Duration d2_23 = new Duration(2, "1:30pm", 3, "4:30pm", "3h");
		Duration d2_24 = new Duration(2, "1:30pm", 4, "5:00pm", "3h30m");	
		List<Duration> ld2 = new ArrayList<Duration>();
		ld2.add(d2_13);
		ld2.add(d2_14);
		ld2.add(d2_23);
		ld2.add(d2_24);
	
		List<Station> ds3 = new ArrayList<Station>();
		s1.setTime("5:50pm");
		s2.setTime("6:30pm");
		ds3.add(s1);
		ds3.add(s2);
		List<Station> as3 = new ArrayList<Station>();
		s3.setTime("9:30pm");
		s4.setTime("10:00pm");
		as3.add(s3);
		as3.add(s4);
		
		Duration d3_13 = new Duration(1, "5:50pm", 3, "9:30pm", "3h40m");
		Duration d3_14 = new Duration(1, "5:50pm", 4, "10:00pm", "4h10m");
		Duration d3_23 = new Duration(2, "6:30pm", 3, "9:30pm", "3h");
		Duration d3_24 = new Duration(2, "6:30pm", 4, "10:00pm", "3h30m");
		List<Duration> ld3 = new ArrayList<Duration>();
		ld3.add(d3_13);
		ld3.add(d3_14);
		ld3.add(d3_23);
		ld3.add(d3_24);
		
		List<Station> ds4 = new ArrayList<Station>();
		s2.setTime("10:30pm");
		ds4.add(s2);
		List<Station> as4 = new ArrayList<Station>();
		s3.setTime("1:30am");
		s4.setTime("2:00am");
		as4.add(s3);
		as4.add(s4);
		
		Duration d4_23 = new Duration(2, "10:30pm", 3, "1:30am", "3h40m");
		Duration d4_24 = new Duration(2, "10:30pm", 4, "2:00am", "4h10m");
		List<Duration> ld4 = new ArrayList<Duration>();
		ld4.add(d4_23);
		ld4.add(d4_24);
		
		List<Station> ds5 = new ArrayList<Station>();
		s4.setTime("8:00am");
		s3.setTime("8:30am");
		ds5.add(s4);
		ds5.add(s3);
		List<Station> as5 = new ArrayList<Station>();
		s2.setTime("11:30am");
		s1.setTime("12:00pm");
		as5.add(s2);
		as5.add(s1);
	
		Duration d5_42 = new Duration(4, "8:00am", 2, "11:30am", "3h30m");
		Duration d5_41 = new Duration(4, "8:00am", 1, "12:00pm", "4h");
		Duration d5_32 = new Duration(3, "8:30am", 2, "11:30am", "3h");
		Duration d5_31 = new Duration(3, "8:30am", 1, "12:00pm", "3h30m");
		List<Duration> ld5 = new ArrayList<Duration>();
		ld5.add(d5_42);
		ld5.add(d5_41);
		ld5.add(d5_32);
		ld5.add(d5_31);
		
		List<Station> ds6 = new ArrayList<Station>();
		s4.setTime("1:00pm");
		s3.setTime("1:30pm");
		ds6.add(s4);
		ds6.add(s3);
		List<Station> as6 = new ArrayList<Station>();
		s2.setTime("4:00pm");
		s1.setTime("4:30pm");
		as6.add(s2);
		as6.add(s1);
	
		Duration d6_42 = new Duration(4, "1:00pm", 2, "4:00pm", "3h");
		Duration d6_41 = new Duration(4, "1:00pm", 1, "4:30pm", "3h30m");
		Duration d6_32 = new Duration(3, "1:30pm", 2, "4:00pm", "3h30m");
		Duration d6_31 = new Duration(3, "1:30pm", 1, "4:30pm", "3h");
		List<Duration> ld6 = new ArrayList<Duration>();
		ld6.add(d6_42);
		ld6.add(d6_41);
		ld6.add(d6_32);
		ld6.add(d6_31);
		
		
		List<Station> ds7 = new ArrayList<Station>();
		s4.setTime("6:00pm");
		s3.setTime("6:30pm");
		ds7.add(s4);
		ds7.add(s3);
		List<Station> as7 = new ArrayList<Station>();
		s2.setTime("9:00pm");
		s1.setTime("9:30pm");
		as7.add(s2);
		as7.add(s1);
		
		Duration d7_42 = new Duration(4, "6:00pm", 2, "9:00pm", "3h");
		Duration d7_41 = new Duration(4, "6:00pm", 1, "9:30pm", "3h30m");
		Duration d7_32 = new Duration(3, "6:30pm", 2, "9:00pm", "3h30m");
		Duration d7_31 = new Duration(3, "6:30pm", 1, "9:30pm", "3h");
		List<Duration> ld7 = new ArrayList<Duration>();
		ld7.add(d7_42);
		ld7.add(d7_41);
		ld7.add(d7_32);
		ld7.add(d7_31);
		
		List<Station> ds8 = new ArrayList<Station>();
		s4.setTime("8:30pm");
		s3.setTime("9:00am");
		ds8.add(s4);
		ds8.add(s3);
		List<Station> as8 = new ArrayList<Station>();
		s2.setTime("12:00am");
		s1.setTime("11:30pm");
		as8.add(s2);
		as8.add(s1);
		
		Duration d8_42 = new Duration(4, "8:30pm", 2, "12:00am", "3h30m");
		Duration d8_41 = new Duration(4, "8:30pm", 1, "11:30pm", "3h");
		Duration d8_32 = new Duration(3, "9:00am", 2, "12:00am", "3h");
		Duration d8_31 = new Duration(3, "9:00am", 1, "11:30pm", "3h30m");
		List<Duration> ld8 = new ArrayList<Duration>();
		ld8.add(d8_42);
		ld8.add(d8_41);
		ld8.add(d8_32);
		ld8.add(d8_31);
		
		BusOperator b1 = BusOperatorDao.instance.getModel().get("1");

		
		ScheduleDetail sd1 = new ScheduleDetail(1, "CBT423", "7:20am", ds1, "11:30am", as1, ld1, b1, 15, 50);
		ScheduleDetail sd2 = new ScheduleDetail(2, "CBT523", "12:50am", ds2, "5:00pm", as2, ld2, b1, 15, 50);
		ScheduleDetail sd3 = new ScheduleDetail(3, "CBT623", "5:50pm", ds3, "10:00pm", as3, ld3, b1, 15, 50);
		ScheduleDetail sd4 = new ScheduleDetail(4, "CBT723", "10:30pm", ds4, "2:00am", as4, ld4, b1, 15, 50);
		
		ScheduleDetail sd5 = new ScheduleDetail(5, "CBT134", "8:00am", ds5, "12:00pm", as5, ld5, b1, 15, 50);
		ScheduleDetail sd6 = new ScheduleDetail(6, "CBT234", "1:00pm", ds6, "4:30pm", as6, ld6, b1, 15, 50);
		ScheduleDetail sd7 = new ScheduleDetail(7, "CBT334", "6:00pm", ds7, "9:30pm", as7, ld7, b1, 15, 50);
		ScheduleDetail sd8 = new ScheduleDetail(8, "CBT13834", "8:30pm", ds8, "12:00am", as8, ld8, b1, 15, 50);
	
		scheduleDetailPool.put("1", sd1);
		scheduleDetailPool.put("2", sd2);
		scheduleDetailPool.put("3", sd3);
		scheduleDetailPool.put("4", sd4);
		scheduleDetailPool.put("5", sd5);
		scheduleDetailPool.put("6", sd6);
		scheduleDetailPool.put("7", sd7);
		scheduleDetailPool.put("8", sd8);

	}
	
	public Map<String, ScheduleDetail> getModel() {
		return scheduleDetailPool;
	}
}
