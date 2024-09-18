package gruppe7.turistguide2.Model;

import java.util.ArrayList;
import java.util.List;

public class Tourist {

    private String name;
    private String description;
    private String town;
    private List<String> tags = new ArrayList<>();

    public Tourist(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Tourist() {

    }

    public String getName() {
        return name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
