package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class TestWithEntityManager{
	
	// entityManagerFactory est base sur META-INF/persistence.xml
	// et est stable sur le long terme (ok pour plusieurs sessions)
	protected static EntityManagerFactory entityManagerFactory =null;
	
	// NB: test d'un service metier (avec injection de entityManager)
	// utilisant directement entityManager en tant que dao generique
    // NB: pour est proche de la realite , la classe de test reinitialisera 
	// l'objet "entityManager" a chaque debut de test (via entityManager.clear();)
	// ==> (tests en tant que sessions independantes + entites  a etat "detachee"")
    protected EntityManager entityManager =null;	
 	
    @BeforeClass
    public static void initEntityManagerFactory(){
    	TestWithEntityManager.entityManagerFactory = MyJpaUtil.getEntityManagerFactory();
    }
	
	@Before
	public void initDaoWithEntityManager() throws Exception {
		this.entityManager = TestWithEntityManager.entityManagerFactory.createEntityManager();
		this.injectEntityManagerIntoService();
	}



	@After
	public void closeEntityManager() throws Exception {
		this.entityManager.close();
	}
	
	@AfterClass
	public static void closeEntityManagerFactory() throws Exception {
		TestWithEntityManager.entityManagerFactory.close();
	}


	// a coder selon contexte et selon service(s) a tester
	protected abstract void injectEntityManagerIntoService();

	protected void reinitEntityManager(){
		
		this.entityManager.clear();
		/*
		// ou bien
		this.entityManager.close();
		this.entityManager = this.entityManagerFactory.createEntityManager();
		injectEntityManagerIntoService();
		*/
	}
	
	
	protected void verifyDetached(Object obj){
		Assert.assertTrue(this.entityManager.contains(obj) == false);
	}

}
