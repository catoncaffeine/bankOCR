import java.io.*;
import java.util.ArrayList;

public class AccountNumberReader {

    public ArrayList<String> readAccountNumber(String filePath) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<String> translatedAccountNumbers = new ArrayList<String>();
        Boolean endOfFile = false;
        String line1;
        String line2;
        String line3;
        String line4;

        while(!endOfFile) {
            ArrayList<String> accountStringArray = new ArrayList<String>();
            line1 = reader.readLine();
            line2 = reader.readLine();
            if(line2 != null) {
                line3 = reader.readLine();
                line4 = reader.readLine();
                accountStringArray.add(addEndingSpaces(line1, 27));
                accountStringArray.add(addEndingSpaces(line2, 27));
                accountStringArray.add(addEndingSpaces(line3, 27));
                accountStringArray.add(addEndingSpaces(line4, 27));
                translatedAccountNumbers.add(translateStringToDigit(accountStringArray));

            } else {
                endOfFile = true;
            }

        }

        return translatedAccountNumbers;
    }

    private String translateStringToDigit(ArrayList<String> accountArray) {
        int charPosition = 0;
        String accountNumber = "";
        while (charPosition < 27) {
            String top = accountArray.get(0).substring(charPosition, charPosition + 3);
            String middle = accountArray.get(1).substring(charPosition, charPosition + 3);
            String bottom = accountArray.get(2).substring(charPosition, charPosition + 3);
            String translatedDigit = BankOCREnum.getDigitFromStringRepresentation(top + middle + bottom);
            accountNumber = accountNumber + translatedDigit;
            charPosition+=3;
        }
        return accountNumber;
    }

    private String addEndingSpaces(String line, int totalLength) {
        int missingSpaces = totalLength - (line != null ? line.length() : 0);
        return (line + new String(new char[missingSpaces]).replace("\0", " "));
    }

}
