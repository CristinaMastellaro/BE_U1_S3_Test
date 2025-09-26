package cristinamastellaro;

import cristinamastellaro.dao.ElementoBibliotecaDAO;
import cristinamastellaro.dao.PrestitoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbl");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

//        Libro libro1 = new Libro("Circe", 2018, 400, "Madeline Miller", Genere.NARRATIVA);
//        Libro libro2 = new Libro("La canzone di Achille", 2012, 300, "Madeline Miller", Genere.NARRATIVA);
//        Libro libro3 = new Libro("L'incubo di Hill House", 1980, 250, "Shirley Jackson", Genere.HORROR);
//        Libro libro4 = new Libro("Atlante occidentale", 1986, 308, "Daniele Del Giudice", Genere.NARRATIVA);
//        Libro libro5 = new Libro("Sei di corvi", 2020, 467, "Leigh Bardugo", Genere.FANTASY);
//        Libro libro6 = new Libro("Mimesis", 1960, 600, "Erich Auerbach", Genere.SAGGISTICA);
//
//        Rivista rivista1 = new Rivista("Filosofi si diventa", 2020, 88, Periodicita.SETTIMANALE);
//        Rivista rivista2 = new Rivista("La settimana enigmistica", 2025, 50, Periodicita.MENSILE);
//        Rivista rivista3 = new Rivista("Cucinare per la settimana", 2025, 97, Periodicita.SETTIMANALE);
//        Rivista rivista4 = new Rivista("Lavori di casa", 2023, 150, Periodicita.SEMESTRALE);

        ElementoBibliotecaDAO ebDao = new ElementoBibliotecaDAO(em);
//        ebDao.save(libro1);
//        ebDao.save(libro2);
//        ebDao.save(libro3);
//        ebDao.save(libro4);
//        ebDao.save(libro5);
//        ebDao.save(libro6);
//        ebDao.save(rivista1);
//        ebDao.save(rivista2);
//        ebDao.save(rivista3);
//        ebDao.save(rivista4);
//
//        Utente utente1 = new Utente("Francesco", "Rena", LocalDate.of(1967, 4, 30));
//        Utente utente2 = new Utente("Gabriella", "Roy", LocalDate.of(2014, 9, 2));
//        Utente utente3 = new Utente("Roberto", "Bolle", LocalDate.of(1997, 5, 7));
//        Utente utente4 = new Utente("Carmela", "Dionisi", LocalDate.of(2001, 10, 15));
//
//        UtenteDAO uDao = new UtenteDAO(em);
//        uDao.save(utente1);
//        uDao.save(utente2);
//        uDao.save(utente3);
//        uDao.save(utente4);
//
//        Prestito prestito1 = new Prestito(utente1, libro1, LocalDate.now());
//        Prestito prestito2 = new Prestito(utente1, libro2, LocalDate.of(2000, 12, 1), LocalDate.of(2000, 1, 8));
//        Prestito prestito3 = new Prestito(utente2, rivista3, LocalDate.now().minusDays(15));
//        Prestito prestito4 = new Prestito(utente3, rivista4, LocalDate.of(2023, 2, 16), LocalDate.of(2023, 5, 18));
//        Prestito prestito5 = new Prestito(utente4, libro6, LocalDate.now().minusWeeks(10));
//        Prestito prestito6 = new Prestito(utente3, libro1, LocalDate.of(2022, 11, 24), LocalDate.of(2022, 12, 16));
//
        PrestitoDAO pDao = new PrestitoDAO(em);
//        pDao.save(prestito1);
//        pDao.save(prestito2);
//        pDao.save(prestito3);
//        pDao.save(prestito4);
//        pDao.save(prestito5);
//        pDao.save(prestito6);

//        ebDao.findByISBN(3);
//        ebDao.findByISBN(8);
//        ebDao.findByISBN(20);

//        ebDao.removeElement(11);
//        ebDao.removeElement(20);

//        ebDao.findByYear(2014);
//        ebDao.findByYear(2025);

//        ebDao.findByAuthor("a");
//        ebDao.findByAuthor("Gino");

//        ebDao.findByTitle("Ci");
//        ebDao.findByTitle("Ramettino");

//        pDao.findByUserCard("2495ea75-d7bc-4973-b30d-4b8393190ae0");
//        pDao.findByUserCard("2495ea75-d7bc-4973-b30d-4b8393190ae1");
//        pDao.findByUserCard("5a61b27f-6529-41ac-9486-96480a4904d2");

        pDao.findOverduesNotReturned();

    }
}
