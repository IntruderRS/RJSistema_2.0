package br.com.sistemarj.rjsistema.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "RJSistema-PU";
    private static EntityManagerFactory factory;

    // O Factory deve ser criado apenas uma vez (Thread-safe)
    static {
        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("Falha ao criar o EntityManagerFactory: " + ex);
        }
    }

    // Retorna uma NOVA instância de EntityManager a cada chamada
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    // Fecha o Factory ao encerrar a aplicação
    public static void closeFactory() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}
