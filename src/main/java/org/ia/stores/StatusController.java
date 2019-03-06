package org.ia.stores;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatusController {

    private StatusStorage statusStorage;

    public  StatusController(StatusStorage statusStorage){
        this.statusStorage = statusStorage;
    }

    @PostMapping("/addstatus")
    public Status create(@RequestBody Status status){
        return statusStorage.save(status);
    }

    @GetMapping("/status")
    public List<Status> findProducts(){
        return statusStorage.findAll();
    }

    @GetMapping("/status/{id}")
    public Status findProduct(@PathVariable Long id){
        return statusStorage.findById(id)
                .orElseThrow( () -> new StatusException("Status with Id: "+id+" does not exist"));
    }

    @PutMapping("/status/{id}")
    public Status change(@RequestBody Status status, @PathVariable Long id) {
        return statusStorage.findById(id).map(storedProduct -> {
            storedProduct.setModel(status.getModel());
            storedProduct.setPrice(status.getPrice());
            storedProduct.setStored(status.getStored());
            return statusStorage.save(storedProduct);
        }).orElseThrow(() -> new StatusException("There is no status with such id."));
    }





}
