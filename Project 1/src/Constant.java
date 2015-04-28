/**
 * 
 */

/**
 * @author jordj
 *
 */
public class Constant extends Function{
	
	private double value;
	
	Constant(double value){
		this.value = value;
	}

	@Override
	double evaluate(double v) {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	boolean isConstant() {
		// TODO Auto-generated method stub
		return true;
	}

	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String val = "";
		if(value > 0){
			val = "" + value;
		}
		else{
			val = "(" + value + ")";
		}
		return val;
	}

	@Override
	Function derivative() {
		// TODO Auto-generated method stub
		return new Constant(0);
	}
	

}
