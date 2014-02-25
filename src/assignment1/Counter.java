package assignment1;

import java.util.Date;

public class Counter {
	private String name;
	private Date date;
<<<<<<< HEAD:Assignment1/src/assignment1/model/Counter.java
	private String amount;
=======
	/**
	 * @uml.property  name="amount"
	 */
	private int amount;
>>>>>>> 81a5615bc061790a6086e71da7cef8b8e09cd598:src/assignment1/Counter.java
	
	public Counter(){	
	}
	
	public Counter(String name, Date date, int amount){
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

<<<<<<< HEAD:Assignment1/src/assignment1/model/Counter.java
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
=======
	/**
	 * @return
	 * @uml.property  name="amount"
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 * @uml.property  name="amount"
	 */
	public void setAmount(int amount) {
>>>>>>> 81a5615bc061790a6086e71da7cef8b8e09cd598:src/assignment1/Counter.java
		this.amount = amount;
	}

}
