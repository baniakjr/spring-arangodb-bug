package baniakjr.bug.springarangodbbug;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "bug")
public class ApplicationProperties {

    private ArangoDbProperties arangoDbProperties;

    public ArangoDbProperties getArangoDbProperties() {
        return arangoDbProperties;
    }

    public void setArangoDbProperties(ArangoDbProperties arangoDbProperties) {
        this.arangoDbProperties = arangoDbProperties;
    }

    public record ArangoDbProperties(
            String host,
            String user,
            Integer port,
            String password,
            String name) {
    }
}
