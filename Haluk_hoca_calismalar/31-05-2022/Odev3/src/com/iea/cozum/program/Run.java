package com.iea.cozum.program; 

import java.util.Scanner;

public class Run 
{

	private static final int KELIME_LIMIT = 2;

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n- PALINDROM BULMA -\n");
		System.out.println("L�tfen bir kelime giriniz:");
		String inputStr = scanner.next();
		
		if(!karakterlerUygunMu(inputStr))
		{
			System.out.println("Girilen verinin �zel karakter bar�nd�rmamas� gerekmektedir."
					+ "\n(kelime olabilme ko�ulu)");
		}
		else
		{
			if(inputStr.length() < KELIME_LIMIT)
			{
				System.out.println("Uyar�: Girilen verinin en az " + KELIME_LIMIT + " karakter bar�nd�rmas� gerekmektedir."
									+ "\n(kelime olabilme ko�ulu)");
			}
			else
			{
				if(palindromMu(inputStr))
				{
					System.out.println("Girilen kelime " + inputStr + " bir palindromdur.");
				}
				else
				{
					System.out.println("Girilen kelime " + inputStr + " palindrom de�ildir.");
				}
			}
		}
		
		
		
		System.out.println("\n- TERS BULMA -\n");
		System.out.println("L�tfen birinci kelimeyi giriniz:");
		String word1 = scanner.next();
		
		System.out.println("L�tfen ikinci kelimeyi giriniz:");
		String word2 = scanner.next();
		
		
		if(!karakterlerUygunMu(word1) || !karakterlerUygunMu(word2) )
		{
			System.out.println("Girilen verinin ikisinin de �zel karakter bar�nd�rmamas� gerekmektedir."
					+ "\n(kelime olabilme ko�ulu)");
		}
		else
		{
			if(word1.length() < KELIME_LIMIT || word2.length() < KELIME_LIMIT)
			{
				System.out.println("Uyar�: Girilen verilerin ikisinin de " + KELIME_LIMIT + " karakter bar�nd�rmas� gerekmektedir."
						+ "\n(kelime olabilme ko�ulu)");
			}
			else
			{
				tersiMi(word1, word2);
			}
				
		}
		
		
		scanner.close();
	}

	private static void tersiMi(String str1, String str2) 
	{
		if(str1.equals(str2))
		{
			if(palindromMu(str1))
			{
				System.out.println("Bu 2 kelime birbiriyle ayn� olmas�na ra�men birbirinin tersidir; "
									+ "��nk� bu kelimeler palindromdur.");
			}
			else
			{
				System.out.println("Uyar�: Bu 2 kelime birbirinden farkl� olmal�d�r.");
			}
		}
		else 
		{
			
			boolean flag = false;
			if(str1.length() == str2.length())
			{				
				int length = str1.length();
				for (int i = 0; i < str1.length(); i++) 
				{
					if(str1.charAt(i) != str2.charAt(length-1-i))
					{
						flag = true;
						break;
					}
				}
				
				if(flag)
				{
					System.out.println("Bu 2 kelime birbirinin tersi de�ildir.");
				}
				else
				{
					System.out.println("Bu 2 kelime birbirinin tersidir.");
				}
			}
			else
			{
				System.out.println("Uyar�: Bu 2 kelime birbiriyle ayn� uzunlukta olmal�d�r.");
			}
		}
	}

	private static boolean palindromMu(String str)
	{
		int length = str.length();
		
		for (int i = 0; i < str.length() / 2; i++) 
		{
			if(str.charAt(i) != str.charAt(length-1-i))
			{
				return false;
			}
		}
		
		return true;
	}

	private static boolean karakterlerUygunMu(String str) 
	{
		for (int i = 0; i < str.length(); i++) 
		{
			
			if( ! ( (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') ) )
			{
				return false;
			}
		}
		
		return true;
	}

	
}
