package gruppe7.turistguide2.Repository;

import gruppe7.turistguide2.Model.Tourist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<Tourist> attractions = new ArrayList<>();
    private int id;

    public TouristRepository() {
        populateAttractions();
    }

    private void populateAttractions() {
        attractions.add(new Tourist("Rundetårn", "Højt rundt tårn i midten af København", "København", List.of("Tårn", "Historisk", "Museum")));
        attractions.add(new Tourist("Eiffel Tower", "Tower in paris", "Paris", List.of("Tårn", "Historisk", "Natur")));
        attractions.add(new Tourist("Lille havfrue", "Kendt dansk figur baseret på H.C Andersens eventyr Den Lille Havfrue", "København", List.of("Eventyr", "Figur")));
    }


    public List<Tourist> getAllAttractions() {
        return attractions;
    }

    public List<String> getTowns() {
        List<String> towns = new ArrayList<>();
        towns.add("København");
        towns.add("Paris");
        towns.add("Odense");
        towns.add("Berlin");
        towns.add("Montevideo");
        towns.add("Luxembough");
        towns.add("Longyearbyen");
        return towns;
    }

    public List<String> getTags() {
        getTags().add("Tårn");
        getTags().add("Historisk");
        getTags().add("Natur");
        getTags().add("Eventyr");
        getTags().add("Museum");
        getTags().add("Figur");
        return getTags();
    }


    public Tourist getAttractionByName(String name) {
        for (Tourist touristAttraction : attractions) {
            if (touristAttraction.getName().equals(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    public List<String> getTagsByName(String name) {
        List<String> tags = new ArrayList<>();
        for (Tourist touristAttraction : attractions) {
            if (touristAttraction.getName().equals(name)) {
                tags.addAll(touristAttraction.getTags());
            }
        }
        return tags;
    }


    public Tourist addAttraction(Tourist attraction) {
        attractions.add(attraction);
        return attraction;
    }


    public Tourist updateAttraction(Tourist attraction) {
        int index = attractions.indexOf(attraction);
        attractions.set(index, attraction);
        return attraction;
    }

    public void deleteAttraction(Tourist attraction) {
        attractions.remove(attraction);
    }

    public List<Tourist> addAttractionList(Tourist attraction) {
        attractions.add(attraction);
        return attractions;
    }

}
