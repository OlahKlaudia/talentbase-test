package mainbase.mainenum;

public enum FooterElementsEnum {
//    footer,
//    designers,
//    developers,
//    financialExperts,
    WHY_US_LINK("Scroll down, click to the why us link, and return Why us page."),
    BLOG("Scroll down, click to the Blog link, and return Blog page."),
    PARTNERS_AND_INVESTORS("Scroll down, click to the Partners and investors link, and return Partners and Investors page."),
    CONTACT_US("Scroll down, click to the Contact us link, and return Contact us page."),
    LOOKING_FOR_WORK("Scroll down, click to the Looking for work, and return Looking for work page."),
    OUR_POLICY("Scroll down, click to the Our policy link, and return Our policy page."),
    WEBSITE_TERMS("Scroll down, click to the Website terms link, and return Website terms page.");
    public final String footerElementLinks;

    FooterElementsEnum(String footerLinks) {
        this.footerElementLinks = footerLinks;
    }

    public String toString() {
        return footerElementLinks;
    }
}
