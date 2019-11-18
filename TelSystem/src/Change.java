import java.util.Date;
import java.util.Random;
import factory.*;
import species.*;
import utility.XMLUtility;

public class Change {

	public static void main(String[] args) {
		
		
		//methord 1:
		 YiDong user;
		 YiDongCompany f;
		 
		 f=(YiDongCompany)XMLUtility.getBean();
		 user=f.createSorts();
		 
		 user.generateCommunicateRecord();
		 user.printDetails();
		
		
		
		//methord 2:
//		 YiDongCompany c1=new YiDongCompany();
//		 LianTongCompany c2=new LianTongCompany();
//	
//		 LianTong s2=c2.createSorts();
//		 YiDong s1=c1.createSorts();
//       
//		  s1.generateCommunicateRecord();
//		  s2.generateCommunicateRecord();
//		  
//		  s1.printDetails();
//		  s2.printDetails();
		  
	}
	

}
 
 