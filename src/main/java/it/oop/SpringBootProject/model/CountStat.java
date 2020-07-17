/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

/**
 * @author Mattia
 *
 */
public class CountStat extends Stat {
	
	private int count;
	
	
	public CountStat() {
		super();
		count = 0;
	}
	
	public CountStat(Calendar date, int count) {
		super(date);
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

}
