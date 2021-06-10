package com.station.service;

import java.sql.SQLException;

import com.station.pesistence.StationDao;
import com.station.pesistence.StationDaoImpl;

public class StationServiceImpl implements StationService {
private StationDao stationDao = new StationDaoImpl();
	
	@Override
	public boolean addStation(int id, String stationName) throws ClassNotFoundException, SQLException {
		return stationDao.addStation(id, stationName);
	
	}
}
