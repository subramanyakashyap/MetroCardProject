package com.metro.bean;

public class MetroCard {
	
	private int id, balance;
	private Station swipeIn, swipeOut;
	public MetroCard(){
	}
	public MetroCard(int id, int balance, Station swipeIn, Station swipeOut){
		this.id = id;
		this.balance = balance;
		this.swipeIn = swipeIn;
		this.swipeOut = swipeOut;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Station getSwipeIn() {
		return swipeIn;
	}
	public void setSwipeIn(Station swipeIn) {
		this.swipeIn = swipeIn;
	}
	public Station getSwipeOut() {
		return swipeOut;
	}
	public void setSwipeOut(Station swipeOut) {
		this.swipeOut = swipeOut;
	}
	@Override
	public String toString() {
		return "MetroCard [id=" + id + ", balance=" + balance + ", swipeIn=" + swipeIn + ", swipeOut=" + swipeOut + "]";
	}
	

}