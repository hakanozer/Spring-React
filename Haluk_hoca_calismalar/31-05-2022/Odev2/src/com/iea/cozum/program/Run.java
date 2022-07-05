package com.iea.cozum.program;

public class Run 
{

	public static void main(String[] args) 
	{
		Muhasebeci muhasebeci1 = new Muhasebeci(555443, "Hasan", "Bilir");
		muhasebeci1.isYap();
		
		Fizyoterapist fizyoterapist1 = new Fizyoterapist(555442, "Bilge", "Çalýþkan");
		fizyoterapist1.isYap();
	}

}
