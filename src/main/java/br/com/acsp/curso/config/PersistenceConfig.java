package br.com.acsp.curso.config;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.LoggingEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


/**
 * User: Christian Reichel
 * Date: 8/10/13
 * Time: 1:31 AM
 */
@Configuration
@EnableMongoRepositories(basePackages = "br.com.acsp.curso.domain")
public class PersistenceConfig extends AbstractMongoConfiguration {

    //TODO: put outside
    @Override
    protected String getDatabaseName() {
        return "acsp-db";
    }

    //TODO: put outside
    @Override
    public Mongo mongo() throws Exception {
        //mongodb://acsp-dbuser:31337pass@ds039487.mongolab.com:39487/acsp-db
        final Mongo mongo = new Mongo("ds039487.mongolab.com", 39487);
        mongo.setWriteConcern(WriteConcern.SAFE);
        return mongo;
    }

    //TODO: put outside
    @Override
    protected UserCredentials getUserCredentials() {
        final UserCredentials credentials = new UserCredentials("acsp-dbuser", "31337pass");
        return credentials;
    }

    @Override
    protected String getMappingBasePackage() {
        return "br.com.acsp.curso.domain";
    }

    @Bean
    public LoggingEventListener loggingEventListener(){
        return new LoggingEventListener();
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception{
        return new MongoTemplate(mongo(), getDatabaseName(), getUserCredentials());
    }

}
