
import vecs.Op3i;
import vecs.Vec2i;
import vecs.Vec3i;
import vecs.Vecf;
import vecs.Veci;

public class VecTester {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println( "testing vecs..." );
		
		Vec2i x2 = new Vec2i( 1, 0 );
		Vec2i y2 = new Vec2i( 0, 1 );
		
		Vec3i x3 = new Vec3i( x2 );       // default z component inferred
		Vec3i y3 = new Vec3i( y2, 0 );    // z component set explicitly
		Vec3i z3 = new Vec3i( 0, 0, 1 );
		
		//           [1, 0, 0]         +     [0, 1, 0]      +    [0, 0, 1]
		Vec3i diag = x3.clone().op( Op3i.PLUS, y3 ).op( Op3i.PLUS, z3 );
		System.out.println( diag );
		
		// [1, 1, 1]    *    3
		diag.op( Op3i.TIMES, 3 );
		System.out.println( diag );
		
		Vec3i a = new Vec3i( 3, 3, 3 );
		Vec3i b = new Vec3i( 1, 3, 6 );
		Vec3i max = a.clone().op( Op3i.COMP_WISE_MAX, b );
		Vec3i min = a.clone().op( Op3i.COMP_WISE_MIN, b );
		
		System.out.println( "\na: " + a + ", b: " + b );
		System.out.println( "component-wise max: " + max + ", min: " + min );
		
		a.op( Op3i.COMP_WISE_MULT, b );
		System.out.println( "component-wise multiplication: " + a );
		
		a = new Vec3i(0, 1, 2);
		b = new Vec3i(1, 2, 3);
		System.out.println( a.op( Op3i.PLUS, b ).op( Op3i.TIMES, 2 ).op( Op3i.MINUS, b ) );
		
		
		
		// Test comparisons for integer vectors
		
		Veci vi1 = new Veci(3);
		vi1.set(0, 1);
		vi1.set(1, 2);
		vi1.set(2, 3);
		
		Veci vi2 = new Veci(5);
		vi2.set(0, 1);
		vi2.set(1, 2);
		vi2.set(2, 3);
		
		System.out.println(String.format("compare %s and %s: %d", vi1, vi2, vi1.compareTo(vi2)));
		
		vi2.set(4, 1);
		System.out.println(String.format("compare %s and %s: %d", vi1, vi2, vi1.compareTo(vi2)));
		
		vi2.set(4, -1);
		System.out.println(String.format("compare %s and %s: %d", vi1, vi2, vi1.compareTo(vi2)));
		
		// Test comparisons for floating-point vectors

		Vecf vf1 = new Vecf(3);
		vf1.set(0, 1);
		vf1.set(1, 2);
		vf1.set(2, 3);
		
		Vecf vf2 = new Vecf(5);
		vf2.set(0, 1);
		vf2.set(1, 2);
		vf2.set(2, 3);
		
		System.out.println(String.format("compare %s and %s: %d", vf1, vf2, vf1.compareTo(vf2)));
		
		vf2.set(4, 1);
		System.out.println(String.format("compare %s and %s: %d", vf1, vf2, vf1.compareTo(vf2)));
		
		vf2.set(4, -1);
		System.out.println(String.format("compare %s and %s: %d", vf1, vf2, vf1.compareTo(vf2)));
		
		System.out.println( "done." );
	}

}
