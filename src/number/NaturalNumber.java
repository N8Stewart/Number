package number;

import java.util.ArrayDeque;
import java.util.Deque;

import number.exception.DigitException;
import number.exception.NaturalNumberException;

/**
 * 
 */
public class NaturalNumber implements Number{

	/**
	 * @version 0.0.2
	 * @date_created 01/26/15
	 * @date_modified 04/06/15
	 * @author N8Stewart
	 */
	private static final long serialVersionUID = -9049749184547170563L;
	
	/**
	 * Used to calculate the hashcode.
	 */
	private static final int NUM_BINS = 1337;
	
	/** 
	 * Use a stack to represent the digits where the farthest digit on the stack is of the highest order.
	 */
	private Deque<Digit> digits;
	
	/**
	 * Create a blank Natural Number
	 */
	public NaturalNumber(){
		
		this.digits = new ArrayDeque<Digit>();
		
	}
	
	/**
	 * Copy a NaturalNumber from number into this.
	 * @param number the number to be copied from.
	 */
	public NaturalNumber(NaturalNumber number){
		
		this();
		
		/* Loop through all digits in number and create a new Digit for this */
		for(Digit d : number.digits)
		{
			this.digits.add(new Digit(d));
		}
		
	}
	
	/**
	 * Parse a string and generate a NaturalNumber from the digits.
	 * @param number String representation of the number to be stored in this.
	 * @throws DigitException If one of the digits in number is non-numeric.
	 * @throws NaturalNumberException if number is not a valid representation of a NaturalNumber.
	 */
	public NaturalNumber(String number) throws DigitException, NaturalNumberException{
		
		this();
		
		int i = 0;
		
		/* Filter all leading 0's off of number */
		while(number.charAt(i) == '0'){
			i++;
		}
		
		/* Attempt to construct the NaturalNumber based on the string representation number */
		for(; i < number.length(); i++){
			this.digits.push(new Digit(number.charAt(i)));
		}
		
	}

	@Override
	public String toString(){
		
		StringBuilder number = new StringBuilder();
		
		/* Construct a string representation of the number */
		for(Digit d : this.digits)
		{
			number.append(d);
		}
		
		return number.toString();
	
	}
	
	@Override
	public boolean equals(Object obj){
		
		if (this == obj) // obj is this
			return true;
		if (obj == null) // obj is Null
			return false;
		if (!(obj instanceof Number)) // obj does not implement Number
			return false;
		
		// Compare this object to obj since we know it is a number object that is not this.
		// compareTo will return 0 if the objects are equal to each other.
		return (this.compareTo((Number) obj) == 0);
	}
	
	@Override
	public int hashCode(){
		
		int bin = 0;
		
		// For each digit, add it onto the bin until it overflows the bins. 
		// At that point, reset the count
		for(Digit d : this.digits)
		{
			bin = (bin + Character.digit(d.getDigit(), 10) * 10) % NUM_BINS;
		}
		
		return bin;
	}

	@Override
	public int compareTo(Number number) {
		
		NaturalNumber nat_num;
		int return_val = 0;
		
		if (this == number) // ensure number is not this
			return 0;
		if (number == null) // ensure number is not null 
			return -1;
		if(!(number instanceof NaturalNumber)) // number is not a natural number, so compare this to number
			return number.compareTo(this) * -1; // reverse which number is larger

		// Both numbers are natural numbers, so check which one is larger
		nat_num = (NaturalNumber) number;
		
		if(this.digits.size() > nat_num.digits.size()) // this has more digits, so it is larger
			return 1;
		else if(nat_num.digits.size() > this.digits.size()) // number has more digits, so it is larger
			return -1;
		else{ // they both have the same number of digits, so compare digit by digit
			for( int i = 0; i < this.digits.size(); i++){
				
				// Grab the digits at the front of the queue
				Digit nat_digit = nat_num.digits.poll(), this_digit = this.digits.poll();
				if(return_val == 0){ // make sure the value has not been calculated already
					return_val = this_digit.compareTo(nat_digit);
				}
				
				// Add the digits onto the end oft he queue
				nat_num.digits.addLast(nat_digit);
				this.digits.addLast(this_digit);
				
			}
		}
		return 0;
	}

}
