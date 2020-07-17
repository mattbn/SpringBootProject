/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

/**
 * @author Mattia
 *
 */
public class Date {
	
	private Integer[] values;
	
	public Date() {
		Calendar c = Calendar.getInstance();
		values = new Integer[3];
		
		values[0] = c.get(Calendar.YEAR);
		values[1] = c.get(Calendar.MONTH);
		values[2] = c.get(Calendar.DAY_OF_MONTH);
	}
	
	public Date(Calendar c) {
		this();
		
		if(c != null) {
			values[0] = c.get(Calendar.YEAR);
			values[1] = c.get(Calendar.MONTH);
			values[2] = c.get(Calendar.DAY_OF_MONTH);
		}
	}
	
	public Date(Calendar c, int maxCalendarField) {
		this(c);
		
		if(c != null) {
			if(maxCalendarField < Calendar.DAY_OF_MONTH)
				values[2] = null;
			if(maxCalendarField < Calendar.MONTH)
				values[1] = null;
			if(maxCalendarField < Calendar.YEAR)
				values[0] = null;
		}
	}
	
	public Date(Date d) {
		this();
		
		if(d != null)
			values = d.getValues();
	}
	
	
	@Override
	public String toString() {
		String res = "";
		
		if(values[0] != null)
			res = values[0].toString();
		
		if(values[1] != null) {
			if(!res.equals(""))
				res += "-";
			res += values[1].toString();
		}
		
		if(values[2] != null) {
			if(!res.equals(""))
				res += "-";
			res += values[2].toString();
		}
		
		return res;
	}
	
	public boolean equals(Date date) {
		if(date != null && values.equals(date.getValues()))
			return true;
		return false;
	}
	
	public boolean before(Date date) {
		if(date != null) {
			
			if(values[0] == date.getYear()) {
				if(values[1] == date.getMonth()) {
					if(values[2] == date.getDay()) 
						return false;
					return (values[2] < date.getDay() ? true : false);
				}
				
				return (values[1] < date.getMonth() ? true : false);
			}
			
			return (values[2] < date.getYear() ? true : false);
		}
		
		return false;
	}
	
	public boolean after(Date date) {
		if(before(date) || equals(date))
			return false;
		return true;
	}

	public Integer[] getValues() {
		return values;
	}

	public void setValues(Integer[] values) {
		this.values = values;
	}
	
	public Integer getYear() {
		return values[0];
	}
	
	public void setYear(Integer year) {
		values[0] = year;
	}
	
	public Integer getMonth() {
		return values[1];
	}
	
	public void setMonth(Integer month) {
		values[1] = month;
	}
	
	public Integer getDay() {
		return values[2];
	}
	
	public void setDay(Integer day) {
		values[2] = day;
	}
	
}
