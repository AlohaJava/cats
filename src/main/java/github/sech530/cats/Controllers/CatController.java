package github.sech530.cats.Controllers;

import github.sech530.cats.Models.Cat;
import github.sech530.cats.Services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CatController {

    private CatService catService;

    @Autowired
    public void setNoteService(CatService catService) {
        this.catService = catService;
    }

    @GetMapping(value="/cats")
    public List<Cat> getAllCats(){
        List<Cat> cats = catService.getAll();
        return cats;
    }

    @PostMapping(value = "/cats")
    public String addCat(@RequestBody Cat cat){
        catService.add(cat);
        return "Ok";
    }

    @RequestMapping(
            value = "/cats/{id}",
            method = RequestMethod.DELETE)
    public String deleteCat(@PathVariable Integer id){
        catService.delete(id);
        return "Ok";
    }

    @RequestMapping(
            value = "/cats",
            method = RequestMethod.PATCH)
    public String patchCat(@RequestBody Cat cat){
        catService.update(cat);
        return "Ok";
    }

    @RequestMapping(
            value = "/cats/{id}",
            method = RequestMethod.GET)
    public Cat getById(@PathVariable Integer id){
        return catService.getById(id);
    }

}