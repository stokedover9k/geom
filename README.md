===============================================================================
||                               0.CONTENTS                                  ||
===============================================================================

 - 1.OVERVIEW
 - 1.a.VECTORS
 - 1.b.OPERATORS
 - 1.c.VECTORS_AND_OPERATORS
 - 1.d.A_NOTE_ON_COMPARISONS
 - 2.CLASSES

===============================================================================
||                               1.OVERVIEW                                  ||
===============================================================================

This library is designed to make vector operators simple and efficient.

-----------------
||    1.a.VECTORS
-----------------

The vectors are differentiated by:
 - component type
 - degree

Classes representing vectors begin with "Vec".  What follows is specification
of the above differentiation parameters:
 - component type:
   - "i" for integer (int)
   - "f" for floating point (double)
 - degree
   - none for raw types which may be created with any degree
   - "2" and "3" are vectors of degree 2 and 3 respectively
So, for example Vec3i is a vector of degree 3 with integer components.

Each vector type comes with overloaded operation functions (op).  These
functions take operator objects (see next section) and additional operands.
Then they call the operator's "performOp" function giving it the "this" pointer
as the first input and the appropriate additional operands as the other inputs.
The operators are abundant and easy to implement.  See below for detailed usage.

-------------------
||    1.a.OPERATORS
-------------------

Operators are objects which perform some operations on vectors and other
inputs and produce an output.  For example a dot-product operator takes two
vectors and produces a number (whether integer or floating point).

The operators in this package have type arguments specifying what kind of
vector they are suitable for (for example, the dot-product operator for
Vec2i vectors requires a different implementation than one for Vec3f vectors).

The interfaces for the operators are in Operators.java . The operator
interfaces are named according to their input and output types and follow the
following naming convention:

  [x...]Op[Y]

where x's are input types in order and Y is the output type.  Note that x's are
lower-case letters while Y is upper-case.  
For example, an operator interface named vvOpI defines a function "performOp"
which takes as inputs two vectors (the first two letters of the name) and
outputs an integer value (last letter of the name).  The type of input vectors
is specified by the type parameter to the interface.  For example, the
interface vvOpI<Vec3i> can be used for the dot-product operator for the 
integer-component vectors of degree 3.

Some of the operator interfaces in iOperator.java have the same names as
ones in the fOperator.java.  This allows for operations like vector addition
to share the same name differentiated only by the vector type (type argument):
vvOpV<V extends Veci> vs. vvOpV<V extends Vecf>.

-------------------------------
||    1.a.VECTORS_AND_OPERATORS
-------------------------------

Although the operators can be used directly with the appropriate inputs (e.g.
operator(input1, input2) : input3), the vector classes have overloaded "op" 
methods which allow for writing expressions left to right.  The op method
calls the operator's performOp method with the "this" pointer as the first
parameter.

For example, the following code adds vectors (0, 1, 2) and (1, 2, 3):
  Vec3i a = new Vec3i(0, 1, 2);
  Vec3i b = new Vec3i(1, 2, 3);
  a.op( Op3i.PLUS, b );
The last line returns a the vector (1, 3, 5) now stored in a.  Thus operations
can be chained:
  a.op( Op3i.PLUS, b ).op( Op3i.TIMES, 2 ).op( Op3i.MINUS, b );
and so on.
Note, however, that the implemented operators store the results in the existing
vectors which are given as the first argument to the "performOp" function of the
operator.  Thus, in the code above, each operation stores the result in the
vector pointed to by a.  If vector a needs to be preserved, clone the first
vector in the operation chain:
  a.clone().op( Op3i.PLUS, b ).op( Op3i.TIMES, 2 ).op( Op3i.MINUS, b );
This returns a new vector (1, 4, 7) while a and b are preserved.

-------------------------------
||    1.d.A_NOTE_ON_COMPARISONS
-------------------------------

Vectors of raw vector types (Veci and Vecf) may be compared to other vectors of
this without the need for matching degrees.  If the degrees are not equal, the
vector with smaller degree is imagined to have 0's for the missing components.
The vectors are compared component-wise starting from the first component (X). 

===============================================================================
||                               2.CLASSES                                   ||
===============================================================================

 - Veci
   Vectors with integer (int) fields
  
 - Vec2i
   Vectors of degree 2 with integer (int) fields
   
 - Vec3i
   Vectors of degree 3 with integer (int) fields
   
 - Vecf
   Vectors with floating point (double) fields
  
 - Vec2f
   Vectors of degree 2 with floating point (double) fields
   
 - Vec3f
   Vectors of degree 3 with floating point (double) fields
   
 - Operators
   This static class contains the interfaces for operators on vectors.
 
 - Op2i
 - Op3i
 - Op2f
 - Op3f
   These static classes contain several operator objects for Vec2i, Vec3i, Vec2f, and
   Vec3f vectors respectively.
   These include (at least) the following:
     - PLUS
     - MINUS
     - TIMES
     - DIVIDE
     - DOT               - dot product
     - COMP_WISE_MULT    - component-wise multiplication
     - COMP_WISE_MAX     - component-wise max
     - COMP_WISE_MIN     - component-wise minimum
     - MAX               - maximum element
     - MIN               - minimum element
   Note that the operators which return a vector are in place operators: they will change
   and return the first vector in the input.
   
 - Opi
 - Opf
   These static classes contain several operators similar to the Op2i, Op2f classes,
   but which are not restricted in the degree of used vectors.  You should use the
   degree restricted operators for efficiency when possible because they eliminate 
   some overhead.
   <<<NOTE>>>:
   Some of the operators in these files are not in-place (e.g. component-wise max and
   min will return a vector of the degree equal to the higher-degree argument).  See files
   for details.
