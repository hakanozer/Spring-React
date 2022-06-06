package com.iea.nyp.kalitim.program;

public enum IsTuru 
{
	MUHASEBECI("mali rapor hazýrlamak"),
	MUDUR("yýllýk iþ planuý hazýrlamak");
	
	private String deger;

	private IsTuru(String deger) {
		this.deger = deger;
	}

	public String getDeger() {
		return deger;
	}	
}
