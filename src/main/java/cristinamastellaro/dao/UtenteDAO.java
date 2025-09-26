package cristinamastellaro.dao;

import cristinamastellaro.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente u) {
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(u);
            et.commit();
            System.out.println(u.getNome() + " è stato registrato!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public Utente findByUserCard(String card) {
        try {
            UUID carddUUId = UUID.fromString(card);
            Utente found = em.find(Utente.class, carddUUId);
            if (found == null) {
                throw new Exception("Utente con tessera " + card + " non trovato");
            } else return found;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }

    }
}
