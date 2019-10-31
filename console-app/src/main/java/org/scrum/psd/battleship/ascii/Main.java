package org.scrum.psd.battleship.ascii;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;
import org.scrum.psd.battleship.controller.GameController;
import org.scrum.psd.battleship.controller.dto.Letter;
import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static List<Ship> myFleet;
    private static List<Ship> enemyFleet;
    private static ColoredPrinter console;
    private static List flag = new ArrayList();

    public static void main(String[] args) {
        console = new ColoredPrinter.Builder(1, false).build();

        console.setForegroundColor(Ansi.FColor.MAGENTA);
        console.println("===COMPUTER===");
        console.println("                                     |__");
        console.println("                                     |\\/");
        console.println("                                     ---");
        console.println("                                     / | [");
        console.println("                              !      | |||");
        console.println("                            _/|     _/|-++'");
        console.println("                        +  +--|    |--|--|_ |-");
        console.println("                     { /|__|  |/\\__|  |--- |||__/");
        console.println("                    +---------------___[}-_===_.'____                 /\\");
        console.println("                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _");
        console.println(" __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7");
        console.println("|                        Welcome to Battleship                         BB-61/");
        console.println(" \\_________________________________________________________________________|");
        console.println("");
        console.println("\n");
        console.println("\n");


        console.println("===PLAYER 1===");
        console.println("                                     |__");
        console.println("                                     |\\/");
        console.println("                                     ---");
        console.println("                                     / | [");
        console.println("                              !      | |||");
        console.println("                            _/|     _/|-++'");
        console.println("                        +  +--|    |--|--|_ |-");
        console.println("                     { /|__|  |/\\__|  |--- |||__/");
        console.println("                    +---------------___[}-_===_.'____                 /\\");
        console.println("                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _");
        console.println(" __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7");
        console.println("|                        Welcome to Battleship                         BB-61/");
        console.println(" \\_________________________________________________________________________|");
        console.println("");
        console.clear();

        InitializeGame();

        StartGame();
    }

    private static void StartGame() {
        Scanner scanner = new Scanner(System.in);

        console.setForegroundColor(Ansi.FColor.GREEN);
        console.print("\033[2J\033[;H");
        console.println("                  __");
        console.println("                 /  \\");
        console.println("           .-.  |    |");
        console.println("   *    _.-'  \\  \\__/");
        console.println("    \\.-'       \\");
        console.println("   /          _/");
        console.println("  |      _  /\" \"");
        console.println("  |     /_\'");
        console.println("   \\    \\_/");
        console.println("    \" \"\" \"\" \"\" \"");

        do {
            console.setForegroundColor(Ansi.FColor.GREEN);
            console.println("");
            console.println("Player, it's your turn");
            console.println("Enter coordinates for your shot :");
            Position position = parsePosition(scanner.next());
            boolean isHit = GameController.checkIsHit(enemyFleet, position);
            if (isHit) {
                beep();

                console.setForegroundColor(Ansi.FColor.RED);
                console.println("                \\         .  ./");
                console.println("              \\      .:\" \";'.:..\" \"   /");
                console.println("                  (M^^.^~~:.'\" \").");
                console.println("            -   (/  .    . . \\ \\)  -");
                console.println("               ((| :. ~ ^  :. .|))");
                console.println("            -   (\\- |  \\ /  |  /)  -");
                console.println("                 -\\  \\     /  /-");
                console.println("                   \\  \\   /  /");
            }

            for(int j=0;j<5;j++) {
                enemyFleet.get(j).getPositions();
                if(enemyFleet.get(j).getPositions() == null) {
                 console.println("You already hit that coordinate! Try another coordinate...");
            }}

            console.println(isHit ? "Yeah ! Nice hit !" : "Missed hit Enemy's fleet");
            for(Ship ship : enemyFleet) {
            	//System.out.println(position.getColumn()+ ""+position.getRow());
                //System.out.println("position ship : "+ship.getPositions());
                try {
                    for(Position pos: ship.getPositions())
                    if((pos.getColumn()+""+pos.getRow()).equals(position.getColumn()+ ""+position.getRow()))
                    {
                     
                        if((pos.getColumn().equals(Letter.B))){
                            System.out.print("You hit Aircraft Carrier of Enemy's fleet Shooted at : " + pos.getColumn()+""+pos.getRow());
                            flag.add(pos.getColumn()+""+pos.getRow());
                        } else if((pos.getColumn().equals(Letter.E))) {
                            System.out.print("You hit Battleship of Enemy's fleet Shooted at : " + pos.getColumn()+""+pos.getRow());
                            flag.add(pos.getColumn()+""+pos.getRow());
                        }else if((pos.getRow() == 3)) {
                            System.out.print("You hit Submarine of Enemy's fleet Shooted at : " + pos.getColumn()+""+pos.getRow());
                            flag.add(pos.getColumn()+""+pos.getRow());
                        }else if((pos.getRow() == 8)) {
                            System.out.print("You hit Destroyer of Enemy's fleet Shooted at : " + pos.getColumn()+""+pos.getRow());
                            flag.add(pos.getColumn()+""+pos.getRow());
                        }else if((pos.getColumn().equals(Letter.C))) {
                            System.out.print("You hit Patrol Boat of Enemy's fleet Shooted at : " + pos.getColumn()+""+pos.getRow());
                            flag.add(pos.getColumn()+""+pos.getRow());
                        }
                        for(int i=0;i<5;i++) {
                        enemyFleet.get(i).getPositions().remove(new Position(pos.getColumn(),pos.getRow()));
                        if(enemyFleet.get(i).getPositions().size()==0) {
                         console.println("\n"+ship.getName() + " has been sunk");
                         }
                     }
                     
                     //flag.add(pos.getColumn()+""+pos.getRow());
                        
                    }
                }
                catch(Exception e) {
                    
                }
            	//System.out.println(ship.getName() + " Ship is sunk ");	
            }
            position = getRandomPosition();
            isHit = GameController.checkIsHit(myFleet, position);
            console.setForegroundColor(Ansi.FColor.YELLOW);
            console.println("");
            console.println(String.format("Computer shoot in %s%s and %s", position.getColumn(), position.getRow(), isHit ? "hit your ship !" : "miss"));
            if (isHit) {
                beep();

                console.setForegroundColor(Ansi.FColor.WHITE);
                console.println("                \\         .  ./");
                console.println("              \\      .:\" \";'.:..\" \"   /");
                console.println("                  (M^^.^~~:.'\" \").");
                console.println("            -   (/  .    . . \\ \\)  -");
                console.println("               ((| :. ~ ^  :. .|))");
                console.println("            -   (\\- |  \\ /  |  /)  -");
                console.println("                 -\\  \\     /  /-");
                console.println("                   \\  \\   /  /");

            }
        } while (true);
    }

    private static void beep() {
        console.print("\007");
    }

    protected static Position parsePosition(String input) {
        Letter letter = Letter.valueOf(input.toUpperCase().substring(0, 1));
        int number = Integer.parseInt(input.substring(1));
        return new Position(letter, number);
    }

    private static Position getRandomPosition() {
        int rows = 8;
        int lines = 8;
        Random random = new Random();
        Letter letter = Letter.values()[random.nextInt(lines)];
        int number = random.nextInt(rows);
        Position position = new Position(letter, number);
        return position;
    }

    private static void InitializeGame() {
        //InitializeMyFleet();

        InitializeEnemyFleet();
    }

    private static void InitializeMyFleet() {
        Scanner scanner = new Scanner(System.in);
        myFleet = GameController.initializeShips();

        console.println("Please position your fleet (Game board has size from A to H and 1 to 8) :");

        for (Ship ship : myFleet) {
            console.println("");
            console.println(String.format("Please enter the positions for the %s (size: %s)", ship.getName(), ship.getSize()));
            for (int i = 1; i <= ship.getSize(); i++) {
                console.println(String.format("Enter position %s of %s (i.e A3):", i, ship.getSize()));

                String positionInput = scanner.next();
                ship.addPosition(positionInput);
            }
        }
    }

    private static void InitializeEnemyFleet() {
        int maxNumber = 8;
    	String letter = "";
        enemyFleet = GameController.initializeShips();
        ArrayList<String> currentLetter = new ArrayList<String>();
        
        for(Ship ship : enemyFleet) {
        	int number = 0;
        	boolean flag = true;
        	boolean flagLetter = true;
        	//letter = getRandomPosition().getColumn().toString();
        	      	
        	        	
        	while(flagLetter) {
        		letter = getRandomPosition().getColumn().toString();
        		//console.debugPrintln(letter);
        		currentLetter.add(letter);
        		if (currentLetter.contains(letter)) {
        			//console.println(letter);
        			flagLetter = false;
        		}
        	}
        	
        	int diff = maxNumber - ship.getSize();
        	//console.debugPrintln(diff);
        	while (flag) {
        		number = getRandomPosition().getRow();
        		if (number <= diff && number != 0) {
        			flag = false;
        			//console.println(number);
        		}
        	}
        	 for (int i = 1; i <= ship.getSize(); i++) {
				console.print(letter+number+",");
				ship.addPosition(letter+number);
				number++;
			}
        	console.println("");
        }

        //enemyFleet = GameController.initializeShips();

        /*enemyFleet.get(0).getPositions().add(new Position(Letter.B, 4));
        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 5));
        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 6));
        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 7));
        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 8));

        enemyFleet.get(1).getPositions().add(new Position(Letter.E, 6));
        enemyFleet.get(1).getPositions().add(new Position(Letter.E, 7));
        enemyFleet.get(1).getPositions().add(new Position(Letter.E, 8));
        enemyFleet.get(1).getPositions().add(new Position(Letter.E, 9));

        enemyFleet.get(2).getPositions().add(new Position(Letter.A, 3));
        enemyFleet.get(2).getPositions().add(new Position(Letter.B, 3));
        enemyFleet.get(2).getPositions().add(new Position(Letter.C, 3));

        enemyFleet.get(3).getPositions().add(new Position(Letter.F, 8));
        enemyFleet.get(3).getPositions().add(new Position(Letter.G, 8));
        enemyFleet.get(3).getPositions().add(new Position(Letter.H, 8));

        enemyFleet.get(4).getPositions().add(new Position(Letter.C, 5));
        enemyFleet.get(4).getPositions().add(new Position(Letter.C, 6));*/
    }
}
