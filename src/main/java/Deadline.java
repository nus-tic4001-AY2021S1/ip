class Deadline extends Todo{
    private String[] split;

    Deadline(String input) {
        super(input);
        split = input.split("/by");
    }
}
