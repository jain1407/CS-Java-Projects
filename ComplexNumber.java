
public class ComplexNumber{
	
	/* STUDENTS:  You may NOT add any further instance or static variables! */
	private final MyDouble real;   // To be initialized in constructors
	private final MyDouble imag;   // To be initialized in constructors
	
	
	/* STUDENTS: Put your methods here, as described in the project description.
	 * 	 * IMPORTANT:  You may NOT call the toString method for the MyDouble class except
	 * while you are writing the toString method for the Complex class.  You may NOT
	 * call the toString method of the Complex class ANYWHERE.  If you don't adhere
	 * to this rule, you will fail some (or possibly all) release tests. */
	
	/* Initializes the complexNumber object 
	 * Precondition: input complexNumber should have a double real and imaginary part
	 * Postcondition: a complexNumber object is formed 
	 * @param MyDouble realNum forms the real part of the complexNumber object  
	 * @param MyDouble imagNum forms the imaginary part of the complexNumber object
	 * @return returns a complexNumber object 
	 */
	public ComplexNumber(MyDouble realNum, MyDouble imagNum){
		this.real = realNum;
		this.imag = imagNum;
	}
	
	/* Initializes the complexNumber object if it only contains a real part 
	 * Precondition: input complexNumber should have a double real part
	 * Postcondition: a complexNumber object is formed 
	 * @param MyDouble realNum forms the real part of the complexNumber object 
	 *        as the imaginary part is set to 0  
	 * @return returns a complexNumber object with a real part and a 0 as the
	 * 		   imaginary part
	 */
	public ComplexNumber(MyDouble realNum){
		this.real = realNum;
		this.imag = new MyDouble(0);
	}
	
	/* Copy constructor which copies an object 
	 * Precondition: input complexNumber should atleast have a double real part 
	 * Postcondition: a copy of complex object is formed 
	 * @param ComplexNumber complex is the object to be copied   
	 * @return returns a copy of the complex object
	 */
	public ComplexNumber(ComplexNumber complex){
		this.real = complex.real;
		this.imag = complex.imag;
	}
	
	/* A getter method which gets the real part of the current object 
	 * Precondition: input complexNumber should have a double real part
	 * Postcondition: the real part of the current complexNumber object is returned
	 * @return returns the real part of the current complexNumber object 
	 */
	public MyDouble getReal(){
		return this.real;
	}
	

	/* A getter method which gets the imaginary part of the current object 
	 * Precondition: input complexNumber should have a double imaginary part but 
	 * 			     if it doesn't then this will simply return 0
	 * Postcondition: the imaginary part of the current complexNumber object is returned
	 * @return returns the imaginary part of the current complexNumber object 
	 */
	public MyDouble getImag(){
		return this.imag;
	}
	

	/* Adds the real and imaginary components of the current complexNumber object and 
	 * the passed complexNumber 
	 * Precondition: input complexNumber should have a double real part and a double 
	 * 				 imaginary part
	 * Postcondition: a complexNumber object is formed which is the sum of the 
	 * 				  current and passed object 
	 * @param ComplexNumber addNum provides the real and imaginary parts which are 
	 * 		  added to the real and imaginary parts of current object 
	 * @return returns a complexNumber object which contains the sum of real parts 
	 * 		   and imaginary parts of current and passed object
	 */
	public ComplexNumber add(ComplexNumber addNum){
		// Adds real part of passed object to real part of current object
		MyDouble realNum = addNum.getReal().add(this.real);
		// Adds imaginary part of passed object to imaginary part of current object
		MyDouble imagNum = addNum.getImag().add(this.imag);
		
		// Constructs a new complex Number 
		ComplexNumber complexnumber = new ComplexNumber(realNum, imagNum);
		return complexnumber;
	}
	
	/* Subtracts the real and imaginary components of the passed complexNumber object from 
	 * the current complexNumber 
	 * Precondition: input complexNumber should have a double real part and a double 
	 * 				 imaginary part
	 * Postcondition: a complexNumber object is formed which is the difference of the 
	 * 				  current and passed object 
	 * @param ComplexNumber addNum provides the real and imaginary parts which are 
	 * 		  subtracted from the real and imaginary parts of current object 
	 * @return returns a complexNumber object which contains the difference of real parts 
	 * 		   and imaginary parts of current and passed object
	 */	
	public ComplexNumber subtract(ComplexNumber subNum){
		// Subtracts real part of passed object from real part of current object
		MyDouble realNum = this.real.subtract(subNum.getReal());
		/* Subtracts imaginary part of passed object from imaginary 
		 * part of current object */
		MyDouble imagNum = this.imag.subtract(subNum.getImag());
		
		// Constructs a new complex Number 
		ComplexNumber complexnumber = new ComplexNumber(realNum, imagNum);
		return complexnumber;
	}
	
	/* Multiplies the real and imaginary components of the current complexNumber object and 
	 * the passed complexNumber 
	 * Precondition: input complexNumber should have a double real part and a double 
	 * 				 imaginary part
	 * Postcondition: a complexNumber object is formed which is the product of the 
	 * 				  current and passed object 
	 * @param ComplexNumber addNum provides the real and imaginary parts which are 
	 * 		  multiplied to the real and imaginary parts of current object 
	 * @return returns a complexNumber object which contains the product of real parts 
	 * 		   and imaginary parts of current and passed object
	 */
	public ComplexNumber multiply(ComplexNumber multNum){
		/* These statements obtain real and imaginary parts of passed and 
		* current objects */
		MyDouble realParam = multNum.getReal();
		MyDouble imagParam = multNum.getImag();
		MyDouble real = this.real;
		MyDouble imag = this.imag;
		MyDouble isquared = new MyDouble(-1);
		
		// Obtains real term of the product 
		MyDouble realTerm = (realParam.multiply(real).add(imagParam.multiply(imag)
							.multiply(isquared)));
		// Obtains imaginary term of the product
		MyDouble imagTerm = (realParam.multiply(imag).add(imagParam.multiply(real)));
		
		// Constructs a new complex Number 
		ComplexNumber complexnumber = new ComplexNumber(realTerm, imagTerm);
		return complexnumber;
	}
	
	/* Divides the real and imaginary components of the current complexNumber object 
	 * by the passed complexNumber 
	 * Precondition: input complexNumber should have a double real part and a double 
	 * 				 imaginary part
	 * Postcondition: a complexNumber object is formed which is the result of 
	 * 				  dividing the current by passed object 
	 * @param ComplexNumber addNum provides the real and imaginary parts which are 
	 * 		  divided from the real and imaginary parts of current object 
	 * @return returns a complexNumber object which contains the divided result 
	 * 		   of real parts and imaginary parts of current and passed object
	 */
	public ComplexNumber divide(ComplexNumber divNum){
		//Retrieves real and imaginary values of passed object
		MyDouble imagParam = divNum.getImag();
		MyDouble realParam = divNum.getReal();
		
		MyDouble negation = new MyDouble(-1); //Creates Double with the value of -1 for i^2
		MyDouble conjImag = imagParam.multiply(negation);
		
		// Constructs complex Number 
		ComplexNumber conjugate = new ComplexNumber(realParam,conjImag);
		
		ComplexNumber newNum = this.multiply(conjugate); 
		ComplexNumber newDen = divNum.multiply(conjugate);
			
		MyDouble numReal = newNum.getReal();
		MyDouble numImag = newNum.getImag();
		MyDouble denReal = newDen.getReal();
			
		//Simplify
		numReal = numReal.divide(denReal);
		numImag = numImag.divide(denReal);
				
		//Constructs Complex Number
		ComplexNumber newComplex = new ComplexNumber(numReal, numImag);
		return newComplex;
	}
	
	/* Checks whether the real and imaginary parts of the passed complexNumber object
	 * are equal to real and imaginary parts of the current object
	 * Precondition: input complexNumber should have a double real part and a double 
	 * 				 imaginary part
	 * Postcondition: the real and imaginary parts of both passed and current object
	 * 				  are checked 
	 * @param ComplexNumber addNum provides the real and imaginary parts which are 
	 * 		  compared to real and imaginary parts of current object 
	 * @return returns true if both real and imaginary parts of both objects are
	 * 		   equal otherwise it returns false
	 */
	public boolean equals(ComplexNumber compareNum){
		// Obtains real part of passed and current object
		MyDouble realNum1 = this.real;
		MyDouble realNum2 = compareNum.getReal();
		
		// Obtains imaginary part of passed and current object
		MyDouble imagNum1 = this.imag;
		MyDouble imagNum2 = compareNum.getImag();
		
		// Checks if both real and imaginary parts of passed and current object are same
		if(realNum1.equals(realNum2) && imagNum1.equals(imagNum2)){
			return true;
		}else{
			return false;
		}
	}
	
	/* Compares the norms of passed object to current object  
	 * Precondition: input complexNumber should have a double real part and a double 
	 * 				 imaginary part
	 * Postcondition: computes the norm of both objects and checks if there are same 
	 * @param ComplexNumber addNum provides the real and imaginary parts which are 
	 * 		  compared to the real and imaginary parts of current object 
	 * @return returns 0 if the norms of both objects are equal, returns -1 if 
	 * 		   the norm of the current object is less that norm of the parameter, 
	 * 		   returns 1 is if the norm of current object is greater than the norm
	 * 		   of the parameter
	 */
	public int compareTo(ComplexNumber comparisonNum){
		/* Checks if passed complexNumber is bigger than current complexNumber by 
		* comparing their normal values	*/
		int value = norm(this).compareTo(norm(comparisonNum));
		
		if(value < 0){
			return -1;
		}else if(value > 0){
			return 1;
		}else{
			return 0;
		}
	}
	
	/* Precondition: input complexNumber should have a double real part and a double 
	 * 				 imaginary part
	 * Postcondition: a complexNumber object is formed which is the sum of the 
	 * 				  current and passed object 
	 * @param ComplexNumber addNum provides the real and imaginary parts which are 
	 * 		  added to the real and imaginary parts of current object 
	 * @return returns a complexNumber object which contains the sum of real parts 
	 * 		   and imaginary parts of current and passed object
	 */
	public String toString(){
		MyDouble realNum = this.real;
		MyDouble imagNum = this.imag;
		
		// Checks if the real and imaginary part of current object are equal to 0
		int value = realNum.compareTo(new MyDouble(0)); 
		int value1 = imagNum.compareTo(new MyDouble(0));
		
		String firstNum = null; 
		
		if(value > 0 && value1 > 0){
			return firstNum = this.real.toString()+"+"+this.imag.toString()+"i";
		}else if(value > 0 && value1 < 0){
			return firstNum = this.real.toString()+this.imag.toString()+"i";
		}else if(value < 0 && value1 > 0){
			return firstNum = this.real.toString()+"+"+this.imag.toString()+"i";
		}else if(value < 0 && value1 < 0){
			return firstNum = this.real.toString()+this.imag.toString()+"i";
		}
		return firstNum;
	}
	
	/* Computes the norm of the parameter 
	 * Precondition: input complexNumber should have a double real part and a double 
	 * 				 imaginary part
	 * Postcondition: computes the norm of parameter 
	 * @param ComplexNumber normal provides the real and imaginary parts from which 
	 * 		  the norm of parameter is calculated 
	 * @return returns the norm of the parameter as a double. 
	 */
	public static MyDouble norm(ComplexNumber normal){
		// Obtains the a^2 and b^2 part
		MyDouble normReal = (normal.getReal().multiply(normal.getReal()));
		MyDouble normImag = (normal.getImag().multiply(normal.getImag()));
		
		// Obtains a^2 + b^2
		MyDouble addNorm = normReal.add(normImag);
		
		// Square roots a^2+b^2
		MyDouble finalNorm = addNorm.sqrt();
		
		return finalNorm;
	}
	
	/* Parses a String into a complexnumber   
	 * Precondition: input String should have a double real part and a double 
	 * 				 imaginary part
	 * Postcondition: parses the string input into a complexnumber 
	 * @param String input provides a string which contains the real and imaginary 
	 * 		  parts that are parsed into a complexnumber 
	 * @return returns a complexNumber which was converted from a string input to 
	 * 		   a complexnumber output
	 */
	public static ComplexNumber parseComplexNumber(String input){
		String complexNumber = input.replaceAll("\\s", ""); // removes white space
		int findI = complexNumber.indexOf("i"); //finds place of i in the input string
		double doubleReal, doubleImag; // Will store the parsed double values
		boolean positive = complexNumber.contains("+"); //checks if complex number has + or -
		
		if (positive == true){
			int plusPlace = complexNumber.indexOf("+");
			
			String realString = complexNumber.substring(0, plusPlace);
			String imagString = complexNumber.substring(plusPlace, findI);
			
			doubleReal = Double.parseDouble(realString);
			doubleImag = Double.parseDouble(imagString);
		}else{
			int minusSign = complexNumber.lastIndexOf("-");
			
			String realString = complexNumber.substring(0, minusSign);
			String imagString = complexNumber.substring(minusSign, findI);
			
			doubleReal = Double.parseDouble(realString);
			doubleImag = Double.parseDouble(imagString);
		}
		
		MyDouble real = new MyDouble(doubleReal);
		MyDouble imag = new MyDouble(doubleImag);
		
		ComplexNumber complexNum = new ComplexNumber(real,imag);
		return complexNum;
	}
}
