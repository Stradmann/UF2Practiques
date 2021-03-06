/*1. El quatre en ratlla és un joc per a dos jugadors, representats mitjançant colors
distints, que es desenvolupa sobre una tauler de MxN caselles. La figura
mostra un tauler de 6x7 caselles. Per torns, cada jugador agafa una de les
seves fitxes i la introdueix per la ranura superior d’alguna de les columnes
disponibles. La fitxa cau fins a quedar situada en la casella inferior de la
columna, o sobre una altra fitxa situada anteriorment. El primer que
aconsegueix col·locar 4 de les seves fitxes en ratlla, de forma horitzontal,
vertical o diagonal, guanya.
Escriu un programa que permeti jugar a una versió simplificada del quatre en
ratlla. Per això, representa el tauler mitjançant una matriu d’MxN enters. Un
valor 0 en una cel·la de la matriu indicarà que la casella està lliure, i els valors
1 i 2 indicaran que la casella conté una fitxa del primer o segon jugador,
respectivament. Els valors M i N de les dimensions del tauler s’han de demanar
a l’inici de la partida.
Es demana:
a) Escriure una funció Jugada que a partir d’una matriu, un número de
columna i un número de jugador, col·loqui si és possible la fitxa d’aquest
jugador en la casella adequada de la columna donada. A més a més, la funció
tornarà el número de la fila en què situa la fitxa, o el valor -1 si no es pot
col·locar la fitxa.
b) Escriu una funció EnRatlla que a partir d’una matriu, un número de fila i un
número de columna donats com a paràmetres, indiqui si la casella corresponent 
pertany a un quatre en ratlla o no. Per a simplificar-ho, només
es tindrà en compte les fitxes connectades en horitzontal o en vertical.
c) Escriu un procediment Dibuixa que a partir d’una matriu, presenti el tauler
per pantalla mostrant un zero per a les posicions buides, un 1 per les fitxes
col·locades per primer jugador i un 2 per les fitxes col·locades pel segon
jugador.
Exemple:
d) Escriu el programa que demani el tamany del tauler i, a continuació, vagi
demanant alternativament el torn dels jugadors fins que algú aconsegueixi fer
quatre en ratlla o bé s’hagi omplert el tauler. Un cop acabi, que demani si es
vol fer una altra partida o bé es vol finalitzar el programa.
 */
package Practica8;

public class Exercici1 {

    static int[][] board;
    static int lastRowPlayed, lastColumnPlayed;
    static int winner = -1;

    public static void main(String[] args) {

        boolean endProgram = false;

        do {
            int option = showMenu();
            switch (option) {
                case 0:
                    endProgram = true;
                    break;
                case 1:
                    board = boardDefinition();
                    break;
                case 2:
                    playGame();
                    break;
            }
        } while (!endProgram);

    }

    public static int showMenu() {

        int option;

        System.out.println("(1)Definir tamany de tauler");
        System.out.println("(2)Jugar amb taulell definit");
        System.out.println("(0)Sortir");

        option = handy.Validator.readInt(0, 2);
        return option;
    }

    public static int[][] boardDefinition() {
        int rows = handy.Validator.readInt("Introdueix el numero de files:");
        int columns = handy.Validator.readInt("Introdueix el numero de columnes");

        int[][] result = new int[rows][columns];
        return result;
    }

    public static void playGame() {

        boolean gameOver = false;
        boolean player1Turn = true;
        int jugada_realitzada_jugador1 = 0, jugada_realitzada_jugador2 = 0;

        initializeBoard();
        printScreen();
        while (!gameOver) {
            if (player1Turn) {
                do {
                    jugada_realitzada_jugador1 = playMove(1);
                    if (jugada_realitzada_jugador1 == -1) {
                        System.out.print("No s'ha pogut realitzar la jugada, torna a intentar-ho.");
                    }
                } while (jugada_realitzada_jugador1 == -1);
            } else {
                do {
                    jugada_realitzada_jugador2 = playMove(2);
                    if (jugada_realitzada_jugador2 == -1) {
                        System.out.print("No s'ha pogut realitzar la jugada, torna a intentar-ho.");
                    }
                } while (jugada_realitzada_jugador2 == -1);
            }
            printScreen();
            gameOver = checkEndGame();
            if(gameOver){
                if(winner != -1)
                    System.out.println("Ha guanyat el jugador " + winner + " !!");
                else
                    System.out.println("Ha estat un empat");
            }else{
                player1Turn = !player1Turn;
            }
            
        }
    }

    public static void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    public static int playMove(int player) {

        int fila = 0;

        System.out.println("Es el torn del jugador " + player + ":");
        int columna = handy.Validator.readInt("En quina columna vols ficar la teva fitxa?", 1, board[0].length);
        columna--;

        boolean ficar_fitxa = false;
        for (int i = board.length - 1; i > 0 && !ficar_fitxa; i--) {
            if (board[i][columna] == 0) {
                board[i][columna] = player;
                fila = i;
                ficar_fitxa = true;
            }
        }
        if (!ficar_fitxa) {
            fila = -1;
        } else {
            lastRowPlayed = fila;
            lastColumnPlayed = columna;
        }
        return fila;
    }

    public static boolean checkEndGame() {

        boolean result;

        boolean winGame = inLine();
        boolean availablePosition = false;
        if (!winGame) {
            for (int i = 0; i < board.length && !availablePosition; i++) {
                for (int j = 0; j < board[i].length && !availablePosition; j++) {
                    if (board[i][j] == 0) {
                        availablePosition = true;
                    }
                }
            }
        }

        if (winGame | !availablePosition) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    public static boolean inLine() {

        boolean result;
        int player = board[lastRowPlayed][lastColumnPlayed];
        boolean endCountingSide;
        int countLine;

        //Comprovem la vertical : i+ j, i- j
        endCountingSide = false;
        countLine = 1;
        for (int i = lastRowPlayed + 1;
                i < lastRowPlayed + 4 && i < board.length && !endCountingSide && countLine < 4;
                i++) {
            if (board[i][lastColumnPlayed] == player) {
                countLine++;
            } else {
                endCountingSide = true;
            }
        }
        endCountingSide = false;
        for (int i = lastRowPlayed - 1;
                i > lastRowPlayed - 4 && i >= 0 && !endCountingSide && countLine < 4;
                i--) {
            if (board[i][lastColumnPlayed] == player) {
                countLine++;
            } else {
                endCountingSide = true;
            }
        }

        if (countLine == 4) {
            result = true;
        } else {
            //Comprovem la horitzontal: i j+, i j-
            countLine = 1;
            endCountingSide = false;
            for (int j = lastColumnPlayed + 1;
                    j < lastColumnPlayed + 4 && j < board[lastRowPlayed].length && !endCountingSide && countLine < 4;
                    j++) {
                if (board[lastRowPlayed][j] == player) {
                    countLine++;
                } else {
                    endCountingSide = true;
                }
            }
            endCountingSide = false;
            for (int j = lastColumnPlayed - 1;
                    j > lastColumnPlayed - 4 && j >= 0 && !endCountingSide && countLine < 4;
                    j--) {
                if (board[lastRowPlayed][j] == player) {
                    countLine++;
                } else {
                    endCountingSide = true;
                }
            }
        }
        
        if (countLine == 4)
            result = true;
        else
            result = false;
        
        if (result == true)
            winner = player;
        
        return result;
    }

    public static void printScreen() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
}
