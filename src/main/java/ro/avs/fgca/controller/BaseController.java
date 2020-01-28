package ro.avs.fgca.controller;

import org.springframework.web.bind.annotation.*;
import ro.avs.fgca.model.BaseEntity;
import ro.avs.fgca.model.ChangesDTO;
import ro.avs.fgca.service.BaseService;

import java.util.List;
import java.util.concurrent.ExecutionException;

public abstract class BaseController<T extends BaseEntity> {

    private BaseService<T> service;

    public BaseController(BaseService<T> service) {
        this.service = service;
    }

    @PostMapping("/create")
    public void save(@RequestBody T entry) {
        service.addDocument(entry);
    }

    @GetMapping("/all")
    public List<T> getAll() throws ExecutionException, InterruptedException {
        return service.getAll();
    }

    @GetMapping("/read")
    public T getById(@RequestParam String id) throws ExecutionException, InterruptedException {
        return service.getById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody T entry) {
        service.updateDocument(entry);
    }

    @PutMapping("/update-fields")
    public void update(@RequestBody ChangesDTO changes) {
        service.updateDocument(changes);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String id) {
        service.deleteDocument(id);
    }
}
