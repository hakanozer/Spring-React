package com.iea.cozum.program; 

import java.util.Scanner;

public class Run 
{

	private static final int KELIME_LIMIT = 2;

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n- PALINDROM BULMA -\n");
		System.out.println("Lütfen bir kelime giriniz:");
		String inputStr = scanner.next();
		
		if(!karakterlerUygunMu(inputStr))
		{
			System.out.println("Girilen verinin özel karakter barýndýrmamasý gerekmektedir."
					+ "\n(kelime olabilme koþulu)");
		}
		else
		{
			if(inputStr.length() < KELIME_LIMIT)
			{
				System.out.println("Uyarý: Girilen verinin en az " + KELIME_LIMIT + " karakter barýndýrmasý gerekmektedir."
									+ "\n(kelime olabilme koþulu)");
			}
			else
			{
				if(palindromMu(inputStr))
				{
					System.out.println("Girilen kelime " + inputStr + " bir palindromdur.");
				}
				else
				{
					System.out.println("Girilen kelime " + inputStr + " palindrom deðildir.");
				}
			}
		}
		
		
		
		System.out.println("\n- TERS BULMA -\n");
		System.out.println("Lütfen birinci kelimeyi giriniz:");
		String word1 = scanner.next();
		
		System.out.println("Lütfen ikinci kelimeyi giriniz:");
		String word2 = scanner.next();
		
		
		if(!karakterlerUygunMu(word1) || !karakterlerUygunMu(word2) )
		{
			System.out.println("Girilen verinin ikisinin de özel karakter barýndýrmamasý gerekmektedir."
					+ "\n(kelime olabilme koþulu)");
		}
		else
		{
			if(word1.length() < KELIME_LIMIT || word2.length() < KELIME_LIMIT)
			{
				System.out.println("Uyarý: Girilen verilerin ikisinin de " + KELIME_LIMIT + " karakter barýndýrmasý gerekmektedir."
						+ "\n(kelime olabilme koþulu)");
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
				System.out.println("Bu 2 kelime birbiriyle ayný olmasýna raðmen birbirinin tersidir; "
									+ "çünkü bu kelimeler palindromdur.");
			}
			else
			{
				System.out.println("Uyarý: Bu 2 kelime birbirinden farklý olmalýdýr.");
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
					System.out.println("Bu 2 kelime birbirinin tersi deðildir.");
				}
				else
				{
					System.out.println("Bu 2 kelime birbirinin tersidir.");
				}
			}
			else
			{
				System.out.println("Uyarý: Bu 2 kelime birbiriyle ayný uzunlukta olmalýdýr.");
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
