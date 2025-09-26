package cristinamastellaro.dao;

import cristinamastellaro.entities.ElementoBiblioteca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ElementoBibliotecaDAO {
    private final EntityManager em;

    public ElementoBibliotecaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ElementoBiblioteca eb) {
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(eb);
            et.commit();
            System.out.println(eb.getTitolo() + " salvato!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public ElementoBiblioteca findByISBN(long isbn) {
        ElementoBiblioteca found = em.find(ElementoBiblioteca.class, isbn);
        if (found != null) {
            System.out.println("L'elemento con isbn " + isbn + " è: ");
            System.out.println(found);
            return found;
        } else {
            System.err.println("Elemento con codice ISBN " + isbn + " non trovato");
            return null;
        }
    }

    public void removeElement(long isbn) {
        try {
            ElementoBiblioteca elToRemove = findByISBN(isbn);
            if (elToRemove == null)
                throw new Exception("Dato che non abbiamo trovato l'elemento, l'operazione è stata interrotta");

            EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(elToRemove);
            et.commit();
            System.out.println(elToRemove.getTitolo() + " è stato rimosso dal catalogo");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ElementoBiblioteca> findByYear(int year) {
        TypedQuery<ElementoBiblioteca> query = em.createQuery("SELECT eb FROM ElementoBiblioteca eb WHERE eb.annoPubblicazione = :anno", ElementoBiblioteca.class);
        query.setParameter("anno", year);
        List<ElementoBiblioteca> elTrovati = query.getResultList();
        if (elTrovati.isEmpty()) {
            System.out.println("Nessun elemento del catalogo è stato pubblicato nel " + year);
            return null;
        } else {
            System.out.println("Ecco gli elementi pubblicati nel " + year);
            elTrovati.forEach(System.out::println);
            return elTrovati;
        }
    }

    public List<ElementoBiblioteca> findByAuthor(String author) {
        try {
            TypedQuery<ElementoBiblioteca> query = em.createQuery("SELECT eb FROM ElementoBiblioteca eb WHERE eb.autore ILIKE :autore", ElementoBiblioteca.class);
            query.setParameter("autore", "%" + author + "%");
            List<ElementoBiblioteca> found = query.getResultList();
            if (found.isEmpty()) {
                System.out.println("Non è stato trovato alcun elemento scritto da " + author);
                return null;
            } else {
                System.out.println("Ecco gli elementi scritti da " + author + ":");
                found.forEach(System.out::println);
                return found;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<ElementoBiblioteca> findByTitle(String title) {
        try {
            TypedQuery<ElementoBiblioteca> query = em.createQuery("SELECT eb FROM ElementoBiblioteca eb WHERE eb.titolo ILIKE :titolo", ElementoBiblioteca.class);
            query.setParameter("titolo", "%" + title + "%");
            List<ElementoBiblioteca> found = query.getResultList();
            if (found.isEmpty()) {
                System.err.println("Non è stato trovato nessun elemento che contenesse al suo interno la stringa " + title);
                return null;
            } else {
                System.out.println("Ecco gli elementi che contengono nel loro titolo la stringa " + title);
                found.forEach(System.out::println);
                return found;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
