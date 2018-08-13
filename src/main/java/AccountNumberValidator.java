public class AccountNumberValidator {

    public AccountNumberErrorEnum validate(String accountNumber) {
        if(hasIllegalDigits(accountNumber)) {
            return AccountNumberErrorEnum.ILLEGAL;
        }

        if(invalidCheckSum(accountNumber)) {
            return AccountNumberErrorEnum.ERROR;
        }

        return AccountNumberErrorEnum.VALID;
    }

    private Boolean hasIllegalDigits(String accountNumber) {

        return accountNumber.indexOf("?") != -1;
    }

    private Boolean invalidCheckSum(String accountNumber) {
        return false;
    }
}
