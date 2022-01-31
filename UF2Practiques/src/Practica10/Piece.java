package Practica10;

public class Piece {

    static final int TILES = 4;
    static final int XY_RELATIVEPOS = 2;
    int[][][] positions;

    enum PieceForm {
        BOX(0, 1),
        LINE(1, 2),
        L_L(2, 4),
        L_R(3, 4),
        Z_L(4, 4),
        Z_R(5, 4);

        int pieceNumber;
        int positionsCount;

        PieceForm(int value, int positionsCount) {
            pieceNumber = value;
            this.positionsCount = positionsCount;
        }
    };

    enum Situation {
        AVAILABLE,
        OCCUPIED,
        OUT_OF_BOUNDS,
        ON_FIELD;
    };

    Piece(PieceForm str) {

        positions = new int[str.positionsCount][TILES][XY_RELATIVEPOS];

        switch (str) {
            case BOX:
                int[] coordsB = {0, 0, 1, 0, 0, 1, 1, 1};

                createCoords(coordsB);
                break;

            case LINE:
                int[] coordsL = {0, 0, 1, 0, 2, 0, 3, 0, //POSICIO HORITZONTAL
                    0, 0, 0, 1, 0, 2, 0, 3}; //POSICIO VERTICAL

                createCoords(coordsL);
                break;

            case L_L:

                break;

            case L_R:
                int[] coordsL_R = {0, 0, 0, 1, 0, 2, 1, 2, //POSICIO DRETA
                    2, 0, 0, 1, 1, 1, 2, 1, //POSICIO AMUNT
                    0, 0, 1, 0, 1, 1, 1, 2, //POSICIO ESQUERRA
                    0, 0, 1, 0, 2, 0, 0, 1}; //POSICIO AVALL

                createCoords(coordsL_R);
                break;

            case Z_L:

                break;

            case Z_R:

                break;
        }
    }

    public void createCoords(int[] coords) {
        int coordI = 0;
        for (int pos = 0; pos < positions.length; pos++) {
            for (int tile = 0; tile < positions[pos].length; tile++) {
                
                for (int xy = 0; xy < positions[pos][tile].length; xy++) {
                    positions[pos][tile][xy] = coords[coordI];
                    coordI++;
                }
            }
        }
    }

    public void drawPiece(char[][] board, int[] origin, int posture, char graf) {
        for (int i = 0; i < positions[posture].length; i++) {
            int cX = origin[0];
            int cY = origin[1];
            for (int j = 0; j < positions[posture][i].length; j++) {
                if (j == 0) {
                    cX += positions[posture][i][j];
                } else { //j == 1
                    cY += positions[posture][i][j];
                }
            }
            board[cY][cX] = graf;
        }
    }

    public Situation checkNextLocation(char[][] lattice, int[] origin, int posture) { //Origin te 2 valors, X e Y, en aquest ordre.

        Situation result;
        result = Situation.AVAILABLE;
        //Copiem el llenç en la variable aux.
        char[][] aux = new char[lattice.length][lattice[0].length];
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[i].length; j++) {
                aux[i][j] = lattice[i][j];
            }
        }

        boolean outOfBounds = false;
        boolean occupied = false;
        boolean onField = false;
        for (int i = 0; i < positions[posture].length && !outOfBounds && !occupied && !onField; i++) {
            int cX = origin[0];
            int cY = origin[1];
            for (int j = 0; j < positions[posture][i].length; j++) {
                if (j == 0) {
                    cX += positions[posture][i][j];
                } else { //j == 1
                    cY += positions[posture][i][j];
                }
            }
            outOfBounds = checkOutOfBounds(aux, cX);
            if (outOfBounds) {
                result = Situation.OUT_OF_BOUNDS;
            } else {
                onField = checkOnField(aux, cY);
                if (onField) {
                    result = Situation.ON_FIELD;
                } else {
                    occupied = checkOccupation(aux, cX, cY);
                    if (occupied) {
                        result = Situation.OCCUPIED;
                    }
                }
            }
        }

        return result;
    }

    public boolean checkOutOfBounds(char[][] lattice, int x) { //True si s'ha sortit dels marges
        boolean result;
        if (x < 0 || x >= lattice[0].length) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean checkOccupation(char[][] lattice, int x, int y) {
        boolean result;
        if (lattice[y][x] == ' ') {
            result = false;
        } else {
            result = true;
        }
        return result;
    }

    public boolean checkOnField(char[][] lattice, int y) {
        boolean result;
        if (y >= lattice.length) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
