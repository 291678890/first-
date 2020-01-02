package biz;

import entity.User;

import java.util.TreeSet;

//银行类存取宽功能的实现
public class Bank {
	private String Bankname = "网上银行";    		//银行名称
	TreeSet<User> holder = null;           		//银行存储的信息
	private static Bank INSTANCE = new Bank();
	private Bank() {}                      		//私有化银行类
	public static Bank getInstance() {
		// TODO Auto-generated method stub
		return INSTANCE;
	}
	//存款功能
	public void saveMoney(User user,double money) {
		//初始金额与存入金额相加
		double sum = user.getSum()+money;
		user.setSum(sum);
		System.out.print(money+"存款成功!!!"+",当前余额是:"+user.getSum());
		System.out.print("\n");
	}
	//取款功能
	public void drawMoney(User user,double money,String pw) {
		if(user.getPw().equals(pw)) {					//先判断取款密码
			if(user.getSum()>=money) {					//判断余额
				user.setSum(user.getSum()-money);
				System.out.print("取款成功");
				System.out.print("\n");
				System.out.print("当前余额为:"+"\t"+user.getSum());
				System.out.print("\n");
			}else {
				System.out.print("抱歉余额不足!!!  当前余额:"+user.getSum());
				System.out.print("\n");
			}
		}
	}
	//查看余额以及信息
	public void looksum(User user) {
	 	System.out.print("姓名:"+user.getName()+",账号:"+user.getAccount()+",余额:"+user.getSum());
	 	System.out.print("\n");
	}
	//欢迎语句
	public void welcom(User user) {
		if(user.getSexual().equals("男")) {
			System.out.print(user.getName()+"  先生!!"+"  "+(this.Bankname)+"  欢迎您!!!");
			System.out.print("\n");
		}else if(user.getSexual().equals("女")){
			System.out.print(user.getName()+"  女士!!"+"  "+(this.Bankname)+"  欢迎您!!!");
			System.out.print("\n");
		}
	}
	//再见语句
	public void GoodBye(User user) {
		if(user.getSexual().equals("男")) {
			System.out.print(user.getName()+"  先生!!"+"  "+(this.Bankname)+"  祝您生活愉快!!!");
			System.out.print("\n");
		}else if(user.getSexual().equals("女")){
			System.out.print(user.getName()+"  女士!!"+"  "+(this.Bankname)+"  祝您生活愉快!!!");
			System.out.print("\n");
		}
	}
	
}
