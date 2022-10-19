package mainbase.mainenum;

public enum AsTalentLinksEnum {
    TERMS_OF_SERVICE("Click to the terms of service, and return Terms of Service page."),
    PRIVACY_POLICY("Click to the privacy policy, and return Privacy policy page."),
    REGISTER_CORPORATION("Scroll down, click to the register corporation, and return Register corporation page."),

    SIGN_IN("Scroll down, click to the sign in, and return Sign in page.");
    public final String registrationAsTalentPageLinks;

    AsTalentLinksEnum(String asTalentLink) {
        this.registrationAsTalentPageLinks = asTalentLink;
    }

    public String toString() {
        return registrationAsTalentPageLinks;
    }
}
