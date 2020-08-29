class Todo extends Task{

    Todo(String input) {
        super(input);
    }

    Todo(String input, boolean isDone) {
        super(input);
        setDone(isDone);
    }
}
