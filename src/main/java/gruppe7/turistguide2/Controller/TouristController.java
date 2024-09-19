package gruppe7.turistguide2.Controller;

import ch.qos.logback.core.model.Model;
import gruppe7.turistguide2.Model.Tourist;
import gruppe7.turistguide2.Service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    public final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("")
    public ResponseEntity<List<Tourist>> getAllAttractions() {
        List<Tourist> attractions = touristService.getAllAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Tourist> getAttraction(@PathVariable String name) {
        Tourist attraction = touristService.getAttractionbyName(name);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    @GetMapping("{name}/tags")


    @PostMapping("/add")
    public ResponseEntity<Tourist> addAttraction(@RequestBody Tourist attraction) {
        Tourist  attraction1 = touristService.addAttraction(attraction);
        return new ResponseEntity<>(attraction1, HttpStatus.CREATED);

    //@PostMapping("/save")


    }
    @GetMapping("/{name}/edit")
    public String editAttraction(@PathVariable  ("name")String name, ModelMap model) { // uden spørgsmålstegn
        Tourist attraction = touristService.getAttractionbyName(name);
            model.addAttribute("attraction",attraction);
            model.addAttribute("tags",touristService.getTagsList());
            model.addAttribute("town",touristService.getTownList());
            return "updateAttraction";
    }
    @PostMapping("/update")
    public ResponseEntity<Tourist> updateAttraction(@RequestBody Tourist updatedAttraction) {

            Tourist  updatedTourist = touristService.updateAttraction(updatedAttraction.getName(), updatedAttraction);
            return new ResponseEntity<>(updatedTourist, HttpStatus.OK);
    }


    /*@DeleteMapping("/delete/{name}")
    public ResponseEntity<Tourist> deleteAttraction(@RequestBody Tourist attraction) { // med spørgsmålstegn
        Tourist attraction3 = touristService.deleteAttraction(attraction);
        return new ResponseEntity<>(attraction3, HttpStatus.OK);
    }*/

}
