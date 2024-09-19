package gruppe7.turistguide2.Service;

import gruppe7.turistguide2.Model.Tourist;
import gruppe7.turistguide2.Repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TouristService {

    public final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<Tourist> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }

    public Tourist getAttractionbyName(String name) {
        return touristRepository.getAttractionByName(name);
    }

    public Tourist addAttraction(Tourist attraction) {
        return touristRepository.addAttraction(attraction);
    }

    public Tourist updateAttraction(String name, Tourist updatedAttraction) {
        Tourist existingAttraction = touristRepository.getAttractionByName(name);
        if(existingAttraction == null){
            throw new RuntimeException("Attraction not found");
        }

        existingAttraction.setDescription(updatedAttraction.getDescription());
        existingAttraction.setName(updatedAttraction.getTown());
        existingAttraction.setTags(updatedAttraction.getTags());

        return touristRepository.updateAttraction(existingAttraction);
    }

    /*public Tourist deleteAttraction(Tourist attraction) {
        return touristRepository.deleteAttraction(attraction);
    }*/

    public List<String> getTagsList() {
        return touristRepository.getTagsList();
    }

    public List<Tourist> AddAttractionsList(Tourist attraction) {
        touristRepository.addAttraction(attraction);
        return touristRepository.getAllAttractions();
    }
    public List<String> getTagsByName(String name){
        return touristRepository.getTagsByName(name);
    }
    public Object getTownList() {
        return touristRepository.getTownList();
    }
}
