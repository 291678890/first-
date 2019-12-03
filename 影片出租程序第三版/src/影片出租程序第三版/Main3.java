package 影片出租程序第三版;

public class Main3{
	 public static void main(String[] args) {
	      Customer c=new Customer("zhangsan");
	      c. addRental(new Rental3(new Movie3("lisi",2),6));
	      System. out.println(c. amountFor());
	  }
	}