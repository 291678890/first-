package dao;

import entity.User;

import java.io.Serializable;
import java.util.Comparator;

//�Զ���Ƚ���
//��Ҫ���뼯�ϱ���ʵ�����л��ͷ����л�
public class MyComparator implements Comparator,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public int compare(Object arg0, Object arg1) {
		User user1 = (User)arg0;								//��д�ȽϷ���   --- ǿת��User����
		User user2 = (User)arg1;
		return user1.getAccount().compareTo(user2.getAccount());//�Ƚ����������˻�
	}

}
