public enum BankOCREnum {
    ZERO("0",   " _ " +
                "| |" +
                "|_|"),

    ONE("1", "ONE"),
    TWO("2", "TWO"),
    THREE("3", "THREE"),
    FOUR("4", "FOUR"),
    FIVE("5", "FIVE"),
    SIX("6", "SIX"),
    SEVEN("7", "SEVEN"),
    EIGHT("8", "EIGHT"),
    NINE("9", "NINE"),
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
