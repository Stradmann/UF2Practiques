
package Practica10;

import handy.Validator;

public class Board {
    final int SUPMARGIN = 4;
    final int WMIN = 6;
    final int WMAX = 12;
    final int HMIN = 10;
    final int HMAX = 20;
    
    char[][] currentBoard;
    
    public char[][] defineBoard() {
        
        int width;
        int height;
        width = Validator.readInt("Introdueix l'amplada (entre 6 i 12)", WMIN, WMAX);
        height = Validator.readInt("Introdueix l'al\u00e7ada(entre 10 i 20)", HMIN, HMAX) + SUPMARGIN;
        
        char[][] board = new char[height][width];
        return board;
    }
    
    public void printBoard(){
        for(int i = 0; i <= currentBoard.length; i++){
            if(i != currentBoard.length){
                for(int j = -1; j <= currentBoard[i].length; j++){
                    if(j == -1 || j == currentBoard[i].length){
                        System.out.print("|");
                    }else{
                        System.out.print(currentBoard[i][j]);
                    }
                }
                System.out.print("\n");
            }else{
                for(int j = -1; j<= currentBoard[i-1].length; j++){
                    System.out.print("-");
                }
                System.out.print("\n");
            }
        }
    }
    
    public void initializeBoard(){
        for(int i = 0; i < currentBoard.length; i++){
            for(int j = 0; j < currentBoard[i].length; j++){
                currentBoard[i][j] = ' ';
            }
        }
    }
    
    public boolean checkEndgame(){
        boolean result = false;
        for(int i = 0; i < SUPMARGIN; i++){
            for(int j = 0; j < this.currentBoard[i].length; j++){
                if(this.currentBoard[i][j] == 'X'){
                    result = true;
                }
            }
        }
        return result;
    }
    
    public void checkLine(){
        int result;
        
        for(int i = 0; i < this.currentBoard.length; i++){
            boolean allX = true;
            for(int j = 0; j < this.currentBoard[i].length && allX; j++){
                if(this.currentBoard[i][j] != 'X'){
                    allX = false;
                }
            }
            if(allX){
                Exercici1.points += 50;
                cleanLine(i);
            }
        }
    }
    
    public void cleanLine(int i){
        for(int j = 0; j < this.currentBoard[i].length; j++){
            this.currentBoard[i][j] = ' ';
        }
        printBoard();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }
        for(int j = 0; j < this.currentBoard[i].length; j++){
            this.currentBoard[i][j] = '*';
        }
        printBoard();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }
        dropRest(i);
        printBoard();
    }
    
    public void dropRest(int row){
        for(int i = row; i > 0; i--){
            for(int j = 0; j < this.currentBoard[i].length; j++){
                currentBoard[i][j] = currentBoard[i-1][j];
            }
        }
    }
}
