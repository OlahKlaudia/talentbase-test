package mainbase.browserenum;

public enum LinksEnum {

    ABOUT_US  ("/about"),
    CONTACT_US ( "/contact"),
    PARTNER_INVESTORS  ("/partners"),
    OUR_POLICY  ("/privacyPolicy"),
    TERMS_OF_SERVICE  ("/termsOfService");

    public final String link;

    LinksEnum(String LinkName) {
        this.link= LinkName;
    }

    public String toString() {
        return link;
    }
}
