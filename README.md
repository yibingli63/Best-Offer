Core Java Code Challenge v2: Best Offer

Overview: 
You are provided a list of accounts that are potential candidates for a new offer. Find the top three (3) qualifying accounts based on the specified criteria and scoring.

Detailed Requirements: 

Given a list of accounts, use the account attributes (a) credit limit, (b) account current balance, and (c) account opened date to find the top 3 candidates for a new 
customer offer that starts on 7/1: The account qualifiers are:

1.	The account age at the time of the offer (the months between the account opened date and the offer start date (7/12/14)) is greater than > 24 months.
2.	The account current balance is > = 0 and = < 10,000.
3.	The account credit limit >= 1,000 and =< 10,000.

Accounts are scored using the account age at the time of the offer multiplied by the percentage of credit available, with the highest score indicated the most qualified
account. The output should always be a String array of length 3 -- even if there are less than 3 offers.

Sample Input: 
new Account("a", Solution.DATE_FORMAT.parse("01/12/2012"), new BigDecimal(750), new BigDecimal(1000)); 
new Account("b", Solution.DATE_FORMAT.parse("01/12/2011"), new BigDecimal(10000), new Big Decimal(10000)); 
new Account("c", Solution.DATE_FORMAT.parse("09/12/2011"), new BigDecimal(1999), new BigDecimal(4200));

Sample Account Scoring: 
Account a: credit available is 250, which is 25%. Age is 30 months. Score is 7.5. 
Account b: credit available is 0, which is 0%. Age is 42 months. Score is 0. 
Account c: credit available is 2201, which is 53%. Age is 34 months. Score is 17.8.

Sample Output:
c
a
b

Available Libraries: 
The following libraries are available: 
import java . math .*;
import java .text .*; 
import java .util.*;

Important Notes: 
1.	While you may consult online references for guidance, you must not copy code from websites and/or other candidates.
2.	Do not change the method signature of the method: protected Stringfi getAccountslnOrder(List accounts)
3.	This problem should take 30 minutes to complete.
4.	Click the "Run Code" button to try out your code against the test cases.

84 private static String DATE_STRING_FORMAT = "MM/dd/yyyy";
85
86 private static final String OFFER_START_DATE	"07/12/2014";
87
88
89 /**
90   * Takes a properly formatted string and converts to a java.util.date.
91   *
92   * @param date the date to parse
93   * @return a date as java.util.Date
94   * @throws ParseException
95  */
96 private static Date getDateFromString(String date) throws ParseException {
97	SimpleDateFormat sdf = new SimpleDateFormat(DATE_STRING_FORMAT, Locale.ENGLISH);
98	return sdf.parse(date);
99 }
100 
101 /**
102 * Primary implementation method. Takes a list of accounts and returns the top 3 as a String array of names.
103
104 * @param accounts the list of accounts to evaluate.
105 * @return a String array of length X of the names of the top qualifying accounts.
106 */
107 protected String[] getAccountsInOrder(List<Account> accounts) {
108	// YOUR CODE GOES HERE
109	// CHANGE null TO YOUR VARIABLE!
110	return null;
111 }
112
113 /**
114 * Account object...the primary object for this class.
115 */
116. protected class Account {
117	private String name;
118
119	private Date accountOpenDate;
120
121	private Double accountCurrentBalance;
122
123	private Double accountCreditLimit;
124
116     protected class Account {
117	private String name;
118
119	private Date accountOpenDate;
120
121	private Double accountCurrentBalance;
122
123	private Double accountCreditLimit;
124
125	private int ageInMonthsAtTime0fOffer;
126
127	private Double accountScore;
128
129	protected Account(String name, Date accountOpenDate, Double accountCurrentBalance, Double accountCreditLimit)
130     	throws ParseException {
131	this.name = name;
132	this.accountOpenDate = accountOpenDate;
133	this.accountCurrentBalance = accountCurrentBalance;
134	this.accountCreditLimit = accountCreditLimit;
135	setAge();
136	setScore();
137	}
138
139	public String getName() {
140	return name;
141	}
142
143	public Date getAccountOpenDate() {
144	return accountOpenDate;
145	}
146
147	public Double getAccountCurrentBalance() {
148	return accountCurrentBalance;
149	}
150
151	public Double getAccountCreditLimit() {
152	return accountCreditLimit;
153	}
154
155 	public int getAgeInMonthsAtTime0fOffer() {
156	return ageInMonthsAtTime0fOffer;
157	}
158
159 	public Double getAccountScore() {
160	return accountScore;
161	}
162
163	public void setAge() throws ParseException {
164	// INSERT YOUR CODE HERE
165	}
166
167	public void setScore() {
168	// INSERT YOUR CODE HERE
169	}
170 }
171
172
173
174



