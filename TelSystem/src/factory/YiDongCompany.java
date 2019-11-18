package factory;

import species.*;
public class YiDongCompany implements Factory{

		public YiDong createSorts(){
			
			return new YiDong("12345678910");
		}
}
