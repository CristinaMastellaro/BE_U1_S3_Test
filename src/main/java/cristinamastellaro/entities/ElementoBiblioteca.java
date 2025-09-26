package cristinamastellaro.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "el_biblioteca")
@DiscriminatorColumn(name = "tipo_elemento")
public abstract class ElementoBiblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codice_isbn")
    protected long codiceIsbn;
    @Column(nullable = false)
    protected String titolo;
    @Column(name = "anno_pubblicazione")
    protected int annoPubblicazione;
    @Column(name = "num_pagine")
    protected int numPagine;

    public ElementoBiblioteca() {
    }

    public ElementoBiblioteca(String titolo, int anno_pubblicazione, int num_pagine) {
        this.titolo = titolo;
        this.annoPubblicazione = anno_pubblicazione;
        this.numPagine = num_pagine;
    }

    public long getCodiceIsbn() {
        return codiceIsbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        if (!titolo.isEmpty()) this.titolo = titolo;
        else {
            System.err.println("Titolo inserito non valido. Verrà inserito un titolo di default");
            this.titolo = "##Titolo da cambiare##";
        }
    }

    public int getAnno_pubblicazione() {
        return annoPubblicazione;
    }

    public void setAnno_pubblicazione(int anno_pubblicazione) {
        this.annoPubblicazione = anno_pubblicazione;
    }

    public int getNum_pagine() {
        return numPagine;
    }

    public void setNum_pagine(int num_pagine) {
        if (num_pagine > 0) this.numPagine = num_pagine;
        else {
            System.err.println("Numero di pagine inserito non valido. Verrà inserito un numero di default");
            this.numPagine = 150;
        }
    }
}
