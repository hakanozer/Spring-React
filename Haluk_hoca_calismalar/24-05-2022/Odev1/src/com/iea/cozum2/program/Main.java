package com.iea.cozum2.program;

import java.util.Scanner;

public class Main 
{

	private static final int KENAR_LIMIT = 2;

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		int girilenDeger;
		
		while(true)
		{
			System.out.println("Lütfen kenar uzunluðunu giriniz:");
			girilenDeger = keyboard.nextInt();
			if(girilenDeger < KENAR_LIMIT)
			{
				System.out.println("Kenar uzunluðu " + KENAR_LIMIT + "den büyük olmalýdýr.");
			}
			else
			{
				iciBosKareCiz(girilenDeger);
				break;
			}
		}
		
		keyboard.close();
	}

	private static void iciBosKareCiz(int kenar) 
	{
		for(int i=0; i < kenar; i++)
		{
			for(int j=0; j < kenar; j++)
			{
				if(i==0 || i==kenar-1 || j==0 || j==kenar-1)
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("  ");
				}
			}
			
			System.out.println();
		}
	}

}
