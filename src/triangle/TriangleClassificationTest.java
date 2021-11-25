package triangle;
/*
 *	isosceles triangle, 1 // ÀÌµîº¯»ï°¢Çü
 *	equilateral triangle, 2 // Á¤»ï°¢Çü
 *	right triangle, 3 // Á÷°¢»ï°¢Çü
 *	triangle, 4 // ÀÌ¿Ü »ï°¢Çü
 *	invalid, 0 // »ï°¢Çü ¾Æ´Ô
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TriangleClassificationTest {
	
	public TriangleClassification classifier;
	
	@Before
	public void setUp() {
		classifier = new TriangleClassification();
	}

	@Test
	public void testIsoscelesTriangle() {
		assertEquals(1, classifier.triangle(2, 2, 1));
		assertEquals(1, classifier.triangle(2, 1, 2));
		assertEquals(1, classifier.triangle(1, 2, 2));
	}
	
	@Test
	public void testNotTriangle() {
		assertEquals(0, classifier.triangle(1, 2, 3));
		assertEquals(0, classifier.triangle(1, 3, 1));
		assertEquals(0, classifier.triangle(3, 2, 1));
	}
	
	@Test
	public void testEquilateralTriangle() {
		assertEquals(2, classifier.triangle(4, 4, 4));
	}
	
	@Test
	public void testRightTriangle() {
		assertEquals(3, classifier.triangle(3, 4, 5));
		assertEquals(3, classifier.triangle(3, 5, 4));
		assertEquals(3, classifier.triangle(5, 4, 3));
	}
	
	@Test
	public void testTriangle() {
		assertEquals(4, classifier.triangle(2, 4, 5));
	}
	
	@Test
	public void testInvalidTriangle() {
		assertEquals(0, classifier.triangle(-1, 3, 3));
		assertEquals(0, classifier.triangle(3, -1, 3));
		assertEquals(0, classifier.triangle(3, 3, -1));
	}
	
	@After
	public void tearDown() {
		this.classifier = null;
	}

}
