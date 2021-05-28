package utils;

public enum MenuLinks {
    Users ("Admin","User Management","Users"),
    Apply ("Leave","Apply")
    ;

    private String [] links;

    MenuLinks(String...links) {
        this.links = links;
    }

    public String[] getLinks() {
        return links;
    }
}
