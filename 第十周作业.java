import java.util.Random;

class Storage {
		private String [] cells = new String[10];
		private int inpos,outpos;
		private int count;
		private String name;
		public synchronized void In () {
			try {
				while (count==cells.length) {
					this.wait();
				}
				Thread.sleep(new Random().nextInt(100));
				name=String.valueOf(new Random().nextInt(100));
				cells[inpos]=name;
				System.out.println("cells["+inpos+"]中用户"+cells[inpos]+"登录---在线人数："+count);
				inpos++;
				if (inpos==cells.length)
					inpos=0;
				count++;
				this.notify();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public  synchronized void out() {
			try {
				while (count==0) {
					this.wait();
				}
				Thread.sleep(new Random().nextInt(100));
				String data = cells[outpos];
				System.out.println("cells["+outpos+"]中用户"+data+"注销---在线人数："+count);
				cells[outpos]=null;
				outpos++;
				if(outpos==cells.length)
					outpos=0;
				count--;
				this.notify();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

}
class In implements Runnable {
	private Storage st;
	In (Storage st) {
		this.st=st;
	}
	public void run () {
		while (true) {
			st.In();
		}
	}
} 
class Out implements Runnable {
	private Storage st;

	Out (Storage st ) {
		this.st =st ;
	}
	public void run () {
		while (true ) {
			st.out();
		}
	}
} 
public class Example15 {
		public static void main (String [] args) {
			Storage st =new Storage ();
			In input =new In (st);
			Out output =new Out(st);
			new Thread(input).start();
			new Thread(output).start();
		}
} 