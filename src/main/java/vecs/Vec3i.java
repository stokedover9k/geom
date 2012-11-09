package vecs;

import vecs.Operators.vOpF;
import vecs.Operators.vOpI;
import vecs.Operators.vOpV;
import vecs.Operators.viOpV;
import vecs.Operators.vvOpF;
import vecs.Operators.vvOpI;
import vecs.Operators.vvOpV;

public class Vec3i extends Veci 
{
	public Vec3i(Vec3i vec) {
		super(vec);
	}
	
	public Vec3i( int x, int y, int z ) {
		super(3);
		_vals[0] = x;
		_vals[1] = y;
		_vals[2] = z;
	}
	
	public Vec3i( Vec2i vec2i, int z ) {
		super(3);
		_vals[0] = vec2i._vals[0];
		_vals[1] = vec2i._vals[1];
		_vals[2] = z;
	}
	
	// Copies the first three components of vec into the new Vec3i.
	// If vec's degree is smaller than 3, the corresponding components are left as 0.
	public Vec3i( Veci vec ) {
		super(3);
		if( vec._vals.length > 0 ) {
			_vals[0] = vec._vals[0];
			if( vec._vals.length > 1 ) {
				_vals[1] = vec._vals[1];
				if( vec._vals.length > 2 )
					_vals[2] = vec._vals[2];
			}
		}
	}
	
	public Vec3i clone() {
		return new Vec3i( this );
	}
	
	public Vec3f toF() {
		return new Vec3f(this);
	}
	
	
	
	public  Vec3i op( vOpV<Vec3i> operator )                    { return operator.performOp(this);           }
	public  Vec3i op( vvOpV<Vec3i> operator, Vec3i operand2 )   { return operator.performOp(this, operand2); }
	public  Vec3i op( viOpV<Vec3i> operator, int operand2 )     { return operator.performOp(this, operand2); }
	public double op( vOpF<Vec3i> operator )                    { return operator.performOp(this);           }
	public    int op( vOpI<Vec3i> operator )                    { return operator.performOp(this);           }
	public double op( vvOpF<Vec3i> operator, Vec3i operand2 )   { return operator.performOp(this, operand2); }
	public    int op( vvOpI<Vec3i> operator, Vec3i operand2 )   { return operator.performOp(this, operand2); }
}
