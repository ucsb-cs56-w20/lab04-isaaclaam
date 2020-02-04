package edu.ucsb.cs56.ratcalc.model;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;  
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1; 
    
    @Before public void setUp() {
	r_5_15 = new Rational(5,15);
	r_24_6 = new Rational(24,6);
	r_3_7  = new Rational(3,7);
	r_13_4 = new Rational(13,4);
	r_20_25 = new Rational(20,25);
	r_0_1 = new Rational(0,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
	Rational r = new Rational(1,0);
    }
    
    @Test
    public void test_getNumerator_20_25() {
	assertEquals(4, r_20_25.getNumerator());
    }
    
    @Test
    public void test_getNumerator_13_4() {
	assertEquals(13, r_13_4.getNumerator());
    }
    
    @Test
    public void test_getDenominator_20_25() {
	assertEquals(5, r_20_25.getDenominator());
    }
    
    @Test
    public void test_getDenominator_13_4() {
	assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_toString_5_15() {
	assertEquals("1/3",r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
	assertEquals("4",r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
	assertEquals("3/7",r_3_7.toString());
    }
    
    @Test
    public void test_toString_20_25() {
	assertEquals("4/5",r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
	assertEquals("0",r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
	assertEquals(5, Rational.gcd(5,15));
    }

    @Test
    public void test_gcd_15_5() {
	assertEquals(5, Rational.gcd(15,5));
    }

    @Test
    public void test_gcd_24_6() {
	assertEquals(6, Rational.gcd(24,6));
    }

    @Test
    public void test_gcd_17_5() {
	assertEquals(1, Rational.gcd(17,5));
    }
    
    @Test
    public void test_gcd_1_1() {
	assertEquals(1, Rational.gcd(1,1));
    }

    @Test
    public void test_gcd_20_25() {
	assertEquals(5, Rational.gcd(20,25));
    }

    @Test
    public void test_lcm_5_25() {
	assertEquals(25, Rational.lcm(5,25));
    }

    @Test
    public void test_lcm_n5_n25() {
	assertEquals(25, Rational.lcm(-5,-25));
    }

    @Test
    public void test_lcm_5_n25() {
	assertEquals(25, Rational.lcm(5,-25));
    }
    @Test
    public void test_lcm_0_25() {
	assertEquals(0, Rational.lcm(0,25));
    }

    @Test
    public void test_rational_m10_m5() {
	Rational r = new Rational(-10,-5);
	assertEquals("2",r.toString());
    }

    @Test
    public void test_rational_m5_6() {
	Rational r = new Rational(-5,6);
	assertEquals("-5/6",r.toString());
    }

    @Test
    public void test_rational_7_m8() {
	Rational r = new Rational(7,-8);
	assertEquals("-7/8",r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
	Rational r = r_5_15.times(r_3_7);
	assertEquals("1/7",r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
	Rational r = r_3_7.times(r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = r_m3_1.times(r_1_m3);
	assertEquals("1",r.toString());
    }

   @Test
    public void test_product_of_r_5_15_and_r_3_7() {
       Rational r = Rational.product(r_5_15,r_3_7);
       assertEquals("1/7",r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
	Rational r = Rational.product(r_3_7,r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = Rational.product(r_m3_1,r_1_m3);
	assertEquals("1",r.toString());
    }
 
    @Test
    public void test_r_5_15_plus_r_3_7() {
	Rational r = r_5_15.plus(r_3_7);
	assertEquals("16/21",r.toString());
    }

    @Test
    public void test_r_3_7_plus_r_13_4() {
	Rational r = r_3_7.plus(r_13_4);
	assertEquals("103/28",r.toString());
    }

    @Test
    public void test_r_0_1_plus_r_13_4() {
	Rational r = r_0_1.plus(r_13_4);
	assertEquals("13/4",r.toString());
    }

    @Test
    public void test_sum_of_r_m3_1_and_m1_3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(-1,3);
	Rational r = Rational.sum(r_m3_1,r_1_m3);
	assertEquals("-10/3",r.toString());
    }

    @Test
    public void test_sum_of_r_1_3_and_0_1() {
	Rational r_1_3 = new Rational(1,3);
	Rational r_0_1 = new Rational(0,1);
	Rational r = Rational.sum(r_1_3,r_0_1);
	assertEquals("1/3",r.toString());
    }

    @Test
    public void test_sum_of_r_1_3_and_1_3() {
	Rational r_1_3 = new Rational(1,3);
	Rational r_1_3_ = new Rational(1,3);
	Rational r = Rational.sum(r_1_3,r_1_3_);
	assertEquals("2/3",r.toString());
    }

    @Test
    public void test_r_5_15_minus_r_3_7() {
	Rational r = r_5_15.minus(r_3_7);
	assertEquals("-2/21",r.toString());
    }

    @Test
    public void test_r_13_4_minus_r_3_7() {
	Rational r = r_13_4.minus(r_3_7);
	assertEquals("79/28",r.toString());
    }

    @Test
    public void test_r_0_1_minus_r_13_4() {
	Rational r = r_0_1.minus(r_13_4);
	assertEquals("-13/4",r.toString());
    }


    @Test
    public void test_difference_of_r_m3_1_and_m1_3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(-1,3);
	Rational r = Rational.difference(r_m3_1,r_1_m3);
	assertEquals("-8/3",r.toString());
    }

    @Test
    public void test_difference_of_r_1_3_and_0_1() {
	Rational r_1_3 = new Rational(1,3);
	Rational r_0_1 = new Rational(0,1);
	Rational r = Rational.difference(r_1_3,r_0_1);
	assertEquals("1/3",r.toString());
    }

    @Test
    public void test_difference_of_r_1_3_and_1_3() {
	Rational r_1_3 = new Rational(1,3);
	Rational r_1_3_ = new Rational(1,3);
	Rational r = Rational.difference(r_1_3,r_1_3_);
	assertEquals("0",r.toString());
    }

    @Test
    public void test_reciprocalOf_r_1_3(){
        Rational r_1_3 = new Rational(1,3);
        assertEquals("3",r_1_3.reciprocalOf().toString());
    }
    @Test
    public void test_reciprocalOf_r_n1_3(){
        Rational r_n1_3 = new Rational(-1,3);
        assertEquals("-3",r_n1_3.reciprocalOf().toString());
    }

    @Test(expected = ArithmeticException.class)
    public void test_reciprocalOf_r_0_3(){
        Rational r_0_3 = new Rational(0,3);
        Rational r = r_0_3.reciprocalOf();
    }

    
    @Test
    public void test_r_5_15_dividedBy_r_3_7() {
	Rational r = r_5_15.dividedBy(r_3_7);
	assertEquals("7/9",r.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void test_r_3_7_dividedBy_r_0_1() {
	Rational r = r_3_7.dividedBy(r_0_1);
    }

    @Test
    public void test_r_m3_1_dividedBy_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_3_m1 = new Rational(3,-1);
	Rational r = r_m3_1.dividedBy(r_3_m1);
	assertEquals("1",r.toString());
    }

    @Test
    public void test_quotient_of_r_m3_1_and_m1_3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(-1,3);
	Rational r = Rational.quotient(r_m3_1,r_1_m3);
	assertEquals("9",r.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void test_quotient_of_r_1_3_and_0_1() {
	Rational r_1_3 = new Rational(1,3);
	Rational r_0_1 = new Rational(0,1);
	Rational r = Rational.quotient(r_1_3,r_0_1);
    }

    @Test
    public void test_quotient_of_r_0_1_and_1_3() {
	Rational r_1_3 = new Rational(1,3);
	Rational r_0_1 = new Rational(0,1);
    Rational r = Rational.quotient(r_0_1,r_1_3);
    assertEquals("0",r.toString());
    }

    @Test
    public void test_quotient_of_r_1_3_and_1_3() {
	Rational r_1_3 = new Rational(1,3);
	Rational r_1_3_ = new Rational(1,3);
	Rational r = Rational.quotient(r_1_3,r_1_3_);
	assertEquals("1",r.toString());
    }
    @Test
    public void test_checkNegative_n_p(){
        Rational r_1_n2 = new Rational(1,-2);
        Rational new_r = r_1_n2.checkNegative();
        assertEquals("-1/2",new_r.toString()); 
    }


}