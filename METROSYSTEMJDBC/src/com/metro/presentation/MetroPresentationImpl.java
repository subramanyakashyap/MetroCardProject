package com.metro.presentation;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;

import com.metro.bean.MetroCard;
import com.metro.bean.Station;
import com.metro.service.MetroServiceImpl;
import com.station.service.StationServiceImpl;

public class MetroPresentationImpl implements MetroPresentation {
	
	private MetroServiceImpl metroService=new MetroServiceImpl();
	private StationServiceImpl stationService = new StationServiceImpl();
	Scanner scanner = new Scanner(System.in);

	@Override
	public void showMenu() {
		System.out.println("*****WELCOME TO METRO SYSTEM*****");
		System.out.println("1. Have a Card?");
		System.out.println("2. Buy a new Card?");
		System.out.println("3. Surrender your card?");
		System.out.println("4. Admin Panel");
		System.out.println("5. Exit");
		
	}
	
	public void createNewCard(){
		int id = 0;
		System.out.println("Enter the balance to be added");
		int balance = scanner.nextInt();
		if(balance>100){
			try {
				id = metroService.addCard(balance);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Your new card is generated with ID: "+id);
		}
		else
			System.out.println("Balance should atleast be Rs.100");
	}
	

	@Override
	public void performMenu(int choice) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		switch(choice){
		case 1://Have a card
			System.out.println("Please Enter your Card ID");
			int id = scanner.nextInt();
			MetroCard card = metroService.getCard(id);
			if(card!=null){
				System.out.println("Card Holder Verified!");
				System.out.println("1. Check Balance");
				System.out.println("2. Add Balance");
				if(metroService.swipedIn(id) == false)
					System.out.println("3. Swipe In");
				else if(metroService.swipedOut(id) == false)
					System.out.println("4. Swipe Out");
				System.out.println("5. Go back");
				int userChoice = scanner.nextInt();
				switch(userChoice){
				case 1:
					System.out.println("Balance: "+metroService.balance(id));
					break;
				case 2:
					System.out.println("Enter the Amount");
					if(metroService.addBalance(id, scanner.nextInt()))
						System.out.println("Balance Added Succesfully");
					else
						System.out.println("Balance Addition Failed!");
					break;
				case 3:
					Collection<Station> stations = stationService.getAllStations();
					for(Station station:stations)
						System.out.println(station);
					System.out.println("Select Source Station ID from above:");
					int stationId = scanner.nextInt();
					metroService.swipeIn(id,stationId);
					break;
				case 4:
					Collection<Station> stations1 = stationService.getAllStations();
					for(Station station:stations1)
						System.out.println(station);
					System.out.println("Select Source Station ID from above:");
					int stationId1 = scanner.nextInt();
					metroService.swipeOut(id,stationId1);
					break;
				case 5:
					break;
				}
				
			}else{
				System.out.println("Card Not Found!");
			}
			break;
		case 2://Buy a new card
			createNewCard();
			break;
		case 3://Surrender your card
			System.out.println("Please enter your card ID to surrender:");
			int idSurrender = scanner.nextInt();
			int balSurrender = metroService.balance(idSurrender);
			if(metroService.removeCard(idSurrender))
				if(balSurrender>0)
					System.out.println("Your card is surrendered successfully! Please collect Rs."+balSurrender);
				else
					System.out.println("Your card is surrendered successfully!");
			else
				System.out.println("Card Removal Failed!");
			break;
		case 4:
			System.out.println("Welcome Admin!\nPlease Identify yoursekf by entering the password!");
			String pass = scanner.next();
			if(pass.equals("maja")){
				System.out.println("Admin Verified!");
				System.out.println("1. Display All Cards");
				System.out.println("2. Display All Stations");
				System.out.println("3. Add a new Station");
				System.out.println("4. Exit");
				int adminChoice = scanner.nextInt();
				switch(adminChoice){
				case 1:
					System.out.println("========All cards=======");
					Collection<MetroCard> cards=metroService.getAllcards();
					for(MetroCard card1:cards) {
						System.out.println(card1);
					}
					break;
				case 2:
					System.out.println("========All Stations=======");
					Collection<Station> stations=stationService.getAllStations();
					for(Station station:stations) {
						System.out.println(station);
					}
					break;
				case 3:
					System.out.println("Enter the station name");
					String stationName = scanner.nextLine();
					if(stationService.addStation(stationName)) {
						System.out.println("Congratulations Station: "+stationName+" has been added!");
					}
					break;
				case 4:
					System.out.println("Thank You Admin! Hope to see you soon!");
					System.exit(0);
				}
			}else{
				System.out.println("Invalid credentials");
			}
			break;
		case 5:
			System.out.println("Thank You For Using Metro Service! Have a nice day!");
			System.exit(0);
		}

	}
}