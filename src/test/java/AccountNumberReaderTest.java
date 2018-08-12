import org.junit.*;
import java.io.IOException;
import java.util.ArrayList;

public class AccountNumberReaderTest {
    AccountNumberReader accountNumberReader = new AccountNumberReader();

    @Test
    public void testReadAccountNumber_0s() {
        try {
            ArrayList<String> output = accountNumberReader.readAccountNumber("src/main/resources/zeros.txt");
            assert(output.get(0)).equals("000000000");
        } catch (IOException e) {

        }
    }
}