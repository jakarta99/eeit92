package softleaderfirst;
//單元測試對單一方法做測試
//測試project上右鍵>new>JUnit Test Case>選擇要測試method
import static org.junit.Assert.*;

import org.junit.Test;

public class CalServiceTest {

	@Test
	public void testAdd() {
		CalService call = new CalService();
		int sum=call.add(3, 5);
		assertEquals(8,sum);//(預期,實際計算)有錯會有紅色
	}

	@Test
	public void testMinus() {
		CalService call = new CalService();
		int sum=call.minus(3, 5);
		assertEquals(-2,sum);
	}

	@Test
	public void testMultiple() {
		CalService call = new CalService();
		int sum=call.multiple(3, 5);
		assertEquals(15,sum);
	}

	@Test
	public void testDiv() {
		CalService call = new CalService();
		double sum=call.div(3, 5);
		assertEquals(0.6,sum,0.01);//可接受誤差範圍

		
		
	}

}
