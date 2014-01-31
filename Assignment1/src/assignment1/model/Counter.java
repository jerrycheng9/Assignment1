package assignment1.model;

import java.util.Date;

/**
 * @author  jcheng1
 */
public class Counter {
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="date"
	 */
	private Date date;
	/**
	 * @uml.property  name="amount"
	 */
	private int amount;
	
	public Counter(){	
	}
	
	public Counter(String name, Date date, int amount){
		this.name = name;
		this.date = date;
		this.amount = amount;
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 * @uml.property  name="date"
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 * @uml.property  name="date"
	 */
	public void setDate(Date date) {
		this.date = date;
	}

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
		this.amount = amount;
	}

}
