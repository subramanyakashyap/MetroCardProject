package com.station.pesistence;

import java.sql.SQLException;
import java.util.Collection;

import com.metro.bean.Station;

public interface StationDao {
	boolean addStation(String stationName) throws ClassNotFoundException, SQLException;
	Collection<Station> getAllStations() throws ClassNotFoundException, SQLException;
}
