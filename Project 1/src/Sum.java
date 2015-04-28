/**
 * 
 */

/**
 * @author jordj
 *
 */
import java.util.*;

public class Sum extends Function{
	
	protected ArrayList<Function> solver = new ArrayList<Function>();
	
	//puts all function arguments into a list
	public Sum(Function... elms){
		for( Function i :elms){
			solver.add(i);
		}
	
	}

	@Override
	//loops through list and adds all items together
	double evaluate(double x){
		// TODO Auto-generated method stub
		double end = 0;
		for(Function i : solver){
			end = i.evaluate(x) + end;
		}
		return end;
	}

	@Override
	//loops through list and checks if each item is constant. if one or more item are not, returns false
	boolean isConstant() {
		// TODO Auto-generated method stub
		int count = 0;
		for(Function i: solver){
			if(i.isConstant()==true){
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
		// returns string of function by combining like terms
		// TODO Auto-generated method stub
		String newString = "";
		ArrayList<Function> temp = new ArrayList<Function>();//creates a temp list to hold values
		double combine=0;
		if(solver.size()==1){//if the list has only 1 element, just returns the item
			newString=""+solver.get(0);
		}
		for(int i=0 ; i < solver.size(); i++){
			Function j = solver.get(i);
			if(j.isConstant()){//combines all the constants together
				if(j.evaluate(1) != 0){
					combine = combine + j.evaluate(1);
				}
			}
			else{//adds non-constants to the temp list
				temp.add(j);
			}
		}
		if(combine != 0){ //if combine is not 0, returns the combined constants with the string
			newString = newString + combine;
			for(int p =0; p< temp.size()-1;p++){//loops through the temp list and adds all non constants to the newString
				Function now = temp.get(p);
				newString= newString + "+" + now + "";
			}
			if(temp.size()>1){
				Function end = temp.get(temp.size()-1);
				newString= newString + "+" + end;
			}
			if(temp.size()==1){
				Function end = temp.get(0);
				newString = newString + "+" + end;
			}
		}
		if(combine == 0){//if combine is 0, just returns the string
			for(int p =0; p< temp.size()-1;p++){//loops through the temp list and adds all non constants to the newString
				Function now = temp.get(p);

				newString= "" + now + "+";
			}
			if(temp.size()>1){
				Function end = temp.get(temp.size()-1);
				newString= newString +  end;
			}
			if(temp.size()==1){
				Function end = temp.get(0);
				newString = newString+ "+" + end;
			}
		}
		
		return newString;
	}

	@Override
	Function derivative() {
		// TODO Auto-generated method stub
		Function [] ready = new Function[solver.size()];//creates an array
		for(int i =0; i < ready.length; i++){
			  ready[i]= solver.get(i).derivative();//finds the derivative at given position in list and places it in the array
		}
		return new Sum(ready);
	}

}
