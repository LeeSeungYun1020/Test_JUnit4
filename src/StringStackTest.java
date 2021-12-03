import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringStackTest {

    @Test
    public void testBasicConstructor() {
        StringStack stack = new StringStack();
        assertEquals(0, stack.getSize());
    }

    @Test
    public void testCharConstructor() {
        StringStack stack = new StringStack('c');
        assertEquals(1, stack.getSize());
    }

    @Test
    public void testStringConstructor() {
        StringStack stack1 = new StringStack("ccc");
        StringStack stack2 = new StringStack(null);
        assertEquals(1, stack1.getSize());
        assertEquals(0, stack2.getSize());
    }

    @Test
    public void testPushChar() {
        StringStack stack = new StringStack();
        stack.push('c');
        assertEquals(1, stack.getSize());
    }

    @Test(expected = StackOverflowError.class)
    public void testPushCharMax() {
        StringStack stack = new StringStack();
        for( int i = 0 ; i < 21 ; i++) {
            stack.push('c');
        }
    }

    @Test
    public void testPushString() {
        StringStack stack = new StringStack();
        stack.push("ccc");
        assertEquals(1, stack.getSize());
    }

    @Test(expected = StackOverflowError.class)
    public void testPushStringMax() {
        StringStack stack = new StringStack();
        for( int i = 0 ; i < 21 ; i++) {
            stack.push("c");
        }
    }

    @Test
    public void testPushStringNull() {
        StringStack stack = new StringStack("str1");
        stack.push(null);
        assertEquals(1, stack.getSize());
    }

    @Test
    public void testPop() {
        StringStack stack = new StringStack("str1");
        assertEquals("str1", stack.pop());
        assertEquals(0, stack.getSize());
    }

    @Test
    public void testEmptyPop() {
        StringStack stack = new StringStack();
        assertEquals("", stack.pop());
        assertEquals(0, stack.getSize());
    }

    @Test
    public void testMaxPop() {// 20인 경우 처리 안됨
        StringStack stack = new StringStack();
        for( int i = 0 ; i < 20 ; i++) {
            stack.push("c");
        }
        assertEquals("c", stack.pop());
    }

    @Test
    public void testMaxSize() {
        StringStack stack = new StringStack("str1");
        assertEquals(20, stack.getMaxSize());
    }

    @Test
    public void testIsEmptyTrue() {
        StringStack stack = new StringStack();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        StringStack stack = new StringStack("str1");
        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void testIsFullTrue() {
        StringStack stack = new StringStack();
        assertEquals(false, stack.isFull());
    }

    @Test
    public void testIsFullFalse() {
        StringStack stack = new StringStack();
        for( int i = 0 ; i < 20 ; i++) {
            stack.push("c");
        }
        assertEquals(true, stack.isEmpty());
    }


}
