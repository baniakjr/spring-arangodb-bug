package baniakjr.bug.springarangodbbug.model;

import com.arangodb.springframework.annotation.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

@Document("Main")
public class MainObject {

    @Id
    @JsonIgnore
    private String id;

    private String name;

    private MapObject attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapObject getAttributes() {
        return attributes;
    }

    public void setAttributes(MapObject attributes) {
        this.attributes = attributes;
    }
}
