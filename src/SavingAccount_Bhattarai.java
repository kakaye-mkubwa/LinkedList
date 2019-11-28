public class SavingAccount_Bhattarai extends Account_Bhattarai {
	private float interestRate;
	private float minAmt=100.0f;
	 
	public SavingAccount_Bhattarai()
	{
		interestRate=0f;
		minAmt=100.0f;
	}
	public SavingAccount_Bhattarai(String accountNo,  String name, float balance, float interestRate) {
		super(accountNo,name,balance);
		this.interestRate=interestRate;
	}
	public void openNewAccount()
	{
		if(balance<minAmt)
		{
			System.out.printf("Minimum Amount while open the Saving a/c is: %f. Minimum balance is required to open an account.", minAmt);
			
		}
		else {
			super.openNewAccount();
			System.out.println("\n Type:         Saving Accoumt\n");
			
		}
	}
	public void checkBalance() {
		super.checkBalance();
		System.out.printf("\nType:            Saving Account\n");
		
	}
	public void deposit(float depAmt)
	{
	System.out.println("Saving Account");

	}
	public void withdraw(float withAmt)
	{
		if( (balance-withAmt<minAmt))
			System.out.println("Please keep sufficient amount");
		else
		{
			super.withdraw(withAmt);
			System.out.println("\nType:          Saving Account\n");
			
		}
	}
		public void printMonthlyState()
		{
			super.printMonthlyState();
			float interestAmt=(balance*interestRate)/100;
			System.out.printf("Interest Rate:%f\n interest Amount:%f", interestRate, interestAmt);
			System.out.println("nType:          Checking Account\n");
			
		}
		public void newInterestRate(float anotherInterestRate)
		{ 
			interestRate=anotherInterestRate;
		}
		
		public SavingAccount_Bhattarai deepCopy()
		{
			SavingAccount_Bhattarai clone=new SavingAccount_Bhattarai(accountNo, name,balance, interestRate);
			return clone;
		}
		public String toString()
		{
			return (super.toString()+"\nInterest Rate"+interestRate);
		}
		
	}



