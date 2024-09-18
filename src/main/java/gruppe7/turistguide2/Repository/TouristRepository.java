package gruppe7.turistguide2.Repository;

import gruppe7.turistguide2.Model.Tourist;

import java.util.ArrayList;
import java.util.List;

public class TouristRepository {
    private final List<Tourist> attractions = new ArrayList<>();
    private int id;
    private final List<String> towns = new ArrayList<>();
    public TouristRepository(){
        populateAttractions();
    }
    public List<String>getTown(){
        towns.add("København");
        towns.add("Paris");
        towns.add("Odense");
        towns.add("Berlin");
        towns.add("Montevideo");
        towns.add("Luxembough");
        towns.add("Longyearbyen");
        return towns;
    }

    public List<String>getTags(){
        getTags().add("Tårn");
        getTags().add("Historisk");
        getTags().add("Natur");
        getTags().add("Eventyr");
        getTags().add("Museum");
        getTags().add("Figur");
        return getTags();
    }
    private void populateAttractions() {
        attractions.add(new Tourist("Rundetårn","Højt rundt tårn i midten af København", "København" ,List.of("Tårn","Historisk","Museum")));
        attractions.add(new Tourist("Eiffel Tower", "Tower in paris","Paris", List.of("Tårn","Historisk","Natur")));
        attractions.add(new Tourist("Lille havfrue","Kendt dansk figur baseret på H.C Andersens eventyr Den Lille Havfrue", "København",List.of("Eventyr","Figur")));
    }


    public List<Tourist> getAllAttractions() {
        return attractions;
    }


    public Tourist getAttractionByName(String name) {
        for (Tourist touristAttraction : attractions) {
            if (touristAttraction.getName().equals(name)) {
                return touristAttraction;
            }
        }
        return null;
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

    public Tourist deleteAttraction(String name) {
        for(int i = 0; i<attractions.size(); i++) {
            Tourist attraction = attractions.get(i);
            if (attraction.getName().equals(name)) {
                attractions.remove(i);
                return attraction;
            }
        }
        return null;
    }
}
