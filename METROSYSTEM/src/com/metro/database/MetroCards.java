package com.metro.database;

import java.util.HashMap;

import com.metro.bean.MetroCard;

public class MetroCards {
	
private static HashMap<Integer,MetroCard> metrocards=new HashMap<Integer, MetroCard>();
	
	static {
		metrocards.put(101, new MetroCard(101,50, 0, 0));
		metrocards.put(102, new MetroCard(102,1500, 2, 3));
		metrocards.put(103, new MetroCard(103,200, 4, 5));
		metrocards.put(104, new MetroCard(104,100, 1, 5));
		metrocards.put(105, new MetroCard(105,150, 3, 4));
		metrocards.put(106, new MetroCard(106,265, 3, 5));
	}

	public static HashMap<Integer, MetroCard> getMetroCards() {
		return metrocards;
	}

	public static void setMetroCards(HashMap<Integer, MetroCard> metrocards) {
		MetroCards.metrocards = metrocards;
	}

}
