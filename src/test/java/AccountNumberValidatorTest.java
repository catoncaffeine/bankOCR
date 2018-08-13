import org.junit.Test;

public class AccountNumberValidatorTest {
    AccountNumberValidator accountNumberValidator = new AccountNumberValidator();

    @Test
    public void testValidateAccountNumber_validAccountNumber() {
        assert(accountNumberValidator.validate("457508000")).equals(AccountNumberErrorEnum.VALID);
    }
}