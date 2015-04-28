import java.util.ArrayList;

/**
 * 
 */

/**
 * @author jordj
 *
 */
public class FunctionComparer {
	
	protected ArrayList<Function> solver = new ArrayList<Function>();
	
	public int compare(Function f1, Function f2, double xmin, double xmax){
		int x = (int) xmin;
		int y = (int) xmax;
		double first = f1.integral(0.01,x, y);
		double second = f2.integral(0.01,x, y);
		if(first > second){
			return 1;
		}
		else if(second > first){
			return -1;
		}
		else{
			return 0;
		}
	}
	
	public Function findBiggest(double xmin, double xmax, Function... flist){
		for(Function i : flist){
			solver.add(i);
		}
		FunctionComparer here = new FunctionComparer();
		Function big = null;
		int count =0;
		double gral=0;
		while(count < solver.size()-1){
			int x = count;
			int answer;
			int next = x+1;
			Function f1 = solver.get(x);
			Function f2 = solver.get(next);
			answer=here.compare(f1, f2, xmin, xmax);
			int a = (int) xmin;
			int b = (int) xmax;
			if(answer==1){
				if(f1.integral(0.01,a,b)>gral){
					gral = f1.integral(0.01,a,b);
					big=f1;
				}
				count++;
			}
			else if(answer==-1){
				if(f2.integral(0.01,a,b)>gral){
					gral = f2.integral(0.01,a,b);
					big=f2;
				}
				count++;
			}
			else{
				count++;
			}
		}
		return big;
	}

}
