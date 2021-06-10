package com.station.service;

import java.sql.SQLException;

public interface StationService {
	boolean addStation(String stationName) throws ClassNotFoundException, SQLException;
}
