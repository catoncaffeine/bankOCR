public class AccountNumberValidator {

    public static AccountNumberErrorEnum validate(String accountNumber) {
        if(hasIllegalDigits(accountNumber)) {
            return AccountNumberErrorEnum.ILLEGAL;
        }

        if(invalidCheckSum(accountNumber)) {
            return AccountNumberErrorEnum.ERROR;
        }

        return AccountNumberErrorEnum.VALID;
    }

    private static Boolean hasIllegalDigits(String accountNumber) {

        return accountNumber.indexOf("?") != -1;
    }

    private static Boolean invalidCheckSum(String accountNumber) {
        int total = 0;
        for(int i = 0; i < 9; i++) {
            int multiplier = 9 - i;
            int digit = Integer.parseInt(accountNumber.substring(i, i+1));
            total+=(multiplier * digit);
        }
        return total%11 != 0;
    }
}
