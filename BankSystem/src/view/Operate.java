package view;

import biz.Bank;
import dao.Data;
import dao.File;
import entity.User;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
//��̨����ϵͳ
//��̨����Ա
public class Operate {
	Scanner sc = new Scanner(System.in);							//����¼��
	TreeSet<User> holder = Data.getData().getHolder();				//��Data���ݿ��л�ȡ����
	Bank bank = Bank.getInstance();   								//��ȡһ��������
	File file = File.getFile();										//��ȡһ���ļ���
	//��¼�˵�
	public void registerMenu(){
		System.out.print("****************************");
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("    ��ӭ����Java���е�¼ϵͳ!!!\n");
		System.out.print("\n");
		System.out.print("****************************");
		System.out.print("\n");
		System.out.print("\n");
		holder = File.ReadFromFile();								//���ļ��л�ȡ����
		Data.getData().setHolder(holder);    						//�Ѵ��ļ��л�ȡ�����洢�����ݿ���
		int str=1;				   									//�Ӽ��̻�ȡ����
		while(str!=0) {
			System.out.print("****************************");
			System.out.print("\n");
			System.out.print(" 1:  ��¼ ");
			System.out.print("\n");
			System.out.print(" 2:  ע�� ");
			System.out.print("\n");
			System.out.print(" 3:  ��������");
			System.out.print("\n");
			System.out.print(" 4:  ע���û�");
			System.out.print("\n");
			System.out.print(" 0:  �˳�");
			System.out.print("\n");
			System.out.print("****************************");
			System.out.print("\n");
			System.out.print("������:");
			str = sc.nextInt();
			switch(str){											//�����û������ֵ����ѡ��
				case 1:
					System.out.print("�����������˺�:");   
					String account = sc.next();			 			//�Ӽ����л�ȡ¼���û���
					System.out.print("��������������:");	   
					String pw = sc.next();				 			//�Ӽ�����¼������
					User user = logon(holder,account,pw);
					if(user!=null) {								//�ж��Ƿ��¼�ɹ�
						System.out.print("��¼�ɹ�!!!!��ӭʹ��");
						System.out.print("\n");
						System.out.print("������ת�����в�������.........");
						System.out.print("\n");
						this.BankMenu(user);                  		//�����¼�ɹ���user�����뵽���в������沢��ת
					}else {
						System.out.print("��¼ʧ��!!!���������");		//�����¼ʧ�ܴ�ӡ�����
						System.out.print("\n");		
					}
					break;
				case 2:
					this.logon();									//����ע�᷽��
					break;
				case 3:
					this.modify();   								//�����޸ķ���
					break;
				case 4:
					holder = logout(holder);						//����ɾ������
					break;
				case 0:
					File.SaveToFile(holder);       					//�˳�ϵͳʽ����Ϣ���浽�ļ���
					System.out.print("�ټ�!!!!");
					System.out.print("\n");
					break;
				default:
					System.out.print("�������!!!!");
					System.out.print("\n");
			}
		}
	}
	//��¼����
	public User logon(TreeSet<User> holder,String account,String pw) {
		Iterator<User> it = holder.iterator();        				  //��ȡ������
		while(it.hasNext()) {
			User user = it.next();
			if(user.getAccount().equals(account)&&user.getPassword().equals(pw)){
				System.out.print("��¼�ɹ�!!");
				System.out.print("\n");
				return user;
			}
		}
		System.out.print("�˻����������     ��¼ʧ��!!");
		System.out.print("\n");
		return null;
	}
	//ע�᷽����
	public void logon(){
		System.out.print("��ӭ����ע�����!!!!");
		System.out.print("\n");
		String name;      													//�û���
		String account;   													//�����˺�
		String password;													//����
		String pw;         													//ȡ������
		double sum;         												//�˻����
		String sexual;      												//�Ա�
		User user = new User();												//�ȴ���һ���ղε�user����
		
		boolean  flag  = true;                                  			//���Ŀ���
		while(flag) {														//��ע�����Ϣ��������
			switch(1) {
			case 1:
				System.out.print("����������:");								//���δӼ����л�ȡ��Ӧ������----������ʽ
				name = sc.next();
				user.setName(name);											//������д�������
			case 2:															
				System.out.print("�������˺�(9λ����):");
				account = sc.next();										//�Ӽ����л�ȡ�˺�
				String reges ="[0-9]{9}";									//������ʽ������˺Ž�������
				if(!account.matches(reges)) {								//���������Ҫ���򱨴�
					System.out.print("�˺Ų����Ϲ淶!!");
					System.out.print("\n");
					System.out.print("������ע��");
					System.out.print("\n");
					break;
				}
				user.setAccount(account);									//���˺�д�������
			case 3:
				System.out.print("����������(6λ):");
				password = sc.next();
				reges ="[0-9]{6}";											//������ʽ����
				if(!password.matches(reges)){								//������벻������������򱨴�
					System.out.print("���벻���Ϲ淶!!");
					System.out.print("\n");
					System.out.print("������ע��");
					System.out.print("\n");
					break;
				}
				user.setPassword(password);									//������д�������
			case 4:
				System.out.print("������ȡ������(6λ):");
				pw = sc.next();
				reges ="[0-9]{6}";											//������ʽ����
				if(!pw.matches(reges)) {						
					System.out.print("ȡ�����벻���Ϲ淶!!");
					System.out.print("\n");
					System.out.print("������ע��");
					System.out.print("\n");
					break;
				}
				user.setPw(pw);												//��ȡ������д�뵽������	
			case 5:
				System.out.print("��������:");
				sum = sc.nextDouble();
				user.setSum(sum);											//�����д�뵽������
			case 6:
				System.out.print("�������Ա�:");
				sexual = sc.next();
				user.setSexual(sexual);										//���Ա�д�뵽������
			case 7:
				if(!holder.contains(user)){
					Data.getData().addUser(user); 							//һ��׼ȷ�����user�������ݿ�Data��
				}
				else {
					System.out.print("�û�����!!!");
					System.out.print("\n");
																			//����ѭ��
				}
				flag = false;
				break;
			}
		}
	}
	//�����������
	public void modify() {
		boolean flag = true;
		Iterator<User> it = holder.iterator();         						//��ȡ������
		System.out.print("�������˻�:");
		String account = sc.next();					   						//�Ӽ����л�ȡ�˻�
		while(it.hasNext()) {
			User user = it.next();      
			if(user.getAccount().equals(account)){     						//����������������������������޸�
				System.out.print("���������˻�������:");
				String pw = sc.next();                 						//�Ӽ�����¼���µ�����
				String reges ="[0-9]{6}";			  		    			//������ʽ����
				if(!pw.matches(reges)) {			   						//������벻������������򱨴�
					System.out.print("���벻���Ϲ淶!!");
					System.out.print("\n");
				}else {							   							//������ʽ�ж��Ƿ��������
					holder.remove(user);				  	 				//�ȴ�ԭ������ɾ��user					 
					user.setPassword(pw);				   					//�޸�user������
					holder.add(user);                      					//Ȼ���������������
					System.out.print("�޸ĳɹ�!!!");
					System.out.print("\n");
					flag = false;
					break;
				}
			}
		}
		if(flag) {
			System.out.print("û���ҵ����û�");
			System.out.print("\n");
		}
	}
	//ע������
	public TreeSet<User> logout(TreeSet<User> list) {
		String username;         										 	 //�û���
		String password;          											 //����
		System.out.print("�������û��˺�:");
		username = sc.next();												 //�Ӽ���¼���û���
		System.out.print("����������:");
		password = sc.next();			  									 //�Ӽ���¼������
		Iterator it = list.iterator();   							     	 //��ȡ������
		while(it.hasNext()) {
			User user = (User)it.next();       							     //��ȡ����
			if(user.getAccount().equals(username)&&user.getPassword().equals(password)){
				list.remove(user);										 	 //���¼�����Ϣƥ�����������ɾ��user����
				System.out.print("ע���ɹ�!!");
				System.out.print("\n");
				return list;
			}
		}		
		System.out.print("�˺Ż����������");									 	 //��ƥ���ӡ��ʾ���
		System.out.print("\n");  
		return list;	
	}
	//���в�������
	public void BankMenu(User user) {
		bank.welcom(user);													 //���е��û�ӭ���
		System.out.print("****************************");
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("    ��ӭ����Java���в���ϵͳ!!!\n");
		System.out.print("\n");
		int str = 1;                 					
		while(str!=0) {
			System.out.print("****************************");
			System.out.print("\n");
			System.out.print(" 1:  ȡǮ ");
			System.out.print("\n");
			System.out.print(" 2:  ��Ǯ ");
			System.out.print("\n");
			System.out.print(" 3:  �鿴���");
			System.out.print("\n");
			System.out.print(" 0:  �˳���¼");
			System.out.print("\n");
			System.out.print("****************************");
			System.out.print("\n");
			System.out.print("\n");
			System.out.print("����������ѡ��:");								//�Ӽ����ж�ȡ�ַ���
			str = sc.nextInt();
			switch(str){												//�����û������ֵ����ѡ��
				case 1:													//ȡǮѡ��
					System.out.print("������ȡ������:");
					
					String pw = sc.next();       						//�Ӽ��̻�ȡ���������
				
					if(user.getPw().equals(pw)) {						//�������ȡ���������û���������бȶ�:�����ͬ�����ִ��
						System.out.print("������ȡ����:");
						double money = sc.nextDouble();					//�Ӽ��̻�ȡ����Ľ��
						if(money>=0) {									//�жϽ���Ƿ�����
							bank.drawMoney(user, money, pw);    	    //����ȡ���
						}else {
							System.out.print("���������!!!");
							System.out.print("\n");
						}
					}else {
						System.out.print("������������!!!");
						System.out.print("\n");
					}
					break;
				case 2:
					System.out.print("������ȡ����:");
					System.out.print("\n");
					double money1 = sc.nextDouble();		//�Ӽ��̻�ȡ����Ľ��
					if(money1>=0) {							//�жϽ���Ƿ�����
						bank.saveMoney(user, money1);;      //���ô���
					}else {
						System.out.print("���������!!!");
						System.out.print("\n");
					}
					break;
				case 3:
					bank.looksum(user);                    	//��������---��ѯ�˻�����
					break;
				case 0:
					bank.GoodBye(user);					   	//���ý������
					break;
				default:
					System.out.print("�������");
					System.out.print("\n");
			}
		}
	}
	
}
