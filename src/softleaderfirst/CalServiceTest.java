package softleaderfirst;
//�椸���չ��@��k������
//����project�W�k��>new>JUnit Test Case>��ܭn����method
import static org.junit.Assert.*;

import org.junit.Test;

public class CalServiceTest {

	@Test
	public void testAdd() {
		CalService call = new CalService();
		int sum=call.add(3, 5);
		assertEquals(8,sum);//(�w��,��ڭp��)�����|������
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
		assertEquals(0.6,sum,0.01);//�i�����~�t�d��

		
		
	}

}
