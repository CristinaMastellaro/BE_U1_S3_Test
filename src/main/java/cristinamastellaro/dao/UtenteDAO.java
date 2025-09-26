package cristinamastellaro.dao;

import cristinamastellaro.entities.ElementoBiblioteca;
import cristinamastellaro.entities.Prestito;
import cristinamastellaro.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
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

    public List<Utente> findAllUsersThatBookedAnElement(long id) {
        try {
//            UUID idUUID = UUID.fromString(id);

            // Assicuriamoci che l'elem esista
            ElementoBibliotecaDAO eDao = new ElementoBibliotecaDAO(em);
            ElementoBiblioteca elTrovato = eDao.findByISBN(id);
            if (elTrovato == null) throw new Exception("L'operazione verrà terminata");

            TypedQuery<Utente> query = em.createQuery("SELECT u FROM Utente u JOIN Prestito p ON p.utente.numeroTessera = u.numeroTessera JOIN ElementoBiblioteca eb ON eb.codiceIsbn = p.elementoPrestato.codiceIsbn WHERE p.elementoPrestato.codiceIsbn = :id ORDER BY p.inizioPrestito DESC", Utente.class);
            query.setParameter("id", id);
            List<Utente> found = query.getResultList();
            if (found.isEmpty()) {
                System.out.println("Nessuno ha mai prenotato questo elemento");
                return null;
            } else {
//                TypedQuery<Prestito> query2 = em.createQuery("")
                System.out.println("Ecco gli utenti che hanno prenotato il libro, in ordine decrescente e con indicato il periodo di prestito");
//                found.forEach(System.out::println);
                PrestitoDAO pDao = new PrestitoDAO(em);
                found.forEach(u -> {
                    List<Prestito> p = pDao.findByUserCard(u.getNumeroTessera().toString());
                    p.forEach(prestito -> {
                        if (prestito.getElementoPrestato().getCodiceIsbn() == id) {
                            System.out.println("Periodo di prestito: " + prestito.getInizioPrestito() + " - " + prestito.getRestituzioneEffettiva());
                            System.out.println("per " + u);
                        }
                    });
                });
                return found;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
