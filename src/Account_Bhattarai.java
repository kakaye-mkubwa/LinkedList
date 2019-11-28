public class Account_Bhattarai {
	String accountNo;
	  String name;
	  float balance;
	  double minAmt;
	 

	public Account_Bhattarai()
	{
	accountNo="";
	name=null;
	balance=0.0f;
	minAmt=0.0;
	}

	public Account_Bhattarai(String account, String name, float balance)
	{
		accountNo=account;
		this.name=name;	
		this.balance=balance;
		
	}


	public void openNewAccount()
	{
		System.out.println("Open New Account: Dipak Bhattarai Bank Account\n");
		System.out.printf("Account Num: %s\n"+
		"name: %s\n"+
		"Balance: %f", accountNo, name, balance);
	}

	public void checkBalance()
	{
		System.out.println("The Current Balance on: Dipak Bhattarai\n");
		System.out.printf("Account Num:%s\n name:%s\n Balance:%f\n", accountNo, name, balance);
	}
	public void deposit(float depAmt)
	{
	System.out.println("Deposit in Dipak Bhattarai Account");
	System.out.printf("Account Num:%s\n name:%s\n Balance:%f\n Deposit Amt:%f\n", accountNo, name, balance,depAmt);
	balance=balance+depAmt;
	System.out.printf("New Balance:%f", balance);
	}
	public void withdraw( float withAmt)
	{
		System.out.println("Withdraw from Dipak Account is:");
		System.out.printf("Account NUm:%s\n name:%s\n Balance:%f\n withdraw amt:%f\n New Balance:%f",accountNo, name, balance, withAmt, balance-withAmt);
		
	}
	public void printMonthlyState()
	{
		System.out.println("Monthly Statement for Dipak Bhattarai Account is");
		System.out.printf("Account NUm:%s\n Name:%s\n End Balance:%f\n",accountNo,name,balance);
	}
	public Account_Bhattarai deepCopy()
	{
		Account_Bhattarai clone=new Account_Bhattarai(accountNo, name, balance);
		
		return clone;
	}
	public int compareTo(String targetKey)
	{
		return(accountNo.compareTo(targetKey));
	}
	public String toString()
	{
		return("\n\n A/C No:"+ accountNo+"\n Name: "+name+"Balance :"+balance);
	}
	public double getMinAmt()
	{
		return minAmt;
	}
	public void newMinAmt(float min)
	{
		minAmt=min;
	}
	}

