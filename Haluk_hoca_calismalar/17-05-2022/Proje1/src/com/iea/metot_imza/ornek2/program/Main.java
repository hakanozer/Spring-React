package com.iea.metot_imza.ornek2.program;

import javax.swing.JOptionPane;

public class Main 
{
	
	public static void main(String[] args) 
	{		
		
		String strSayi1 = JOptionPane.showInputDialog("Birinci say�y�(int) giriniz:");
		int sayi1 = Integer.parseInt(strSayi1);	
		
		String strSayi2 = JOptionPane.showInputDialog("ikinci say�y�(int) giriniz:");
		int sayi2 = Integer.parseInt(strSayi2);	
		
		int toplam = topla(sayi1, sayi2);
		JOptionPane.showMessageDialog(null, "Toplama i�leminin sonucu: " + toplam);
		
		cikar(sayi1, sayi2);
		
		carp(sayi1, sayi2);
		
		double bolum = bol(sayi1, sayi2);
		JOptionPane.showMessageDialog(null, "B�lme i�leminin sonucu: " + bolum);
		
	}
		
	private static double bol(int num1, int num2) 
	{
		double sonuc = num1 / (double)num2;
		return sonuc;
	}

	private static void carp(int sayi1, int sayi2) 
	{
		int sonuc = sayi1  * sayi2;
		JOptionPane.showMessageDialog(null, "�arpma i�leminin sonucu: " + sonuc);
	}

	private static void cikar(int sayi1, int sayi2)
	{
		JOptionPane.showMessageDialog(null, "��karma i�leminin sonucu: " + (sayi1-sayi2));
	}

	private static int topla(int num1, int num2) 
	{
		return num1 + num2;
	}	

}
