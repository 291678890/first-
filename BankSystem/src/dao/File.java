package dao;

import entity.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * �ļ���--�������ڴ��г�ʼ����Ϣ�Լ�������������ڴ��д�����Ϣ
 * */
public class File {
	TreeSet<User> holder = Data.getData().getHolder();				//��Data���ݿ��л�ȡ����
	//�ļ���ֻ��ʹ�ò��ܱ�����ʵ�ʻ�
	public static File FILE;										//˽�л�һ��File��
	private File() {};			
	public static File getFile() {									//������ṩ��ȡ����
		return FILE;
	}
	//���浽�ļ���
    public static void SaveToFile(TreeSet<User> list) {				//����ȡ�����������뵽�ļ���----���л�
    	ObjectOutputStream oo = null;
        try {
            oo = new ObjectOutputStream(new FileOutputStream("text1.txt"));		//��ȡ�ļ��洢��ַ
            oo.writeObject(list);																//������д��
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
        	try {
        		oo.close();																		//�����ر�
        	}catch(IOException e) {
        		e.printStackTrace();
        	}
        }
    }
    //���ļ����ȡ
	public static TreeSet<User> ReadFromFile() {
		ObjectInputStream ois = null;
		TreeSet<User> list = null;
        try {
        	ois = new ObjectInputStream(new FileInputStream("text1.txt"));//�����л����ļ��л�ȡ�������ص��ڴ�
        	list = Data.getData().getHolder();											//��ȡ����
        	list = (TreeSet<User>) ois.readObject();									//�����л�ȡ����
            Iterator it = list.iterator();												//������
            System.out.print("��ǰ�û���Ϣ:");
            System.out.print("\n"); 
            System.out.print("\n"); 
            while(it.hasNext()) {														//������ʼ��Ϣ
            	User user = (User) it.next();
            	System.out.print("\t"+"����:"+user.getName()+"\t"+"�˺�:"+user.getAccount()+"\t"+"����:"+user.getPassword()+"\t"+"���:"+user.getSum()+"\t");
            	System.out.print("\n");
            	System.out.print("\n");
            }
        	
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
        	try {
        		ois.close();															//�����ر�
        	}catch(IOException e){
        		e.printStackTrace();
        	}
        }
        return list;
    }
}
