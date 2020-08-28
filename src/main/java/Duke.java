public class Duke {
    public static void main(String[] args) {
        String logo = "  __          __ \n"
                + "  | | ____    | | ____\n"
                + "  | |/ __ \\   | |/ __ \\\n"
                + "__/ | |__| |__/ | |__| |\n"
                + "\\__/ \\____/ \\__/ \\____/\n";
        System.out.println("Hello from\n" + logo);
        Ui ui = new Ui();
        ui.greetUser();
        ui.farewellUser();
    }
}
