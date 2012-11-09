package vecs;

import java.util.Arrays;

public class Veci 
{
	int[] _vals;
	
	public Veci( Veci vec ) {
		_vals = vec._vals.clone();
	}
	
	public Veci( int degree ) {
		_vals = new int[degree];
	}
	
	public int get( int index ) {
		return _vals[index];
	}
	
	public void set( int index, int val ) {
		_vals[index] = val;
	}
	
	public String toString() {
		return Arrays.toString(_vals);
	}
}
