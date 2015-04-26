import classes.FinBankAccNum;

/**
 * This is the "client-end" to test that FinBankAccNum-class is working properly
 * @author Sauli Rajala
 *
 */
public class Test {

	public static void main(String[] args) {		
		FinBankAccNum sourceAcNumNor = new FinBankAccNum("123456-785");
		FinBankAccNum sourceAcNumSP = new FinBankAccNum("423456-781");
		FinBankAccNum sourceAcNumOP = new FinBankAccNum("533802-596007");
		System.out.println(sourceAcNumNor.getLongFormat());
		System.out.println(sourceAcNumSP.getLongFormat());
		System.out.println(sourceAcNumOP.getLongFormat());
		
		//this isn't real bank account number because of the letter
		FinBankAccNum sourceAcNumFAIL = new FinBankAccNum("510335-1A5999");
		System.out.println(sourceAcNumFAIL.getLongFormat());
		//this isn't real bank account number because the checksum doesn't match
		//but if you change 7 to 0, the checksum match
		FinBankAccNum sourceAcNumSHB = new FinBankAccNum("110335-1537");
		System.out.println(sourceAcNumSHB.getLongFormat());
		
	}

}
