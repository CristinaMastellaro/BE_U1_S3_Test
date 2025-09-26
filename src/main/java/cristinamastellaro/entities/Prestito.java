package cristinamastellaro.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "elem_biblioteca", nullable = false)
    private ElementoBiblioteca elementoPrestato;
    @Column(name = "inizio_prestito", nullable = false)
    private LocalDate inizioPrestito;
    @Column(name = "restituzione_prevista")
    private LocalDate restituzionePrevista;
    @Column(name = "restituzione effettiva")
    private LocalDate restituzioneEffettiva;

    public Prestito() {
    }

    public Prestito(Utente utente, ElementoBiblioteca elementoPrestato, LocalDate inizioPrestito) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.inizioPrestito = inizioPrestito;
        restituzionePrevista = this.inizioPrestito.plusDays(30);
    }

    public Prestito(Utente utente, ElementoBiblioteca elementoPrestato, LocalDate inizioPrestito, LocalDate restituzioneEffettiva) {
        this(utente, elementoPrestato, inizioPrestito);
        this.restituzioneEffettiva = restituzioneEffettiva;
    }

    public UUID getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementoBiblioteca getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(ElementoBiblioteca elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getInizioPrestito() {
        return inizioPrestito;
    }

    public void setInizioPrestito(LocalDate inizioPrestito) {
        this.inizioPrestito = inizioPrestito;
    }

    public LocalDate getRestituzionePrevista() {
        return restituzionePrevista;
    }

    public void setRestituzionePrevista(LocalDate restituzionePrevista) {
        this.restituzionePrevista = restituzionePrevista;
    }

    public LocalDate getRestituzioneEffettiva() {
        return restituzioneEffettiva;
    }

    public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
        this.restituzioneEffettiva = restituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito\n" +
                "id: " + id +
                ", \nutente: " + utente +
                ", \nelemento prestato: " + elementoPrestato +
                ", \ninizio del prestito: " + inizioPrestito +
                ", restituzione prevista entro il " + restituzionePrevista +
                ", restituzione effettiva: " + restituzioneEffettiva;
    }
}
