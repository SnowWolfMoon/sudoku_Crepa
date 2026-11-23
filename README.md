# Risolutore di Sudoku in Java (`Sudokua.java`)

Stamattina, mentre guardavo Noah giocare a un gioco basato sui numeri, ho avuto un’improvvisa intuizione. Mi sono unito a lui per un’ora e mi è venuta un’idea: perché non lasciare che sia una macchina a pensare al posto mio? È così che è nato questo progetto. Un'applicazione console sviluppata in Java che permette di inserire manualmente uno schema di Sudoku 9x9, verificare in tempo reale la validità delle mosse e calcolare automaticamente la soluzione completa tramite un algoritmo di **backtracking ricorsivo**.

---

## Caratteristiche Principali

* **Inserimento interattivo guidato per riga:** L'utente popola la griglia riga per riga (dalla riga `0` alla `8`), specificando la colonna e il valore desiderato.
* **Validazione in tempo reale:** Ogni numero inserito viene controllato immediatamente rispetto alle regole standard del Sudoku (riga, colonna e riquadro 3x3) prima di essere accettato.
* **Visualizzazione strutturata:** La griglia 9x9 viene stampata a schermo con separatori visivi che evidenziano i 9 sotto-riquadri 3x3.
* **Risoluzione automatica (Backtracking):** Una volta completato l'inserimento dei dati iniziali, il programma risolve lo schema in autonomia e mostra il risultato finale.

---

### Guida all'Inserimento Dati
Durante l'esecuzione, il programma scorre automaticamente dalla **riga 0** alla **riga 8**:
1. Inserisci l'indice della **colonna** (`0-8`) in cui vuoi posizionare un numero e premi `Invio`.
2. Inserisci il **numero** (`1-9`) da assegnare a quella cella e premi `Invio`.
3. Ripeti per tutte le celle note della riga corrente.
4. Digita **`-1`** quando ti viene chiesta la colonna per passare alla riga successiva.
5. Al termine della riga 8, il programma avvierà automaticamente il risolutore.
