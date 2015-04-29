

/**
 * 
 */

/**
 * @author jordj
 *
 */
public class Quotient extends Function{
	
	private Function numerator;
	private Function denominator;
	
	//constructor that takes a function in the numerator and denominator
	public Quotient(Function num, Function denom){
		numerator= num;
		denominator = denom;

	}

	@Override
	//evaluates the numerator and divides it against the evaluated denominator
	double evaluate(double x) {
		// TODO Auto-generated method stub
		double divide = numerator.evaluate(x)/ denominator.evaluate(x);
		return divide;
	}

	@Override
	//checks if the numerator and the denominator is constant. if either is false, returns false
	boolean isConstant() {
		// TODO Auto-generated method stub
		if(numerator.isConstant() && denominator.isConstant()){
			return true;
		}
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
		String newString = "";
		if(numerator.isConstant() && denominator.isConstant()){//tries to combine terms if both num and denom are constant
			Quotient val = new Quotient(numerator,denominator);
			val.evaluate(3);
		}
		newString= "[" + numerator + "]" +"/"+ "[" + denominator + "]" ;
		return newString;
	}

	@Override
	//creates a new Quotient function using (num*denom.deriv + denom*num.deriv)/denom^2
	Function derivative() {
		// TODO Auto-generated method stub
		Function num1 = numerator.derivative();
		Function denom= denominator.derivative();
		return new Quotient(new Sum(new Product(numerator,denom),new Product(denominator,num1)),new Product(denominator,denominator));
	}

}
