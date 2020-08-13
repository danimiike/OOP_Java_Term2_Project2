/**
	 * Interface Name:	D_M_LoanPayable
	 * Purpose:			olds a constant value called ANNUAL_RATE_TO_MONTHLY_RATE and an abstract method calculateLoanPayment() to be implemented
	 * Coder:			Danielle Miike
	 * Date:			Apr 2, 2020
*/
public interface D_M_LoanPayable {
	
	double ANNUAL_RATE_TO_MONTHLY_RATE = 1.0/1200.0;

	
	/*
	* Method Name:	calculateLoanPayment
	* Purpose: 		will return a double value that represents the loan payment amount
	* Accepts:		a double for OSL or CSL principal amount, a double for prime interest rate and an int that represents the period of months amortization
	* Returns:		double
	*/

	public abstract double calculateLoanPayment(double principalAmount, double annualPrimeIntRate, int monthsAmort);
	
}
