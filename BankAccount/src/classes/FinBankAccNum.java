package classes;

/**
 * FinBankAccNum-class stores the bank account number in computer format
 * 
 * Class takes the bank account number in following format: "123456-785" and
 * stores it in the computer format: "12345600000785"
 * 
 * @author Sauli Rajala
 * 
 */
public class FinBankAccNum {
	private long longFormat;
	private StringBuilder sb;

	/*
	 * Constructor
	 */
	public FinBankAccNum(String number) {
		this.sb = new StringBuilder(number);
		this.sb.deleteCharAt(6);

		if (this.sb.substring(0, 1).equals("4")
				|| this.sb.substring(0, 1).equals("5"))
			addZeros(this.sb, 7);
		else
			addZeros(this.sb, 6);

		try {
			if (!validate(sb)) {
				System.out.println("Tilinumeron " + number
						+ " tarkistenumero ei täsmää");
				return;
			}
			this.longFormat = Long.parseLong(this.sb.toString());

		} catch (NumberFormatException e) {
			System.out.println("Syöttämäsi tilinumero " + number
					+ " ei ollut oikeaa muotoa");
		}
	}

	/*
	 * This method validates the computer format of bank account number. It
	 * checks if the checksum of account number is same as the last number in
	 * bank account number.
	 * 
	 * Modified from the Stack Overflow -example:
	 * http://stackoverflow.com/questions
	 * /20725761/validate-credit-card-number-using-luhn-algorithm
	 * 
	 * @param StringBuilder num - original bank account number
	 * 
	 * @return false - checksum is not the same as the last number
	 * 
	 * @return true - checksum is the same as the last number
	 */
	private boolean validate(StringBuilder num) {
		int tarkiste = Integer.parseInt(String.valueOf(num.charAt(13)));
		char[] numChars = num.toString().toCharArray();
		int[] numInts = new int[13];
		for (int i = 0; i < 13; i++) {
			if (i % 2 == 0) {
				numInts[i] = Integer.parseInt(String.valueOf(numChars[i])) * 2;
				if (numInts[i] > 9)
					numInts[i] = 1 + numInts[i] % 10;
			} else
				numInts[i] = Integer.parseInt(String.valueOf(numChars[i]));
		}

		int sum = 0;
		for (int i = 0; i < 13; i++) {
			sum += numInts[i];
		}

		int erotus = ((sum / 10 + 1) * 10) - sum;
		if (erotus % 10 == tarkiste)
			return true;
		return false;
	}

	/*
	 * This method adds zeros to the bank account number
	 * 
	 * @param StringBuilder number - original bank account number
	 * 
	 * @param int startIndex - first index where to add zero
	 */
	private void addZeros(StringBuilder number, int startIndex) {
		int i = 14 - number.length();
		while (i > 0) {
			this.sb.insert(startIndex, "0");
			i--;
		}
	}

	/*
	 * get-method
	 * 
	 * @return longFormat - bank account number in computer format
	 */
	public long getLongFormat() {
		return this.longFormat;
	}

}
