package com.iea.temeller.flag.ornek1.program;

import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner klavye = new Scanner(System.in);
		
		String kullaniciAd = " ";
		String parola = " ";
		
		boolean cikisYapildi = false;
		
		// !(kullaniciAd.equals("haluk") &&  parola.equals("1234"))				
		while(!kullaniciAd.equals("haluk") || !parola.equals("1234"))
		{
			System.out.println("Kullan�c� ad (��k�� i�in exit yaz�n�z) :");
			kullaniciAd = klavye.next();
			if(kullaniciAd.equals("exit"))
			{
				System.out.println("��k�� yapt�n�z.");
				cikisYapildi = true;
				break;
			}
			
			System.out.println("Parola (��k�� i�in exit yaz�n�z) :");
			parola = klavye.next();
			if(parola.equals("exit"))
			{
				System.out.println("��k�� yapt�n�z.");
				cikisYapildi = true;
				break;
			}
			
		}
		
		if(!cikisYapildi)
		{
			System.out.println("Kullan�c� ad ve parola onayland�.");
		}
		
		klavye.close();
	}

}
