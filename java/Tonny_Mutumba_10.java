/*****************
NAME: TONNY MUTUMBA
ENVIRONMENT: JGRASP
QUOTE: TO PITY DISTRESS IS BUT HUMAN, TO RELIEVE IT IS GODLIKE.
      BY HORACE MANN. 

This program Calculates payroll data using classes.
Employee.java
EmployeeParameters
EmployeeParameters.txt	
********/
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.*;
public class Tonny_Mutumba_10 {
	static Toolkit tools = new Toolkit();
   static int maxEmployees = 30;

	public static void main(String [] args) throws IOException{
		
		File inputFile = new File("Tonny_Mutumba_10_Input.txt");
		File outputFileName = new File("Tonny_Mutumba_10_Output.txt");
		PrintWriter outputFile = new PrintWriter(outputFileName);
		Scanner input = new Scanner ("inputFile");

		EmployeeParameters params = new EmployeeParameters();
      
      int maxEmployees = params.maxEmployees;
		Employee [] empl = new Employee[maxEmployees];
      
      //declarations
		int nRead = 0;
		int results = 0;      
		
      //getEmployeeParameters();
		params.getEmployeeParameters();
		params.displayEmployeeParameters();
      double savingsRate = params.savingsRate;
      double iraRate = params.iraRate;
      double taxRate = params.federalWithholdingRate 
                        + params.stateWithholdingRate;
      
      //method call                  
      nRead = getInfo(empl, input);                  
      printHeading(outputFile);
      calGrossPay(empl, nRead);
      calData(empl, nRead, taxRate, iraRate, savingsRate, params);
      printInfo(empl, nRead, outputFile);
      calTotals(empl, nRead, outputFile);
		System.out.println("\nNumber of rows Read: " + nRead);
		//input.close();
		
		//displayInfo("input", empl, nRead);
		
		//sorting
		results = tools.selectionSortArrayOfClass(empl, nRead, "Name");
		//displayInfo("Name", empl, nRead);
		
		results = tools.selectionSortArrayOfClass(empl, nRead, "Gross Pay");
		//displayInfo("Gross Pay", empl, nRead);
      outputFile.close();
      System.exit(0);
	}
	
	//*****************************************************
   public static int getInfo(Employee [] empl, Scanner input){
      int i = 0;
      //Read input
		while (input.hasNext() && (i < empl.length)){
			empl[i] = new Employee();
			empl[i].hoursWorked = input.nextDouble();
			empl[i].payRate = input.nextDouble();
			empl[i].name = input.nextLine().trim();
         //empl[i].grossPay = empl[i].hoursWorked * empl[i].payRate;
         i++;
		}
      return i;
   }
	public static void displayInfo(String printOrder, Employee[] empl, int nRead){ 
		final String dollar = "#,##0.00";
		
		System.out.println("\nPrint in " + printOrder.toLowerCase() + "order\n");
		
		for(int i = 0; i < nRead; i++){
			System.out.println(tools.padString(empl[i].name, 20) + "" + tools.leftPad(empl[i].payRate, 10, dollar)
							+ " " + tools.leftPad(empl[i].hoursWorked, 10, dollar)
							+ " " + tools.leftPad(empl[i].grossPay, 10, dollar));
		}
	}
   
   public static void printHeading(PrintWriter outputFile){
         String line;
         line = "Name                   Gross Pay          Net Pay         " 
               + "Wealth          Taxes           Hours            Pay Rate"
               + "\n_______               ___________        ________        "
               + "_________      __________      __________        "     
               + "____________";
         outputFile.println(line);
         System.out.println(line);      
   }

   public static void calGrossPay(Employee[]empl, int nRead){
      for (int i = 0; i < nRead; i++){
         if (empl[i].hoursWorked <= 0.0){
            empl[i].grossPay = 0.0;
         }
         else if (empl[i].hoursWorked <= 40.0){
            empl[i].grossPay = empl[i].payRate * empl[i].hoursWorked;
         }
         else if (40.0 < empl[i].hoursWorked && empl[i].hoursWorked <= 50.0){
            empl[i].grossPay = empl[i].payRate * (3.0 / 2.0) * 
                           empl[i].hoursWorked - 20.0;
         }
         else if (empl[i].hoursWorked > 50.0){
            empl[i].grossPay = empl[i].payRate * (3.0 / 2.0) * 
                           empl[i].hoursWorked - 45.0;
         }
      }
    }  
    public static void calData(Employee[] empl, int nRead, 
               double taxRate, double iraRate, double savingsRate,
               EmployeeParameters params){
       //double sumTaxes = 0.0;
       for (int i = 0; i < nRead; i ++){
         empl[i].adjustedGrossPay = (empl[i].grossPay - empl[i].iraAmount);
         empl[i].iraAmount = (empl[i].adjustedGrossPay * iraRate) / 100;
         empl[i].taxAmount = (empl[i].adjustedGrossPay * taxRate) / 100;
         empl[i].netPay = empl[i].adjustedGrossPay - empl[i].taxAmount;
         empl[i].savingsAmount = (empl[i].adjustedGrossPay * savingsRate) / 100;
         empl[i].wealth = empl[i].savingsAmount + empl[i].iraAmount;
 
       }        
    }
    public static void calTotals(Employee [] empl, int nRead, 
                        PrintWriter outputFile){
      double totalGrossPay = 0.0;
      double totalNetPay = 0.0;
      double totalTaxes = 0.0;
      double totalHours = 0.0;
      double totalWealth = 0.0;
      double totalPayRate = 0.0;
      double wealth = 0.0;
      double averagePayRate = 0.0;
      double average = 0.0;
      
      for(int i = 0; i < nRead; i++){
         empl[i].wealth = empl[i].savingsAmount + empl[i].iraAmount;
         totalWealth += empl[i].wealth;
         totalGrossPay += empl[i].grossPay;
         totalNetPay += empl[i].netPay;
         totalHours += empl[i].hoursWorked;
         totalTaxes += empl[i].taxAmount;
         totalPayRate += empl[i].payRate;
      }
      if (nRead > 0){
         average = totalPayRate / nRead;
      }
      System.out.println("                       " 
                       + tools.leftPad(totalGrossPay, 5, "0.00") + 
                "              "+ tools.leftPad(totalNetPay, 5, "0.00") + "           "
                       + tools.leftPad(totalWealth, 5, "0.00") + "           "
                       + tools.leftPad(totalTaxes, 5, "0.00") + "            "
                       + tools.leftPad(totalHours, 5, "0.00") + "            "
                       + tools.leftPad(totalPayRate, 5, "0.00") + "                ");
      System.out.println("\nAverage: " + tools.rightPad(average, 10, "0.00")); 
    }
    public static void printInfo(Employee [] empl, int nRead, 
                        PrintWriter outputFile){
      for(int i = 0; i < nRead; i++){
         System.out.println(tools.padString(empl[i].name, 22) + " " 
                          + tools.leftPad(empl[i].grossPay, 6, "0.00")
                          + tools.leftPad(empl[i].netPay, 6, "0.00")
                          + tools.leftPad(empl[i].wealth, 6, "0.00")
                          + tools.leftPad(empl[i].taxAmount, 6, "0.00")
                          + tools.leftPad(empl[i].hoursWorked, 6, "0.00")
                          + tools.leftPad(empl[i].payRate, 6, "0.00") );
      }                    
    }
  }