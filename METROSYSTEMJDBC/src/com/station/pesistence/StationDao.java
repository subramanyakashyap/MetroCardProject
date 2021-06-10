package com.station.pesistence;

import java.sql.SQLException;

public interface StationDao {
	boolean addStation(int id, String stationName) throws ClassNotFoundException, SQLException;
}
