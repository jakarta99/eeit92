package softleaderfirst;

public class CalService {
	public int add(int a ,int b){
		return a+b;		
	}
	
	public int minus(int a ,int b ){
		return a-b;
	}
	
	public int multiple(int a ,int b){
		return a*b;		
	}
	
	public double div(int a,int b){
		
		if(b!=0){
		return  (double) a/(double)b;
		}
		return b;
	}

}
