package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HidatoSolver {
    int EMPTY = 0;
    int BLOCKED = -1;

    public void test(){
        List<Hidato> boards = new ArrayList<Hidato>();
        boards.add(getBoard2());
        boards.add(getBoard3());
        //boards.add(getBoard1());
        for (Hidato hidato: boards){
            //System.out.println(validate(board, start, end));
            long t1 = System.currentTimeMillis();
            boolean solutionExists = solve(hidato, 0, 0, getFilledValues(hidato.board));
            long t2 = System.currentTimeMillis();
            System.out.println("Found solution :" + solutionExists);
            System.out.println("Time taken in ms = " + (t2-t1));
            printBoard(hidato.board);
        }
        
    }

    private void printBoard(int [][] board){
        for(int i=0; i< board.length; i++){
            for (int j=0; j< board.length; j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }
    private Set<Integer> getFilledValues(int [][] board){
        //Keep all filled numbers in a set
        Set<Integer> filledValues = new HashSet<Integer>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                int val = board[i][j];
                if(val != EMPTY && val != BLOCKED){
                    filledValues.add(board[i][j]);
                }
            }
        }
        return filledValues;
    }

    private Hidato getBoard1(){
        int [][] board = {
            {-1,30,28,24,0,0,0,0,-1},
            {0,31,0,0,0,0,61,59,58},
            {36,0,32,26,0,0,55,0,0},
            {0,33,0,0,18,0,51,0,0},
            {0,38,0,17,0,52,0,65,0},
            {40,0,77,16,0,0,9,0,0},
            {42,1,0,0,0,0,0,69,0},
            {0,43,3,0,0,6,70,72,0},
            {-1,0,0,0,0,0,0,0,-1}
        };
        int start = 1;
        int end = 77;
        Hidato hidato = new Hidato();
        hidato.board = board;
        hidato.start = start;
        hidato.end = end;

        return hidato;
    }

    private Hidato getBoard2() {
        int [][] board = {
            {13,0,15,0,0},
            {0,25,1,2,18},
            {0,24,0,21,0},
            {10,0,22,4,20},
            {9,0,0,6,0}
        };
        int start = 1;
        int end = 25;
        Hidato hidato = new Hidato();
        hidato.board = board;
        hidato.start = start;
        hidato.end = end;

        return hidato;
    }

    private Hidato getBoard3() {
        int [][] board = {
            {5,0,2},
            {0,1,0},
            {7,0,9}
        };
        int start = 1;
        int end = 9;
        Hidato hidato = new Hidato();
        hidato.board = board;
        hidato.start = start;
        hidato.end = end;

        return hidato;
    }
    

    class Hidato{
        int [][] board;
        int start, end;
    }
    private boolean solve(Hidato hidato, int row, int col, Set<Integer> filledValues) {
        int [][] board = hidato.board;
        // Base case: If row is equal to board length, entire board has been filled
        if (row == board.length) {
            return true;
        }
        
        // Move to next row when current row is fully filled
        if (col == board.length) {
            //System.out.println("Filled row : " + row);
            return solve(hidato, row + 1, 0, filledValues);
        }
        
        // Skip cells that are already filled
        if (board[row][col] != EMPTY && board[row][col] != BLOCKED) {
            return solve(hidato, row, col + 1, filledValues);
        }
        
        // Try different numbers in current cell
        for (int num = hidato.start; num <= hidato.end; num++) {
            if(filledValues.contains(num)) continue;
            if (isValidPlacement(hidato, row, col, num, filledValues)) {
                board[row][col] = num; // Fill current cell with valid number
                filledValues.add(num);
                // Move to next cell
                if (solve(hidato, row, col + 1, filledValues)) {
                    return true;
                }
                
                // Backtrack to previous state if solution not found
                filledValues.remove(board[row][col]);
                board[row][col] = EMPTY;
            }
        }
        
        // No valid solution found
        return false;
    }

    private boolean isValidPlacement(Hidato hidato, int row, int col, int num, Set<Integer> filledValues) {
        hidato.board[row][col] = num;
        boolean isValid = validate(hidato, filledValues);
        hidato.board[row][col] = EMPTY;
        return isValid;
    }

    private boolean validate(Hidato hidato, Set<Integer> filledValues){
        int [][] board = hidato.board;
        int start = hidato.start;
        int end = hidato.end;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                int val = board[i][j];
                if(val != EMPTY && val != BLOCKED){
                    int previous = val - 1;
                    if(previous>=start && filledValues.contains(previous)){
                        if(!isNeighbor(previous, i, j, board)){
                            return false;
                        }
                    }
                    int next = val + 1;
                    if(next<=end && filledValues.contains(next)){
                        if(!isNeighbor(next, i, j, board)){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    boolean isNeighbor(int num, int row, int col, int [][] hidato){
        for(int i = row -1; (i <= row + 1) && (i < hidato.length); i++){
            if (i< 0) continue;
            for(int j = col -1; (j <= col +1) && (j < hidato.length); j++){
                if (j<0) continue;
                if(hidato[i][j] == num) return true;
            }
        }
        return false;
    }

}
