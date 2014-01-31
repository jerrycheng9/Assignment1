package assignment1.model;

import java.util.Date;

public class Counter {
	private String name;
	private Date date;
	private String amount;
	
	public Counter(){	
	}
	
	public Counter(String name, Date date, String amount){
		this.name = name;
		this.date = date;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
