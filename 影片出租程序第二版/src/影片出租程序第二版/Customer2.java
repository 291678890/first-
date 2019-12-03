package 影片出租程序第二版;

import  java.util.Enumeration;

public class Customer2 {
    private String _name;
    private Vector _rentals = new Vector() ;

    public Customer2 (String name){
      _name = name;
    };

    public void addRental(Rental arg){
      _rentals.addElement(arg);
    }

    public String getName(){
    return _name;
     };
     private double amountFor(Rental each) {
    	 double thisAmount = 0;
    	 switch (each.getMovie().getPriceCode()) {
    	 case Movie.REGULAR;
    	      thisAmount +=2;
    	      if(each.getDaysRented()>2)
    	    	  thisAmount += (each.getDaysRented()-2)*1.5;
    	      break;
    	 case Movie.NEW_RELEASE;
    	 thisAmount+=each.getDaysRented()*3;
    	 break;
    	 case Movie.CHILDRENS;
    	 thisAmount+=1.5;
    	 if(each.getDaysRented()>3)
    		 thisAmount+=(each.getDaysRented()-3)*1.5;
    	 break;
    	 }
    	 return thisAmount;
     }