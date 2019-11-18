import java.util.*;

public class TelcomAccountSystem {

	public static void main(String[] args) {
		
		//实例化一个电信用户类
		TelcomUser telcomUser=new TelcomUser("13800138000");
		
		//生成通讯记录
		telcomUser.generateCommunicateRecord();
		
		//打印清单
		telcomUser.printDetails();
		
	}

}
 
class TelcomUser {
      private String phoneNumber;//实例化对象的电话号码
      private String callTo;  //打给的对象
      private StringBuffer communicationRecords; //交谈记录
      
      public TelcomUser(String phoneNumber){  //生成的一个用户，必须要有电话号码
    	  
    	  this.phoneNumber=phoneNumber;
    	  this.communicationRecords=new StringBuffer();
      }
      
      //模拟通话记录的生成
      void generateCommunicateRecord(){
    	   //随机生成通话记录数目
    	  int recordNum=new Random().nextInt(10);
    	  for(int i=0;i<=recordNum;i++){
    		  //随机生成第i条通话记录
    		  //开始时间，当前时间之前的某个随机时间
    		  long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
    		  //结束时间，开始后的十分钟内随机的一个时间，至少一分钟
    		  long timeEnd=timeStart+60000+new Random().nextInt(600000);
    		  //被叫号码
    		  this.callTo=this.getCallToPhoneNumber();
    		  //插入通话记录
    		  this.communicationRecords.append(this.phoneNumber+
    				  ","+timeStart+","+timeEnd+","+this.callTo+";");
    	  }
      }
      //随机生成被呼叫着的号码
      private String getCallToPhoneNumber(){
    	  return "1380372"+String.valueOf(new Random().nextInt(10))
    	  +String.valueOf(new Random().nextInt(10))
    	  +String.valueOf(new Random().nextInt(10))
    	  +String.valueOf(new Random().nextInt(10));
    	  
      }
      //计费
      private String accountFee(long timeStart,long timeEnd){
    	 
    	  double feePerMinute=0.2;
    	  
    	  int minutes=Math.round((timeEnd-timeStart)/60000);
    	  double feeTotal=feePerMinute*minutes;
    	  
    	  return String.format("%.4f", feeTotal);
      }
      //打印清单
      void printDetails(){
    	  //将所有的记录转化成字符串型的数据类型，便于分割出来一条条的信息
    	 String allRecords=this.communicationRecords.toString();
    	 
    	 String[] recordArray=allRecords.split(";");
    	 
    	 for(int i=0;i<recordArray.length;i++){
    		 
    		 //System.out.println("message i"+recordArray[i]);
    		 String[] recordField=recordArray[i].split(",");
    		 
    		 System.out.println("主叫："+recordField[0]);
    		 System.out.println("被叫："+ recordField[3]);
    		 System.out.println("通话开始时间："+new Date(Long.parseLong( recordField[1])));
    		 System.out.println("通话结束时间"+new Date(Long.parseLong(recordField[2])));
    		 System.out.println("计费："+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))
    		 +"元");
    		 
    		                
    	 }
    	  
      }
      
}
