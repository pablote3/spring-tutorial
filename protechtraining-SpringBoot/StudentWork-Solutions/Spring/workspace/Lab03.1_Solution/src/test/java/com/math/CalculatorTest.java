/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

  @Test
  public void testAddPositive() {
    System.out.println("testAddPositive");
    Calculator calc = new Calculator();
    assertEquals(5, calc.add(1, 4));  // expected, actual
  }
  
  @Test
  public void testDividePositive() {
    System.out.println("testDividePositive");
    Calculator calc = new Calculator();
    assertEquals(2.5, calc.divide(5, 2), .001);
  }
  
  @Test
  public void testIsEvenPositive() {
    System.out.println("testIsEvenPositive");
    Calculator calc = new Calculator();
    assertTrue(calc.isEven(10));
  }
  
  @Test // Optional negative test
  public void testDivideByZeroNegative() {
	  System.out.println("testDivideByZeroNegative");
	  Calculator calc = new Calculator();
	  double result = calc.divide(0, 0);
	  assertTrue("0/0 should not be a number", result==Double.NaN);
  }


}