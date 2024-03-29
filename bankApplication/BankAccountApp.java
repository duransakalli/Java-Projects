package bankApplication;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
	
	public static void main(String[] args) {
	
		List<Account> accounts = new LinkedList<Account>();
		String file = "C:\\Users\\Duran\\eclipse-workspace\\JavaProjects\\src\\bankApplication\\denem.csv";
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit =Double.parseDouble(accountHolder[3]) ;
			
			if(accountType.equals("Saving")) {
				accounts.add(new Saving(name, sSN, initDeposit));
			} else if (accountType.equals("Checking")) {
				accounts.add(new Checking(name, sSN, initDeposit));
			} else {
				System.out.println("No account found");
			}
			
		}
		
		for(Account acc : accounts) {
			acc.showInfo();
			System.out.println("**************************** \n");
		}
		
		
	}
}
