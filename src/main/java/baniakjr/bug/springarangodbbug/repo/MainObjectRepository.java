package baniakjr.bug.springarangodbbug.repo;

import baniakjr.bug.springarangodbbug.model.MainObject;
import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainObjectRepository extends ArangoRepository<MainObject, String> {

    Optional<MainObject> findByName(String name);

}
