package Ó°Æ¬³ö×â³ÌÐò;

public class Main{
	  public static void main(String[] args) {
	      Customer c1=new Customer("zhangsan");
	      c1. addRental(new Rental(new Movie("lisi",2),6));
	      System. out.print(c1. statement());
	  }
	}