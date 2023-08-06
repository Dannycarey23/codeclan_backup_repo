package flights;

public enum AirportID {

    GLASGOW("GLA"),
    MAGALUF("PMI"),
    SHETLAND("LWK"),
    BORABORA("BOB");

    private final String code;

    AirportID(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
