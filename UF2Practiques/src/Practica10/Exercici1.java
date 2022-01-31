/*EL TETRIS
El 6 de juny de 1984, Alekséi Pázhitnov, un enginyer
informàtic rus de 29 anys en una avorrida tarda al servei del
govern rus, va desenvolupar un videojoc molt simple que
acabaria sent un èxit de vendes. Com que ho va fer amb
recursos del govern rus, el pobre home no ve rebre ni un
cèntim i tots els guanys van anar a parar al govern rus. Fart
d’aquesta situació, l’Alekséi va marxar als Estats Units l’any
1991. Microsoft el va fitxar l’any 1996 per col·laborar en el
desenvolupament de la Xbox 360. També al 1996, juntament amb Henk Rogers, van
aconseguir recuperar els drets d’autor d’aquest videojoc, però ja era massa tard perquè
corrien diferents versions de codi lliure.
Es demana que desenvolupeu una versió simple d’aquest joc. El programa demanarà
el tamany del tauler de joc i anirà mostrant aleatòriament una sèrie de peces que, en
aquesta versió simplificada, no podran rotar. Aquestes peces les mourem N posicions
a la dreta o a l’esquerra i les deixarem caure. En el moment que una peça toqui el fons
o alguna de les peces ja col·locades, la peça aturarà la seva caiguda. Si s’aconsegueix
que una línia horitzontal quedi completament plena, aquesta línia desapareixerà del
taulell i les peces (o restes de peces) que hi ha al damunt cauen fins tocar el fons o
alguna altra peça. El programa finalitza quan alguna peça arriba al límit superior del
taulell i, per tant, ja no podem col·locar cap més.
El conjunt de peces del que disposeu és el següent:
Una possible versió del programa en pseudo-codi podria ser la següent:
Programa Tetris
DemanarTamanyTaulell
Mentre ( no FinalPartida) fer
MostrarPeça
MourePeçaCostats
FerCaureLaPeça
MostrarTaulell
 Fi Mentre
Fi Programa
Basant-te en aquest pseudo-codi, acaba de desenvolupar aquesta versió simplificada
del Tetris, aplicant les tècniques de descomposició en subproblemes. Recorda que cap
funció o procediment hauria de tenir més de 10 línies de codi.*/
package Practica10;

import java.util.Random;

public class Exercici1 {

    final public static int PIECE_TYPES_COUNT = 2;
    private static long lastTime = System.currentTimeMillis();
    public static void main(String[] args) {

        boolean endGame = false;

        System.out.println("BENVINGUT AL TETRIS!!");

        //crear tauler de joc
        Board b = new Board();
        b.currentBoard = b.defineBoard();
        b.initializeBoard();

        int[] pointerCoords = new int[2];
        int[] auxCoordOrigin = new int[2];
        boolean needNewPiece = false;
        Piece currentPiece = null;
        int posture = 0;
        

        do {
            //Comprovem si necessitem una nova peça
            if (currentPiece == null) {
                needNewPiece = true;
            }else{
                needNewPiece = false;
            }
            //creem una nova peça per colocar
            if (needNewPiece) {
                currentPiece = createNewPiece();
                handy.ArrayManager.initializeToZero(pointerCoords);
                handy.ArrayManager.copyArray(pointerCoords, auxCoordOrigin);
                posture = 0;
            }

            if (isDeltaTimeEquals(500)) {

                //comprovem la localitzacio de la peça
                Piece.Situation currSit = currentPiece.checkNextLocation(b.currentBoard, auxCoordOrigin, 0);
                //inserim la peça al tauler
                switch (currSit) {
                    case AVAILABLE:
                        handy.ArrayManager.copyArray(auxCoordOrigin, pointerCoords);
                        currentPiece.drawPiece(b.currentBoard, pointerCoords, posture, 'O');
                        break;

                    case OCCUPIED:
                        currentPiece.drawPiece(b.currentBoard, pointerCoords, posture, 'X');
                        currentPiece = null;
                        break;

                    case OUT_OF_BOUNDS:
                        currentPiece.drawPiece(b.currentBoard, pointerCoords, posture, 'O');
                        break;
                        
                    case ON_FIELD:
                        currentPiece.drawPiece(b.currentBoard, pointerCoords, posture, 'X');
                        currentPiece = null;
                        break;
                }
                //imprimirBoard
                b.printBoard();
                if(currSit == currSit.AVAILABLE || currSit == currSit.OUT_OF_BOUNDS){
                    currentPiece.drawPiece(b.currentBoard, pointerCoords, posture, ' ');//fer el clean piece
                    auxCoordOrigin[1]++;
                } 
            }
        } while (!endGame);
    }

    public static Piece createNewPiece() {
        Piece currentPiece;
        Random r = new Random();
        int pieceNumber = r.nextInt(PIECE_TYPES_COUNT);
        switch (pieceNumber) {
            case 0:
                currentPiece = new Piece(Piece.PieceForm.BOX);
                break;
            case 1:
                currentPiece = new Piece(Piece.PieceForm.LINE);
                break;
            case 2:
                currentPiece = new Piece(Piece.PieceForm.L_L);
                break;
            case 3:
                currentPiece = new Piece(Piece.PieceForm.L_R);
                break;
            case 4:
                currentPiece = new Piece(Piece.PieceForm.Z_L);
                break;
            case 5:
                currentPiece = new Piece(Piece.PieceForm.Z_R);
                break;
            default:
                currentPiece = null;
        }
        return currentPiece;
    }

    

    public static boolean isDeltaTimeEquals(int delta) {
        long time = System.currentTimeMillis();
        int deltaTime = (int) (time - lastTime);
        if (deltaTime >= delta) {
            lastTime = time;
            return true;
        }
        return false;
    }

    public static void tutorial() {
        //tutorial. a d esq dret espai girar s caiguda
        System.out.println("\n\"a\" moure a l'esquerra");
        System.out.println("\"d\" moure a la dreta");
        System.out.println("\"s\" caiguda lliure");
        System.out.println("\"Espai\" girar la peça\n");
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
