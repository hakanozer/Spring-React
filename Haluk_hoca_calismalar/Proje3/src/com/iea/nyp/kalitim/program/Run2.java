package com.iea.nyp.kalitim.program;

import javax.swing.JOptionPane;

public class Run2 
{

	public static void main(String[] args) 
	{
		
		Muhasebeci muhasebeci1 = new Muhasebeci(555771, "Ali", "Bulut");
		JOptionPane.showMessageDialog(null, muhasebeci1.calis());
		
		Mudur mudur1 = new Mudur(555774, "Mine", "Caliskan");
		JOptionPane.showMessageDialog(null, mudur1.calis());
	}

}
