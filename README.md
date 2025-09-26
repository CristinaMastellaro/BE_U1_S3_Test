C'è una relazione many-to-one dal Prestito all'Utente perché un utente potrà avere più prestiti, in quanto potrà prendere più libri e/o riviste contemporaneamente, mentre un singolo record di un prestito sarà collegato al nome di un unico utente.
Anche tra Prestito ed Elemento_biblioteca c'è una relazione many-to-one: un elemento potrà essere preso in prestito più volte, mentre un prestito fa riferimento a un unico elemento della biblioteca (libro o rivista che sia).
Libro e Rivista invece saranno classi figlie di Elemento_Biblioteca, che invece sarà una classe astratta.
