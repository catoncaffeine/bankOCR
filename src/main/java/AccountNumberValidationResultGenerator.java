import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class AccountNumberValidationResultGenerator {

    public HashMap<String, String> getValidationResults(ArrayList<String> accountNumbers) throws IOException{
        long now = new Date().getTime();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/main/resources/validationResult/"+ now +".txt"));

        HashMap<String, String> result = new HashMap<>();
        accountNumbers.forEach(accountNumber -> {
            String error = AccountNumberValidator.validate(accountNumber).getValue();
            try {
                fileWriter.write(accountNumber + " " + error);
                fileWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            result.put(accountNumber, error);
        });
        fileWriter.close();
        return result;
    }

}
