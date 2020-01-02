package view;

import biz.Bank;
import dao.Data;
import dao.File;
import entity.User;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
//后台操作系统
//后台管理员
public class Operate {
	Scanner sc = new Scanner(System.in);							//键盘录入
	TreeSet<User> holder = Data.getData().getHolder();				//从Data数据库中获取容器
	Bank bank = Bank.getInstance();   								//获取一个银行类
	File file = File.getFile();										//获取一个文件类
	//登录菜单
	public void registerMenu(){
		System.out.print("****************************");
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("    欢迎来到Java银行登录系统!!!\n");
		System.out.print("\n");
		System.out.print("****************************");
		System.out.print("\n");
		System.out.print("\n");
		holder = File.ReadFromFile();								//从文件中获取容器
		Data.getData().setHolder(holder);    						//把从文件中获取容器存储到数据库中
		int str=1;				   									//从键盘获取数字
		while(str!=0) {
			System.out.print("****************************");
			System.out.print("\n");
			System.out.print(" 1:  登录 ");
			System.out.print("\n");
			System.out.print(" 2:  注册 ");
			System.out.print("\n");
			System.out.print(" 3:  忘记密码");
			System.out.print("\n");
			System.out.print(" 4:  注销用户");
			System.out.print("\n");
			System.out.print(" 0:  退出");
			System.out.print("\n");
			System.out.print("****************************");
			System.out.print("\n");
			System.out.print("请输入:");
			str = sc.nextInt();
			switch(str){											//根据用户输入的值进行选择
				case 1:
					System.out.print("请输入您的账号:");   
					String account = sc.next();			 			//从键盘中获取录入用户名
					System.out.print("请输入您的密码:");	   
					String pw = sc.next();				 			//从键盘中录入密码
					User user = logon(holder,account,pw);
					if(user!=null) {								//判断是否登录成功
						System.out.print("登录成功!!!!欢迎使用");
						System.out.print("\n");
						System.out.print("正在跳转到银行操作界面.........");
						System.out.print("\n");
						this.BankMenu(user);                  		//如果登录成功则将user对象传入到银行操作界面并跳转
					}else {
						System.out.print("登录失败!!!请从新输入");		//如果登录失败打印此语句
						System.out.print("\n");		
					}
					break;
				case 2:
					this.logon();									//调用注册方法
					break;
				case 3:
					this.modify();   								//调用修改方法
					break;
				case 4:
					holder = logout(holder);						//调用删除操作
					break;
				case 0:
					File.SaveToFile(holder);       					//退出系统式将信息保存到文件中
					System.out.print("再见!!!!");
					System.out.print("\n");
					break;
				default:
					System.out.print("输入错误!!!!");
					System.out.print("\n");
			}
		}
	}
	//登录方法
	public User logon(TreeSet<User> holder,String account,String pw) {
		Iterator<User> it = holder.iterator();        				  //获取迭代器
		while(it.hasNext()) {
			User user = it.next();
			if(user.getAccount().equals(account)&&user.getPassword().equals(pw)){
				System.out.print("登录成功!!");
				System.out.print("\n");
				return user;
			}
		}
		System.out.print("账户或密码错误     登录失败!!");
		System.out.print("\n");
		return null;
	}
	//注册方法体
	public void logon(){
		System.out.print("欢迎来到注册界面!!!!");
		System.out.print("\n");
		String name;      													//用户名
		String account;   													//银行账号
		String password;													//密码
		String pw;         													//取款密码
		double sum;         												//账户金额
		String sexual;      												//性别
		User user = new User();												//先创建一个空参的user对象
		
		boolean  flag  = true;                                  			//语句的开关
		while(flag) {														//将注册的信息依次输入
			switch(1) {
			case 1:
				System.out.print("请输入姓名:");								//依次从键盘中获取对应的姓名----正则表达式
				name = sc.next();
				user.setName(name);											//将名字写入对象中
			case 2:															
				System.out.print("请输入账号(9位数字):");
				account = sc.next();										//从键盘中获取账号
				String reges ="[0-9]{9}";									//正则表达式规则对账号进行限制
				if(!account.matches(reges)) {								//如果不符合要求则报错
					System.out.print("账号不符合规范!!");
					System.out.print("\n");
					System.out.print("请重新注册");
					System.out.print("\n");
					break;
				}
				user.setAccount(account);									//将账号写入对象中
			case 3:
				System.out.print("请输入密码(6位):");
				password = sc.next();
				reges ="[0-9]{6}";											//正则表达式规则
				if(!password.matches(reges)){								//如果密码不符合正则规则则报错
					System.out.print("密码不符合规范!!");
					System.out.print("\n");
					System.out.print("请重新注册");
					System.out.print("\n");
					break;
				}
				user.setPassword(password);									//将密码写入对象中
			case 4:
				System.out.print("请输入取款密码(6位):");
				pw = sc.next();
				reges ="[0-9]{6}";											//正则表达式规则
				if(!pw.matches(reges)) {						
					System.out.print("取款密码不符合规范!!");
					System.out.print("\n");
					System.out.print("请重新注册");
					System.out.print("\n");
					break;
				}
				user.setPw(pw);												//将取款密码写入到对象中	
			case 5:
				System.out.print("请输入金额:");
				sum = sc.nextDouble();
				user.setSum(sum);											//将金额写入到对象中
			case 6:
				System.out.print("请输入性别:");
				sexual = sc.next();
				user.setSexual(sexual);										//将性别写入到对象中
			case 7:
				if(!holder.contains(user)){
					Data.getData().addUser(user); 							//一切准确无误后将user存入数据库Data中
				}
				else {
					System.out.print("用户存在!!!");
					System.out.print("\n");
																			//结束循环
				}
				flag = false;
				break;
			}
		}
	}
	//忘记密码操作
	public void modify() {
		boolean flag = true;
		Iterator<User> it = holder.iterator();         						//获取迭代器
		System.out.print("请输入账户:");
		String account = sc.next();					   						//从键盘中获取账户
		while(it.hasNext()) {
			User user = it.next();      
			if(user.getAccount().equals(account)){     						//如果容器中有这个对象则对它进行修改
				System.out.print("请输入新账户的密码:");
				String pw = sc.next();                 						//从监盘上录入新的密码
				String reges ="[0-9]{6}";			  		    			//正则表达式规则
				if(!pw.matches(reges)) {			   						//如果密码不符合正则规则则报错
					System.out.print("密码不符合规范!!");
					System.out.print("\n");
				}else {							   							//正则表达式判断是否符合条件
					holder.remove(user);				  	 				//先从原容器中删除user					 
					user.setPassword(pw);				   					//修改user的属性
					holder.add(user);                      					//然后再向容器中添加
					System.out.print("修改成功!!!");
					System.out.print("\n");
					flag = false;
					break;
				}
			}
		}
		if(flag) {
			System.out.print("没有找到该用户");
			System.out.print("\n");
		}
	}
	//注销方法
	public TreeSet<User> logout(TreeSet<User> list) {
		String username;         										 	 //用户名
		String password;          											 //密码
		System.out.print("请输入用户账号:");
		username = sc.next();												 //从键盘录入用户名
		System.out.print("请输入密码:");
		password = sc.next();			  									 //从键盘录入密码
		Iterator it = list.iterator();   							     	 //获取迭代器
		while(it.hasNext()) {
			User user = (User)it.next();       							     //获取对象
			if(user.getAccount().equals(username)&&user.getPassword().equals(password)){
				list.remove(user);										 	 //如果录入的信息匹配则从容器中删除user对象
				System.out.print("注销成功!!");
				System.out.print("\n");
				return list;
			}
		}		
		System.out.print("账号或者密码错误");									 	 //不匹配打印提示语句
		System.out.print("\n");  
		return list;	
	}
	//银行操作界面
	public void BankMenu(User user) {
		bank.welcom(user);													 //银行调用欢迎语句
		System.out.print("****************************");
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("    欢迎来到Java银行操作系统!!!\n");
		System.out.print("\n");
		int str = 1;                 					
		while(str!=0) {
			System.out.print("****************************");
			System.out.print("\n");
			System.out.print(" 1:  取钱 ");
			System.out.print("\n");
			System.out.print(" 2:  存钱 ");
			System.out.print("\n");
			System.out.print(" 3:  查看余额");
			System.out.print("\n");
			System.out.print(" 0:  退出登录");
			System.out.print("\n");
			System.out.print("****************************");
			System.out.print("\n");
			System.out.print("\n");
			System.out.print("请输入您的选项:");								//从键盘中读取字符串
			str = sc.nextInt();
			switch(str){												//根据用户输入的值进行选择
				case 1:													//取钱选项
					System.out.print("请输入取款密码:");
					
					String pw = sc.next();       						//从键盘获取输入的密码
				
					if(user.getPw().equals(pw)) {						//将输入的取款密码与用户的密码进行比对:如果相同则继续执行
						System.out.print("请输入取款金额:");
						double money = sc.nextDouble();					//从键盘获取输入的金额
						if(money>=0) {									//判断金额是否有误
							bank.drawMoney(user, money, pw);    	    //调用取款方法
						}else {
							System.out.print("输入金额错误!!!");
							System.out.print("\n");
						}
					}else {
						System.out.print("输入密码有误!!!");
						System.out.print("\n");
					}
					break;
				case 2:
					System.out.print("请输入取款金额:");
					System.out.print("\n");
					double money1 = sc.nextDouble();		//从键盘获取输入的金额
					if(money1>=0) {							//判断金额是否有误
						bank.saveMoney(user, money1);;      //调用存款方法
					}else {
						System.out.print("输入金额错误!!!");
						System.out.print("\n");
					}
					break;
				case 3:
					bank.looksum(user);                    	//调用银行---查询账户操作
					break;
				case 0:
					bank.GoodBye(user);					   	//调用结束语句
					break;
				default:
					System.out.print("输入错误");
					System.out.print("\n");
			}
		}
	}
	
}
