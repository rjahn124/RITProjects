

/**
 * 
 */

/**
 * @author jordj
 *
 */
public class FunctionTest {
	
	public static void main(String[] args){
		
		System.out.println(Variable.X.derivative());
		System.out.println(Variable.X.evaluate(3));
		System.out.println(Variable.X.isConstant());
		System.out.println(Variable.X.integral(1,1, 5));
		
		Constant num1 = new Constant(8);
		Constant num2 = new Constant(12);
		Constant num3 = new Constant(-4.3);
		Constant num4 = new Constant(78622.2);
		
		System.out.println("NUM1: " + num1);
		System.out.println("NUM2: " + num2);
		System.out.println("NUM3: " + num3);
		System.out.println("NUM4: " + num4);
		
		Sine new1 = new Sine(num1);
		Sine new2 = new Sine(num2);
		Cosine new3 = new Cosine(num1);
		Cosine new4 = new Cosine(num2);
		
		System.out.println("NEW1: " + new1);
		System.out.println("NEW2: " + new2);
		System.out.println("NEW3: " + new3);
		System.out.println("NEW4: " + new4);
		
		System.out.println("NUM1 = " + num1.evaluate(1));
		System.out.println("NUM2 = " + num2.evaluate(1));
		System.out.println("NUM3 = " + num3.evaluate(1));
		System.out.println("NUM4 = " + num4.evaluate(1));
	
		System.out.println("NUM1 DERIV = " + num1.derivative());
		System.out.println("NUM2 DERIV = " + num2.derivative());
		System.out.println("NUM3 DERIV = " + num3.derivative());
		System.out.println("NUM4 DERIV= " + num4.derivative());
		
		System.out.println("IS NUM1 CONSTANT? "+num1.isConstant());
		System.out.println("IS NUM2 CONSTANT? "+num2.isConstant());
		System.out.println("IS NUM3 CONSTANT? "+num3.isConstant());
		System.out.println("IS NUM4 CONSTANT? "+num4.isConstant());
		
		System.out.println("NEW1 = " + new1.evaluate(2));
		System.out.println("NEW2 = " + new2.evaluate(3.2));
		System.out.println("NEW3 = " + new3.evaluate(2));
		System.out.println("NEW4 = " + new4.evaluate(3.2));
		
		System.out.println("NEW1 DERIV = " + new1.derivative());
		System.out.println("NEW2 DERIV = " + new2.derivative());
		System.out.println("NEW3 DERIV = " + new3.derivative());
		System.out.println("NEW4 DERIV = " + new4.derivative());
		
		System.out.println("IS NEW1 CONSTANT? "+new1.isConstant());
		System.out.println("IS NEW2 CONSTANT? "+new2.isConstant());
		System.out.println("IS NEW3 CONSTANT? "+new3.isConstant());
		System.out.println("IS NEW4 CONSTANT? "+new4.isConstant());
		
		
		Sum solve = new Sum(new Product(num1,Variable.X),new Product(num2,Variable.X));
		Sum basic = new Sum(new Constant(2),new Constant(4),new Constant(3));
		Sum var = new Sum(new Constant(2),Variable.X,Variable.X,Variable.X,Variable.X);
		Product test = new Product(new Constant(3),Variable.X);
		Product example = new Product(Variable.X,new Product(new Constant(12.5),Variable.X));

		
		System.out.println("SOLVE: "+solve);//(8x)+(12x)
		System.out.println("SOLVE DERIV: " + solve.derivative());//8+12
		System.out.println("SOLVE INTEGRAL(1:5): " + solve.integral(1,1, 5));
		
		System.out.println("BASIC: "+basic);//9
		System.out.println("BASIC DERIV: "+basic.derivative());//0
		System.out.println("BASIC INTEGRAL(1:5): "+basic.integral(1,1,5));

		System.out.println("VAR: "+var);//(2+4x)
		System.out.println("VAR DERIV: "+var.derivative());//4
		System.out.println("VAR INTEGRAL(1:5): "+var.integral(1,1,5));
		
		System.out.println("TEST: "+test);//3x
		System.out.println("TEST DERIV: "+test.derivative());//3
		System.out.println("TEST INTEGRAL(1:5): "+test.integral(2,1, 5));
		
		System.out.println("EXAMPLE: " + example);//12.5x^2
		System.out.println("EXAMPLE DERIV: " + example.derivative());//25x
		System.out.println("EXAMPLE INTEGRAL(1:5):"+example.integral(2,1, 5));
		
		
		Quotient quo = new Quotient(new Product(new Constant(6),Variable.X),new Sine(Variable.X));
		
		System.out.println("QUO: "+quo);//(6x/sin(x)
		System.out.println("QUO = "+quo.evaluate(2));//(12/sin(2))
		System.out.println("QUO DERIV: " + quo.derivative());// 6x*cos(x)+6*sin(x)/sin(x)*sin(x)
		System.out.println("QUO INTEGRAL(1:5): " + quo.integral(2,1, 5));
		
		Quotient ex = new Quotient( new Product( Variable.X, Variable.X ),
				new Sum (new Cosine( new Product( new Constant(2), Variable.X)),new Constant(7)));
		
		System.out.println("EX: "+ex);//(x^2)/((cos(2x)+7)
		System.out.println("EX = "+ex.evaluate(2));//(4/cos(4)+7)
		System.out.println("EX DERIV: " + ex.derivative());// 2x^2(sin(2x))-2x(cos(2x)+7)/(cos(2x)+7)^2
		System.out.println("EX INTEGRAL(1:5): "+ex.integral(0.01,1, 5));
		
		
		FunctionComparer fc = new FunctionComparer();
		
		System.out.println("TEST VS EXAMPLE: " + fc.compare(test, example, 1, 5));
		System.out.println("QUO VS SOLVE: " + fc.compare(quo,solve, 0, 0));
		System.out.println("VAR VS BASIC: " + fc.compare(var, basic, 1, 5));
		
		System.out.println("Biggest of them all is: " + fc.findBiggest(1.0, 5.0, test,ex,example,quo,solve,var,basic));
		
	}

}
