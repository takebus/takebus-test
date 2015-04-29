package com.takebus.dao;

import java.util.*;

import com.takebus.model.BusOperator;
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
		
		List<Station> ds = new ArrayList<Station>();
		ds.add(s1);
		ds.add(s2);
		
		List<Station> as = new ArrayList<Station>();
		as.add(s3);
		as.add(s4);
		
		BusOperator b1 = BusOperatorDao.instance.getModel().get("1");
		
		ScheduleDetail sd1 = new ScheduleDetail(1, "CBT423", "7:20am", ds, "11:30am", as, b1, 15, 50);
		ScheduleDetail sd2 = new ScheduleDetail(2, "CBT523", "12:50am", ds, "5:00pm", as, b1, 15, 50);
		ScheduleDetail sd3 = new ScheduleDetail(3, "CBT623", "5:50pm", ds, "10:00pm", as, b1, 15, 50);
		ScheduleDetail sd4 = new ScheduleDetail(4, "CBT723", "10:30pm", ds, "2:00am", as, b1, 15, 50);
		
		ScheduleDetail sd5 = new ScheduleDetail(5, "CBT134", "8:00am", as, "12:00pm", ds, b1, 15, 50);
		ScheduleDetail sd6 = new ScheduleDetail(6, "CBT723", "10:30pm", as, "2:00am", ds, b1, 15, 50);
		ScheduleDetail sd7 = new ScheduleDetail(7, "CBT234", "1:00pm", as, "4:30pm", ds, b1, 15, 50);
		ScheduleDetail sd8 = new ScheduleDetail(8, "CBT334", "6:00pm", as, "9:30pm", ds, b1, 15, 50);
		ScheduleDetail sd9 = new ScheduleDetail(9, "CBT13834", "8:30pm", as, "12:00pm", ds, b1, 15, 50);
	
		scheduleDetailPool.put("1", sd1);
		scheduleDetailPool.put("2", sd2);
		scheduleDetailPool.put("3", sd3);
		scheduleDetailPool.put("4", sd4);
		scheduleDetailPool.put("5", sd5);
		scheduleDetailPool.put("6", sd6);
		scheduleDetailPool.put("7", sd7);
		scheduleDetailPool.put("8", sd8);
		scheduleDetailPool.put("9", sd9);
	}
	
	public Map<String, ScheduleDetail> getModel() {
		return scheduleDetailPool;
	}
}
