import static org.junit.Assert.*;

import org.junit.Test;


public class PublicTests {

	@Test
	public void testBasicConstructorsAndGetters() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble d = new MyDouble(555.729);
		
		ComplexNumber x = new ComplexNumber(a, b);
		assertTrue(x.getReal().compareTo(a) == 0 && x.getImag().compareTo(b) == 0);
		
		ComplexNumber z = new ComplexNumber(d);
		assertTrue(z.getReal().compareTo(d) == 0 && z.getImag().compareTo(new MyDouble(0)) == 0);
	}
	
	@Test
	public void testCopyConstructor() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(x);
		assertTrue(x != y);     // Check to be sure they are not aliased!
		assertTrue(y.getReal().compareTo(a) == 0 && y.getImag().compareTo(b) == 0);
	}
	
	@Test
	public void testAdd() {
		MyDouble a = new MyDouble(6.0), b = new MyDouble(-5.7);
		MyDouble c = new MyDouble(-7.0), d = new MyDouble(8.0);
	
		ComplexNumber com = new ComplexNumber(a,b); //6-5.7i
		ComplexNumber com1 = new ComplexNumber(c,d); //-7+8i 
		ComplexNumber com2 = new ComplexNumber(b,c); //-5.7-7i 
		ComplexNumber com3 = new ComplexNumber(a,d); // 6+8i

		ComplexNumber com4 = com.add(com1); //-1+2.3i
		ComplexNumber com5 = com.add(com2); //0.3-12.7i 
		ComplexNumber com6 = com.add(com3); //12+2.3i 
		ComplexNumber com7 = com1.add(com2); //-12.7+i 
		ComplexNumber com8 = com1.add(com3); //-1+16i 
		ComplexNumber com9 = com2.add(com3); //0.3+i 
		
		ComplexNumber checkcom4 = new ComplexNumber(new MyDouble(-1), new MyDouble(2.3));
		assertTrue(com4.compareTo(checkcom4) == 0);
		
		ComplexNumber checkcom5 = new ComplexNumber(new MyDouble(0.3), new MyDouble(-12.7));
		assertTrue(com5.compareTo(checkcom5) == 0);
		
		ComplexNumber checkcom6 = new ComplexNumber(new MyDouble(12.0), new MyDouble(2.3));
		assertTrue(com6.compareTo(checkcom6) == 0);
		
		ComplexNumber checkcom7 = new ComplexNumber(new MyDouble(-12.7), new MyDouble(1.0));
		assertTrue(com7.compareTo(checkcom7) == 0);
		
		ComplexNumber checkcom8 = new ComplexNumber(new MyDouble(-1), new MyDouble(16.0));
		assertTrue(com8.compareTo(checkcom8) == 0);
		
		ComplexNumber checkcom9 = new ComplexNumber(new MyDouble(0.3), new MyDouble(1.0));
		assertTrue(com9.compareTo(checkcom9) == 0);	
	}
	
	@Test
	public void testSubtract() {
		MyDouble a = new MyDouble(-1.0), b = new MyDouble(5.0);
		MyDouble c = new MyDouble(-4.0), d = new MyDouble(7.0);
		
		ComplexNumber com = new ComplexNumber(a,b); //-1+5i
		ComplexNumber com1 = new ComplexNumber(a,c); //-1-4i
		ComplexNumber com2 = new ComplexNumber(b,c); // 5-4i
		ComplexNumber com3 = new ComplexNumber(b,d); // 5+7i
		
		ComplexNumber com4 = com.subtract(com1); //0+9i
		ComplexNumber com5 = com.subtract(com2); //-6+9i
		ComplexNumber com6 = com.subtract(com3); //-6-2i
		ComplexNumber com7 = com1.subtract(com2); //-6+0i
		ComplexNumber com8 = com1.subtract(com3); //-6-11i
		ComplexNumber com9 = com2.subtract(com3); //0-11i
		
		ComplexNumber checkcom4 = new ComplexNumber(new MyDouble(0), new MyDouble(9.0));
		assertTrue(com4.compareTo(checkcom4) == 0);
		
		ComplexNumber checkcom5 = new ComplexNumber(new MyDouble(-6.0), new MyDouble(9.0));
		assertTrue(com5.compareTo(checkcom5) == 0);
		
		ComplexNumber checkcom6 = new ComplexNumber(new MyDouble(-6.0), new MyDouble(-2.0));
		assertTrue(com6.compareTo(checkcom6) == 0);
		
		ComplexNumber checkcom7 = new ComplexNumber(new MyDouble(-6.0), new MyDouble(0.0));
		assertTrue(com7.compareTo(checkcom7) == 0);
		
		ComplexNumber checkcom8 = new ComplexNumber(new MyDouble(-6), new MyDouble(-11.0));
		assertTrue(com8.compareTo(checkcom8) == 0);
		
		ComplexNumber checkcom9 = new ComplexNumber(new MyDouble(0.0), new MyDouble(-11.0));
		assertTrue(com9.compareTo(checkcom9) == 0);	
	}
	
	@Test
	public void testMult() {
		MyDouble a = new MyDouble(-1.0), b = new MyDouble(-1.0);
		MyDouble c = new MyDouble(-3.0), d = new MyDouble(-6.0);
		MyDouble e = new MyDouble(5.0), f = new MyDouble(8.0);
		
		ComplexNumber com = new ComplexNumber(a,b);
		ComplexNumber com1 = new ComplexNumber(c,d);
		ComplexNumber com2 = new ComplexNumber(e,f);
		ComplexNumber com3 = new ComplexNumber(a,c);
		ComplexNumber com4 = new ComplexNumber(b,d);
		
		ComplexNumber com5 = com.multiply(com1); //-1-1i and -3-6i = -3 + 9i
		ComplexNumber com6 = com2.multiply(com3); //5+8i and -1-3i = 29 -23i
		ComplexNumber com7 = com3.multiply(com4); //-1-3i and -1-6i = -17+9i
		
		assertTrue(com5.compareTo(new ComplexNumber(new MyDouble(-3.0), new MyDouble(9.0))) == 0);
		assertTrue(com6.compareTo(new ComplexNumber(new MyDouble(19.0), new MyDouble(-23.0))) == 0);
		assertTrue(com7.compareTo(new ComplexNumber(new MyDouble(-17.0), new MyDouble(9.0))) == 0);
	}
	
	@Test
	public void testDiv() {
		MyDouble a = new MyDouble(4.5), b = new MyDouble(3.5);
		MyDouble c = new MyDouble(3.2), d = new MyDouble(1.7);
	
		MyDouble e = new MyDouble(20.35/13.13), f = new MyDouble(3.55/13.13); 
		
		ComplexNumber compare = new ComplexNumber(e, f);
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(c, d);
		x = x.divide(y); 
		assertTrue(x.compareTo(compare) == 0); 
	}
	
	@Test
	public void testEqComp() {
		MyDouble a = new MyDouble(-3.0), b = new MyDouble(-6.0);
		MyDouble c = new MyDouble(5.0), d = new MyDouble(8.0);
		
		ComplexNumber com = new ComplexNumber(a,b);
		ComplexNumber com1 = new ComplexNumber(a,b);
		ComplexNumber com2 = new ComplexNumber(c,d);
		ComplexNumber com3 = new ComplexNumber(c,d);
		ComplexNumber com4 = new ComplexNumber(a,c);
		ComplexNumber com5 = new ComplexNumber(a,c);
		ComplexNumber com6 = new ComplexNumber(a,d);
		ComplexNumber com7 = new ComplexNumber(a,d);
		ComplexNumber com8 = new ComplexNumber(b,d);
		ComplexNumber com9 = new ComplexNumber(b,d);
		
		assertTrue(com.compareTo(com1) == 0);
		assertTrue(com2.compareTo(com3) == 0);
		assertTrue(com4.compareTo(com5) == 0);
		assertTrue(com6.compareTo(com7) == 0);
		assertTrue(com8.compareTo(com9) == 0);
	}
	
	@Test
	public void testNorm() {
		MyDouble a = new MyDouble(3.0), b = new MyDouble(-4.0);
		MyDouble c = new MyDouble(-12.0), d = new MyDouble(5.0);
		
		ComplexNumber com = new ComplexNumber(a,b);
		ComplexNumber com1 = new ComplexNumber(c,d);
		ComplexNumber com2 = new ComplexNumber(a,d);
		ComplexNumber com3 = new ComplexNumber(b,c);
		
		MyDouble e = ComplexNumber.norm(com);
		ComplexNumber comE = new ComplexNumber(e);
		
		MyDouble f = ComplexNumber.norm(com1);
		ComplexNumber comF = new ComplexNumber(f);
		
		MyDouble g = ComplexNumber.norm(com2);
		ComplexNumber comG = new ComplexNumber(g);
		
		MyDouble h = ComplexNumber.norm(com3);
		ComplexNumber comH = new ComplexNumber(h);
		
		assertTrue(com.compareTo(comE) == 0);
		assertTrue(com1.compareTo(comF) == 0);
		assertTrue(com2.compareTo(comG) == 0);
		assertTrue(com3.compareTo(comH) == 0);
	}
	
	@Test 
	public void testParse() {
		String mystring = "4+ 5i";
		ComplexNumber complex = ComplexNumber.parseComplexNumber(mystring);
		ComplexNumber complex1 = new ComplexNumber(new MyDouble(4.0), new MyDouble(5.0));
		assertTrue(complex.compareTo(complex1) == 0);
		
		String mystring1 = "  -4  +   5i";
		ComplexNumber complex2 = ComplexNumber.parseComplexNumber(mystring1);
		ComplexNumber complex3 = new ComplexNumber(new MyDouble(-4.0), new MyDouble(5.0));
		assertTrue(complex2.compareTo(complex3) == 0);
		
		String mystring2 = " 4 - 5i";
		ComplexNumber complex4 = ComplexNumber.parseComplexNumber(mystring2);
		ComplexNumber complex5 = new ComplexNumber(new MyDouble(4.0), new MyDouble(-5.0));
		assertTrue(complex4.compareTo(complex5) == 0);
		
		String mystring3 = "-4 -5i";
		ComplexNumber complex6 = ComplexNumber.parseComplexNumber(mystring3);
		ComplexNumber complex7 = new ComplexNumber(new MyDouble(-4.0), new MyDouble(-5.0));
		assertTrue(complex6.compareTo(complex7) == 0);
		
		String mystring4 = "    -4-5i  ";
		ComplexNumber complex8 = ComplexNumber.parseComplexNumber(mystring4);
		ComplexNumber complex9 = new ComplexNumber(new MyDouble(-4.0), new MyDouble(-5.0));
		assertTrue(complex8.compareTo(complex9) == 0);
	}
}
