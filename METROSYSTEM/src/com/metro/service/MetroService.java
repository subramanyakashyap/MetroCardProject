package com.metro.service;

import java.util.Collection;

import com.metro.bean.MetroCard;

public interface MetroService {
	
	boolean addCard(int id, int balance);
	boolean removeCard(int id);
	int balance(int id);
	boolean addBalance(int id, int balance);
	void deductBalance(int id, int amount);
	int calcFare(int id, int souce, int dest);
	boolean swipedIn(int idIn);
	boolean swipedOut(int idOut);
	boolean swipeIn(int idIn, int stationId);
	boolean swipeOut(int idOut, int stationId);
	
	Collection<MetroCard> getAllcards();

}
