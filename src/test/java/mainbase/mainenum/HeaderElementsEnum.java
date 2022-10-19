package mainbase.mainenum;

public enum HeaderElementsEnum {
    HOME("Click to the Home link, and return Home page."),
    TALENTBASE_LOGO("Click to the Talentbase logo link, and return Talentbase logo page."),
    PARTNERS_AND_INVESTORS("Click to the Partners and Investors link, and return Partners and Investors page."),
    LOOKING_FOR_WORK("Click to the Looking for work link, and return Looking for work page."),
    ABOUT("Click to the About link, and return About page."),
    CONTACT("Click to the Contact link, and return Contact page."),
    SALARY("Click to the Salary link, and return Salary page."),
    BLOG("Click to the Blog link, and return Blog page."),
    NOTIFICATION("Click to the Notification link, and return Notification page."),
    PROFILE("Click to the Profile link, and return Profile page."),
    BASE("Click to the Base link, and return Base page."),
    SIGN_OUT("Click to the Sign out link, and return Sign out page."),
    APPLY_AS_TALENT("Click to the Apply as talent link, and return Apply as talent page."),
    HIRE_TALENT("Click to the Hire talent link, and return Hire talent page."),
    SIGN_IN("Click to the Sign in link, and return Sign in page.");
    public final String headerElementLinks;

    HeaderElementsEnum(String headerLink) {
        this.headerElementLinks = headerLink;
    }

    public String toString() {
        return headerElementLinks;
    }
}
