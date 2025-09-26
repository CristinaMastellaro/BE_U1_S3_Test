package cristinamastellaro.dao;

import cristinamastellaro.entities.Prestito;
import cristinamastellaro.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito p) {
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(p);
            et.commit();
            System.out.println("Il prestito di " + p.getElementoPrestato().getTitolo() + " per " + p.getUtente().getNome() + " è stato registrato!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Prestito> findByUserCard(String id) {
        try {
            // Assicuriamoci che la card sia intestato a un utente
            UtenteDAO uDao = new UtenteDAO(em);
            Utente utente = uDao.findByUserCard(id);
            if (utente == null) throw new Exception("");

            UUID idUUID = UUID.fromString(id);
            TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p JOIN ElementoBiblioteca eb ON eb.codiceIsbn = p.elementoPrestato.codiceIsbn WHERE p.utente.numeroTessera = :tessera", Prestito.class);
            query.setParameter("tessera", idUUID);
            List<Prestito> found = query.getResultList();
            if (found.isEmpty()) {
                System.out.println("L'utente non ha mai richiesto prestiti");
                return null;
            } else {
                return found;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<Prestito> findByUserCardTheActiveLoad(String id) {
        try {
            // Assicuriamoci che la card sia intestato a un utente
            UtenteDAO uDao = new UtenteDAO(em);
            Utente utente = uDao.findByUserCard(id);
            if (utente == null) throw new Exception("");

            UUID idUUID = UUID.fromString(id);
            TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p JOIN ElementoBiblioteca eb ON eb.codiceIsbn = p.elementoPrestato.codiceIsbn WHERE p.utente.numeroTessera = :tessera AND p.restituzioneEffettiva IS NULL", Prestito.class);
            query.setParameter("tessera", idUUID);
            List<Prestito> found = query.getResultList();
            if (found.isEmpty()) {
                System.out.println("L'utente non ha nessun prestito in attivo");
                return null;
            } else {
                System.out.println("Ecco gli elementi che sono in prestito dall'utente:");
                found.forEach(System.out::println);
                return found;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<Prestito> findOverduesNotReturned() {
        try {
            TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.restituzioneEffettiva IS NULL AND p.restituzionePrevista < :data", Prestito.class);
            query.setParameter("data", LocalDate.now());
            List<Prestito> found = query.getResultList();
            if (found.isEmpty()) {
                System.out.println("Nessun utente è in ritardo con la restituzione!");
                return null;
            } else {
                System.out.println("Ecco i prestiti in ritardo:");
                found.forEach(System.out::println);
                return found;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }

    }
}
