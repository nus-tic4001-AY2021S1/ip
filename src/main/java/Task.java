import java.util.*;

public class Task {
    public static final String descriptionPrefix = "description: ";
    private String description;
    private boolean important;
    List<String> pastDescription = new ArrayList<>(); // a list of past descriptions

    public Task(String d) {
      this.description = d;
      if (!d.isEmpty())
          this.important = true;
    }

    public String getAsXML() { return "<task>"+description+"</task>"; }

    /**
     * Print the description as a string.
     */
    public void printingDescription(){ System.out.println(this); }

    @Override
    public String toString() { return descriptionPrefix + description; }
}
