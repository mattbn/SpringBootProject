/**
 * 
 */
package it.oop.SpringBootProject.model;

/**
 * @author Mattia
 *
 */
public class Stat {
	
	private String name;
	private Object value;
	
	
	public Stat(Stat stat) {
		if(stat != null) {
			name = stat.getName();
			value = stat.getValue();
		}
		
		else {
			name = null;
			value = null;
		}
	}
	
	public Stat(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
