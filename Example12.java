package 编写教材例题;
class Ticket1 implements Runnable{
	private int tickets=10;
	Object lock=new Object();
	public void run() {
		while(true) {
			synchronized(lock) {
				try {
					Thread.sleep(10);
				
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				if(tickets>0) {
					System.out.println(Thread.currentThread().getName()+"---买出的票"+tickets--);
				}else {
					break;
				}
			}
		}
	}
}

public class Example12 {
	public static void main(String[] args) {
		Ticket1 ticket=new Ticket1();
		new Thread(ticket,"现程一").start();
		new Thread(ticket,"现程二").start();
		new Thread(ticket,"现程三").start();
		new Thread(ticket,"现程四").start();
	}

}
