

package training.karbouali.chrono;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class TestChronometer extends TestCase{
	private static CyclicCounter hour;
	private static CyclicCounter minute;
	private static CyclicCounter second;
	private Chronometer chrono;
	
	@BeforeClass
	public static void testBeforeClass(){
		hour = new CyclicCounter(0, 23, 0);
		minute = new CyclicCounter(0, 59, 0);
		second = new CyclicCounter(0, 59, 0);
	}
	
	@Test
	public void testChrono(){
		chrono = new Chronometer(0,0,0);
		int i;
		
		for (i=0;i<120;i++){
			chrono.increment();
		}
		assertEquals(2, chrono.getMinute().getValue());
		
		for (i=0;i<600;i++){
			chrono.increment();
		}
		assertEquals(12, chrono.getMinute().getValue());
	}
}
