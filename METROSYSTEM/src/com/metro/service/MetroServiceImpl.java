package com.metro.service;

import java.util.Collection;

import com.metro.bean.MetroCard;
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
		if(balance(idIn)>=20){
			return metroDao.swipeIn(idIn, stationId);
		}
		else
			return false;
	}

	@Override
	public boolean swipeOut(int idOut, int stationId) {
		if(balance(idOut)<20){
			System.out.println("Insufficient Balance! Please Recharge");
			return false;
		}else if(swipedOut(idOut)){
			return false;
		}
		else{
			MetroCard card = metroDao.getCard(idOut);
			int fare = calcFare(idOut, card.getSwipeInId(), stationId);
			System.out.println("Last Travel Charges: "+fare);
			return metroDao.swipeOut(idOut, stationId);
		}
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

	@Override
	public void deductBalance(int id, int amount) {
		metroDao.deductBalance(id, amount);
	}

	@Override
	public int calcFare(int id, int source, int dest) {
		int length = Math.abs(source-dest);
		int fare = length*5;
		if(balance(id)<fare){
			return 0;
		}
		else{
			deductBalance(id, fare);
			metroDao.resetStatus(id);
			return fare;
		}
	}

	@Override
	public boolean addCard(int id, int balance) {
		return metroDao.addCard(id, balance);
	}

	@Override
	public Collection<MetroCard> getAllcards() {
		
		return metroDao.getAllRecords();
	}
	
}
