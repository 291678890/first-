package 影片出租程序第二版;

public class Main2{
	 public static void main(String[] args) {
	      Customer c=new Customer("zhangsan");
	      c. addRental(new Rental2(new Movie2("lisi",2),6));
	      System. out.println(c. amountFor());
	  }
	}