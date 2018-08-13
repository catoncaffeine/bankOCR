import org.junit.Test;

public class AccountNumberValidatorTest {
    AccountNumberValidator accountNumberValidator = new AccountNumberValidator();

    @Test
    public void testValidateAccountNumber_validAccountNumber() {
        assert(accountNumberValidator.validate("457508000")).equals(AccountNumberErrorEnum.VALID);
    }

    @Test
    public void testValidateAccountNumber_hasIllegalDigits() {
        assert(accountNumberValidator.validate("457508???")).equals(AccountNumberErrorEnum.ILLEGAL);
    }

    @Test
    public void testValidateAccountNumber_invalidCheckSum() {
        assert(accountNumberValidator.validate("664371495")).equals(AccountNumberErrorEnum.ERROR);
    }
}