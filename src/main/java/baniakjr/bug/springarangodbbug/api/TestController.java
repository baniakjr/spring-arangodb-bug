package baniakjr.bug.springarangodbbug.api;

import baniakjr.bug.springarangodbbug.model.MainObject;
import baniakjr.bug.springarangodbbug.repo.MainObjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class TestController {

    private final MainObjectRepository repository;

    public TestController(MainObjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "main/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MainObject>> getMainList() {
        List<MainObject> list = new ArrayList<>();
        Iterable<MainObject> result = repository.findAll();
        result.forEach(list::add);
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "main/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MainObject> getMain(@PathVariable(name = "name") String name) {
        Optional<MainObject> objectFromDb = repository.findByName(name);

        if (objectFromDb.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(objectFromDb.get());
    }

    @PostMapping(path = "main/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MainObject> saveMain(@RequestBody MainObject main) {

        Optional<MainObject> objectFromDb = repository.findByName(main.getName());

        if (objectFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(objectFromDb.get());
        }

        main = repository.save(main);

        return ResponseEntity.ok(main);
    }

}
