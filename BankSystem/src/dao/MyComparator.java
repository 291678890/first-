package dao;

import entity.User;

import java.io.Serializable;
import java.util.Comparator;

//自定义比较器
//想要存入集合必须实现序列化和反序列化
public class MyComparator implements Comparator,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public int compare(Object arg0, Object arg1) {
		User user1 = (User)arg0;								//重写比较方法   --- 强转成User类型
		User user2 = (User)arg1;
		return user1.getAccount().compareTo(user2.getAccount());//比较两个银行账户
	}

}
