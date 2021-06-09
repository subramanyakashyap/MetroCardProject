package com.metro.persistence;

import java.util.Collection;
import java.util.HashMap;

import com.metro.bean.MetroCard;
import com.metro.database.MetroCards;

public class MetroDaoImpl implements MetroDao {

	@Override
	public boolean swipedIn(int idIn) {
		
		int swipedIn = MetroCards.getMetroCards().get(idIn).getSwipeInId();
		if(swipedIn!=0)
			return true;
		return false;
	}

	@Override
	public boolean swipedOut(int idOut) {
		int swipedOut = MetroCards.getMetroCards().get(idOut).getSwipeOut();
		if(swipedOut!=0)
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

	@Override
	public void deductBalance(int id, int amount) {
		int prevBalance = getBalance(id);
		int newbalance = prevBalance-amount;
		MetroCards.getMetroCards().get(id).setBalance(newbalance);
	}

	@Override
	public MetroCard getCard(int id) {
		return MetroCards.getMetroCards().get(id);
	}

	@Override
	public boolean addCard(int id, int balance) {
		MetroCard card = new MetroCard(id, balance, 0, 0);
		MetroCards.getMetroCards().put(card.getId(), card);
		return true;
	}

	@Override
	public Collection<MetroCard> getAllRecords() {
		HashMap<Integer,MetroCard> cards=MetroCards.getMetroCards();
		 Collection<MetroCard> recs=cards.values();
		return recs;
	}

	@Override
	public void resetStatus(int id) {
		MetroCards.getMetroCards().get(id).setSwipeInId(0);
		MetroCards.getMetroCards().get(id).setSwipeOut(0);
	}

}
