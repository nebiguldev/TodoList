package hepsiemlak.todolist.TodoList.config;

import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.mapping.event.ValidatingCouchbaseEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    public static final String NODE_LIST = "localhost";
    public static final String BUCKET_NAME = "beer-sample";
    public static final String BUCKET_USERNAME = "nebi";
    public static final String BUCKET_PASSWORD = "123456";

    @Override
    public String getConnectionString() {
        return NODE_LIST; // Couchbase sunucusunun adresi
    }

    @Override
    public String getPassword() {
        return BUCKET_PASSWORD; // Parola
    }

    @Override
    public String getUserName() {
        return BUCKET_USERNAME; // Bucket için kullanıcı adı
    }

    @Override
    public String getBucketName() {
        return BUCKET_NAME; // Bucket adı
    }

    @Override
    public QueryScanConsistency getDefaultConsistency() {
        return QueryScanConsistency.REQUEST_PLUS;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public ValidatingCouchbaseEventListener validatingCouchbaseEventListener() {
        return new ValidatingCouchbaseEventListener(localValidatorFactoryBean());
    }
}

