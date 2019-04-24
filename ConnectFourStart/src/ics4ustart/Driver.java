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
		String value = "";

		int column = 0;
		
		CellState currentP = CellState.P1;

		while (!done) {
			column = getColumn();
			
			for(int i = ROWS -1 ; i >= 0; i--) {
				if(board.getCell(i,column-1).getState() == CellState.EMPTY) {
					board.getCell(i, column-1).setState(CellState.P1);
					break;
				}
				
			}
			
			
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
			if(in.hasNextInt() && in.nextInt() >0 && in.nextInt() <=7) {
				//column = Integer.parseInt(in.nextLine().trim());
				
				column = in.nextInt();
				valid = true;
			
				
			}
			else {
				in.nextLine();
				System.out.println("Must be between 1 and 7");
			}
			
			
		}
		in.close();
		return column;

	}
}
