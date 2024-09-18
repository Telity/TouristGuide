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

    public Tourist updateAttraction(Tourist attraction) {
        return touristRepository.updateAttraction(attraction);
    }

    public Tourist deleteAttraction(Tourist attraction) {
        return touristRepository.deleteAttraction(attraction);
    }

}
