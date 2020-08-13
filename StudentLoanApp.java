
/**
	 * Class Name:		StudentLoanApp
	 * Purpose:			Create a gui prototype app that accepts some inputs and shows how modifying their repayment schedules would affect
	 * 					the loan cost in terms of the amount of interest that the student would pay.
	 * Coder:			Danielle Miike
	 * Date:			Apr 2, 2020
*/


import java.awt.*; 
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*; 

public class StudentLoanApp extends JFrame {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    static ArrayList<Student> stdArrList;
	
	 private Font fo = new Font("SansSerif",Font.PLAIN,16),fontTitle;
	 
	 private JLabel title;
	 private JLabel space1, space2, lblStudentID, lblSurname, lblMiddleName, lblFirstName, lblAptNumber,
             lblStreetNumber, lblStreetName, lblCity, lblProvince, lblPostalCode, lblCslLoanAmount, lblOslLoanAmount;
     private JTextField tfStudentID, tfSurname, tfMiddleName, tfFirstName, tfAptNumber, tfStreetNumber, tfStreetName,
             tfCity, tfProvince, tfPostalCode, tfCslLoanAmount, tfOslLoanAmount;
     private JButton inputSubmit;
     private JButton RepayCalcForm;
     private JPanel panelTitle, panel1, panel2;
     private JTextArea studentInform;

     private DecimalFormat df = new DecimalFormat("$###,##0.00");

     // variables
     private int i = 0;

     StudentLoanApp() {
         super("Danielle 0910303");
         this.setSize(800, 700);
         this.setLocationRelativeTo(null);// center it on the screen
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit program if you close the window
         this.setLayout(new BorderLayout(5, 5));
         this.setFont(fo);

         stdArrList = new ArrayList<Student>();

         Student studend = new Student("0910303", "Miike", "Menezes de Mello", "Danielle", " ", "237", "Blackacres",
                 "London", "ON", "N6G 2H1", 2500.00, 1500.00);
         stdArrList.add(studend);

         /********************************
          * TITLE - POSITION NORTH
          *************************************************************/

         panelTitle = new JPanel();
         panelTitle.setLayout(new GridLayout(3, 1, 0, 0));
         panelTitle.setBackground(Color.lightGray);
         title = new JLabel("This is Danielle's Student Loan Calculator");
         title.setHorizontalAlignment(SwingConstants.CENTER);
         title.setForeground(Color.DARK_GRAY);
         fontTitle = new Font("SansSerif", Font.BOLD, 20);
         title.setFont(fontTitle);
         panelTitle.add(new JLabel(" "), "span, grow");
		panelTitle.add(title);

		/******************************** PANEL1 POSITION WEST ******************************************************************/
		//instantiate the labels
		lblStudentID = 		new JLabel("Student ID: ");
		lblStudentID.setFont(fo);
		lblSurname = 		new JLabel("Last Name: ");
		lblSurname.setFont(fo);
		lblMiddleName = 	new JLabel("Middle Name: ");
		lblMiddleName.setFont(fo);
		lblFirstName = 		new JLabel("First Name: ");
		lblFirstName.setFont(fo);
		lblAptNumber = 		new JLabel("Apt. number: ");
		lblAptNumber.setFont(fo);
		lblStreetNumber = 	new JLabel("Street number: ");
		lblStreetNumber.setFont(fo);
		lblStreetName = 	new JLabel("Street name: ");
		lblStreetName.setFont(fo);
		lblCity = 			new JLabel("City: ");
		lblCity.setFont(fo);
		lblProvince = 		new JLabel("Province: ");
		lblProvince.setFont(fo);
		lblPostalCode = 	new JLabel("Postal Code: ");
		lblPostalCode.setFont(fo);
		lblCslLoanAmount = 	new JLabel("CSL Loan Amount: ");
		lblCslLoanAmount.setFont(fo);
		lblOslLoanAmount = 	new JLabel("OSL Loan Amount: ");
		lblOslLoanAmount.setFont(fo);
			
		/******************************** PANEL2 POSITION CENTER**************************************************************/
		//instantiate the text fields
		
		tfStudentID = 		new JTextField();
		tfStudentID.setHorizontalAlignment(SwingConstants.LEFT);
		tfStudentID.setFont(fo);
		tfSurname = 		new JTextField();
		tfSurname.setHorizontalAlignment(SwingConstants.LEFT);
		tfSurname.setFont(fo);
		tfMiddleName = 		new JTextField();
		tfMiddleName.setHorizontalAlignment(SwingConstants.LEFT);
		tfMiddleName.setFont(fo);
		tfFirstName = 		new JTextField();
		tfFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		tfFirstName.setFont(fo);
		tfAptNumber = 		new JTextField();
		tfAptNumber.setHorizontalAlignment(SwingConstants.LEFT);
		tfAptNumber.setFont(fo);
		tfStreetNumber = 	new JTextField();
		tfStreetNumber.setHorizontalAlignment(SwingConstants.LEFT);
		tfStreetNumber.setFont(fo);
		tfStreetName = 		new JTextField();
		tfStreetName.setHorizontalAlignment(SwingConstants.LEFT);
		tfStreetName.setFont(fo);
		tfCity = 			new JTextField("London");
		tfCity.setHorizontalAlignment(SwingConstants.LEFT);
		tfCity.setFont(fo);
		tfProvince = 		new JTextField("ON");
		tfProvince.setHorizontalAlignment(SwingConstants.LEFT);
		tfProvince.setFont(fo);
		tfPostalCode = 		new JTextField();
		tfPostalCode.setHorizontalAlignment(SwingConstants.LEFT);
		tfPostalCode.setFont(fo);
		tfCslLoanAmount = 	new JTextField();
		tfCslLoanAmount.setHorizontalAlignment(SwingConstants.LEFT);
		tfCslLoanAmount.setFont(fo);
		tfOslLoanAmount = 	new JTextField();
		tfOslLoanAmount.setHorizontalAlignment(SwingConstants.LEFT);
		tfOslLoanAmount.setFont(fo);
	
		//limiting the amount of characters to be typed
		tfStudentID.setDocument(new JTextFieldLimit(7));

		//testing if there is only numbers in this fields
		tfStudentID.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();

				if ((input < '0' || input > '9') && input !='\b' ) {
					e.consume();
					JOptionPane.showMessageDialog(null,"Only numbers in this field.");
				}
			}
		});
		/*
		tfCslLoanAmount.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if (!Character.isDigit(input) && input != '.' && input !='\b' ) {
					e.consume();
					JOptionPane.showMessageDialog(null,"Only numbers and dot in this field (format #####.##).");
				}
			}
		});
		tfOslLoanAmount.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if (!Character.isDigit(input) && input != '.' && input !='\b' ) {
					e.consume();
					JOptionPane.showMessageDialog(null,"Only numbers and dot in this field (format #####.##).");
				}
			}
		});*/
		
		space1 = new JLabel(" ");
		space2= new JLabel(" ");
		space2.setHorizontalAlignment(SwingConstants.LEFT);
		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(14,2,0,5));
		panel1.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panel1.setBackground(Color.WHITE);
		panel1.add(space1);
		panel1.add(space2);
		panel1.add(lblStudentID);
		panel1.add(tfStudentID);
		panel1.add(lblSurname);
		panel1.add(tfSurname);
		panel1.add(lblMiddleName);
		panel1.add(tfMiddleName);
		panel1.add(lblFirstName);
		panel1.add(tfFirstName);
		panel1.add(lblAptNumber);
		panel1.add(tfAptNumber);
		panel1.add(lblStreetNumber);
		panel1.add(tfStreetNumber);
		panel1.add(lblStreetName);
		panel1.add(tfStreetName);
		panel1.add(lblCity);
		panel1.add(tfCity);
		panel1.add(lblProvince);
		panel1.add(tfProvince);
		panel1.add(lblPostalCode);
		panel1.add(tfPostalCode);
		panel1.add(lblCslLoanAmount);
		panel1.add(tfCslLoanAmount);
		panel1.add(lblOslLoanAmount);
		panel1.add(tfOslLoanAmount);
		
		/********************************************* PANEL POSITION SOUTH ******************************************************/
		inputSubmit = 	new JButton("Save Student Info");
		inputSubmit.setFont(fo);
		RepayCalcForm = new JButton("Repayment Calc Form");
		RepayCalcForm.setFont(fo);
		ActionListener jbtListener = new MyJButtonListener();
	
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
		panel2.setBackground(Color.lightGray);

		panel2.add(inputSubmit);
		panel2.add(RepayCalcForm);

		RepayCalcForm.addActionListener(jbtListener);
		inputSubmit.addActionListener(jbtListener);

		JLabel empty1 = new JLabel();
		JLabel empty2 = new JLabel();

		/******************************** INSERT INFORMATION INTO INPUT FORM LAYOUT ********************************************/
		//insert data in the Layout
		this.add(panelTitle, BorderLayout.NORTH);
		this.add(empty1, BorderLayout.WEST);
		this.add(panel1, BorderLayout.CENTER);
		this.add(empty2, BorderLayout.EAST);
		this.add(panel2, BorderLayout.SOUTH);
		this.setVisible(true);
	}
		
	/*
	* Method Name:	getArray
	* Purpose: 		run the constructor
	* Accepts:		nothing
	* Returns:		the array list
	*/
	
	public ArrayList<Student> getStdArrList() {
		return stdArrList;
	}
	
	/*
	* Method Name:	main
	* Purpose: 		run the constructor
	* Accepts:		String
	* Returns:		create a Anonymous Student Loan Obj
	*/
	
	public static void main (String[] args) {
		
		//create an instance of the frame
		new StudentLoanApp();
	}

	/*******************************************************INNER CLASSES **********************************************************/

	/**
	 * Class Name:		JTextFieldLimit
	 * Purpose:			This class is used to limited the student id input characters
	 * Coder:			Danielle Miike
	 * Date:			Apr 2, 2020
*/
	class JTextFieldLimit extends PlainDocument {
	

        private static final long serialVersionUID = 1L;
        private int limit;
		   JTextFieldLimit(int limit) {
		      super();
		      this.limit = limit;
		   }
		   
		   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		      if (str == null)
		         return;
		      if ((getLength() + str.length()) <= limit) {
		         super.insertString(offset, str, attr);
		      }
		   }
		}
		
	
	/**
	 * Class Name:		RepaymentCalculationForm
	 * Purpose:			This class will display all of the student’s information, and also the Loan Payments information
	 * Coder:			Danielle Miike
	 * Date:			Apr 2, 2020
*/

	
	public class RepaymentCalculationForm extends JFrame{
		
		
        private static final long serialVersionUID = 1L;
        
        private final double CSL_INTEREST = 2.5, OSL_INTEREST = 1.0;
		private Font font = new Font("SansSerif",Font.PLAIN,14);
		private Font font1 = new Font("SansSerif",Font.PLAIN,13);
		private JLabel lblMonthlyTotal, lblMonthlyCSL, lblMonthlyOSL, lblIntRateAnnual, lblAmortMonth, lblTotalRepaid,lblBorrowed, lblInterestLoans;
		private JTextField  tfAmortPeriod; 
		private JFormattedTextField tfCslLoanAmount, tfOslLoanAmount, tfMonthlyTotal, tfMonthlyCSL, tfMonthlyOSL, tfTotalRepaid,tfBorrowed, tfInterestLoans;
		private JComboBox<Double> cboOptions;
		private JPanel panel4, panel5, panel5_1, panel5_2, panel5_3;
		private JButton previous;
		private JButton next;
		private JButton calcBtn;
		private JButton clearLoanInfo;
		private JButton removeStudent;
		private double IntRateSelected, monthlyCSL, monthlyOSL, cslLoanAmount, oslLoanAmount, totalMonthly, borrowed, interestLoans, totalRepaid;
		private int monthAmort;
		
		RepaymentCalculationForm(){
			super("Danielle 0910303");
			this.setSize(800,700); 
			this.setLocationRelativeTo(null);//center it on the screen
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //exit program if you close the window
			this.setLayout(new BorderLayout(5,5));
			this.setFont(fo);
			

		/********************************************* PANEL POSITION SOUTH ******************************************************/
			previous = 	new JButton("Previous Student");
			previous.setFont(font);
			next	 = new JButton("Next Student");
			next.setFont(font);
			clearLoanInfo	 = new JButton("Clear Loan Info");
			clearLoanInfo.setFont(font);
			removeStudent = new JButton("Delete Student");
			removeStudent.setFont(font);
			
			panel4 = new JPanel();
			panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
			panel4.setBackground(Color.LIGHT_GRAY);
			panel4.add(previous);
			panel4.add(next);
			panel4.add(clearLoanInfo);
			panel4.add(removeStudent);
			
			previous.addActionListener(new CalculateLoan());
			next.addActionListener(new CalculateLoan());
			clearLoanInfo.addActionListener(new CalculateLoan());
			removeStudent.addActionListener(new CalculateLoan());
		/********************************************* PANEL POSITION CENTER***************************************************/					

			studentInform = new JTextArea(
					
				"Student ID: " + getStdArrList().get(i).getStudentID()+ "\n" + 			
				"\nStudent Name: " +  getStdArrList().get(i).getSurname() + "," + getStdArrList().get(i).getMiddleName() + " " + getStdArrList().get(i).getFirstName() + "\n" + 
				"\nStudent Address:" + "Apt. "+ getStdArrList().get(i).getAptNumber() + " - " + getStdArrList().get(i).getStreetNumber() + " " + getStdArrList().get(i).getStreetName() + "\n" + 
				"\nCity: " + getStdArrList().get(i).getCity() + " Province: " + getStdArrList().get(i).getProvince() + "\n" + 
				"\nPostal Code: " + getStdArrList().get(i).getPostalCode() );
			
			studentInform.setColumns(60);
			studentInform.setFont(font);
			studentInform.setBorder(new TitledBorder(new EtchedBorder(), "Student Information"));
			studentInform.setEditable(false);
		/********************************************* NESTED PANEL POSITION CENTER 5_1 ***************************************/	
			
			lblCslLoanAmount = 	new JLabel("CSL Loan Amount: ");
			lblCslLoanAmount.setFont(font);
			lblOslLoanAmount = 	new JLabel("OSL Loan Amount: ");
			lblOslLoanAmount.setFont(font);
			tfCslLoanAmount= 	new JFormattedTextField(df);
			tfCslLoanAmount.setValue(getStdArrList().get(i).getCslLoanAmount());
			tfCslLoanAmount.setFont(font);
			tfCslLoanAmount.setEditable(false);
			tfCslLoanAmount.setHorizontalAlignment(SwingConstants.RIGHT);
			tfCslLoanAmount.setColumns(10);
			tfOslLoanAmount= 	new JFormattedTextField(df);
			tfOslLoanAmount.setValue(getStdArrList().get(i).getOslLoanAmount());
			tfOslLoanAmount.setFont(font);
			tfOslLoanAmount.setEditable(false);
			tfOslLoanAmount.setHorizontalAlignment(SwingConstants.RIGHT);
			tfOslLoanAmount.setColumns(10);
			
			panel5_1 = new JPanel();
			panel5_1.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 5));
			panel5_1.add(lblCslLoanAmount);
			panel5_1.add(tfCslLoanAmount);	
			panel5_1.add(lblOslLoanAmount);
			panel5_1.add(tfOslLoanAmount);
	
		/********************************************* NESTED PANEL POSITION CENTER 5_2 **************************************/	
			Double options[] =  {4.25, 4.50, 4.75, 5.0, 5.25, 5.25, 5.50, 5.75, 6.0, 6.25, 6.50, 6.75, 7.0};
			cboOptions = new JComboBox<Double>(options);
			cboOptions.setFont(font);
			lblIntRateAnnual = new JLabel("Interest rate (% p.y.)"); 
			lblIntRateAnnual.setFont(font);
			lblAmortMonth = new JLabel("Amortization Period (months)");
			lblAmortMonth.setFont(font);
			tfAmortPeriod = new JTextField();
			tfAmortPeriod.setFont(font);
			calcBtn = new JButton("Calc Loan");
			calcBtn.setFont(font);
			
			panel5_2 = new JPanel();
			panel5_2.setLayout(new GridLayout(2,3,50,10));
			panel5_2.setBorder(new TitledBorder(new EtchedBorder(), "Choose an Annual Interest and Type amortization period in months."));
			
			JLabel empty1 = new JLabel();
			
			panel5_2.add(lblIntRateAnnual);
			panel5_2.add(cboOptions);
			panel5_2.add(empty1);
			panel5_2.add(lblAmortMonth);	
			panel5_2.add(tfAmortPeriod);
			panel5_2.add(calcBtn);
			
			//cboOptions.addActionListener(new CalculateLoan());
			calcBtn.addActionListener(new CalculateLoan());	
		/***************************************** NESTED PANEL POSITION CENTER 5_3 *************************************************/	
			
			lblMonthlyCSL = 	new JLabel("Monthly CLS payment amount:");
			lblMonthlyCSL.setFont(font1);
			lblMonthlyOSL = 	new JLabel("Monthly OLS payment amount:");
			lblMonthlyOSL.setFont(font1);
			lblMonthlyTotal = 	new JLabel("Total monthly payment amount:");
			lblMonthlyTotal.setFont(font1);
			lblTotalRepaid = 	new JLabel("Total repaid loan:");
			lblTotalRepaid.setFont(font1);
			lblBorrowed = 		new JLabel("Total borrowed:");
			lblBorrowed.setFont(font1);
			lblInterestLoans = 	new JLabel("Total interest:");
			lblInterestLoans.setFont(font1);
			
			tfMonthlyCSL = 		new JFormattedTextField(df);
			tfMonthlyCSL.setFont(font1);
			tfMonthlyOSL = 		new JFormattedTextField(df);
			tfMonthlyOSL.setFont(font1);
			tfMonthlyTotal = 	new JFormattedTextField(df);
			tfMonthlyTotal.setFont(font1);
			tfTotalRepaid = 	new JFormattedTextField(df);
			tfTotalRepaid.setFont(font1);
			tfBorrowed = 		new JFormattedTextField(df);
			tfBorrowed.setFont(font1);
			tfInterestLoans = 	new JFormattedTextField(df);
			tfInterestLoans.setFont(font1);
		
			
			panel5_3 = new JPanel();
			panel5_3.setLayout(new GridLayout(3,4,5,15));
			panel5_3.setBorder(new TitledBorder(new EtchedBorder(), "Payment Information"));
		
			panel5_3.add(lblMonthlyCSL);
			panel5_3.add(tfMonthlyCSL);
			panel5_3.add(lblMonthlyOSL);
			panel5_3.add(tfMonthlyOSL);
			
			panel5_3.add(lblMonthlyTotal);
			panel5_3.add(tfMonthlyTotal);
			panel5_3.add(lblTotalRepaid);
			panel5_3.add(tfTotalRepaid);
			
			panel5_3.add(lblBorrowed);
			panel5_3.add(tfBorrowed);	
			panel5_3.add(lblInterestLoans);
			panel5_3.add(tfInterestLoans);
				
			

		/********************************************ADD NESTED PANELS IN THE CENTER PANEL ***********************************/		
			panel5 = new JPanel();
			panel5.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
			panel5.add(studentInform);
			panel5.add(panel5_1);
			panel5.add(panel5_2);
			panel5.add(panel5_3);
			
		/******************************************************AFF PANELS IN THE MAIN PANEL **********************************/		
			this.add(panelTitle, BorderLayout.NORTH);
			this.add(panel5, BorderLayout.CENTER);
			this.add(panel4, BorderLayout.SOUTH);
			
			this.setVisible(true);		
			
		}

		/**
		 * Class Name:		CalculateLoan
		 * Purpose:			This class is a action performed used to handle event listener and also calculate the Loan values
		 * Coder:			Danielle Miike
		 * Date:			Apr 2, 2020
	*/

		private class CalculateLoan implements ActionListener,D_M_LoanPayable{
			  
			public void actionPerformed(ActionEvent arg0){
				Object source = arg0.getSource();
				
				if(source == previous) {
					if(i > 0) {
						i--;
						setStudentInformation(i);
						
						//clean values if change student by pressing the previous button
						cleanLoanTextFields();
					}
					else {
						JOptionPane.showMessageDialog(null,"This is the first record.","Message", JOptionPane.PLAIN_MESSAGE);
					}
				}
					
				else if(source == next) {
				
					if(i < getStdArrList().size()-1) {
						i++;
						setStudentInformation(i);
						
						//clean values if change student by pressing the next button
						cleanLoanTextFields();
					}
					else {
						JOptionPane.showMessageDialog(null,"This is the last record.","Message", JOptionPane.PLAIN_MESSAGE);
					}
				}  
				  
				else if(source == calcBtn) {

					try {
						//in case the user to not type any value
						if(tfAmortPeriod.getText().equals(null)|| tfAmortPeriod.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"Please put a valid amounth of months in the field Amortization Period","Message", JOptionPane.PLAIN_MESSAGE);
						}
						//in case the user to type negative value
						else if(Integer.parseInt(tfAmortPeriod.getText()) < 0) {
							throw new D_M_NegativeValueException();
						}
					}
					catch(D_M_NegativeValueException ex) {
						monthAmort = Math.abs(monthAmort);
						JOptionPane.showMessageDialog(null,ex.getMessage(),"Error Message", JOptionPane.PLAIN_MESSAGE);
					}
						
						IntRateSelected = (double) cboOptions.getSelectedItem();
						cslLoanAmount = getStdArrList().get(i).getCslLoanAmount();
					    oslLoanAmount = getStdArrList().get(i).getOslLoanAmount();
					    monthAmort =  Integer.parseInt(tfAmortPeriod.getText());  
					
					    double interest = IntRateSelected + CSL_INTEREST;
						monthlyCSL = Math.round(calculateLoanPayment(cslLoanAmount, interest, monthAmort) * 100) / 100.0;
						interest = IntRateSelected + OSL_INTEREST;
						monthlyOSL = Math.round(calculateLoanPayment(oslLoanAmount, interest, monthAmort) * 100) / 100.0;
						totalMonthly = Math.round( (monthlyCSL + monthlyOSL) * 100) / 100.0;
						borrowed = cslLoanAmount + oslLoanAmount;
						interestLoans = Math.round( (totalMonthly * monthAmort - borrowed) * 100) / 100.0;
						totalRepaid = borrowed + interestLoans;
						
						//display the calculations in the corresponding text fields
						((JFormattedTextField) tfMonthlyCSL).setValue(monthlyCSL);
						((JFormattedTextField) tfMonthlyOSL).setValue(monthlyOSL);
						((JFormattedTextField) tfMonthlyTotal).setValue(totalMonthly);
						((JFormattedTextField) tfBorrowed).setValue(borrowed);
						((JFormattedTextField) tfInterestLoans).setValue(interestLoans);
						((JFormattedTextField) tfTotalRepaid).setValue(totalRepaid);
					
					 }
						
				else if(source == clearLoanInfo) {
					
					cleanLoanTextFields();
				}
					
				else if (source == removeStudent) {					
					if(i > 0) {
						i--;
						setStudentInformation(i);
					}
					else {
						int result = JOptionPane.showConfirmDialog(null,"This is the last student in the array, would you like to delete?","Message", JOptionPane.OK_CANCEL_OPTION);
						 if (result == JOptionPane.OK_OPTION) {
							 stdArrList.remove(i);
							 studentInform.setText(
										"Student ID: " +"\n"+			
										"\nStudent Name: " + "\n"+
										"\nStudent Address:" +	"\n"+
										"\nCity: "  +	"\n"+
										"\nPostal Code: " );
							tfCslLoanAmount.setValue(null);
							tfOslLoanAmount.setValue(null);
						 }
						 
					}
					
				}
			 }
	
			
			/*
			* Method Name:	calculateLoanPayment
			* Purpose: 		Orverride the D_M_LoanPayable abstract method
			* Accepts:		two doubles and one int
			* Returns:		the monthly payment amount
			*/

			public double calculateLoanPayment(double principalAmount, double annualPrimeIntRate, int monthsAmort) {

				double i = annualPrimeIntRate * ANNUAL_RATE_TO_MONTHLY_RATE;
				return principalAmount * i * Math.pow((1+i), monthsAmort) / (Math.pow((1+i), monthsAmort)-1);

			}
			
			/*
			* Method Name:	cleanTextFields
			* Purpose: 		set textfields to null
			* Accepts:		nothing
			* Returns:		nothing
			*/
			
			private void cleanLoanTextFields() {
				
				tfMonthlyCSL.setValue(null);
				tfMonthlyOSL.setValue(null);
				tfMonthlyTotal.setValue(null);
				tfBorrowed.setValue(null);
				tfInterestLoans.setValue(null);
				tfTotalRepaid.setValue(null);
			}
			
			/*
			* Method Name:	setStudentInformations
			* Purpose: 		fill gui components with student information
			* Accepts:		int index
			* Returns:		nothing
			*/
			
			private void setStudentInformation(int i) {
				
				studentInform.setText(
						"Student ID: " + getStdArrList().get(i).getStudentID()+	"\n"+			
						"\nStudent Name: " +  getStdArrList().get(i).getSurname() + "," + getStdArrList().get(i).getMiddleName() + " " + getStdArrList().get(i).getFirstName() +	"\n"+
						"\nStudent Address:" + "Apt. "+ getStdArrList().get(i).getAptNumber() + " - " + getStdArrList().get(i).getStreetNumber() + " " + getStdArrList().get(i).getStreetName() +	"\n"+
						"\nCity: " + getStdArrList().get(i).getCity() + " Province: " + getStdArrList().get(i).getProvince() +	"\n"+
						"\nPostal Code: " + getStdArrList().get(i).getPostalCode());
						((JFormattedTextField) tfCslLoanAmount).setValue(getStdArrList().get(i).getCslLoanAmount());
						((JFormattedTextField) tfOslLoanAmount).setValue(getStdArrList().get(i).getOslLoanAmount());
				
			}
		 
		}
	}
	

	/**
	 * Class Name:		MyJButtonListener
	 * Purpose:			This class is a action performed used to handle event listener of Student Loan Form
	 * Coder:			Danielle Miike
	 * Date:			Apr 2, 2020
*/
	
	  private class MyJButtonListener implements ActionListener{
	  
		public void actionPerformed(ActionEvent e){
			Object source = e.getSource();
			
			if(source == RepayCalcForm) {
				
				try {
					new RepaymentCalculationForm();
			
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"There is no Student in the data base, insert at least one Student.","Message", JOptionPane.PLAIN_MESSAGE);
				}
			}
			
			else if (source == inputSubmit) {
				//recordStdArrList ();
				double cls=0, ols=0;
				
				//validate if the field student id was filled
				if(tfStudentID.getText().equals(null)|| tfStudentID.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"You must enter a Student ID in this field.","Error Message", JOptionPane.PLAIN_MESSAGE);
				}
				else if(tfStudentID.getText().length() != 7) {
					JOptionPane.showMessageDialog(null,"Student ID must have 7 digits.","Error Message", JOptionPane.PLAIN_MESSAGE);
				}
					
				
				//in case the user do not type any value it will be consider zero
				if(tfCslLoanAmount.getText().equals(null)|| tfCslLoanAmount.getText().equals("")) {
					cls = 0;
				}
				
				else if(tfOslLoanAmount.getText().equals(null)|| tfOslLoanAmount.getText().equals("")) { 
					ols = 0;
				}
				
				else {
					try {
						cls = Double.parseDouble(tfCslLoanAmount.getText());
						ols = Double.parseDouble(tfOslLoanAmount.getText());
						if(cls < 0 ||ols < 0 ) {
							throw new D_M_NegativeValueException();
						}
					}
					catch(D_M_NegativeValueException ex){
						cls = Math.abs(cls);
						ols = Math.abs(ols);
						JOptionPane.showMessageDialog(null,ex.getMessage(),"Error Message", JOptionPane.PLAIN_MESSAGE);
					}
				}
			
				//record student info into an array
				Student stu = new Student(
						tfStudentID.getText(),
						tfSurname.getText(),	
						tfMiddleName.getText(),
						tfFirstName.getText(),
						tfAptNumber.getText(),
						tfStreetNumber.getText(),
						tfStreetName.getText(),
						tfCity.getText(),	
						tfProvince.getText(),	
						tfPostalCode.getText(),
						cls,
						ols); 
				
				//input the data in the array
				stdArrList.add(stu);
				JOptionPane.showMessageDialog(null,"Student salved with success.","Message", JOptionPane.PLAIN_MESSAGE);
				cleanStuArr();
				}	
			}
			
		/*
		* Method Name:	cleanStuArr
		* Purpose: 		clean student form text fields
		* Accepts:		nothing
		* Returns:		nothing
		*/
		
		public void cleanStuArr() {
			//clean the fields
			tfStudentID.setText("");
			tfSurname.setText("");	
			tfMiddleName.setText("");
			tfFirstName.setText("");
			tfAptNumber.setText("");
			tfStreetNumber.setText("");
			tfStreetName.setText("");
			tfCity.setText("London");
			tfProvince.setText("ON");	
			tfPostalCode.setText("");
			tfCslLoanAmount.setText("");
			tfOslLoanAmount.setText("");
		}
		
	 }
	
}
	
	
	
	
	
	
	
	



