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
			System.out.println("Kullanýcý ad (çýkýþ için exit yazýnýz) :");
			kullaniciAd = klavye.next();
			if(kullaniciAd.equals("exit"))
			{
				System.out.println("Çýkýþ yaptýnýz.");
				cikisYapildi = true;
				break;
			}
			
			System.out.println("Parola (çýkýþ için exit yazýnýz) :");
			parola = klavye.next();
			if(parola.equals("exit"))
			{
				System.out.println("Çýkýþ yaptýnýz.");
				cikisYapildi = true;
				break;
			}
			
		}
		
		if(!cikisYapildi)
		{
			System.out.println("Kullanýcý ad ve parola onaylandý.");
		}
		
		klavye.close();
	}

}
