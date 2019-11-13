import javax.swing.JOptionPane;
import java.text.DecimalFormat;	
import java.util.StringTokenizer;

public class Main_03 {
	public static void main(String [] args){
		double grossPay = 0.0;		// Gross pay
		double savingsRate = 0.0;	// Savings rate, as a percent
		double iraRate = 0.0;		// IRA investment rate as a percent
		String inputStr = "";		// The line that is input from the user
		StringTokenizer  st;		// The Tokenizer to split a string
		 
		inputStr = JOptionPane.showInputDialog("Enter gross pay, savings rate and IRA rate separated by spaces");
		
		// Prepare to parse the input and convert each of the three tokens to number
		st = new StringTokenizer(inputStr);
		grossPay = Double.parseDouble(st.nextToken()); 
		savingsRate = Double.parseDouble(st.nextToken()); 
		iraRate = Double.parseDouble(st.nextToken()); 
		
		// creating the Decimal format class
		DecimalFormat stds = new DecimalFormat("####.00");
		
		// Calculate the Savings Amount
		double savingsAmount  = (grossPay * (savingsRate / 100));
		
		// Calculate the IRA investment amount
		double iraInvestmentAmount = grossPay * (iraRate / 100);
		
		// Calculate the total that goes into both accounts
		double totalAmount = savingsAmount + iraInvestmentAmount;
		
		System.out.println("Gross pay: " + stds.format(grossPay)  + "\tSavings pay: " + stds.format(savingsRate) 
		+ "\tIRA rate: " + stds.format(iraRate) );
		
		System.out.println("Savings amount: " + stds.format(savingsAmount));
		System.out.println("IRA investment amount: " + stds.format(iraInvestmentAmount)); 
		System.out.println("Total of savings and IRA amounts: " + stds.format(totalAmount));
		
		//Close and exist
		System.exit(0);
	}

}
