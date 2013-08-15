package br.com.acsp.curso.config;

import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


/**
 * User: Christian Reichel
 * Date: 8/10/13
 * Time: 1:31 AM
 */
@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

    @Value("${jdbc.driverClassName}")       private String driverClassName;
    @Value("${jdbc.url}")                   private String url;
    @Value("${jdbc.username}")              private String username;
    @Value("${jdbc.password}")              private String password;

    @Value("${hibernate.dialect}")          private String hibernateDialect;
    @Value("${hibernate.show_sql}")         private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}")     private String hibernateHbm2ddlAuto;

    private final String[] packagesToScan = new String[] { "br.com.acsp.curso.domain" };

    //@Bean
    public DataSource dataSource2()
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setName("ACSP-db").build();
    }

    @Bean
    public TransactionAttributeSource annotationTransactionAttributeSource() {
        return new AnnotationTransactionAttributeSource();
    }

    @Bean
    public TransactionInterceptor transactionInterceptor() {
        final TransactionInterceptor interceptor = new TransactionInterceptor(transactionManager(), annotationTransactionAttributeSource());
        interceptor.setTransactionManager(transactionManager());
        return interceptor;
    }

    @Bean
    public JdbcOperations jdbcOperations() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        final LocalSessionFactoryBean result = new LocalSessionFactoryBean();
        result.setDataSource(dataSource());
        result.setPackagesToScan(packagesToScan);
        result.setHibernateProperties(hibernateProperties());
        return result;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan(packagesToScan);
        entityManagerFactory.setPersistenceUnitName("acsppu");
        final HibernatePersistence hibernatePersistence = new HibernatePersistence();
        hibernatePersistence.createEntityManagerFactory("acsppu", hibernateProperties());
        entityManagerFactory.setPersistenceProvider(hibernatePersistence);
        entityManagerFactory.setJpaProperties(hibernateProperties());
        entityManagerFactory.afterPropertiesSet();
        entityManagerFactory.setJtaDataSource(dataSource());
        final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        return entityManagerFactory.getObject();
    }

    @Bean
    public SessionFactory sessionFactory() {
        return sessionFactoryBean().getObject();
    }

    @Bean JpaTransactionManager transactionManager(){
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(dataSource());
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }

    @Bean
    public Properties hibernateProperties()
    {
        final Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        properties.put("hibernate.show_sql", true);
        return properties;
    }

}
