package cristinamastellaro;

import cristinamastellaro.dao.ElementoBibliotecaDAO;
import cristinamastellaro.dao.PrestitoDAO;
import cristinamastellaro.entities.Genere;
import cristinamastellaro.entities.Libro;
import cristinamastellaro.entities.Periodicita;
import cristinamastellaro.entities.Rivista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbl");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        Scanner s = new Scanner(System.in);

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

//        pDao.findOverduesNotReturned();

        while (true) {
            try {
                System.out.println("\nCiao! Benvenuto nel catalogo della biblioteca Leonardo da Vinci! Che operazione vuoi compiere? Per uscire digita 'quit'");
                System.out.println("1 - Aggiungi un elemento al catalogo");
                System.out.println("2 - Ricerca usando il codice ISBN");
                System.out.println("3 - Ricerca usando l'anno di pubblicazione");
                System.out.println("4 - Ricerca per autore");
                System.out.println("5 - Ricerca per titolo o parte di esso");
                System.out.println("6 - Ricerca i prestiti attualmente in prestito di un utente");
                System.out.println("7 - Ricerca tutti i prestiti scaduti e non ancora restituiti");
                System.out.println("8 - Rimuovi un elemento");
                String operation = s.nextLine();
                if (operation.trim().equals("quit")) break;

                switch (operation) {
                    case "1":
                        while (true) {
                            try {
                                System.out.println("Che elemento vuoi aggiungere? ");
                                System.out.println("1 - Libro");
                                System.out.println("2 - Rivista");
                                String tipoEl = s.nextLine();
                                if (!tipoEl.trim().equals("1") && !tipoEl.trim().equals("2")) {
                                    System.out.println("Numero selezionato non valido, ridigita");
                                }

                                System.out.println("Indica il titolo:");
                                String title = s.nextLine();
                                System.out.println("Indica l'anno di pubblicazione:");
                                String year = s.nextLine();
                                int yearN = Integer.parseInt(year);
                                System.out.println("Indica il numero di pagine:");
                                String pages = s.nextLine();
                                int pagesN = Integer.parseInt(pages);
                                System.out.println("Il codice ISBN sarà aggiunto in automatico in base alle informazioni inserite");

                                switch (tipoEl) {
                                    case "1":
                                        System.out.println("Indica il nome dell'autore:");
                                        String author = s.nextLine();
                                        System.out.println("Indica il genere, scegliendo il numero corrispondente:");
                                        System.out.println("1 - Narrativa");
                                        System.out.println("2 - Poesia");
                                        System.out.println("3 - Horror");
                                        System.out.println("4 - Fantasy");
                                        System.out.println("5 - Saggistica");
                                        System.out.println("(Se il numero selezionato non è valido, verrà messo in automatico genere narrativo)");
                                        String choice = s.nextLine();
                                        Genere genre = switch (choice) {
                                            case "2" -> Genere.POESIA;
                                            case "3" -> Genere.HORROR;
                                            case "4" -> Genere.FANTASY;
                                            case "5" -> Genere.SAGGISTICA;
                                            default -> Genere.NARRATIVA;
                                        };
                                        Libro libro = new Libro(title, yearN, pagesN, author, genre);
                                        ebDao.save(libro);
                                        break;
                                    case "2":
                                        System.out.println("Indica la periodicità, scegliendo il numero corrispondente:");
                                        System.out.println("1 - Settimanale");
                                        System.out.println("2 - Mensile");
                                        System.out.println("3 - Semestrale");
                                        System.out.println("(Se il numero selezionato non è valido, verrà messo in automatico periodicità mensile)");
                                        String per = s.nextLine();
                                        Periodicita periodicity = switch (per) {
                                            case "1" -> Periodicita.SETTIMANALE;
                                            case "3" -> Periodicita.SEMESTRALE;
                                            default -> Periodicita.MENSILE;
                                        };
                                        Rivista rivista = new Rivista(title, Integer.parseInt(year), Integer.parseInt(pages), periodicity);
                                        ebDao.save(rivista);
                                        break;
                                    default:
                                        System.out.println("Come ci sei arrivato fin qui?");
                                }
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                                System.out.println("Ricomincia a compilare i dati");
                            }
                        }
                        break;
                    case "2":
                        while (true) {
                            try {
                                System.out.println("Indica il codice ISBN dell'elemento da cercare:");
                                String isbn = s.nextLine();
                                ebDao.findByISBN(Integer.parseInt(isbn));
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                        break;
                    case "3":
                        while (true) {
                            try {
                                System.out.println("Indica l'anno di pubblicazione:");
                                String year = s.nextLine();
                                ebDao.findByYear(Integer.parseInt(year));
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                        break;
                    case "4":
                        while (true) {
                            try {
                                System.out.println("Indica l'autore di cui vuoi cercare i libri:");
                                String author = s.nextLine();
                                ebDao.findByAuthor(author);
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                        break;
                    case "5":
                        while (true) {
                            try {
                                System.out.println("Indica il libro scrivendo il suo titolo o parte di esso:");
                                String title = s.nextLine();
                                ebDao.findByTitle(title);
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                        break;
                    case "6":
                        while (true) {
                            try {
                                System.out.println("Indica il numero della tessera di cui vuoi vedere i prestiti in attivo:");
                                String title = s.nextLine();
                                pDao.findByUserCard(title);
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                        break;
                    case "7":
                        pDao.findOverduesNotReturned();
                        break;
                    case "8":
                        while (true) {
                            try {
                                System.out.println("Indica il codice isbn dell'elemento da rimuovere:");
                                String isbn = s.nextLine();
                                ebDao.removeElement(Integer.parseInt(isbn));
                                break;
                            } catch (InputMismatchException e) {
                                System.err.println("Non puoi inserire stringhe al posto di numeri!");
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                        break;
                    default:
                        System.out.println("Valore selezionato non valido, riprova");
                        break;
                }

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
