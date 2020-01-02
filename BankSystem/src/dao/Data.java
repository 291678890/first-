package dao;

import entity.User;

import java.util.TreeSet;
//模拟一个数据库
//银行的数据库
public class Data {
	TreeSet<User> holder = new TreeSet<User>(new MyComparator());		//用于存储用户信息的容器---自定义比较规则
	File file = File.getFile();											//获取一个文件类
	private static Data data = new Data();            					
	//单例模式--因为存储数据的类唯一.所以不能随意被实例化
	private Data() {}													//私有化构造方法
	public static Data getData() {   									//提供返回该对象的静态方法
		return data; 
	}
	//添加用户
	public void addUser(User user) {
		holder.add(user);
		System.out.print("注册成功!!");
		System.out.print("\n");
	}
	//删除用户
	public void removeUser(User user) {
		if(holder.contains(user)) {										//如果容器中包含所user对象,则移除对象
			holder.remove(user);	
		}else {															//如果不包含则打印语句
			System.out.print("抱歉请检查输入的信息是否正确");
			System.out.print("\n");
		}
	}
	//获取容器
	public TreeSet<User> getHolder() {
		return holder;
	}
	//写入容器
	public void setHolder(TreeSet<User> holder) {
		this.holder = holder;
	}
	
}
