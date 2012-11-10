package vecs;

import java.util.Arrays;

public class Veci implements Comparable<Veci> 
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
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(_vals);
	}
	
	@Override
	public boolean equals( Object o ) {
		if( o == null ) return false;
		if( o == this ) return true;
		return compareTo((Veci)o) == 0;
	}

	/* This method does component-wise comparisons, starting at component 0 (X).
	 * If vectors are not of the same degree, the results are the same as if the
	 * smaller degree vector was completed with 0's to match the degree of the
	 * higher degree vector.
	 * 
	 *  a = [1, 2, 3]        ---\  [1, 2, 3, 0, 0]  ---\   a < b
	 *  b = [1, 2, 3, 4, 5]  ---/  [1, 2, 3, 4, 5]  ---/
	 *  
	 *  a = [1, 2, 3]        ---\  [1, 2, 3,  0]    ---\   a > b
	 *  b = [1, 2, 3, -1]    ---/  [1, 2, 3, -1]    ---/
	 */
	@Override
	public int compareTo(Veci v) {
		int[] a = _vals, b = v._vals;
		int flip = 1;
		if( a.length > b.length ) 
		{
			int[] tmp = a;
			a = b;
			b = tmp;
			flip = -1;
		}   // a now holds the shorter array
		// for components in both vectors, compare corresponding components
		for( int i = 0; i < a.length; i++ )
			if( a[i] != b[i] )
				return (a[i] - b[i]) * flip;
		// for components in only the higher degree vector, compare against 0 values
		for( int i = a.length; i < b.length; i++ )
			if( b[i] != 0 )
				return b[i] * flip;
		return 0;
	}
}
