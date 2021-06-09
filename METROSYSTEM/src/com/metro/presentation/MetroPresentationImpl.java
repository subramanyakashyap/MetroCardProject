package com.metro.presentation;

import java.util.Collection;
import java.util.Scanner;

import com.metro.bean.MetroCard;
import com.metro.service.MetroServiceImpl;

public class MetroPresentationImpl implements MetroPresentation {
	
	private static int cardId=0;
	
	private MetroServiceImpl metroService=new MetroServiceImpl();

	@Override
	public void showMenu() {
		System.out.println("WELCOME TO METRO SYSTEM");
		System.out.println("1. Create a new Metro Card");
		System.out.println("2. Remove Existing Card");
		System.out.println("3. Check Balance");
		System.out.println("4. Add Balance");
		System.out.println("5. Swipe In");
		System.out.println("6. Swipe Out");
		System.out.println("7. Exit");
		System.out.println("8. Display");
	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner = new Scanner(System.in);
		switch(choice){
		case 1://create metrocard
			System.out.println("Enter the balance to be added");
			int balance = scanner.nextInt();
			if(balance>100)
				metroService.addCard(++cardId, balance);
			else
				System.out.println("Balance should atleast be Rs.100s");
			
			break;
		case 2://remove card
			System.out.println("Enter the card ID to remove:");
			if(metroService.removeCard(scanner.nextInt()))
				System.out.println("Card Removed Successfully");
			else
				System.out.println("Card Removal Failed!");
			break;
		case 3://check balance
			System.out.println("Enter the card ID");
			System.out.println("Balance: "+metroService.balance(scanner.nextInt()));
			break;
		case 4://add balance
			System.out.println("Enter the card ID and Amount");
			if(metroService.addBalance(scanner.nextInt(), scanner.nextInt()))
				System.out.println("Balance Added Succesfully");
			else
				System.out.println("Balance Addition Failed!");
			break;
		case 5://swipein
			System.out.println("Enter Card ID:");
			int idIn = scanner.nextInt();
			if(!(metroService.swipedIn(idIn))){
				System.out.println("Enter Source Station:");
				int stationId = scanner.nextInt();
				metroService.swipeIn(idIn,stationId);
			}
			else
				System.out.println("Card is already Swiped in! Kindly Swipe out to continue");
			break;
		case 6://swipeout
			System.out.println("Enter Card ID:");
			int idOut = scanner.nextInt();
			if((!(metroService.swipedOut(idOut)))){
				System.out.println("Enter Destination Station:");
				int stationId = scanner.nextInt();
				metroService.swipeOut(idOut,stationId);
			}
			else
				System.out.println("Card is already Swiped out! Kindly Swipe in to continue");
			break;
		case 7:
			System.out.println("Thank You For Using Metro Service! Have a nice day!");
			System.exit(0);
		case 8:
			System.out.println("========All cards=======");
			Collection<MetroCard> cards=metroService.getAllcards();
			for(MetroCard card:cards) {
				System.out.println(card);
			}
			break;
		}
	}

}
