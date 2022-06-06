package com.iea.temeller.flag.ornek2.program;

import javax.swing.JOptionPane;

public class Main 
{

	public static void main(String[] args) 
	{
				
		String kullaniciAd = " ";
		String parola = " ";
		
		boolean cikisYapildi = false;
		
		// !(kullaniciAd.equals("haluk") &&  parola.equals("1234"))				
		while(!kullaniciAd.equals("haluk") || !parola.equals("1234"))
		{
			
			kullaniciAd = JOptionPane.showInputDialog("Kullanýcý ad:");
			if(kullaniciAd == null)
			{
				JOptionPane.showMessageDialog(null, "Çýkýþ yaptýnýz.");
				cikisYapildi = true;
				break;
			}
			
			parola = JOptionPane.showInputDialog("Parola:");
			if(parola == null)
			{
				JOptionPane.showMessageDialog(null, "Çýkýþ yaptýnýz.");
				cikisYapildi = true;
				break;
			}
			
		}
		
		if(!cikisYapildi)
		{
			JOptionPane.showMessageDialog(null, "Kullanýcý ad ve parola onaylandý.");
		}		
		
	}

}
