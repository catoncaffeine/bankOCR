import java.io.*;
import java.util.ArrayList;

public class AccountNumberReader {

    public ArrayList<String> getAccountNumbers(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<String> translatedAccountNumbers = new ArrayList();
        readAccountNumbers(reader, translatedAccountNumbers);
        return translatedAccountNumbers;
    }

    private void readAccountNumbers(BufferedReader reader, ArrayList<String> translatedAccountNumbers) throws IOException{
        ArrayList<String> accountStringArray = generateAccountStringArray(reader);
        if(accountStringArray.size() == 3) {
            StringBuffer accountNumber = new StringBuffer();
            translateStringToDigit(accountStringArray, accountNumber, 0);
            translatedAccountNumbers.add(accountNumber.toString());
            readAccountNumbers(reader, translatedAccountNumbers);
        }
    }

    private ArrayList<String> generateAccountStringArray(BufferedReader reader) throws IOException{
        ArrayList<String> accountStringArray = new ArrayList<>();
        for (int i = 0; i<3; i++) {
            String line = reader.readLine();
            if(!isEndOfFile(i, line)) {
                accountStringArray.add(addEndingSpaces(line, 27));
            }
        }
        reader.skip(1);
        return accountStringArray;
    }

    private Boolean isEndOfFile(int lineIndex, String line) {
        return lineIndex == 1 && line == null;
    }
    
    private void translateStringToDigit(ArrayList<String> accountStringArray, StringBuffer accountNumber, int startingPosition) {
        int endingPosition = startingPosition + 3;
        if(endingPosition <= 27) {
            StringBuffer digitStringRepresentation = new StringBuffer();
            accountStringArray.forEach(line ->
                    digitStringRepresentation.append(line.substring(startingPosition, endingPosition))
            );
            String translatedDigit = BankOCREnum.getDigitFromStringRepresentation(digitStringRepresentation.toString());
            accountNumber.append(translatedDigit);
            translateStringToDigit(accountStringArray, accountNumber, endingPosition);
        }
    }

    private String addEndingSpaces(String line, int totalLength) {
        int missingSpaces = totalLength - (line != null ? line.length() : 0);
        return (line + new String(new char[missingSpaces]).replace("\0", " "));
    }

}
