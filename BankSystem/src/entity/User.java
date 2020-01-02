package entity;

import java.io.Serializable;
   /*
    * 这是一个User类
    * */
public class User implements Serializable{
	/**
	 * 实现接口,用于序列化和反序列化
	 */
	private static final long serialVersionUID = 1L;
	private String name;      	//用户名
	private String account;   	//银行账号
	private String password;	//密码
	private String pw;          //取款密码
	private double sum;         //账户金额
	private String sexual;      //性别
	//获取用户名
	public String getName() {
		return name;
	}
	//写入用户名
	public void setName(String name) {
		this.name = name;
	}
	//获取账号
	public String getAccount() {
		return account;
	}
	//写入账号
	public void setAccount(String account) {
		this.account = account;
	}
	//获取密码
	public String getPassword() {
		return password;
	}
	//修改密码
	public void setPassword(String password) {
		this.password = password;
	}
	//查看余额
	public double getSum() {
		return sum;
	}
	//修改余额
	public void setSum(double sum) {
		this.sum = sum;
	}
	//写入性别
	public String getSexual() {
		return sexual;
	}
	//修改性别
	public void setSexual(String sexual) {
		this.sexual = sexual;
	}
	//获取取款密码
	public String getPw() {
		return pw;
	}
	//写入取款密码
	public void setPw(String pw) {
		this.pw = pw;
	}
	//hashCode比较方法
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((sexual == null) ? 0 : sexual.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	//equals比较方法
	/*
	 * 知识点:
	 * 	public boolean equals(Object obj)名称不可改变
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (sexual == null) {
			if (other.sexual != null)
				return false;
		} else if (!sexual.equals(other.sexual))
			return false;
		if (Double.doubleToLongBits(sum) != Double.doubleToLongBits(other.sum))
			return false;
		return true;
	}
	//初始化用户
	public User(String name,String account,String password,String pw,double sum,String sexual){
		this.name = name;
		this.account = account;
		this.password = password;
		this.sum = sum;
		this.sexual = sexual;
		this.pw = pw;
	}
	//空参构造函数
	public User(){
		
	}
}
