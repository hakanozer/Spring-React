package com.iea.nyp.kalitim.program;

public enum IsTuru 
{
	MUHASEBECI("mali rapor haz�rlamak"),
	MUDUR("y�ll�k i� planu� haz�rlamak");
	
	private String deger;

	private IsTuru(String deger) {
		this.deger = deger;
	}

	public String getDeger() {
		return deger;
	}	
}
