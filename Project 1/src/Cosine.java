/**
 * 
 */

/**
 * @author jordj
 *
 */



public class Cosine extends Function{
	private Function value;
	
	public Cosine(Function val){
		value = val;
	}

	@Override
	double evaluate(double v) {
		// TODO Auto-generated method stub
		double answr = Math.cos(value.evaluate(v));
		return answr;
	}

	@Override
	boolean isConstant() {
		// TODO Auto-generated method stub
		return false;
	}
/*
	@Override
	double integral() {
		// TODO Auto-generated method stub
		return 0;
	}
*/
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "cos" + "(" + value + ")";
	}

	@Override
	Function derivative() {
		// TODO Auto-generated method stub
		return new Sine(value);
	}

}