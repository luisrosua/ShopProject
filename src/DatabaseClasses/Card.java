package DatabaseClasses;

import java.sql.Date;

public class Card {
	private long number;
	private int cvv;
	private Date expiration;
	
	public Card(long number, int cvv, int year, int month) {
		this.number = number;
		this.cvv = cvv;
		
		this.expiration = new Date(year, month, 1);
	}
	
	public Card(long number, int cvv, Date expiration) {
		this.number = number;
		this.cvv = cvv;
		this.expiration = expiration;
	}

	public long getNumber() {
		return number;
	}

	public int getCvv() {
		return cvv;
	}

	public Date getExpiration() {
		return expiration;
	}
	
}