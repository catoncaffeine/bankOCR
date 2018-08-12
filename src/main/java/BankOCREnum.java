public enum BankOCREnum {
    ZERO("0",   " _ " +
                "| |" +
                "|_|"),

    ONE("1",    "   " +
                "  |" +
                "  |"),

    TWO("2",    " _ " +
                " _|" +
                "|_ "),

    THREE("3",  " _ " +
                " _|" +
                " _|"),

    FOUR("4",   "   " +
                "|_|" +
                "  |"),

    FIVE("5",   " _ " +
                "|_ " +
                " _|"),

    SIX("6",    " _ " +
                "|_ " +
                "|_|"),

    SEVEN("7",  " _ " +
                "  |" +
                "  |"),

    EIGHT("8",  " _ " +
                "|_|" +
                "|_|"),

    NINE("9",   " _ " +
                "|_|" +
                " _|"),

    UNKNOWN("?", "?");

    private final String stringRepresentation;
    private final String digit;

    BankOCREnum(String digit, String stringRepresentation) {
        this.digit = digit;
        this.stringRepresentation = stringRepresentation;
    }

    public String getDigit() {
        return this.digit;
    }

    public String getStringRepresentation() {
        return this.stringRepresentation;
    }

    public static String getDigitFromStringRepresentation(String stringRepresentation) {
        String digit = BankOCREnum.UNKNOWN.getDigit();
        for (BankOCREnum bankOCREnum : BankOCREnum.values()) {
            if(bankOCREnum.getStringRepresentation().equals(stringRepresentation)) {
                digit = bankOCREnum.getDigit();
            }
        }
        return digit;
    }
}
