package biz;

import entity.User;

import java.util.TreeSet;

//�������ȡ���ܵ�ʵ��
public class Bank {
	private String Bankname = "��������";    		//��������
	TreeSet<User> holder = null;           		//���д洢����Ϣ
	private static Bank INSTANCE = new Bank();
	private Bank() {}                      		//˽�л�������
	public static Bank getInstance() {
		// TODO Auto-generated method stub
		return INSTANCE;
	}
	//����
	public void saveMoney(User user,double money) {
		//��ʼ�������������
		double sum = user.getSum()+money;
		user.setSum(sum);
		System.out.print(money+"���ɹ�!!!"+",��ǰ�����:"+user.getSum());
		System.out.print("\n");
	}
	//ȡ���
	public void drawMoney(User user,double money,String pw) {
		if(user.getPw().equals(pw)) {					//���ж�ȡ������
			if(user.getSum()>=money) {					//�ж����
				user.setSum(user.getSum()-money);
				System.out.print("ȡ��ɹ�");
				System.out.print("\n");
				System.out.print("��ǰ���Ϊ:"+"\t"+user.getSum());
				System.out.print("\n");
			}else {
				System.out.print("��Ǹ����!!!  ��ǰ���:"+user.getSum());
				System.out.print("\n");
			}
		}
	}
	//�鿴����Լ���Ϣ
	public void looksum(User user) {
	 	System.out.print("����:"+user.getName()+",�˺�:"+user.getAccount()+",���:"+user.getSum());
	 	System.out.print("\n");
	}
	//��ӭ���
	public void welcom(User user) {
		if(user.getSexual().equals("��")) {
			System.out.print(user.getName()+"  ����!!"+"  "+(this.Bankname)+"  ��ӭ��!!!");
			System.out.print("\n");
		}else if(user.getSexual().equals("Ů")){
			System.out.print(user.getName()+"  Ůʿ!!"+"  "+(this.Bankname)+"  ��ӭ��!!!");
			System.out.print("\n");
		}
	}
	//�ټ����
	public void GoodBye(User user) {
		if(user.getSexual().equals("��")) {
			System.out.print(user.getName()+"  ����!!"+"  "+(this.Bankname)+"  ף���������!!!");
			System.out.print("\n");
		}else if(user.getSexual().equals("Ů")){
			System.out.print(user.getName()+"  Ůʿ!!"+"  "+(this.Bankname)+"  ף���������!!!");
			System.out.print("\n");
		}
	}
	
}
