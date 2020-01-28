package ro.avs.fgca.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ro.avs.fgca.model.BaseEntity;
import ro.avs.fgca.service.BaseService;

import java.util.List;
import java.util.concurrent.ExecutionException;

public abstract class BaseController<T extends BaseEntity> {

    private BaseService<T> service;

    public BaseController(BaseService<T> service) {
        this.service = service;
    }

    @PostMapping("/create")
    public void save(T entry) {
        service.addDocument(entry);
    }

    @GetMapping("/all")
    public List<T> getAll() throws ExecutionException, InterruptedException {
        return service.getAll();
    }

    @GetMapping("/read")
    public T getById(String id) throws ExecutionException, InterruptedException {
        return service.getById(id);
    }

    @PutMapping("/update")
    public void update(T entry) {
        service.updateDocument(entry);
    }

    @DeleteMapping("/delete")
    public void delete(String id) {
        service.deleteDocument(id);
    }
}
