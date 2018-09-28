package by.intexsoft.call.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Objects;

/**
 * Class configuration Cassandra using JavaConfig
 */
@Configuration
@PropertySource("classpath:cassandra.properties")
@ComponentScan("by.intexsoft.call")
@EnableCassandraRepositories(basePackages = {"by.intexsoft.call.repositories"})
@AllArgsConstructor

// todo make via @Value without ENV
public class CassandraConfig extends AbstractCassandraConfiguration {
    private final Environment environment;

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getKeyspaceName() {
        return environment.getProperty("cassandra.keyspace");
    }

    /**
     * Create a {@link CassandraClusterFactoryBean}
     */
    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(environment.getProperty("cassandra.host"));
        cluster.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("cassandra.port"))));
        return cluster;
    }

    /**
     * Create a {@link CassandraMappingContext}
     */
    @Bean
    public CassandraMappingContext mappingContext() {
        return new CassandraMappingContext();
    }

    /**
     * Create {@link MappingCassandraConverter}
     *
     * @return {@link CassandraConverter}
     * @see #mappingContext()
     */
    @Bean
    public CassandraConverter converter() {
        return new MappingCassandraConverter(mappingContext());
    }

    /**
     * Create {@link CassandraSessionFactoryBean}
     *
     * @see #cluster()
     * @see #converter()
     * @see #getSchemaAction()
     */
    @Bean
    public CassandraSessionFactoryBean session() {
        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
        session.setCluster(Objects.requireNonNull(cluster().getObject()));
        session.setKeyspaceName(getKeyspaceName());
        session.setConverter(converter());
        session.setSchemaAction(getSchemaAction());
        return session;
    }

    /**
     * @return {@link SchemaAction}
     */
    @Bean
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE;
    }
}
