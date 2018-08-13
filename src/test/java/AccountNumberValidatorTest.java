import org.junit.Test;

public class AccountNumberValidatorTest {
    @Test
    public void testValidateAccountNumber_validAccountNumber() {
        assert(AccountNumberValidator.validate("457508000")).equals(AccountNumberErrorEnum.VALID);
    }

    @Test
    public void testValidateAccountNumber_hasIllegalDigits() {
        assert(AccountNumberValidator.validate("457508???")).equals(AccountNumberErrorEnum.ILLEGAL);
    }

    @Test
    public void testValidateAccountNumber_invalidCheckSum() {
        assert(AccountNumberValidator.validate("664371495")).equals(AccountNumberErrorEnum.ERROR);
    }
}