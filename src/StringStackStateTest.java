import static org.junit.Assert.*;
import org.junit.Test;


public class StringStackStateTest {
	
	// state coverage - zero state, size state, max state
	/*
	** 스테이트 커버리지는 달성하기 쉬우나 효과적이지 못하다.
	** (결함 잘 찾아내지 못한다.)
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
	/* 일부 테스트 케이스에서 for 문을 사용하여 각 경우를 모두 테스트하였지만 굳이 그렇게 할 필요는 없음
	** AAA 법칙 만족을 위해서는 assertion 한 번만 나오는 것이 적합
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
	** 편의상 예시 하나만 작성하였으나 각 트랜지션 페어(들어오는 트랜지션, 나가는 트랜지션)에 해당하는 모든 경우에 대한 작성 필요
	** 단, infeasible 경우에 대해서는 고려하지 않음
	*/
	
	@Test
	public void testEmptyToSizState() {
		StringStack stack = new StringStack();
		stack.push("str");
		assertEquals("str", stack.pop());
		assertEquals(0, stack.getSize());
	}
}	
