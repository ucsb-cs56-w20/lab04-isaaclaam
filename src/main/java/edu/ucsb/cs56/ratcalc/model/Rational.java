package edu.ucsb.cs56.ratcalc.model;
/** A class to represent a rational number
    with a numerator and denominator

    @author P. Conrad for CS56 F16

*/

public class Rational {

    private int num;
    private int denom;

    /** 
	greatest common divisor of a and b
	@param a first number
	@param b second number
	@return gcd of a and b
    */
    public static int gcd(final int a, final int b) {
	if (a == 0)
	    return b;
	else if (b == 0)
	    return a;
	else
	    return gcd(b % a, a);
    }

    /** 
	least common multiple of a and b
	@param a first number
	@param b second number
	@return lcm of a and b
    */
    public static int lcm(final int a, final int b) {
	int atimesb = a * b;
	atimesb = java.lang.Math.abs(atimesb);
	return atimesb / java.lang.Math.abs(gcd(a, b));
    }

    public Rational() {
	this.num = 1;
	this.denom = 1;
    }

    public Rational(final int num, final int denom) {
	if (denom == 0) {
	    throw new IllegalArgumentException("denominator may not be zero");
	}
	this.num = num;
	this.denom = denom;
	if (num != 0) {
	    final int gcd = Rational.gcd(num, denom);
	    this.num /= gcd;
	    this.denom /= gcd;
	}
    }

    public String toString() {
	if (denom == 1 || num == 0)
	    return "" + num;
	return num + "/" + denom;
    }

    public int getNumerator() {
	return this.num;
    }

    public int getDenominator() {
	return this.denom;
    }

    public Rational times(final Rational r) {
	return new Rational(this.num * r.num, this.denom * r.denom);
    }
    
    /** 
	Flips sign of numerator and denominator if denominator is negative and numerator is positive
	@return fraction in correct format
    */
    public Rational checkNegative() {
	if (this.denom < 0 && this.num > 0) {
	    this.num *= -1;
	    this.denom = java.lang.Math.abs(this.denom);
	    return this;
	} else {
	    return this;
	}

    }

    public static Rational product(final Rational a, final Rational b) {
	return new Rational(a.num * b.num, a.denom * b.denom);
    }

    /** 
	adds this rational object with another object of rational type
	@param r rational object to add
	@return returns the sum of the rational number r and instance member variable of type Rational
    */
    public Rational plus(final Rational r) {
	return new Rational(this.num * r.denom + r.num * this.denom, this.denom * r.denom).checkNegative();
    }
    
    /** 
	adds two rational objects
	@param a rational object
	@param b rational object
	@return returns the sum of the rational number r and instance member variable of type Rational
    */
    public static Rational sum(final Rational a, final Rational b) {
	Rational sum = new Rational(a.num * b.denom + b.num * a.denom, a.denom * b.denom);
	return sum.checkNegative();
		
    }

    /** 
	subtracts an object of rational type from this rational object
	@param r rational object to subtract
	@return returns the difference of the rational number r and instance member variable of type Rational
    */
    public Rational minus(final Rational r) {
	final Rational r_n1_1 = new Rational(-1, 1);
	final Rational nr = r.times(r_n1_1);
	return this.plus(nr).checkNegative();
    }

    /** 
	subtracts two rational objects
	@param a rational object
	@param b rational object
	@return returns the difference of the rational number r and instance member variable of type Rational
    */
    public static Rational difference(final Rational a, final Rational b) {
	final Rational r_n1_1 = new Rational(-1, 1);
	final Rational nb = b.times(r_n1_1);
	final Rational sum = Rational.sum(a, nb);
	return sum.checkNegative();
    }

    /** 
	Flips the numerator and denominator of this object
	@return returns a new object of rational type that contains the reciprocal of the original object
    */
    public Rational reciprocalOf() {
	if (num == 0) {
	    throw new ArithmeticException("denominator may not be zero");
	}
	else{
	    return new Rational(this.denom, this.num).checkNegative();
	}
    }

    /** 
        divides an object of rational type from this rational object
	@param r rational object to divide by
	@return returns the quotient of the rational number r and this Rational object
    */
    public Rational dividedBy(final Rational r) {
	final Rational recip_of_r = r.reciprocalOf();
	return this.times(recip_of_r).checkNegative();

    }

    /** 
	quotient of two rational objects
	@param a rational object (dividend)
	@param b rational object (divisor)
	@return returns the quotient of the rational number r and instance member variable of type Rational
    */
    public static Rational quotient(final Rational a, final Rational b) {
	final Rational recip_of_b = b.reciprocalOf();
	final Rational quotient = Rational.product(a, recip_of_b);
	return quotient.checkNegative();
    }

    /**
     * For testing getters.
     * 
     * @param args unused
     */

    public static void main(final String[] args) {
	final Rational r = new Rational(5, 7);
	System.out.println("r.getNumerator()=" + r.getNumerator());
	System.out.println("r.getDenominator()=" + r.getDenominator());
    }

    
}