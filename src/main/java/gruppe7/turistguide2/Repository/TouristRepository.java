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
    private final List<String> towns = new ArrayList<>();
    private final List<String> tagsList = new ArrayList<>();
    public TouristRepository(){
        populateAttractions();
        populateTagsList();
        populateTownList();
    }
    public List<String>getTownList(){

        return towns;
    }
    private void populateTownList(){
        towns.add("København");
        towns.add("Paris");
        towns.add("Odense");
        towns.add("Berlin");
        towns.add("Montevideo");
        towns.add("Luxembough");
        towns.add("Longyearbyen");
    }

    public List<String>getTagsList(){
        return getTagsList();
    }
    private void populateTagsList(){
        tagsList.add("Tårn");
        tagsList.add("Historisk");
        tagsList.add("Natur");
        tagsList.add("Eventyr");
        tagsList.add("Museum");
        tagsList.add("Figur");
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


    public List<Tourist> addAttractionList(Tourist attraction) {
        attractions.add(attraction);
        return attractions;
    }

}
