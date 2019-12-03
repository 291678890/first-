package 影片出租程序第三版;

import  java.util.Enumeration;

public class Customer3 {
    private String _name;
    private Vector _rentals = new Vector() ;

    public Customer3 (String name){
      _name = name;
    };

    public void addRental(Rental arg){
      _rentals.addElement(arg);
    }

    public String getName(){
    return _name;
     };
 private double amountFor(Rental aRental) {
    	 double result = 0;
    	 switch (aRental.getMovie().getPriceCode()) {
    	 case Movie.REGULAR;
    	      result +=2;
    	      if(aRental.getDaysRented()>2)
    	    	  result += (aRental.getDaysRented()-2)*1.5;
    	      break;
    	 case Movie.NEW_RELEASE;
    	 result+=aRental.getDaysRented()*3;
    	 break;
    	 case Movie.CHILDRENS;
    	 result+=1.5;
    	 if(aRental.getDaysRented()>3)
    		 result+=(aRental.getDaysRented()-3)*1.5;
    	 break;
    	 }
    	 return result;
     }