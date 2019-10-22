public class Example10 {
    public static void main(String[] args) {
		Zu ti=new Zu();
		new Thread(ti,"段1").start();
		new Thread(ti,"段2").start();
		new Thread(ti,"段3").start();
	}
}
class Zu implements Runnable{
	private int[] arr=new int[100];
	public void run() {
		for(int i=1;i<=100;i++){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"正在下载第"+i+"段");
		}
}
}

	