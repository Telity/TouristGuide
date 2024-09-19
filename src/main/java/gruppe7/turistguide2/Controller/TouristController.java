package gruppe7.turistguide2.Controller;

import gruppe7.turistguide2.Model.Tourist;
import gruppe7.turistguide2.Service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getTag(@PathVariable("name") String name, Model model) {
        List<String> tags = touristService.getTagsByName(name);
        model.addAttribute("tags", tags);
        return "tags";
    }

    @GetMapping("/add")
    public String addAttraction(Model model) {
        //adding list with tags options
        List<String> attractionTags = touristService.getTagsList();
        //makes a new tourist that will get values from the html
        Tourist attraction = new Tourist();
        model.addAttribute("attractionTags", attractionTags);
        model.addAttribute("attraction", attraction);
        return "addAttraction";
    }

    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute Tourist attraction) {
        touristService.AddAttractionsList(attraction);
        return "redirect:/attractions";
    }
    @GetMapping("/{name}/edit")
    public String editAttraction(@PathVariable("name")String name, Model model) { // uden spørgsmålstegn
        Tourist attraction = touristService.getAttractionbyName(name);
        model.addAttribute("attraction",attraction);
        model.addAttribute("tags",touristService.getTagsList());
        model.addAttribute("towns",touristService.getTownList());
        return "updateAttraction";
    }
    @PostMapping("/update")
    public String updatesAttraction(@ModelAttribute Tourist attraction) {
        touristService.updateAttraction(attraction);
        return "redirect:/attractions";
    }


    /*@DeleteMapping("/delete/{name}")
    public ResponseEntity<Tourist> deleteAttraction(@RequestBody Tourist attraction) { // med spørgsmålstegn
        Tourist attraction3 = touristService.deleteAttraction(attraction);
        return new ResponseEntity<>(attraction3, HttpStatus.OK);
    }*/

}



