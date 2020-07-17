/**
 * 
 */
package it.oop.SpringBootProject.util;

/**
 * @author Mattia
 *
 */
public class Pair<A, B> {
	
	public A first;
	public B second;
	
	
	public Pair(A first, B second) {
		this.first = first;
		this.second = second;
	}
	
	public static <T,U> Pair<T,U> make(T first, U second) {
		return new Pair<T,U>(first, second);
	}
	
	@Override
	public String toString() {
		String 	fstr = "", 
				sstr = "";
		if(first != null)
			fstr = first.toString();
		if(second != null)
			sstr = second.toString();
		
		return "("+fstr+", "+sstr+")";
	}

}
