package character_stack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.EmptyStackException;

public class CharacterStackTest {

	@Test
	public void testConstructor() {
		CharacterStack stack = new CharacterStack();
		assertEquals(0, stack.getSize());
	}

	@Test
	public void testNullConstructor() {
		CharacterStack stack = new CharacterStack(null);
		assertEquals(0, stack.getSize());
	}

	@Test
	public void testEmptyStringConstructor() {
		CharacterStack stack = new CharacterStack("");
		assertEquals(0, stack.getSize());
	}

	@Test
	public void testCharacterConstructor() {
		CharacterStack stack = new CharacterStack('a');
		assertEquals(1, stack.getSize());
		assertEquals('a', stack.pop());
		assertEquals(0, stack.getSize());
	}

	@Test
	public void testStringConstructor() {
		CharacterStack stack = new CharacterStack("abc");
		assertEquals(3, stack.getSize());
	}

	@Test(expected = StackOverflowError.class)
	public void testLongStringConstructor() {
		CharacterStack stack = new CharacterStack("012345678901234567891");
	}
	
	@Test
	public void testPop() {
		CharacterStack stack = new CharacterStack("aaaaa");
		assertEquals('a', stack.pop());
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPopEmpty() {
		CharacterStack stack = new CharacterStack();
		stack.pop();
	}

	@Test
	public void testCharacterPush() {
		CharacterStack stack = new CharacterStack();
		stack.push('w');
		assertEquals(1, stack.getSize());
	}

	@Test
	public void testStringPush() {
		CharacterStack stack = new CharacterStack();
		stack.push("world");
		assertEquals(5, stack.getSize());
	}

	@Test(expected = StackOverflowError.class)
	public void testLongStringPush() {
		CharacterStack stack = new CharacterStack();
		stack.push("012345678901234567890");
	}

	@Test
	public void testNullPush() {
		CharacterStack stack = new CharacterStack();
		stack.push(null);
		assertEquals(0, stack.getSize());
	}

	@Test
	public void testEmptyStringPush() {
		CharacterStack stack = new CharacterStack();
		stack.push("");
		assertEquals(0, stack.getSize());
	}

	@Test(expected = StackOverflowError.class)
	public void testMaxSizePush() {
		CharacterStack stack = new CharacterStack();
		stack.push("01234567890123456789");
		stack.push('e');
	}

	// AAA 법칙 준수
	@Test(expected = StackOverflowError.class)
	public void testSomething() {
		// arrange
		CharacterStack stack = new CharacterStack();
		// action
		stack.push("0123456789012345");
		stack.push("6789012345");
		// assertion
		assertEquals('5', stack.pop());
	}
	/*
	* push(String) 함수에서 최대 스택 길이를 체크하지 않는 오류가 있다.
	* */
}
