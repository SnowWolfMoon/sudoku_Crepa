# Risolutore di Sudoku in Java (`Sudokua.java`)

Un'applicazione console sviluppata in Java che permette di inserire manualmente uno schema di Sudoku 9x9, verificare in tempo reale la validità delle mosse e calcolare automaticamente la soluzione completa tramite un algoritmo di **backtracking ricorsivo**.

---

## Caratteristiche Principali

* **Inserimento interattivo guidato per riga:** L'utente popola la griglia riga per riga (dalla riga `0` alla `8`), specificando la colonna e il valore desiderato.
* **Validazione in tempo reale:** Ogni numero inserito viene controllato immediatamente rispetto alle regole standard del Sudoku (riga, colonna e riquadro 3x3) prima di essere accettato.
* **Visualizzazione strutturata:** La griglia 9x9 viene stampata a schermo con separatori visivi che evidenziano i 9 sotto-riquadri 3x3.
* **Risoluzione automatica (Backtracking):** Una volta completato l'inserimento dei dati iniziali, il programma risolve lo schema in autonomia e mostra il risultato finale.

---

## Struttura del Codice e Metodi

Il programma è contenuto all'interno del package `Sudoku` nella classe `Sudokua` ed è suddiviso in quattro metodi principali:

### 1. `main(String[] args)`
Gestisce il flusso principale dell'applicazione:
1. Inizializza una matrice bidimensionale `int[9][9]` riempita con `0` (che rappresentano le celle vuote).
2. Avvia un ciclo `for` per acquisire l'input dell'utente tramite `Scanner`, avanzando di riga ogni volta che viene inserito `-1` come indice di colonna.
3. Invoca il metodo `solve(board)` e stampa la soluzione oppure avvisa se lo schema inserito non ammette soluzioni.

### 2. `isValid(int[][] board, int row, int col, int num)`
Verifica se il numero `num` (compreso tra `1` e `9`) può essere inserito nella posizione `(row, col)` senza violare le regole del gioco:
* Controlla che `num` non sia già presente nella stessa **riga**.
* Controlla che `num` non sia già presente nella stessa **colonna**.
* Calcola le coordinate iniziali del **riquadro 3x3** (`(row / 3) * 3` e `(col / 3) * 3`) e verifica che il numero non compaia al suo interno.

### 3. `solve(int[][] board)`
Implementa l'algoritmo di **backtracking ricorsivo**:
* Scansiona la griglia alla ricerca della prima cella vuota (`0`).
* Prova ad inserire i numeri da `1` a `9` verificandone la validità tramite `isValid`.
* Richiama ricorsivamente se stesso (`solve(board)`) per proseguire con le celle successive.
* Se una strada non porta a una soluzione valida, reimposta la cella a `0` (*backtrack*) e prova il numero successivo.

### 4. `printBoard(int[][] board)`
Stampa la matrice `9x9` formattata in console, racchiudendo ogni valore tra barre verticali (`|n|`) e inserendo spazi e righe vuote ogni 3 celle per rendere ben leggibili i quadranti 3x3.

---

## Requisiti e Utilizzo

### Prerequisiti
* **Java Development Kit (JDK)** 8 o superiore.

### Compilazione ed Esecuzione
1. Salva il file come `Sudokua.java` all'interno di una cartella chiamata `Sudoku`.
2. Apri il terminale nella directory superiore a `Sudoku` e compila il codice:
   ```bash
   javac Sudoku/Sudokua.java
   ```
3. Avvia il programma:
   ```bash
   java Sudoku.Sudokua
   ```

### Guida all'Inserimento Dati
Durante l'esecuzione, il programma scorre automaticamente dalla **riga 0** alla **riga 8**:
1. Inserisci l'indice della **colonna** (`0-8`) in cui vuoi posizionare un numero e premi `Invio`.
2. Inserisci il **numero** (`1-9`) da assegnare a quella cella e premi `Invio`.
3. Ripeti per tutte le celle note della riga corrente.
4. Digita **`-1`** quando ti viene chiesta la colonna per passare alla riga successiva.
5. Al termine della riga 8, il programma avvierà automaticamente il risolutore.
