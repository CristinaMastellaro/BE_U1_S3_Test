package cristinamastellaro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Rivista extends ElementoBiblioteca {
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista() {
    }

    public Rivista(String titolo, int anno_pubblicazione, int num_pagine, Periodicita periodicita) {
        super(titolo, anno_pubblicazione, num_pagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista dal titolo: " + titolo +
                ", periodicità: " + periodicita +
                ", codice Isbn: " + codiceIsbn +
                ", anno di pubblicazione: " + annoPubblicazione +
                ", numero di pagine: " + numPagine;
    }
}
