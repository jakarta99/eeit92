package softleaderfirst;

public class CalApp {

	public static void main(String[] args) {
		CalService call = new CalService();
		int sum=call.add(3, 5);
		int sum2=call.minus(3, 5);
		int sum3=call.multiple(3, 5);
		double sum4=call.div(3, 5);
	    System.out.println(sum);
	    System.out.println(sum2);
	    System.out.println(sum3);
	    System.out.println(sum4);

	}

}
