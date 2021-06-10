package com.metro.service;

import java.sql.SQLException;
import java.util.Collection;

import com.metro.bean.MetroCard;

public interface MetroService {
	
	boolean addCard(int id, int balance) throws ClassNotFoundException, SQLException;
	boolean removeCard(int id) throws ClassNotFoundException, SQLException;
	int balance(int id) throws ClassNotFoundException, SQLException;
	boolean addBalance(int id, int balance) throws ClassNotFoundException, SQLException;
	void deductBalance(int id, int amount) throws ClassNotFoundException, SQLException;
	int calcFare(int id, int souce, int dest) throws ClassNotFoundException, SQLException;
	boolean swipedIn(int idIn) throws ClassNotFoundException, SQLException;
	boolean swipedOut(int idOut) throws ClassNotFoundException, SQLException;
	boolean swipeIn(int idIn, int stationId) throws ClassNotFoundException, SQLException;
	boolean swipeOut(int idOut, int stationId) throws ClassNotFoundException, SQLException;
	
	Collection<MetroCard> getAllcards() throws ClassNotFoundException, SQLException;

}
