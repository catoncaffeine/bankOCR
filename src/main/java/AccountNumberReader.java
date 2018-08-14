import java.io.*;
import java.util.ArrayList;

// TODO: Story 1 - handle exception more gracefully
// TODO: Make it so that this can process any number of digits
// TODO: Name variables with more meaningful names

public class AccountNumberReader {

    public ArrayList<String> getAccountNumbers(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<String> translatedAccountNumbers = new ArrayList();
        readAccountNumbers(reader, translatedAccountNumbers);
        return translatedAccountNumbers;
    }

    // TODO: use a more specific exception
    private void readAccountNumbers(BufferedReader reader, ArrayList<String> translatedAccountNumbers) throws IOException{
        ArrayList<String> accountStringArray = generateAccountStringArray(reader);
        // if the generated [top, middle, bottom] array does not include all 3 components
        // assume to be the end of the file and do not process
        if(accountStringArray.size() == 3) {
            // combine all digit into single string
            StringBuffer fullStringRep = new StringBuffer();
            translateStringToDigit(accountStringArray, fullStringRep, 0);
            // once have the full string representation of all 9 numbers, translate it into digits
            StringBuffer translatedAccountNum = new StringBuffer();
            translateFullAccountNumber(fullStringRep, translatedAccountNum, 0);
            // add the translated full account number to the list of outputs
            translatedAccountNumbers.add(translatedAccountNum.toString());
            // do it again
            readAccountNumbers(reader, translatedAccountNumbers);
        }
    }

    // TODO: check what happens if IO Exception
    // TODO: use a more specific exception
    private ArrayList<String> generateAccountStringArray(BufferedReader reader) throws IOException{
        // reading 4 lines at a time to generate one account id,
        // stored in a string array of 3 -> [top, middle, bottom]
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

    // TODO: extract this to a utility class, can this be static
    private void translateStringToDigit(ArrayList<String> accountStringArray, StringBuffer accountNumberStrRep,  int startingPosition) {
        int endingPosition = startingPosition + 3;
        if(endingPosition <= 27) { // TODO: use digitLength * 3
            StringBuffer digitStringRepresentation = new StringBuffer();
            accountStringArray.forEach(line ->
                digitStringRepresentation.append(line.substring(startingPosition, endingPosition))
            );
            accountNumberStrRep.append(digitStringRepresentation);
            translateStringToDigit(accountStringArray, accountNumberStrRep, endingPosition);
        }
    }

    // TODO: extract this to a utility class, can this be static
    private void translateFullAccountNumber(StringBuffer accountNumberStrRep, StringBuffer accountNumber, int startingPosition) {
        int endingPosition = startingPosition + 9;
        if(endingPosition <= 81) { // TODO: use digitLength * 9
            String digitStrRep = accountNumberStrRep.substring(startingPosition, endingPosition);
            String translatedDigit = BankOCREnum.getDigitFromStringRepresentation(digitStrRep);
            accountNumber.append(translatedDigit);
            translateFullAccountNumber(accountNumberStrRep, accountNumber, endingPosition);
        }
    }

    // TODO: extract this to a utility class, can this be static
    private String addEndingSpaces(String line, int totalLength) {
        int missingSpaces = totalLength - (line != null ? line.length() : 0);
        return (line + new String(new char[missingSpaces]).replace("\0", " "));
    }

}
