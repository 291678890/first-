package 影片出租程序第三版;

public class Movie3 {
	public static final int CHILDRENS=2;
	public static final int REGULAR=0;
	public static final int NEW_RELEASE=1;
	
	private String _title;
	private int _priceCode;
	
	public Movie3(String title,int priceCode) {
		_title=title;
		_priceCode=priceCode;
	}
	public int getPriceCode() {
		return _priceCode;
	}
	public void setPriceCode(int arg) {
		_priceCode=arg;
	}
	public String getTitle() {
		return _title;
	}
}