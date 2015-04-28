import java.util.ArrayList;

/**
 * 
 */

/**
 * @author jordj
 *
 */
public class Product extends Function{
	
	protected ArrayList<Function> solver = new ArrayList<Function>();
	
	//constructor takes all function arguments and puts them into a list
	public Product(Function... elms){
		for( Function i :elms){
			solver.add(i);
		}
	
	}

	@Override
	//loops through list and multiplies all functions together
	double evaluate(double x) {
		// TODO Auto-generated method stub
		double end = 1;
		for(Function i : solver){
			end = i.evaluate(x) * end;
		}
		/*if(end==0){
			solver=new ArrayList<Function>();
			solver.add(new Constant(0));
		}
		*/
		return end;
	}


	@Override
	//checks each item in list to see if its constant. if one or more functions ae not, returns false
	boolean isConstant() {
		// TODO Auto-generated method stub
		int count = 0;
		for(Function i: solver){
			if(i.isConstant()){
				count ++;
			}
			if(count == solver.size()){
				return true;
			}
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
		//returns string of function by combining constants
		// TODO Auto-generated method stub
		ArrayList<Function> temp = new ArrayList<Function>();//creates a temp list to hold values
		String newString = "";
		double combine=1;
		if(solver.size()==1){
			newString=""+solver.get(0);
		}
		for(int i=0 ; i < solver.size(); i++){
			Function j = solver.get(i);
			if(j instanceof Constant){//if i is a constant, multiplies it with other constants
				combine = combine * j.evaluate(1);
			}
			
			else{
				temp.add(j);//adds non constants to the list
			}
		}
		if(combine != 0 && combine !=1){//checks if combine is 0 or 1, if not then returns combine and the newString
			newString = combine + "";
			for(Function k: temp){
				newString= newString + "*" + k;
			}
		}
		else if (combine==1){//if combine=1 or 0, returns the newString
			for(int p =0; p< temp.size()-1;p++){//loops through the temp list and adds all non constants to the newString
				Function now = temp.get(p);
				newString= newString + now + "*";
			}
			Function end = temp.get(temp.size()-1);
			newString= "("+newString + end+")";
		}
		else if(combine ==0){
			newString="";
		}
		return newString;
	}

	@Override
	Function derivative() {
		// TODO Auto-generated method stub
		//creates a new list to store functions
		ArrayList<Function> deriv = new ArrayList<Function>();
		double combine=1;
		//iterates through the list and combines like constants
		for(int i=0 ; i < solver.size(); i++){
			Function j = solver.get(i);
			if(j.isConstant()){
				combine = combine * j.evaluate(1);
			}
			//if not a constant, just adds it to the list
			else if(j.isConstant()==false){
				deriv.add(j);
			}
		}
		Sum sum=null;
		if(combine !=1){
			deriv.add(new Constant(combine));
		}
		//creates a new sum and adds the total of constants to the list
		if(deriv.size()==1){
			Function [] ready = new Function[solver.size()];
			for(int i =0; i < ready.length; i++){
				  ready[i]= solver.get(i).derivative();//finds the derivative and places it in the array
			}
			sum = new Sum (ready);
		}
			//looks at list and does derivative formula of a sum (x*y'+y*x')
			Function one = deriv.get(0);
			Function two = deriv.get(1);
			Function d1= one.derivative();
			Function d2= two.derivative();
			Product first = new Product(one,d2);
			Product next = new Product(two,d1);
			sum =  new Sum(first,next);


		return sum;
	}


}
