
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
}
