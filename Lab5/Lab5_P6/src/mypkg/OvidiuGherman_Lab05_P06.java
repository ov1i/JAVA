package mypkg;

import java.util.Scanner;

/*	6. 
 * Define an interface called ChessPiece which defines the prototype for the method move(). Create the specific classes
 * for each of the chess pieces and implement the move() method according to the rules of movement on the chess board.
 * The method takes as input the chess piece’s current location and the direction of the move given by the geographical
 * coordinates (N, S, E, V, NE, NV, SE, SV), and returns the final position of the piece. Pay attention to the pieces which can
 * move a different number of cells!!
 */

interface ChessPiece {
	public int[] move(int [] position, String direction); 
}

abstract class Chess implements ChessPiece {
	private String color;
	
	Chess() {
		this.color = null;
	}
	Chess(String color) {
		this.color = color.toLowerCase();
	}
	public String getColor() {
		return this.color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}

class Pawn extends Chess {

	@Override
	public int[] move(int[] position, String direction) {
		if(this.getColor().equals("white") &&  direction.toUpperCase().equals("N") && position[0]+1 < 9 ) {
			return new int[] {position[0] + 1, position[1]}; 
		}
		if(this.getColor().equals("black") &&  direction.toUpperCase().equals("S") && position[0]-1 >= 1)
		{
			return new int[] {position[0] - 1, position[1]};
		}
		return position;
	}
	
}

class Rook extends Chess {

	@Override
	public int[] move(int[] position, String direction) {
		int times = position[2];
		while(times != 0) {
			if(direction.toUpperCase().equals("N") && position[0] + times < 9) {
				return new int[] {position[0] + times, position[1]};
			}
			if(direction.toUpperCase().equals("S") && position[0] - times >= 1) {
				return new int[] {position[0] - times, position[1]};
			}
			if(direction.toUpperCase().equals("W") && position[1] - times >= 1) {
				return new int[] {position[0], position[1] - times};
			}
			if(direction.toUpperCase().equals("E") && position[1] + times < 9) {
			return new int[] {position[0], position[1] + times};
			}
			times--;
			}
		return position;		
	}
	
}

class Knight extends Chess {

	@Override
	public int[] move(int[] position, String direction) {
		if(direction.toUpperCase().equals("NNW") && position[0]  + 3  < 9 && position[1] - 1 >= 1) {
			return new int[] {position[0] + 3, position[1] - 1};
		}
		if(direction.toUpperCase().equals("NNE") && position[0] + 3 < 9 && position[1] + 1 < 9) {
			return new int[] {position[0] + 3, position[1] + 1};
		}
		if(direction.toUpperCase().equals("NW") && position[0] + 1 < 9 && position[1] - 3 >= 1 ) {
			return new int[] {position[0] + 1, position[1] - 3};
		}
		if(direction.toUpperCase().equals("NE") && position[0] + 1 < 9 && position[1] + 3 < 9) {
			return new int[] {position[0] + 1, position[1] + 3};
		}
		if(direction.toUpperCase().equals("SSW") && position[0]  - 3  >= 1 && position[1] - 1 >= 1) {
			return new int[] {position[0] - 3, position[1] - 1};
		}
		if(direction.toUpperCase().equals("SSE") && position[0] - 3 >= 1 && position[1] + 1 < 9) {
			return new int[] {position[0] - 3, position[1] + 1};
		}
		if(direction.toUpperCase().equals("SW") && position[0] - 1 >= 1 && position[1] - 3 >= 1 ) {
			return new int[] {position[0] - 1, position[1] - 3};
		}
		if(direction.toUpperCase().equals("SE") && position[0] - 1 >= 1 && position[1] + 3 < 9) {
			return new int[] {position[0] - 1, position[1] + 3};
		}
		return position;
	}
	
}

class Queen extends Chess {

	@Override
	public int[] move(int[] position, String direction) {
		int times = position[2];
		while(times != 0) {
			if(direction.toUpperCase().equals("N") && position[0] + times < 9) {
				return new int[] {position[0] + times, position[1]};
			}
			if(direction.toUpperCase().equals("S") && position[0] - times >= 1) {
				return new int[] {position[0] - times, position[1]};
			}
			if(direction.toUpperCase().equals("W") && position[1] - times >= 1) {
				return new int[] {position[0], position[1] - times};
			}
			if(direction.toUpperCase().equals("E") && position[1] + times < 9) {
				return new int[] {position[0], position[1] + times};
			}
			if(direction.toUpperCase().equals("NE") && position[0] + times < 9 && position[1] + times < 9) {
				return new int[] {position[0] + times, position[1] + times};
			}
			if(direction.toUpperCase().equals("SE") && position[0] - times >= 1 && position[1] + times < 9) {
				return new int[] {position[0] - times, position[1] + times};
			}
			if(direction.toUpperCase().equals("NW") && position[0] + times < 9 && position[1] - times >= 1) {
				return new int[] {position[0] + times, position[1] - times};
			}
			if(direction.toUpperCase().equals("SW") && position[0] - times >= 1 && position[1] - times >= 1) {
				return new int[] {position[0] - times, position[1] - times};
			}
			times--;
		}
		
		return position;
	}
	
}

class Bishop extends Chess {

	@Override
	public int[] move(int[] position, String direction) {
		int times = position[2];
		while(times !=0) {
			if(direction.toUpperCase().equals("NE") && position[0] + times < 9 && position[1] + times < 9) {
				return new int[] {position[0] + times, position[1] + times};
			}
			if(direction.toUpperCase().equals("SE") && position[0] - times >= 1 && position[1] + times < 9) {
				return new int[] {position[0] - times, position[1] + times};
			}
			if(direction.toUpperCase().equals("NW") && position[0] + times < 9 && position[1] - times >= 1) {
				return new int[] {position[0] + times, position[1] - times};
			}
			if(direction.toUpperCase().equals("SW") && position[0] - times >= 1 && position[1] - times >= 1) {
				return new int[] {position[0] - times, position[1] - times};
			}
			times--;
		}
		return position;
	}
}
class King extends Chess {

	@Override
	public int[] move(int[] position, String direction) {
		if(direction.toUpperCase().equals("N") && position[0] + 1 < 9) {
			return new int[] {position[0] + 1, position[1]};
		}
		if(direction.toUpperCase().equals("S") && position[0] - 1 >= 1) {
			return new int[] {position[0] - 1, position[1]};
		}
		if(direction.toUpperCase().equals("W")&& position[1] - 1 >= 1) {
			return new int[] {position[0], position[1] - 1};
		}
		if(direction.toUpperCase().equals("E") && position[1] + 1 < 9) {
			return new int[] {position[0], position[1] + 1};
		}
		if(direction.toUpperCase().equals("NE") && position[0] + 1 < 9 && position[1] + 1 < 9) {
			return new int[] {position[0] + 1, position[1] + 1};
		}
		if(direction.toUpperCase().equals("SE") && position[0] - 1 >= 1 && position[1] + 1 < 9) {
			return new int[] {position[0] - 1, position[1] + 1};
		}
		if(direction.toUpperCase().equals("NW") && position[0] + 1 < 9 && position[1] - 1 >= 1) {
			return new int[] {position[0] + 1, position[1] - 1};
		}
		if(direction.toUpperCase().equals("SW") && position[0] - 1 >= 1 && position[1] - 1 >= 1) {
			return new int[] {position[0] - 1, position[1] - 1};
		}
		return position;
	}
}


public class OvidiuGherman_Lab05_P06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		int[] arr;
		Chess piece;
		System.out.println("Type \"Help\" to see the available commands!");
		while(true) {
			System.out.print("->Input: ");
			input = scanner.nextLine();
			if(input.toLowerCase().equals("pawn")) {
				piece = new Pawn();
				do {
					System.out.print("Please enter the color of the pawn(white/black): ");
					input = scanner.nextLine();
					piece.setColor(input.toLowerCase());
				}while(!piece.getColor().toLowerCase().equals("white") && !piece.getColor().toLowerCase().equals("black"));
				
				while(true) {
					System.out.print("Please enter the direction of the pawn: ");
					input = scanner.next();
					if(piece.getColor().toLowerCase().equals("black") && input.toUpperCase().equals("S")) {
						break;
					}
					else if(piece.getColor().toLowerCase().equals("white") && input.toUpperCase().equals("N")) {
						break;
					}
				}
				while(true) {
					System.out.print("Please enter the location of the pawn(ex: H 1): ");
					char b;
					int a;
					b = scanner.next().charAt(0);
					a = scanner.nextInt();
					arr = new int[] { a, ((int)(b) - 64)};
					if((a > 0 && a < 9) && (b >= 'A' && b <= 'H')) {
						break;
					}
				}
				System.out.println("Pawn (" + piece.getColor() + "): \n->Origina location: " + (char)(arr[1] + 64) + arr[0]);
				System.out.println("->New location: " + (char)(piece.move(arr, input)[1] + 64) + piece.move(arr, input)[0]);
				scanner.nextLine();
			}
			
			else if(input.toLowerCase().equals("queen")) {
				piece = new Queen();
				do {
					System.out.print("Please enter the color of the queen(white/black): ");
					input = scanner.nextLine();
					piece.setColor(input);
				}while(!piece.getColor().toLowerCase().equals("white") && !piece.getColor().toLowerCase().equals("black"));
				
				while(true) {
					System.out.print("Please enter the direction of the queen: ");
					input = scanner.next();
					if(input.toUpperCase().equals("S") || input.toUpperCase().equals("N") || input.toUpperCase().equals("NW") || input.toUpperCase().equals("NE") || input.toUpperCase().equals("SW") || input.toUpperCase().equals("SE")
							|| input.toUpperCase().equals("E") || input.toUpperCase().equals("W")) {
						break;
					}
				}
				while(true) {
					System.out.print("Please enter the location and how many cells the queen will move(ex: H 1 2): ");
					char b;
					int a;
					int c;
					scanner.nextLine();
					b = scanner.next().charAt(0);
					a = scanner.nextInt();
					c = scanner.nextInt();
					arr = new int[] { a, ((int)b - 64), c};
					if((a > 0 && a < 9) && (b >= 'A' && b <= 'H') && (c > 0 && c < 9)) {
						break;
					}
				}
				System.out.println("Queen (" + piece.getColor() + "): \n->Origina location: " + (char)(arr[1] + 64) + arr[0]);
				System.out.println("->New location: " + (char)(piece.move(arr, input)[1] + 64) + piece.move(arr, input)[0]);	
				scanner.nextLine();
			}
			
			
			else if(input.toLowerCase().equals("king")) {
				piece = new King();
				do {
					System.out.print("Please enter the color of the king(white/black): ");
					input = scanner.nextLine();
					piece.setColor(input);
				}while(!piece.getColor().toLowerCase().equals("white") && !piece.getColor().toLowerCase().equals("black"));
				
				while(true) {
					System.out.print("Please enter the direction of the king: ");
					input = scanner.next();
					if(input.toUpperCase().equals("S") || input.toUpperCase().equals("N") || input.toUpperCase().equals("NW") || input.toUpperCase().equals("NE") || input.toUpperCase().equals("SW") || input.toUpperCase().equals("SE") 
							|| input.toUpperCase().equals("E") || input.toUpperCase().equals("W")) {
						break;
					}
				}
				while(true) {
					System.out.print("Please enter the location of the king(ex: H 1): ");
					char b;
					int a;
				 	scanner.nextLine();
					b = scanner.next().charAt(0);
					a = scanner.nextInt();					
					arr = new int[] { a, ((int)b - 64)};
					if((a > 0 && a < 9) && (b >= 'A' && b <= 'H')) {
						break;
					}
				}
				
				System.out.println("King (" + piece.getColor() + "): \n->Origina location: " + (char)(arr[1] + 64) + arr[0]);
				System.out.println("->New location: " + (char)(piece.move(arr, input)[1] + 64) + piece.move(arr, input)[0]);
				scanner.nextLine();
			}
			
			
			else if(input.toLowerCase().equals("bishop")) {
				piece = new Bishop();
				do {
					System.out.print("Please enter the color of the bishop(white/black): ");
					input = scanner.nextLine();
					piece.setColor(input);
				} while(!piece.getColor().toLowerCase().equals("white") && !piece.getColor().toLowerCase().equals("black"));
				
				
				while(true) {
					System.out.print("Please enter the direction of the bishop: ");
					input = scanner.next();
					if(input.toUpperCase().equals("NW") || input.toUpperCase().equals("NE") || input.toUpperCase().equals("SW") || input.toUpperCase().equals("SE") ) {
						break;
					}
				}
				while(true) {
					System.out.print("Please enter the location and how many cells the bishop will move(ex: H 1 2): ");
					char b;
					int a;
					int c;
					scanner.nextLine();
					b = scanner.next().charAt(0);
					a = scanner.nextInt();
					c = scanner.nextInt();
					arr = new int[] { a, ((int)b - 64), c};
					if((a > 0 && a < 9) && (b >= 'A' && b <= 'H') && (c > 0 && c < 9)) {
						break;
					}
				}
				
				System.out.println("Bishop (" + piece.getColor() + "): \n->Origina location: " + (char)(arr[1] + 64) + arr[0]);
				System.out.println("->New location: " + (char)(piece.move(arr, input)[1] + 64) + piece.move(arr, input)[0]);
				scanner.nextLine();
			}
			
			
			else if(input.toLowerCase().equals("rook")) {
				piece = new Rook();
				do {
					System.out.print("Please enter the color of the rook(white/black): ");
					input = scanner.nextLine();
					piece.setColor(input);
				}while(!piece.getColor().toLowerCase().equals("white") && !piece.getColor().toLowerCase().equals("black"));
				
				while(true) {
					System.out.print("Please enter the direction of the rook: ");
					input = scanner.next();
					if(input.toUpperCase().equals("S") || input.toUpperCase().equals("N") || input.toUpperCase().equals("E") || input.toUpperCase().equals("W")) {
						break;
					}
				}
				while(true) {
					System.out.print("Please enter the location and how many cells the rook will move(ex: H 1 2): ");
					char b;
					int a;
					int c;
					scanner.nextLine();
					b = scanner.next().charAt(0);
					a = scanner.nextInt();
					c = scanner.nextInt();
					arr = new int[] { a, ((int)b - 64), c};
					if((a > 0 && a < 9) && (b >= 'A' && b <= 'H') && (c > 0 && c < 9)) {
						break;
					}
				}
				
				System.out.println("Rook (" + piece.getColor() + "): \n->Origina location: " + (char)(arr[1] + 64) + arr[0]);
				System.out.println("->New location: " + (char)(piece.move(arr, input)[1] + 64) + piece.move(arr, input)[0]);
				scanner.nextLine();
			}
			
			else if(input.toLowerCase().equals("knight")) {
				piece = new Knight();
				do {
					System.out.print("Please enter the color of the knight(white/black): ");
					input = scanner.nextLine();
					piece.setColor(input);
				}while(!piece.getColor().toLowerCase().equals("white") && !piece.getColor().toLowerCase().equals("black"));
				
				while(true) {
					System.out.print("Please enter the direction of the knight(NNE|NNW|NW|NE|SSE|SSW|SE|SW): ");
					input = scanner.next();
					if(input.toUpperCase().equals("NNW") || input.toUpperCase().equals("NNE") || input.toUpperCase().equals("SSW") || input.toUpperCase().equals("SSE") || input.toUpperCase().equals("SW") || input.toUpperCase().equals("SE") 
							|| input.toUpperCase().equals("NE") || input.toUpperCase().equals("NW")) {
						break;
					}
				}
				while(true) {
					System.out.print("Please enter the location of the knight(ex: H 1): ");
					char b;
					int a;
				 	scanner.nextLine();
					b = scanner.next().charAt(0);
					a = scanner.nextInt();					
					arr = new int[] { a, ((int)b - 64)};
					if((a > 0 && a < 9) && (b >= 'A' && b <= 'H')) {
						break;
					}
				}
				System.out.println("Knight (" + piece.getColor() + "): \n->Origina location: " + (char)(arr[1] + 64) + arr[0]);
				System.out.println("->New location: " + (char)(piece.move(arr, input)[1] + 64) + piece.move(arr, input)[0]);
				scanner.nextLine();
			}
			else if(input.toLowerCase().equals("help")) {
				System.out.println("COMMANDS: \n->PAWN-(black-S|white-N)");
				System.out.println("->BISHOP-(black/white(NE|NW|SE|SW : type the number of cells you want to move..ex : H 1 2)");
				System.out.println("->QUEEN-(black/white(N|S|E|W|NW|NE|SW|SE : type the number of cells you want to move..ex: H 1 2)");
				System.out.println("->KING-(black/white(N|S|E|W|NW|NE|SW|SE)");
				System.out.println("->ROOK-(black/white(N|S|E|W : type the number of cells you want to move..ex: H 1 2)");
				System.out.println("->KNIGHT-(black/white(NNW|NNE|SSW|SSE|NW|NE|SE|SW)");
				
			}
			else if(input.toLowerCase().equals("bye")) {
				System.out.println("Game Over!");
				break;				
			}
			else {
				System.out.println("Invlid input!\nType help to list the available commands!\n");
			}
		}
		scanner.close();
	}
}
