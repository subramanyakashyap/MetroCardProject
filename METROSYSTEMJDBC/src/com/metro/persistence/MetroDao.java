package com.metro.persistence;

import java.sql.SQLException;
import java.util.Collection;

import com.metro.bean.MetroCard;
import com.metro.bean.Station;

public interface MetroDao {
	
	int addCard(int balance) throws SQLException, ClassNotFoundException;
	boolean removeCard(int id) throws ClassNotFoundException, SQLException;
	int getBalance(int id) throws ClassNotFoundException, SQLException;
	void deductBalance(int id, int amount) throws ClassNotFoundException, SQLException;
	boolean addBalance(int id, int balance) throws ClassNotFoundException, SQLException;
	boolean swipedIn(int idIn) throws ClassNotFoundException, SQLException;
	boolean swipedOut(int idOut) throws SQLException, ClassNotFoundException;
	boolean swipeIn(int idIn, int stationId) throws ClassNotFoundException, SQLException;
	boolean swipeOut(int idOut, int stationId) throws ClassNotFoundException, SQLException;
	MetroCard getCard(int id) throws ClassNotFoundException, SQLException;
	void resetStatus(int id) throws ClassNotFoundException, SQLException;
	
	Collection<MetroCard> getAllCards() throws ClassNotFoundException, SQLException;
	

}
