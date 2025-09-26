package cristinamastellaro.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue
    @Column(name = "num_tessera")
    private UUID numeroTessera;
    @Column(nullable = false)
    private String nome;
    private String cognome;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public UUID getNumeroTessera() {
        return numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        return "L'utente con numero di tessera " + numeroTessera +
                ", si chiama " + nome + " " + cognome +
                " e ha data di nascita " + dataNascita;
    }
}
