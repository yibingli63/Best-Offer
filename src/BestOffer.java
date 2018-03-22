import java.text .*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.temporal.ChronoUnit;

public class BestOffer {

	protected static class Account implements Comparable<Account> {
		private String name;
		private LocalDate accountOpenDate;
		private Double accountCurrentBalance;
		private Double accountCreditLimit;
		private int ageInMonthsAtTime0fOffer;
		private Double accountScore;
			
		protected Account(String name, LocalDate accountOpenDate, Double accountCurrentBalance, Double accountCreditLimit)
			throws ParseException {
			this.name = name;
			this.accountOpenDate = accountOpenDate;
			this.accountCurrentBalance = accountCurrentBalance;
			this.accountCreditLimit = accountCreditLimit;
			setAge();
			setScore();
		}
		
		public Account() {
			// TODO Auto-generated constructor stub
		}

		public String getName() {
			return name;
		}		
		public LocalDate getAccountOpenDate() {
			return accountOpenDate;
		}		
		public Double getAccountCurrentBalance() {
			return accountCurrentBalance;
		}		
		public Double getAccountCreditLimit() {
			return accountCreditLimit;
		}		
		public int getAgeInMonthsAtTime0fOffer() {
			return ageInMonthsAtTime0fOffer;
		}		
		public Double getAccountScore() {
			return accountScore;
		}
		
		public void setAge() throws ParseException {
			Long tmp;
		    tmp = ChronoUnit.MONTHS.between(this.getAccountOpenDate(), getDateFromString(OFFER_START_DATE));
			this.ageInMonthsAtTime0fOffer = tmp.intValue();
			System.out.println("Age = " + tmp.intValue());
		}		
		public void setScore() {
			DecimalFormat df = new DecimalFormat(".##");	
			
			if ((this.getAgeInMonthsAtTime0fOffer() > 24) && ((this.getAccountCurrentBalance() >= 0) && (this.getAccountCurrentBalance() <= 10000))
					&& ((this.getAccountCreditLimit() >= 1000) && (this.getAccountCreditLimit() <= 10000))) {
					this.accountScore = this.ageInMonthsAtTime0fOffer * ((this.getAccountCreditLimit() - this.getAccountCurrentBalance()) / this.getAccountCreditLimit());			
					this.accountScore = Double.valueOf(df.format(accountScore));
			} else {
				this.accountScore = -1.00;
			}
			System.out.println("Score = " + this.accountScore);
		}

		public int compareTo(Account account) {
			Double compareScore=(account).getAccountScore();
	        //For Descending order
	        return (int) (compareScore - this.getAccountScore());						
		}
	}
	
	private static String DATE_STRING_FORMAT = "MM/dd/yyyy";
	private static final String OFFER_START_DATE = "07/12/2014";

	private static LocalDate getDateFromString(String date) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_STRING_FORMAT);
		return LocalDate.parse(date, formatter);
	}

	protected static String[] getAccountsInOrder(List<Account> accounts) throws Exception {
		int index = 0;
		String[] str = new String[accounts.size()];
		Account acct = new Account();
		
		Collections.sort(accounts);
		
		Iterator<Account> it1 = accounts.iterator();
		while (it1.hasNext()) {
			acct = (Account) it1.next();
			if (acct.getAccountScore() >= 0) {
				str[index] = acct.getName();
			} else {
				str[index] = null;
			}
			index++;
		}
		return str;
	}

	public static int ageInMonths = 0; 
		
	public static void main(String[] args) throws Exception {				
		List<Account> accounts = new ArrayList<Account>();

		accounts.add(new Account("a", getDateFromString("01/12/2012"), new Double(750), new Double(1000)));
		accounts.add(new Account("b", getDateFromString("01/12/2011"), new Double(10000), new Double(10000)));
		accounts.add(new Account("c", getDateFromString("09/12/2011"), new Double(1999), new Double(4200)));
		
		String str[] = new String[accounts.size()];
		str = getAccountsInOrder(accounts);
		
		for(int i = 0; i < 3; i++){
			System.out.println("Order by Score: " + str[i]);
	    }
	}
}
