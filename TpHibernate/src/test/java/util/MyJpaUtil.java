package util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyJpaUtil {

	private static EntityManagerFactory emf = null;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			// NB: myPersistenceUnit configure dans META-INF/persistence.xml
			// emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

			Map<String, Object> configOverrides = new HashMap<String, Object>();
			// configOverrides.put("javax.persistence.provider",
			// "org.hibernate.jpa.HibernatePersistenceProvider");
			configOverrides.put("javax.persistence.jdbc.driver", "org.h2.Driver");
			configOverrides.put("javax.persistence.jdbc.user", "sa");
			configOverrides.put("javax.persistence.jdbc.password", "");
			configOverrides.put("javax.persistence.jdbc.url", "jdbc:h2:~/produit");
			/*
			 * configOverrides.put("javax.persistence.jdbc.driver",
			 * "com.mysql.jdbc.Driver"); configOverrides.put("javax.persistence.jdbc.user",
			 * "root"); configOverrides.put("javax.persistence.jdbc.password", "root");
			 * configOverrides.put("javax.persistence.jdbc.url",
			 * "jdbc:mysql://localhost:3307/produit?createDatabaseIfNotExist=true&serverTimezone=UTC"
			 * );
			 */
			emf = Persistence.createEntityManagerFactory("TpHibernate", configOverrides);
		}
		return emf;
	}

}
