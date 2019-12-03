package 影片出租程序第二版;

public class Rental2 {
	private Movie2 _movie;
	private int _daysRented;
	
	public Rental2(Movie2 movie,int daysRented) {
		_movie=movie;
		_daysRented=daysRented;
	}
	public int getDaysRented() {
		return _daysRented;
	}
	public Movie2 getMovie() {
		return _movie;
	}

}
