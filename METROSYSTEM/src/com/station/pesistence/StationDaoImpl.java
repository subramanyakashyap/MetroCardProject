package com.station.pesistence;

import com.metro.bean.Station;
import com.metro.database.Stations;

public class StationDaoImpl implements StationDao {
	@Override
	public boolean addStation(int id, String stationName) {
		Station name = new Station(id, stationName);
		Stations.getStations().put(name.getId(), name);
		return true;
	}
}
