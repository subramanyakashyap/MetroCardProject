package com.metro.service;

import java.sql.SQLException;
import java.util.Collection;

import com.metro.bean.MetroCard;
import com.metro.persistence.MetroDao;
import com.metro.persistence.MetroDaoImpl;

public class MetroServiceImpl implements MetroService {
	
	private MetroDao metroDao = new MetroDaoImpl();

	@Override
	public boolean swipedIn(int idIn) throws ClassNotFoundException, SQLException {
		
		return metroDao.swipedIn(idIn);
	}

	@Override
	public boolean swipedOut(int idOut) throws ClassNotFoundException, SQLException {
		
		return metroDao.swipedOut(idOut);
	}

	@Override
	public boolean swipeIn(int idIn, int stationId) throws ClassNotFoundException, SQLException {
		if(balance(idIn)>=20){
			return metroDao.swipeIn(idIn, stationId);
		}
		else
			return false;
	}

	@Override
	public boolean swipeOut(int idOut, int stationId) throws ClassNotFoundException, SQLException {
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
	public boolean removeCard(int id) throws ClassNotFoundException, SQLException {
		return metroDao.removeCard(id);
	}

	@Override
	public int balance(int id) throws ClassNotFoundException, SQLException {
		return metroDao.getBalance(id);
	}

	@Override
	public boolean addBalance(int id, int balance) throws ClassNotFoundException, SQLException {
		return metroDao.addBalance(id, balance);
	}

	@Override
	public void deductBalance(int id, int amount) throws ClassNotFoundException, SQLException {
		metroDao.deductBalance(id, amount);
	}

	@Override
	public int calcFare(int id, int source, int dest) throws ClassNotFoundException, SQLException {
		int length = Math.abs(source-dest);
		int fare = length*5;
		if(balance(id)<fare){
			
			return 0;
		}
		else{
			deductBalance(id, fare);
//			metroDao.resetStatus(id);
			return fare;
		}
	}

	@Override
	public int addCard(int balance) throws ClassNotFoundException, SQLException {
		return metroDao.addCard(balance);
	}

	@Override
	public Collection<MetroCard> getAllcards() throws ClassNotFoundException, SQLException {
		
		return metroDao.getAllRecords();
	}
	
}
