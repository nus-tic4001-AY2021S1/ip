package com.example.duke;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath=filePath;
    }

    public ArrayList<Task> load() {
        return CreateTaskFromFile.getTasksFromFile(filePath);
    }
}



