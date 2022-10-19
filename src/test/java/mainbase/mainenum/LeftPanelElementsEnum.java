package mainbase.mainenum;

public enum LeftPanelElementsEnum {
    START("Click to the Start link, and return Start page."),
    OVERVIEW("Click to the Oveview link, and return Home page."),
    ACCOUNT_DETAILS("Click to the Account details link, and return Account details page."),
    INTRO_DESCRIPTION("Click to the Intro description des link, and return Intro description page."),
    EXPERIENCE("Click to the Experience link, and return Experience page."),
    EDUCATION("Click to the Education link, and return Education page."),
    SKILLS("Click to the Skills link, and return Skills page."),
    LANGUAGE("Click to the Language link, and return Language page."),
    CERTIFICATES("Click to the Certificates link, and return Certificates page."),
    PROJECTS("Click to the Project link, and return Project page."),
    HOBBIES("Click to the Hobbies link, and return Hobbies page."),
    SOCIAL_LINKS("Click to the Social Link link, and return Social link page."),
    CLICK("Click to the Click, and see the Social links"),
    USER_TERMS("Click to the User terms link, and return User terms page."),
    EVOLUTION("Click to the Evolution link, and return Evolution page."),
    SEARCH_THE_BASE("Click to the Search the base link, and return Search the base page."),
    MY_BASE("Click to the My base link, and return My base page.");

    public final String leftPanelElementsLink;

    LeftPanelElementsEnum(String leftPanelLinks) {
        this.leftPanelElementsLink = leftPanelLinks;
    }

    public String toString() {
        return leftPanelElementsLink;
    }
}
