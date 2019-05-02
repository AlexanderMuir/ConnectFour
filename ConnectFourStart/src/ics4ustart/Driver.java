package ics4ustart;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) throws InterruptedException {

		// Setup constants for the Board
		final int ROWS = 7;
		final int COLS = 7;

		// create the board
		Board board = new Board(ROWS, COLS);
		board.display();

		boolean done = false;
		//String value = "";

		int column = 0;
		
		CellState currentP = CellState.P1;
		
		while (!done) {
			System.out.println(currentP +"'s turn");
			column = getColumn() -1;
			int currentRow = 0;
			
			
			//placing pieces at lowest height in column
			for(int i = ROWS -1 ; i >= 0; i--) {
				if(board.getCell(i,column).getState() == CellState.EMPTY) {
					board.getCell(i, column).setState(currentP);
					currentRow = i;
					break;
				}
				
			}
			
			
			//vertical win check
			if(currentRow<=3) {
				if(board.getCell(currentRow+1,column).getState() == currentP) {
					if(board.getCell(currentRow+2,column).getState() == currentP) {
						if(board.getCell(currentRow+3,column).getState() == currentP) {
							System.out.println(currentP + " wins");
							done = true;
						}
					}	
				}
			}
			
			
			//horizontal win check
			
			int horizNum = 1;
			
			//checking to the left
			for(int i = 1; i < 4; i++) {
				if( column - i >= 0) {
					if(board.getCell(currentRow,column-i).getState() == currentP) {
						horizNum ++;
					}
				}
			}
			
			//checking to the right
			for(int i = 1; i < 4; i++) {
				if( column + i < ROWS) {
					if(board.getCell(currentRow,column+i).getState() == currentP) {
						horizNum ++;
					}
				}
			}
			
			
			if(horizNum ==  4) {
				System.out.println(currentP + "wins");
				done = true;
			}
			
			
			
			//diagonal win check
			//top left to bottom right
			/*
			int diagNumTLBR = 1;
			
			//checking to left
			for(int i = 1; i < 4; i++) {
				if( column - i >= 0  && currentRow - i >= 0) {
					if(board.getCell(currentRow-i,column-i).getState() == currentP) {
						diagNumTLBR ++;
					}
				}
			}
			
			//checking to right
			for(int i = 1; i < 4; i++) {
				System.out.println(i);
				if( column + i < COLS && currentRow + i < ROWS) {
					if(board.getCell(currentRow+i,column+i).getState() == currentP) {
						diagNumTLBR ++;
					}
				}
			}
			
			if(diagNumTLBR == 4) {
				System.out.println(currentP + "wins");
				done = true;
			}
			
			//bottom left to top right
			
			int diagNumBLTR = 1;
			
			//checking to left
			for(int i = 1; i < 4; i++) {
				if( column - i >= 0 && currentRow + i < ROWS) {
					if(board.getCell(currentRow+i,column-i).getState() == currentP) {
						diagNumBLTR ++;
					}
				}
			}
			
			//checking to right
			for(int i = 1; i < 4; i++) {
				if( column - i >= 0 && currentRow - 2 - i > 0) {
					if(board.getCell(currentRow-2-i,column+i).getState() == currentP) {
						diagNumBLTR ++;
					}
				}
			}
			
			if(diagNumBLTR == 4) {
				System.out.println(currentP + "wins");
				done = true;
			}
			*/
			
			//swapping players
			if(currentP == CellState.P1) {
				currentP = CellState.P2;
			}
			else {
				currentP = CellState.P1;
			}
			
			
			
			board.display();
		}
	}

	private static int getColumn() {
		boolean valid = false;
		int column = 0;
		Scanner in = new Scanner(System.in);
		
		
		while(!valid) {
			System.out.print("Which Column (1-7) :");
			if(in.hasNextInt()) {
				column=in.nextInt();
				if(column<1 || column >7) {
					in.nextLine();
					System.out.println("An integer in between 1-7 is expected try again.");
				}
				else if(column>=1 && column <=7){
					valid=true;
				}
			}
			else {
				in.nextLine();
				System.out.println("An integer in between 1-7 is expected try again.");
			}
		}
		return column;

	}
}
