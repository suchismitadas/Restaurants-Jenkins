package com.example.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
class RestaurantController {

    private final RestaurantRepository repository;

    RestaurantController(RestaurantRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method=RequestMethod.GET, value="/items")
    List<Restaurant> allRestaurants() {
        return repository.findAll();
    }

    @PostMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    Restaurant newItem(@RequestBody Restaurant item) {
        return repository.save(item);
    }

    // Single item

    @GetMapping("/items/{id}")
    Restaurant getRestaurant(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
    }

    @GetMapping("/itemsrp")
    Restaurant getRestaurantrp(@RequestParam(value = "id",
            defaultValue = "1", required = false) Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
    }

    @PutMapping("/items/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    Restaurant updateRestaurant(@RequestBody Restaurant newItem, @PathVariable Long id) {
        return repository.findById(id)
                .map(item -> {
                    item.setName(newItem.getName());
                    item.setCity(newItem.getCity());
                    item.setRating(newItem.getRating());
                    return repository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return repository.save(newItem);
                });
    }

    @DeleteMapping("/items/{id}")
    void deleteRestaurant(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
