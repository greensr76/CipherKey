/*
 * Stephen Green
 * CS 339 Homework 3
 */
public class MainCipher {
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String message1 = "F30MDAAFEMA1MI0EF0D9M609FGZ6KMG94H0DE4FKM2AMYXZ6MFAMOVUTMI4 F3MF30M1AG9 "
				+ "492MYKMXMIM8077MA1MF30MBD4HXF07KMAI90 M27XE2AIM9AD8X7MEZ3AA7MX9 MYGE490EEMZA77020M49M27XE2AIM609FGZ6KMF34EM8AH0"
				+ "MFAMYAI7492M2D009M49MOVVRMX9"
				+ "MY0ZX80MF30MEAGF30D9M9AD8X7MEZ3AA7MX9"
				+ "MYGE490EEMZA77020M49MOVWNMBAFF0DMZA77020MIXEMAB090"
				+ "MYKMB70XEX9FM5MBAFF0DM49MOWNTM309DKM3XD 09MZ30DDKMEA7"
				+ "MF30MEAGF30D9M9AD8X7MEZ3AA7MX9 MY0ZX80MBD0E4"
				+ "09FMA1MF30MI0EF0D9M609FGZ6KMEFXF0M9AD8X7MEZ3AA7";
		
		String message2 = "ZG261OOZI6OJ6C2IZ2176U27ZF5U96F7XW21IXZ96"
				+ "O6P85U6ZO63BVE6CXZG6ZG26JOF7MX7"
				+ "6P9686C6R2AA6OJ6ZG2641XW8Z2A96OC72M6 A8I"
				+ "OC67O1R8A6I5GOOA687M6PFIX72II65OAA2 26X76 A8I"
				+ "OC6U27ZF5U96ZGXI6ROW2M6ZO6POCAX7 6"
				+ "12276X763BBH687M6P258R26ZG26IOFZG21767O1R8A6I5GOOA687M6PFIX"
				+ "72II65OAA2 26X763BSN64OZZ2165OAA2"
				+ "26C8I6O4272M6P964A28I87Z6D64OZZ216X763SNE6G27196G81M2765G21"
				+ "196IOAM6ZG26IOFZG21767O1R8A6I5GOOA687M6P258R26412IXM27Z6OJ6"
				+ "ZG26C2IZ2176U27ZF5U96IZ8Z267O1R8A6I5GOOA";
		
		

		/*Shift Cipher
		for(int k = 0; k <= 37; k++){
			String realMessage = ShiftConversion(message1,k);
			System.out.println(k + ": " + realMessage );
		}
		*/
		
		//AffineCipher
	//	for(int a = 0; a < 37; a++){ Console is not big enough to show all values
		int a = 17;
			for(int b = 0; b <= 37; b++){
				String realMessage = AffineCipher(message2,a,b);
				System.out.println(a + ":" + b + ": "+ realMessage );
			}
		
		
		
		
	}
	/**
	 * Tried every key value from 0-37 and took each character and found its index from
	 * the created alphabet string. It then shifted the index by the key value
	 * and used the mod function to keep it within the array if it were to go over or under range
	 * 
	 * 
	 * Key value was 23 for message1
	 * Message: THE ROOTS OF WESTERN KENTUCKY UNIVERSITY GO BACK TO 1876 WIDTH THE FOUNDING BY 
	 * A W MELL OF THE PRIVATELY OWNED GLASGOW NORMAL SCHOOL AND BUSINESS COLLEGE IN 
	 * GLASGOW KENTUCKY THIS MOVE TO BOWLING GREEN IN 1884 AN BECAME THE 
	 * SOUTHERN NORMAL SCHOOL AN BUSINESS COLLEGE IN 1890 POTTER COLLEGE WAS 
	 * OPENE BY PLEASANT J POTTER IN 1906 HENRY HARDEN CHERRY SOL THE SOUTHERN 
	 * NORMAL SCHOOL AND BECAME PRESIENT OF THE WESTERN KENTUCKY STATE NORMAL SCHOOL
	 */
	public static String ShiftConversion(String codedText, int key){
		String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
		String realText = "";
		
		for(int i = 0; i < codedText.length(); i ++){
			int y = alphabet.indexOf(codedText.charAt(i));
			
			realText += alphabet.charAt(Math.floorMod(y-key, 37));
		}
		return realText;
	}
	
	
	
	/*
	 * Key was (17,23)
	 * THE ROOTS OF WESTERN KENTUCKY UNIVERSITY O BACK TO 1876 WITH THE FOUNDIN BY A W MELL OF THE PRIVATELY OWNED GLASOW NORMAL SCHOOL 
	 * AND BUSINESS COLLEGE IN GLASOW KENTUCKY THIS MOVED TO BOWLING REEN IN 1884 AND BECAME THE SOUTHERN NORMAL SCHOOL AND BUSINESS COLLEGE 
	 * IN 1890 POTTER COLLEE WAS OPENED BY PLEASANT J POTTER IN 1906 HENRY HARDEN CHERRY SOLD THE SOUTHERN NORMAL SCHOOL AND BECAME PRESIDENT 
	 * OF THE WESTERN KENTUCKY STATE NORMAL SCHOOL
	 */
	public static String AffineCipher(String cipher, int a, int b){
		String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
		String realText = "";
		
		int c = 0;
		for(int i = 0; i <= 50; i ++){
			if (Math.floorMod(a*i, 37) == 1){
				c = i;
			}
		}
		
		for (int i = 0; i < cipher.length(); i ++){
			int y = alphabet.indexOf(cipher.charAt(i));
			realText += alphabet.charAt(Math.floorMod(c*(y-b), 37));
			
		}
		
		return realText;
	}

}
