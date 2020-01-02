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
 * 文件类--负责向内存中初始化信息以及程序结束后向内存中存入信息
 * */
public class File {
	TreeSet<User> holder = Data.getData().getHolder();				//从Data数据库中获取容器
	//文件类只供使用不能被任意实际化
	public static File FILE;										//私有化一个File类
	private File() {};			
	public static File getFile() {									//对外界提供获取方法
		return FILE;
	}
	//保存到文件里
    public static void SaveToFile(TreeSet<User> list) {				//将获取到的容器存入到文件中----序列化
    	ObjectOutputStream oo = null;
        try {
            oo = new ObjectOutputStream(new FileOutputStream("text1.txt"));		//获取文件存储地址
            oo.writeObject(list);																//将容器写入
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
        	try {
        		oo.close();																		//将流关闭
        	}catch(IOException e) {
        		e.printStackTrace();
        	}
        }
    }
    //从文件里读取
	public static TreeSet<User> ReadFromFile() {
		ObjectInputStream ois = null;
		TreeSet<User> list = null;
        try {
        	ois = new ObjectInputStream(new FileInputStream("text1.txt"));//反序列化从文件中获取容器加载到内存
        	list = Data.getData().getHolder();											//获取容器
        	list = (TreeSet<User>) ois.readObject();									//从流中获取对象
            Iterator it = list.iterator();												//迭代器
            System.out.print("当前用户信息:");
            System.out.print("\n"); 
            System.out.print("\n"); 
            while(it.hasNext()) {														//迭代初始信息
            	User user = (User) it.next();
            	System.out.print("\t"+"姓名:"+user.getName()+"\t"+"账号:"+user.getAccount()+"\t"+"密码:"+user.getPassword()+"\t"+"余额:"+user.getSum()+"\t");
            	System.out.print("\n");
            	System.out.print("\n");
            }
        	
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
        	try {
        		ois.close();															//将流关闭
        	}catch(IOException e){
        		e.printStackTrace();
        	}
        }
        return list;
    }
}
