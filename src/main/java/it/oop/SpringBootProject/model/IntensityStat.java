/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

/**
 * @author Mattia
 *
 */
public class IntensityStat extends Stat {
	
	private int count;
	private SolarEvent min;
	private SolarEvent max;
	private float average;
	
	
	public IntensityStat() {
		super();
	}
	
	public IntensityStat(Calendar date, int count, SolarEvent min, SolarEvent max, float average) {
		super(date);
		
		this.count = count;
		this.min = min;
		this.max = max;
		this.average = average;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public SolarEvent getMin() {
		return min;
	}
	
	public void setMin(SolarEvent min) {
		this.min = min;
	}
	
	public SolarEvent getMax() {
		return max;
	}
	
	public void setMax(SolarEvent max) {
		this.max = max;
	}
	
	public float getAverage() {
		return average;
	}
	
	public void setAverage(float average) {
		this.average = average;
	}

}
