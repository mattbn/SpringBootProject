/**
 * 
 */
package it.oop.SpringBootProject.model;

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
	
	public CountStat(Date date, int count) {
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
