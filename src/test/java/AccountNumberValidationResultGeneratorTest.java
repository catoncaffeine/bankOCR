import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AccountNumberValidationResultGeneratorTest {
    AccountNumberValidationResultGenerator resultGenerator = new AccountNumberValidationResultGenerator();

    @Test
    public void testValidationResult() {
        String validAccount = "457508000";
        String invalidDigitAccount = "457508???";
        String invalidChecksumAccount = "664371495";
        ArrayList<String> accounts = new ArrayList<>(Arrays.asList(validAccount, invalidDigitAccount, invalidChecksumAccount));
        HashMap<String, String> result = resultGenerator.getValidationResults(accounts);
        assert(result.get(validAccount)).equals(AccountNumberErrorEnum.VALID.getValue());
        assert(result.get(invalidDigitAccount)).equals(AccountNumberErrorEnum.ILLEGAL.getValue());
        assert(result.get(invalidChecksumAccount)).equals(AccountNumberErrorEnum.ERROR.getValue());
    }
}
