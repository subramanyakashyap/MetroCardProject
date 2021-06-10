package com.station.service;

import com.station.pesistence.StationDao;
import com.station.pesistence.StationDaoImpl;

public class StationServiceImpl implements StationService {
private StationDao stationDao = new StationDaoImpl();
	
	@Override
	public boolean addStation(int id, String stationName) {
		return stationDao.addStation(id, stationName);
	
	}
}
