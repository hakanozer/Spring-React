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
			
			kullaniciAd = JOptionPane.showInputDialog("Kullan�c� ad:");
			if(kullaniciAd == null)
			{
				JOptionPane.showMessageDialog(null, "��k�� yapt�n�z.");
				cikisYapildi = true;
				break;
			}
			
			parola = JOptionPane.showInputDialog("Parola:");
			if(parola == null)
			{
				JOptionPane.showMessageDialog(null, "��k�� yapt�n�z.");
				cikisYapildi = true;
				break;
			}
			
		}
		
		if(!cikisYapildi)
		{
			JOptionPane.showMessageDialog(null, "Kullan�c� ad ve parola onayland�.");
		}		
		
	}

}
