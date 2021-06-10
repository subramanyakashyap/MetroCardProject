package com.metro.client;

import java.sql.SQLException;
import java.util.Scanner;

import com.metro.presentation.MetroPresentation;
import com.metro.presentation.MetroPresentationImpl;

public class MetroMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		MetroPresentation presentation=new MetroPresentationImpl();
		while(true) {
			presentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=sc.nextInt();
			try {
				presentation.performMenu(choice);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
