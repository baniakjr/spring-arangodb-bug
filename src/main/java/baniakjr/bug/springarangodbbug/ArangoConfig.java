package baniakjr.bug.springarangodbbug;

import com.arangodb.ArangoDB;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@EnableArangoRepositories(basePackages = {"baniakjr.bug.springarangodbbug.repo"})
public class ArangoConfig implements ArangoConfiguration {
    private final ApplicationProperties properties;

    public ArangoConfig(ApplicationProperties properties) {
        this.properties = properties;
    }

    @Override
    public ArangoDB.Builder arango() {
        ArangoDB.Builder builder = new ArangoDB.Builder()
                .host(properties.getArangoDbProperties().host(), properties.getArangoDbProperties().port())
                .user(properties.getArangoDbProperties().user());

        if (StringUtils.hasLength(properties.getArangoDbProperties().password())) {
            builder.password(properties.getArangoDbProperties().password());
        }

        return builder;
    }

    @Override
    public String database() {
        return properties.getArangoDbProperties().name();
    }

}
