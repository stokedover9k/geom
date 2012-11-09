package vecs;

import java.util.Arrays;

public class Vecf
{
	double[] _vals;
	
	public Vecf( Vecf vec ) {
		_vals = vec._vals.clone();
	}
	
	public Vecf( int degree ) {
		_vals = new double[degree];
	}
	
	public double get( int index ) {
		return _vals[index];
	}
	
	public void set( int index, double val ) {
		_vals[index] = val;
	}
	
	public String toString() {
		return Arrays.toString(_vals);
	}

}
