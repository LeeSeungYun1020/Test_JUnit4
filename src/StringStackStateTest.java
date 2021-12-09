import static org.junit.Assert.*;
import org.junit.Test;


public class StringStackStateTest {
	
	// state coverage - zero state, size state, max state
	/*
	** ������Ʈ Ŀ�������� �޼��ϱ� ���쳪 ȿ�������� ���ϴ�.
	** (���� �� ã�Ƴ��� ���Ѵ�.)
	*/
	
	@Test
	public void testZeroState() {
		StringStack stack = new StringStack();
		assertEquals(0, stack.getSize());
	}
	
	@Test
	public void testSizeState() {
		StringStack stack = new StringStack();
		stack.push("string1");
		assertEquals(1, stack.getSize());
	}
	
	@Test
	public void testMaxState() {
		StringStack stack = new StringStack();
		for(int i = 1; i < 20; i++) {
			stack.push("string");
		}
		
		stack.push("max");
		
		assertEquals(stack.getMaxSize(), stack.getSize());
	}
	
	//	transition coverage
	/* �Ϻ� �׽�Ʈ ���̽����� for ���� ����Ͽ� �� ��츦 ��� �׽�Ʈ�Ͽ����� ���� �׷��� �� �ʿ�� ����
	** AAA ��Ģ ������ ���ؼ��� assertion �� ���� ������ ���� ����
	*/
	
	@Test
	public void testEmptyTransition() {
		StringStack stack = new StringStack();
		assertEquals(0, stack.getSize());
	}
	
	@Test
	public void testEmptyPushTransition() {
		StringStack stack = new StringStack();
		stack.push("something");
		assertEquals(1, stack.getSize());
	}
	
	@Test
	public void testEmptyPopTransition() {
		StringStack stack = new StringStack();
		stack.push("something");
		assertEquals("something", stack.pop());
		assertEquals(0, stack.getSize());
	}
	
	@Test
	public void testSizeSelfPushTransition() {
		StringStack stack = new StringStack();
		for(int i = 1; i < 20; i++) {
			stack.push("string");
			assertEquals(i, stack.getSize());
		}
	}
	
	@Test
	public void testSizeSelfPopTransition() {
		StringStack stack = new StringStack();
		for(int i = 1; i < 20; i++) {
			stack.push("string" + i);
		}
		assertEquals(19, stack.getSize());
		for(int i = 19; i > 1; i--) {
			assertEquals("string" + i, stack.pop());
			assertEquals(i - 1, stack.getSize());
		}
	}
	
	@Test
	public void testMaxPushTransition() {
		StringStack stack = new StringStack();
		for(int i = 1; i <= 20; i++) {
			stack.push("string");
		}
		assertEquals(stack.getMaxSize(), stack.getSize());
	}
	
	@Test
	public void testMaxPopTransition() {
		StringStack stack = new StringStack();
		for(int i = 0; i < 20; i++) {
			stack.push("string");
		}
		// assertEquals(stack.getMaxSize(), stack.getSize());
		assertEquals("string", stack.pop());
		assertEquals(stack.getMaxSize() - 1, stack.getSize());
	}
	
	// transition pair coverage
	/*
	** ���ǻ� ���� �ϳ��� �ۼ��Ͽ����� �� Ʈ������ ���(������ Ʈ������, ������ Ʈ������)�� �ش��ϴ� ��� ��쿡 ���� �ۼ� �ʿ�
	** ��, infeasible ��쿡 ���ؼ��� ������� ����
	*/
	
	@Test
	public void testEmptyToSizState() {
		StringStack stack = new StringStack();
		stack.push("str");
		assertEquals("str", stack.pop());
		assertEquals(0, stack.getSize());
	}
}	
