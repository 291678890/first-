package factory;

import species.*;
public class LianTongCompany implements Factory{
	
	public LianTong createSorts(){
		
		return new LianTong("98765432101");
	}
}
