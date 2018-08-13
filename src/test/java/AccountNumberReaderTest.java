import org.junit.*;
import java.io.IOException;
import java.util.ArrayList;

public class AccountNumberReaderTest {
    AccountNumberReader accountNumberReader = new AccountNumberReader();

    @Test
    public void testGetAccountNumbers_0s() {
        try {
            ArrayList<String> output = accountNumberReader.getAccountNumbers("src/main/resources/zeros.txt");
            assert(output.get(0)).equals("000000000");
        } catch (IOException e) {

        }
    }

    @Test
    public void testGetAccountNumbers_1s() {
        try {
            ArrayList<String> output = accountNumberReader.getAccountNumbers("src/main/resources/ones.txt");
            assert(output.get(0)).equals("111111111");
        } catch (IOException e) {

        }
    }

    @Test
    public void testGetAccountNumbers_2s() {
        try {
            ArrayList<String> output = accountNumberReader.getAccountNumbers("src/main/resources/twos.txt");
            assert(output.get(0)).equals("222222222");
        } catch (IOException e) {

        }
    }

    @Test
    public void testGetAccountNumbers_3s() {
        try {
            ArrayList<String> output = accountNumberReader.getAccountNumbers("src/main/resources/threes.txt");
            assert(output.get(0)).equals("333333333");
        } catch (IOException e) {

        }
    }

    @Test
    public void testGetAccountNumbers_4s() {
        try {
            ArrayList<String> output = accountNumberReader.getAccountNumbers("src/main/resources/fours.txt");
            assert(output.get(0)).equals("444444444");
        } catch (IOException e) {

        }
    }

    @Test
    public void testGetAccountNumbers_5s() {
        try {
            ArrayList<String> output = accountNumberReader.getAccountNumbers("src/main/resources/fives.txt");
            assert(output.get(0)).equals("555555555");
        } catch (IOException e) {

        }
    }

    @Test
    public void testGetAccountNumbers_6s() {
        try {
            ArrayList<String> output = accountNumberReader.getAccountNumbers("src/main/resources/sixes.txt");
            assert(output.get(0)).equals("666666666");
        } catch (IOException e) {

        }
    }

    @Test
    public void testGetAccountNumbers_7s() {
        try {
            ArrayList<String> output = accountNumberReader.getAccountNumbers("src/main/resources/sevens.txt");
            assert(output.get(0)).equals("777777777");
        } catch (IOException e) {

        }
    }

    @Test
    public void testGetAccountNumbers_8s() {
        try {
            ArrayList<String> output = accountNumberReader.getAccountNumbers("src/main/resources/eights.txt");
            assert(output.get(0)).equals("888888888");
        } catch (IOException e) {

        }
    }

    @Test
    public void testGetAccountNumbers_9s() {
        try {
            ArrayList<String> output = accountNumberReader.getAccountNumbers("src/main/resources/nines.txt");
            assert(output.get(0)).equals("999999999");
        } catch (IOException e) {

        }
    }

    @Test
    public void testGetAccountNumbers_NaNs() {
        try {
            ArrayList<String> output = accountNumberReader.getAccountNumbers("src/main/resources/nans.txt");
            assert(output.get(0)).equals("?????????");
        } catch (IOException e) {

        }
    }

    @Test
    public void testGetAccountNumbers_multi() {
        try {
            ArrayList<String> output = accountNumberReader.getAccountNumbers("src/main/resources/multi.txt");
            assert(output.get(0)).equals("012345678");
            assert(output.get(1)).equals("123456789");
        } catch (IOException e) {

        }
    }
}