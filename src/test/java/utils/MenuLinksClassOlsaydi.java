package utils;

public class MenuLinksClassOlsaydi {


    private String[] links;

    MenuLinksClassOlsaydi(String... links) {
        this.links = links;
    }

    public String[] getLinks() {
        return links;
    }

    public static void main(String[] args) {
       MenuLinksClassOlsaydi Users = new MenuLinksClassOlsaydi("Admin", "User Management", "Users");
       MenuLinksClassOlsaydi Apply = new MenuLinksClassOlsaydi("Leave", "Apply");

    }
}
