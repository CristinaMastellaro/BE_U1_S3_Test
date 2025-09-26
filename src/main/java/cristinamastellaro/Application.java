package cristinamastellaro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbl");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
    }
}
