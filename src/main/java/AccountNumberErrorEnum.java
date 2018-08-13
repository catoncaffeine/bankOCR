public enum AccountNumberErrorEnum {
    VALID(""),
    ERROR("ERR"),
    ILLEGAL("ILL");

    String value;

    AccountNumberErrorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
