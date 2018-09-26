package aeb.gov.br.util;

import java.util.InputMismatchException;

public final class StringUtil {

	public static boolean isEmpty(String string) {
		if (string == null) {
			return true;
		} else {
			if (string.equals("")) {
				System.out.println("String null." + string);
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static String replaceCpfCharacteres(String cpf) {
		if (cpf != null) {
			cpf = cpf.replace(".", "");
			cpf = cpf.replace("-", "");
			cpf = cpf.replace("/", "");
			
			//System.out.println("---- CPF not null, printing it: " + cpf);
			return cpf;
		}		
		return cpf;
	}
	
	/**
	 * Checks if the cpf is valid by the rules used by the government
	 * 
	 * @param cpf
	 *            {@link String} containing the cpf to be verified
	 * @return {@link Boolean} to check if the cpf is valid or not
	 */
	public static boolean checkCPF(String cpf) {		
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != 11)) {
			
			return false;
		}

		char digit10, digit11;
		int sum, rest, number, weight;

		try {
			sum = 0;
			weight = 10;

			// sums all the numbers of the cpf before the verify number
			for (int i = 0; i < 9; i++) {

				number = (int) (cpf.charAt(i) - 48);
				sum = sum + (number * weight);
				weight = weight - 1;
			}

			rest = 11 - (sum % 11);
			if ((rest == 10) || (rest == 11)) {

				digit10 = '0';
			} else {

				digit10 = (char) (rest + 48);
			}

			// sums all the numbers of the cpf before the last verify number
			sum = 0;
			weight = 11;
			for (int i = 0; i < 10; i++) {

				number = (int) (cpf.charAt(i) - 48);
				sum = sum + (number * weight);
				weight = weight - 1;
			}

			rest = 11 - (sum % 11);
			if ((rest == 10) || (rest == 11)) {

				digit11 = '0';
			} else {

				digit11 = (char) (rest + 48);
			}

			/*
			 * verify if the cpf is truly valid by verifying if the value found
			 * is the same as the value given
			 */

			if ((digit10 == cpf.charAt(9)) && (digit11 == cpf.charAt(10))) {

				return true;
			} else {

				return false;
			}
		} catch (InputMismatchException erro) {
			return false;
		}
	}
}
