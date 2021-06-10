package com.metro.persistence;

import java.util.Collection;

import com.metro.bean.MetroCard;

public interface MetroDao {
	
	boolean addCard(int id,int balance);
	boolean removeCard(int id);
	int getBalance(int id);
	void deductBalance(int id, int amount);
	boolean addBalance(int id, int balance);
	boolean swipedIn(int idIn);
	boolean swipedOut(int idOut);
	boolean swipeIn(int idIn, int stationId);
	boolean swipeOut(int idOut, int stationId);
	MetroCard getCard(int id);
	void resetStatus(int id);
	
	Collection<MetroCard> getAllRecords();
	

}
