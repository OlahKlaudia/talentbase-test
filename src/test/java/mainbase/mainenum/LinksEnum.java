package mainbase.mainenum;

public enum LinksEnum {
    LINKED_IN("Scroll down,and get Linked in href."),
    FACEBOOK("Scroll down,and get Facebook href."),
    TWITTER("Scroll down,and get Twitter href."),
    MAIL("Scroll down,and get Mail href.");
    public final String socialLinks;

    LinksEnum(String socialLink) {
        this.socialLinks = socialLink;
    }

    public String toString() {
        return socialLinks;
    }
}
