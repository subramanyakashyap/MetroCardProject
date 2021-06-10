package com.station.service;

import java.sql.SQLException;

public interface StationService {
	boolean addStation(int id, String stationName) throws ClassNotFoundException, SQLException;
}
