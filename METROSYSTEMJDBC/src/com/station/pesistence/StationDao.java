package com.station.pesistence;

import java.sql.SQLException;

public interface StationDao {
	boolean addStation(String stationName) throws ClassNotFoundException, SQLException;
}
