package vecs;

import vecs.Operators.vOpF;
import vecs.Operators.vOpI;
import vecs.Operators.vOpV;
import vecs.Operators.vfOpV;
import vecs.Operators.viOpV;
import vecs.Operators.vvOpF;
import vecs.Operators.vvOpI;
import vecs.Operators.vvOpV;

public class Vec3f extends Vecf
{
	public Vec3f( Vec3f vec ) {
		super( vec );
	}
	
	public Vec3f( double x, double y, double z ) {
		super(3);
		_vals[0] = x;
		_vals[1] = y;
		_vals[2] = z;
	}
	
	public Vec3f( Vec2f vec2f, double z ) {
		super(3);
		_vals[0] = vec2f._vals[0];
		_vals[1] = vec2f._vals[1];
		_vals[2] = z;
	}
	
	// Copies the first three components of vec into the new Vec3f.
	// If vec's degree is smaller than 3, the corresponding components are left as 0.
	public Vec3f( Vecf vec ) {
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
	
	// Copies the first three components of vec into the new Vec3f.
	// If vec's degree is smaller than 3, the corresponding components are left as 0.
	public Vec3f( Veci vec ) {
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
	
	public Vec3f clone() {
		return new Vec3f( this );
	}
	
	
	
	public  Vec3f op( vOpV<Vec3f> operator )                    { return operator.performOp(this);           }
	public  Vec3f op( vvOpV<Vec3f> operator, Vec3f operand2 )   { return operator.performOp(this, operand2); }
	public  Vec3f op( vfOpV<Vec3f> operator, double operand2 )  { return operator.performOp(this, operand2); }
	public  Vec3f op( viOpV<Vec3f> operator, int operand2 )     { return operator.performOp(this, operand2); }
	public double op( vOpF<Vec3f> operator )                    { return operator.performOp(this);           }
	public    int op( vOpI<Vec3f> operator )                    { return operator.performOp(this);           }
	public double op( vvOpF<Vec3f> operator, Vec3f operand2 )   { return operator.performOp(this, operand2); }
	public    int op( vvOpI<Vec3f> operator, Vec3f operand2 )   { return operator.performOp(this, operand2); }	
}
