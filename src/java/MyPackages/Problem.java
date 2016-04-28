package MyPackages;

public class Problem {
    private int id;
    private String name;
    private String description;
    private String input;
    private String output;
    private String samples;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.replace("\n", "<br />\n");
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input.replace("\n", "<br />\n");
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output.replace("\n", "<br />\n");
    }

    public String getSamples() {
        return samples;
    }

    public void setSamples(String samples) {
        this.samples = samples.replace("\n", "<br />\n");
    }
            
}
