package gruppe7.turistguide2.Controller;

import gruppe7.turistguide2.Model.Tourist;
import gruppe7.turistguide2.Service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getAllAttractions(Model model) {
        List<Tourist> allAttractions = touristService.getAllAttractions();
        model.addAttribute("attractions", allAttractions);
        return "attractionList";
    }

    @GetMapping("/{name}")
    public String getAttraction(@PathVariable("name") String name, Model model) {
        Tourist attraction = touristService.getAttractionbyName(name);
        model.addAttribute("attraction", attraction);
        return "attractionNames";
    }

    @GetMapping("{name}/tags")
    public String getAttractionTags(@PathVariable("name") String name, Model model) {
        Tourist attraction = touristService.getAttractionbyName(name);
        model.addAttribute("attraction", attraction);
       /* model.addAttribute("tags", tags) */
        return "tags";
    }

    @PostMapping("/add")
    public ResponseEntity<Tourist> addAttraction(@RequestBody Tourist attraction) {
        Tourist  attraction1 = touristService.addAttraction(attraction);
        return new ResponseEntity<>(attraction1, HttpStatus.CREATED);
    }

   // @PostMapping("/save")

    //@PostMapping("/update")



    @PutMapping("/{name}/edit")
    public ResponseEntity<Tourist> updateAttraction(@PathVariable String name, @RequestBody Tourist attraction) { // uden spørgsmålstegn
        Tourist attraction2 = touristService.updateAttraction(attraction);
        return new ResponseEntity<>(attraction2, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Tourist> deleteAttraction(@RequestBody Tourist attraction) { // med spørgsmålstegn
        Tourist attraction3 = touristService.deleteAttraction(attraction);
        return new ResponseEntity<>(attraction3, HttpStatus.OK);
    }

}
