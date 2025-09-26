package cristinamastellaro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Libro extends ElementoBiblioteca {
    private String autore;
    @Enumerated(EnumType.STRING)
    private Genere genere;

    public Libro() {
    }

    public Libro(String titolo, int anno_pubb, int num_pagine, String autore, Genere genere) {
        super(titolo, anno_pubb, num_pagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro dal titolo " + titolo +
                ", autore: " + autore +
                ", genere: " + genere +
                ", codice Isbn: " + codiceIsbn +
                ", anno di pubblicazione: " + annoPubblicazione +
                ", numero di pagine: " + numPagine;
    }
}
