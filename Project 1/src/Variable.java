/**
 * 
 */

/**
 * @author jordj
 *
 */
public class Variable extends Function{
	
	private double value;
	public static final double DVALUE = 0;
	
	private Variable(){
		this.value = DVALUE;
	}
	
	
	public static final Variable X = new Variable();

	@Override
	double evaluate(double v) {
		// TODO Auto-generated method stub
		return v;
	}


	@Override
	boolean isConstant() {
		// TODO Auto-generated method stub
		return false;
	}

/*
	@Override
	double integral(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}
*/

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x";
	}


	@Override
	Function derivative() {
		// TODO Auto-generated method stub
		return new Constant(1);
	}

}
