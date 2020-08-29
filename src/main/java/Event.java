class Event extends Todo{
    private String[] split;

    Event(String input) {
        super(input);
        split = input.split("/at");
    }
}
