package cn.itcast.application;
import java.util.HashMap;
public class DBUtil {
	private static DBUtil instance = null;
	private HashMap<String,User>users=new HashMap<String,User>();
	
	private DBUtil(){
		User u1=new User();
		u1.setCardId("111");
		u1.setCardPwd("111");
		u1.setUserName("张三");
		u1.setCall("13513949751");
		u1.setAccount(1000);
		users.put(u1.getCardId(), u1);
		
		User u2=new User();
		u1.setCardId("222");
		u1.setCardPwd("222");
		u1.setUserName("李四");
		u1.setCall("13513949752");
		u1.setAccount(1000);
		users.put(u2.getCardId(), u2);
		
		User u3=new User();
		u1.setCardId("333");
		u1.setCardPwd("333");
		u1.setUserName("王五");
		u1.setCall("13513949753");
		u1.setAccount(1000);
		users.put(u3.getCardId(), u3);
	}
	public static DBUtil getInstance(){
		if(instance==null){
			synchronized (DBUtil.class){
				if(instance==null){
					instance=new DBUtil();
				}
			}
		}
		return instance;
	}
	public User getUser(String cardId){
		User user=(User) users.get(cardId);
		return user;
	}
	public HashMap<String,User> getUsers(){
		return users;
	}
}
