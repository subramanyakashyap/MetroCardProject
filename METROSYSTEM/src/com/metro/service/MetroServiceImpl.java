package com.metro.service;

import com.metro.persistence.MetroDao;
import com.metro.persistence.MetroDaoImpl;

public class MetroServiceImpl implements MetroService {
	
	private MetroDao metroDao = new MetroDaoImpl();

	@Override
	public boolean swipedIn(int idIn) {
		
		return metroDao.swipedIn(idIn);
	}

	@Override
	public boolean swipedOut(int idOut) {
		
		return metroDao.swipedOut(idOut);
	}

	@Override
	public boolean swipeIn(int idIn, int stationId) {
		return metroDao.swipeIn(idIn, stationId);
	}

	@Override
	public boolean swipeOut(int idOut, int stationId) {
		return metroDao.swipeOut(idOut, stationId);
	}

	@Override
	public boolean removeCard(int id) {
		return metroDao.removeCard(id);
	}

	@Override
	public int balance(int id) {
		return metroDao.getBalance(id);
	}

	@Override
	public boolean addBalance(int id, int balance) {
		return metroDao.addBalance(id, balance);
	}
	
}
