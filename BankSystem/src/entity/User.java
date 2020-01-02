package entity;

import java.io.Serializable;
   /*
    * ����һ��User��
    * */
public class User implements Serializable{
	/**
	 * ʵ�ֽӿ�,�������л��ͷ����л�
	 */
	private static final long serialVersionUID = 1L;
	private String name;      	//�û���
	private String account;   	//�����˺�
	private String password;	//����
	private String pw;          //ȡ������
	private double sum;         //�˻����
	private String sexual;      //�Ա�
	//��ȡ�û���
	public String getName() {
		return name;
	}
	//д���û���
	public void setName(String name) {
		this.name = name;
	}
	//��ȡ�˺�
	public String getAccount() {
		return account;
	}
	//д���˺�
	public void setAccount(String account) {
		this.account = account;
	}
	//��ȡ����
	public String getPassword() {
		return password;
	}
	//�޸�����
	public void setPassword(String password) {
		this.password = password;
	}
	//�鿴���
	public double getSum() {
		return sum;
	}
	//�޸����
	public void setSum(double sum) {
		this.sum = sum;
	}
	//д���Ա�
	public String getSexual() {
		return sexual;
	}
	//�޸��Ա�
	public void setSexual(String sexual) {
		this.sexual = sexual;
	}
	//��ȡȡ������
	public String getPw() {
		return pw;
	}
	//д��ȡ������
	public void setPw(String pw) {
		this.pw = pw;
	}
	//hashCode�ȽϷ���
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
	//equals�ȽϷ���
	/*
	 * ֪ʶ��:
	 * 	public boolean equals(Object obj)���Ʋ��ɸı�
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
	//��ʼ���û�
	public User(String name,String account,String password,String pw,double sum,String sexual){
		this.name = name;
		this.account = account;
		this.password = password;
		this.sum = sum;
		this.sexual = sexual;
		this.pw = pw;
	}
	//�ղι��캯��
	public User(){
		
	}
}
