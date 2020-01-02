package dao;

import entity.User;

import java.util.TreeSet;
//ģ��һ�����ݿ�
//���е����ݿ�
public class Data {
	TreeSet<User> holder = new TreeSet<User>(new MyComparator());		//���ڴ洢�û���Ϣ������---�Զ���ȽϹ���
	File file = File.getFile();											//��ȡһ���ļ���
	private static Data data = new Data();            					
	//����ģʽ--��Ϊ�洢���ݵ���Ψһ.���Բ������ⱻʵ����
	private Data() {}													//˽�л����췽��
	public static Data getData() {   									//�ṩ���ظö���ľ�̬����
		return data; 
	}
	//����û�
	public void addUser(User user) {
		holder.add(user);
		System.out.print("ע��ɹ�!!");
		System.out.print("\n");
	}
	//ɾ���û�
	public void removeUser(User user) {
		if(holder.contains(user)) {										//��������а�����user����,���Ƴ�����
			holder.remove(user);	
		}else {															//������������ӡ���
			System.out.print("��Ǹ�����������Ϣ�Ƿ���ȷ");
			System.out.print("\n");
		}
	}
	//��ȡ����
	public TreeSet<User> getHolder() {
		return holder;
	}
	//д������
	public void setHolder(TreeSet<User> holder) {
		this.holder = holder;
	}
	
}
