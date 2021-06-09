package com.metro.persistence;

import com.metro.bean.MetroCard;
import com.metro.database.MetroCards;

public class MetroDaoImpl implements MetroDao {

	@Override
	public boolean swipedIn(int idIn) {
		
		int swipedIn = MetroCards.getMetroCards().get(idIn).getSwipeInId();
		if(swipedIn>0)
			return true;
		return false;
	}

	@Override
	public boolean swipedOut(int idOut) {
		int swipedOut = MetroCards.getMetroCards().get(idOut).getSwipeInId();
		if(swipedOut>0)
			return true;
		return false;
	}

	@Override
	public boolean swipeIn(int idIn, int stationId) {
		MetroCards.getMetroCards().get(idIn).setSwipeInId(stationId);
		return true;
	}

	@Override
	public boolean swipeOut(int idOut, int stationId) {
		MetroCards.getMetroCards().get(idOut).setSwipeOut(stationId);
		return true;
	}

	@Override
	public boolean removeCard(int id) {
		MetroCard card = MetroCards.getMetroCards().remove(id);
		if(card == null)
			return false;
		else
			return true;
	}

	@Override
	public int getBalance(int id) {
		return MetroCards.getMetroCards().get(id).getBalance();
	}

	@Override
	public boolean addBalance(int id, int balance) {
		int prevBalance = getBalance(id);
		int newBalance = prevBalance+balance;
		MetroCards.getMetroCards().get(id).setBalance(newBalance);
		return true;
	}

}
