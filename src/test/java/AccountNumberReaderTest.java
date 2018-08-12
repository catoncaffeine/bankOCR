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

    @Test
    public void testReadAccountNumber_1s() {
        try {
            ArrayList<String> output = accountNumberReader.readAccountNumber("src/main/resources/ones.txt");
            assert(output.get(0)).equals("111111111");
        } catch (IOException e) {

        }
    }

    @Test
    public void testReadAccountNumber_2s() {
        try {
            ArrayList<String> output = accountNumberReader.readAccountNumber("src/main/resources/twos.txt");
            assert(output.get(0)).equals("222222222");
        } catch (IOException e) {

        }
    }

    @Test
    public void testReadAccountNumber_3s() {
        try {
            ArrayList<String> output = accountNumberReader.readAccountNumber("src/main/resources/threes.txt");
            assert(output.get(0)).equals("333333333");
        } catch (IOException e) {

        }
    }

    @Test
    public void testReadAccountNumber_4s() {
        try {
            ArrayList<String> output = accountNumberReader.readAccountNumber("src/main/resources/fours.txt");
            assert(output.get(0)).equals("444444444");
        } catch (IOException e) {

        }
    }

    @Test
    public void testReadAccountNumber_5s() {
        try {
            ArrayList<String> output = accountNumberReader.readAccountNumber("src/main/resources/fives.txt");
            assert(output.get(0)).equals("555555555");
        } catch (IOException e) {

        }
    }

    @Test
    public void testReadAccountNumber_6s() {
        try {
            ArrayList<String> output = accountNumberReader.readAccountNumber("src/main/resources/sixes.txt");
            assert(output.get(0)).equals("666666666");
        } catch (IOException e) {

        }
    }

    @Test
    public void testReadAccountNumber_7s() {
        try {
            ArrayList<String> output = accountNumberReader.readAccountNumber("src/main/resources/sevens.txt");
            assert(output.get(0)).equals("777777777");
        } catch (IOException e) {

        }
    }

    @Test
    public void testReadAccountNumber_8s() {
        try {
            ArrayList<String> output = accountNumberReader.readAccountNumber("src/main/resources/eights.txt");
            assert(output.get(0)).equals("888888888");
        } catch (IOException e) {

        }
    }

    @Test
    public void testReadAccountNumber_9s() {
        try {
            ArrayList<String> output = accountNumberReader.readAccountNumber("src/main/resources/nines.txt");
            assert(output.get(0)).equals("999999999");
        } catch (IOException e) {

        }
    }

    @Test
    public void testReadAccountNumber_NaNs() {
        try {
            ArrayList<String> output = accountNumberReader.readAccountNumber("src/main/resources/nans.txt");
            assert(output.get(0)).equals("?????????");
        } catch (IOException e) {

        }
    }

    @Test
    public void testReadAccountNumber_multi() {
        try {
            ArrayList<String> output = accountNumberReader.readAccountNumber("src/main/resources/multi.txt");
            assert(output.get(0)).equals("012345678");
            assert(output.get(1)).equals("123456789");
        } catch (IOException e) {

        }
    }
}