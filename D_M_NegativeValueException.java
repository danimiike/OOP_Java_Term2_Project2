/**
 * Program Name: 	D_M_NegativeValueException
 * Purpose: 		an exception that will be thrown if the user tries to enter negative values
 * Coder: 			Danielle Miike
 * Date: 			Apr 2, 2020
 */

public class D_M_NegativeValueException extends Exception{

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    D_M_NegativeValueException() {
		super("The number entered was negative, it will be converted to positive");
	}
	
}


