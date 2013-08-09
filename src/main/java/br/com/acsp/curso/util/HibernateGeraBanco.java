/**
 * 
 */
package br.com.acsp.curso.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * @author eduardobregaida
 * 
 */
public class HibernateGeraBanco {
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		configuration.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		configuration.buildSessionFactory(serviceRegistry);
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}

}
