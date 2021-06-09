package com.metro.persistence;

public interface MetroDao {
	
	boolean removeCard(int id);
	int getBalance(int id);
	boolean addBalance(int id, int balance);
	boolean swipedIn(int idIn);
	boolean swipedOut(int idOut);
	boolean swipeIn(int idIn, int stationId);
	boolean swipeOut(int idOut, int stationId);
	

}
