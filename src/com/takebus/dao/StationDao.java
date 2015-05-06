package com.takebus.dao;

import java.util.*;

import com.takebus.model.Station;

public enum StationDao {

	instance;
	
	private Map<String, Station> stationPool = new HashMap<String, Station>();
	
	private StationDao() {
		
		Station s1 = new Station(1, "1400 Washington Ave", "Albany", "NY", "");
		Station s2 = new Station(2, "217 Central Ave", "Albany", "NY", "");
		
		Station s3 = new Station(3, "888 6th Ave", "New York", "NY", "");
		Station s4 = new Station(4, "3 Allen St", "New York", "NY", "");
		
		Station s5 = new Station(5, "900 State street", "Schenectady", "NY", "");
		
		stationPool.put("1", s1);
		stationPool.put("2", s2);
		stationPool.put("3", s3);
		stationPool.put("4", s4);
		stationPool.put("5", s5);
	}
	
	public Map<String, Station> getModel() {
		return stationPool;
	}
}
