package 编写教材例题;
class Storage{
	private int[] cells=new int[10];
	private int inpos,outpos;
	private int count;
	public synchronized void put(int num) {
		try {
			while(count==cells.length) {
				this.wait();
			}
			cells[inpos]=num;
			System.out.println("在cells["+inpos+"]中放入数据---"+cells[inpos]);
					inpos++;
					if(inpos==cells.length)
						inpos=0;
					count++;
					this.notify();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized void get() {
		try {
			while(count==0) {
				this.wait();
			}
			int data=cells[outpos];
			System.out.println("从cells["+outpos+"]中取出数据"+data);
			cells[outpos]=0;
			outpos++;
			if(outpos==cells.length)
				outpos=0;
			count--;
			this.notify();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
class Input implements Runnable{
	private Storage st;
	private int num;
	Input (Storage st){
		this.st=st;
	}
	public void run() {
		while(true) {
			st.put(num++);
		}
	}
}
class Output implements Runnable{
	private Storage st;
	private int num;
	Output (Storage st){
		this.st=st;
	}
	public void run() {
		while(true) {
			st.put(num++);
		}
	}
}
public class Example17 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Storage st=new Storage();
		Input input=new Input(st);
		Output output=new Output(st);
		new Thread(input).start();
		new Thread(output).start();

	}

}
