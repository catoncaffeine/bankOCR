import java.util.ArrayList;
import java.util.HashMap;

public class AccountNumberValidationResultGenerator {

    public HashMap<String, String> getValidationResults(ArrayList<String> accountNumbers) {
        HashMap<String, String> result = new HashMap<>();
        accountNumbers.forEach(accountNumber -> {
            AccountNumberErrorEnum error = AccountNumberValidator.validate(accountNumber);
            result.put(accountNumber, error.getValue());
        });
        return result;
    }

}
