package 影片出租程序第三版;

public class Rental3 {
	private Movie3 _movie;
	private int _daysRented;
	
	public Rental3(Movie3 movie,int daysRented) {
		_movie=movie;
		_daysRented=daysRented;
	}
	public int getDaysRented() {
		return _daysRented;
	}
	public Movie3 getMovie() {
		return _movie;
	}

}
