import java.util.ArrayList;

public class GameMenu {
    private Player player1;
    private Player player2;
    private int limit;
    private int turn;
    private int selectedSpotX;
    private int selectedSpotY;
    private int startSpotX;
    private int startSpotY;
    private int movedSpotX;
    private int movedSpotY;
    private int winner;
    private boolean isSelected = false;
    private boolean isDestroyed = false;
    private boolean isMoved = false;
    private boolean hasUndo = true;
    private Piece deadPiece = null;
    private ArrayList<String> player1Moves = new ArrayList<>();
    private ArrayList<String> player2Moves = new ArrayList<>();
    private ArrayList<String> allMoves = new ArrayList<>();

    public GameMenu(Player playerNo1, Player playerNo2, int limit1) {
        player1 = playerNo1;
        player2 = playerNo2;
        limit = limit1;
    }

    public void startGame() {
        Pawn wPawn1 = new Pawn(0,1,2);
        Piece.allPieces.add(wPawn1);
        Pawn wPawn2 = new Pawn(0,2,2);
        Piece.allPieces.add(wPawn2);
        Pawn wPawn3 = new Pawn(0,3,2);
        Piece.allPieces.add(wPawn3);
        Pawn wPawn4 = new Pawn(0,4,2);
        Piece.allPieces.add(wPawn4);
        Pawn wPawn5 = new Pawn(0,5,2);
        Piece.allPieces.add(wPawn5);
        Pawn wPawn6 = new Pawn(0,6,2);
        Piece.allPieces.add(wPawn6);
        Pawn wPawn7 = new Pawn(0,7,2);
        Piece.allPieces.add(wPawn7);
        Pawn wPawn8 = new Pawn(0,8,2);
        Piece.allPieces.add(wPawn8);
        Rook wRook1 = new Rook(0,1,1);
        Piece.allPieces.add(wRook1);
        Rook wRook2 = new Rook(0,8,1);
        Piece.allPieces.add(wRook2);
        Knight wKnight1 = new Knight(0,2,1);
        Piece.allPieces.add(wKnight1);
        Knight wKnight2 = new Knight(0,7,1);
        Piece.allPieces.add(wKnight2);
        Bishop wBishop1 = new Bishop(0,3,1);
        Piece.allPieces.add(wBishop1);
        Bishop wBishop2 = new Bishop(0,6,1);
        Piece.allPieces.add(wBishop2);
        Queen wQueen = new Queen(0,4,1);
        Piece.allPieces.add(wQueen);
        King wKing = new King(0,5,1);
        Piece.allPieces.add(wKing);
        Pawn bPawn1 = new Pawn(1,1,7);
        Piece.allPieces.add(bPawn1);
        Pawn bPawn2 = new Pawn(1,2,7);
        Piece.allPieces.add(bPawn2);
        Pawn bPawn3 = new Pawn(1,3,7);
        Piece.allPieces.add(bPawn3);
        Pawn bPawn4 = new Pawn(1,4,7);
        Piece.allPieces.add(bPawn4);
        Pawn bPawn5 = new Pawn(1,5,7);
        Piece.allPieces.add(bPawn5);
        Pawn bPawn6 = new Pawn(1,6,7);
        Piece.allPieces.add(bPawn6);
        Pawn bPawn7 = new Pawn(1,7,7);
        Piece.allPieces.add(bPawn7);
        Pawn bPawn8 = new Pawn(1,8,7);
        Piece.allPieces.add(bPawn8);
        Rook bRook1 = new Rook(1,1,8);
        Piece.allPieces.add(bRook1);
        Rook bRook2 = new Rook(1,8,8);
        Piece.allPieces.add(bRook2);
        Knight bKnight1 = new Knight(1,2,8);
        Piece.allPieces.add(bKnight1);
        Knight bKnight2 = new Knight(1,7,8);
        Piece.allPieces.add(bKnight2);
        Bishop bBishop1 = new Bishop(1,3,8);
        Piece.allPieces.add(bBishop1);
        Bishop bBishop2 = new Bishop(1,6,8);
        Piece.allPieces.add(bBishop2);
        Queen bQueen = new Queen(1,4,8);
        Piece.allPieces.add(bQueen);
        King bKing = new King(1,5,8);
        Piece.allPieces.add(bKing);
        for (Player player : Player.getAllPlayers()) {
            player.setUndoTerns(2);
        }
        while(limit > 0) {
            if(deadPiece == wKing) {
                winner = 2;
            }
            else if(deadPiece == bKing) {
                winner = 1;
            }
            System.gc();
            runGameMenu();
            System.gc();
        }
    }

    public void startUnLimitGame() {
        Pawn wPawn1 = new Pawn(0,1,2);
        Piece.allPieces.add(wPawn1);
        Pawn wPawn2 = new Pawn(0,2,2);
        Piece.allPieces.add(wPawn2);
        Pawn wPawn3 = new Pawn(0,3,2);
        Piece.allPieces.add(wPawn3);
        Pawn wPawn4 = new Pawn(0,4,2);
        Piece.allPieces.add(wPawn4);
        Pawn wPawn5 = new Pawn(0,5,2);
        Piece.allPieces.add(wPawn5);
        Pawn wPawn6 = new Pawn(0,6,2);
        Piece.allPieces.add(wPawn6);
        Pawn wPawn7 = new Pawn(0,7,2);
        Piece.allPieces.add(wPawn7);
        Pawn wPawn8 = new Pawn(0,8,2);
        Piece.allPieces.add(wPawn8);
        Rook wRook1 = new Rook(0,1,1);
        Piece.allPieces.add(wRook1);
        Rook wRook2 = new Rook(0,8,1);
        Piece.allPieces.add(wRook2);
        Knight wKnight1 = new Knight(0,2,1);
        Piece.allPieces.add(wKnight1);
        Knight wKnight2 = new Knight(0,7,1);
        Piece.allPieces.add(wKnight2);
        Bishop wBishop1 = new Bishop(0,3,1);
        Piece.allPieces.add(wBishop1);
        Bishop wBishop2 = new Bishop(0,6,1);
        Piece.allPieces.add(wBishop2);
        Queen wQueen = new Queen(0,4,1);
        Piece.allPieces.add(wQueen);
        King wKing = new King(0,5,1);
        Piece.allPieces.add(wKing);
        Pawn bPawn1 = new Pawn(1,1,7);
        Piece.allPieces.add(bPawn1);
        Pawn bPawn2 = new Pawn(1,2,7);
        Piece.allPieces.add(bPawn2);
        Pawn bPawn3 = new Pawn(1,3,7);
        Piece.allPieces.add(bPawn3);
        Pawn bPawn4 = new Pawn(1,4,7);
        Piece.allPieces.add(bPawn4);
        Pawn bPawn5 = new Pawn(1,5,7);
        Piece.allPieces.add(bPawn5);
        Pawn bPawn6 = new Pawn(1,6,7);
        Piece.allPieces.add(bPawn6);
        Pawn bPawn7 = new Pawn(1,7,7);
        Piece.allPieces.add(bPawn7);
        Pawn bPawn8 = new Pawn(1,8,7);
        Piece.allPieces.add(bPawn8);
        Rook bRook1 = new Rook(1,1,8);
        Piece.allPieces.add(bRook1);
        Rook bRook2 = new Rook(1,8,8);
        Piece.allPieces.add(bRook2);
        Knight bKnight1 = new Knight(1,2,8);
        Piece.allPieces.add(bKnight1);
        Knight bKnight2 = new Knight(1,7,8);
        Piece.allPieces.add(bKnight2);
        Bishop bBishop1 = new Bishop(1,3,8);
        Piece.allPieces.add(bBishop1);
        Bishop bBishop2 = new Bishop(1,6,8);
        Piece.allPieces.add(bBishop2);
        Queen bQueen = new Queen(1,4,8);
        Piece.allPieces.add(bQueen);
        King bKing = new King(1,5,8);
        Piece.allPieces.add(bKing);
        for (Player player : Player.getAllPlayers()) {
            player.setUndoTerns(2);
        }
        while(true) {
            if(deadPiece == wKing) {
                winner = 2;
            }
            else if(deadPiece == bKing) {
                winner = 1;
            }
            System.gc();
            runGameMenu();
            System.gc();
        }
    }

    public void select(int destX , int destY) {
        if(destX <= 8 && destY <= 8 && destX >= 1 && destY >= 1)  {
            if(Piece.getByPlace(destX,destY) != null) {
                if(Piece.getByPlace(destX,destY).getColor() == turn) {
                    selectedSpotX = destX;
                    selectedSpotY = destY;
                    isSelected = true;
                    System.out.println("selected");
                }
                else
                    System.out.println("you can only select one of your pieces");
            }
            else
                System.out.println("no piece on this spot");
        }
        else
            System.out.println("wrong coordination");
    }

    public void deselect() {
        if(isSelected) {
            selectedSpotX = 0;
            selectedSpotY = 0;
            isSelected = false;
            System.out.println("deselected");
        }
        else
            System.out.println("no piece is selected");
    }

    public void move(String destX, String destY) {
        if(!isMoved) {
            if(destX.length() < 7 && destY.length() < 7) {
                int distX = Integer.parseInt(destX);
                int distY = Integer.parseInt(destY);
                if(distX <= 8 && distY <= 8 && distX >= 1 && distY >= 1) {
                    if(isSelected) {
                        Piece piece = Piece.getByPlace(selectedSpotX,selectedSpotY);
                        if(piece.canMove(selectedSpotX,selectedSpotY,distX,distY) == 2) {
                            Piece destPiece = Piece.getByPlace(distX,distY);
                            isDestroyed = true;
                            isMoved = true;
                            Piece.deadPieces.add(destPiece);
                            deadPiece = destPiece;
                            Piece.allPieces.remove(destPiece);
                            piece.setX(distX);
                            piece.setY(distY);
                            startSpotX = selectedSpotX;
                            startSpotY = selectedSpotY;
                            movedSpotX = distX;
                            movedSpotY = distY;
                            if(turn == 0)
                                showMovesPlayer1();
                            else if(turn == 1)
                                showMovesPlayer2();
                            System.out.println("rival piece destroyed");
                        }
                        else if(piece.canMove(selectedSpotX,selectedSpotY,distX,distY) == 1) {
                            piece.setX(distX);
                            piece.setY(distY);
                            startSpotX = selectedSpotX;
                            startSpotY = selectedSpotY;
                            movedSpotX = distX;
                            movedSpotY = distY;
                            isMoved = true;
                            if(turn == 0)
                                showMovesPlayer1();
                            else if(turn == 1)
                                showMovesPlayer2();
                            System.out.println("moved");
                        }
                        else
                            System.out.println("cannot move to the spot");
                    }
                    else
                        System.out.println("do not have any selected piece");
                }
                else
                    System.out.println("wrong coordination");
            }
            else
                System.out.println("wrong coordination");
        }
        else
            System.out.println("already moved");
    }

    public void showMovesPlayer2() {
        if(isDestroyed == false) {
            player2Moves.add(Piece.getByPlace(movedSpotX,movedSpotY).tellName() + " " + selectedSpotY
                    + "," + selectedSpotX + " to " + movedSpotY + "," + movedSpotX);
            allMoves.add(Piece.getByPlace(movedSpotX,movedSpotY).tellName() + " " + selectedSpotY
                    + "," + selectedSpotX + " to " + movedSpotY + "," + movedSpotX);
        }
        else if(isDestroyed == true) {
            player2Moves.add(Piece.getByPlace(movedSpotX,movedSpotY).tellName() + " " + selectedSpotY
                    + "," + selectedSpotX + " to " + movedSpotY + "," + movedSpotX + " destroyed " +
                    deadPiece.tellName());
            allMoves.add(Piece.getByPlace(movedSpotX,movedSpotY).tellName() + " " + selectedSpotY
                    + "," + selectedSpotX + " to " + movedSpotY + "," + movedSpotX + " destroyed " +
                    deadPiece.tellName());
        }
    }

    public void removeMovesPlayer2() {
        player2Moves.remove(player2Moves.size() - 1);
        allMoves.remove(allMoves.size() - 1);
    }

    public void showMovesPlayer1() {
        if(isDestroyed == false) {
            player1Moves.add(Piece.getByPlace(movedSpotX,movedSpotY).tellName() + " " + selectedSpotY
                    + "," + selectedSpotX + " to " + movedSpotY + "," + movedSpotX);
            allMoves.add(Piece.getByPlace(movedSpotX,movedSpotY).tellName() + " " + selectedSpotY
                    + "," + selectedSpotX + " to " + movedSpotY + "," + movedSpotX);
        }
        else if(isDestroyed == true) {
            player1Moves.add(Piece.getByPlace(movedSpotX,movedSpotY).tellName() + " " + selectedSpotY
                    + "," + selectedSpotX + " to " + movedSpotY + "," + movedSpotX + " destroyed " +
                    deadPiece.tellName());
            allMoves.add(Piece.getByPlace(movedSpotX,movedSpotY).tellName() + " " + selectedSpotY
                    + "," + selectedSpotX + " to " + movedSpotY + "," + movedSpotX + " destroyed " +
                    deadPiece.tellName());
        }
    }

    public void removeMovesPlayer1() {
        player1Moves.remove(player1Moves.size() - 1);
        allMoves.remove(allMoves.size() - 1);
    }

    public void nextTern() {
        if(isMoved) {
            if(turn == 1) {
                isSelected = false;
                isDestroyed = false;
                isMoved = false;
                hasUndo = true;
                deadPiece = null;
                turn = 0;
                limit--;
                System.out.println("turn completed");
                if(limit == 0) {
                    player1.setPoint(player1.getPoint() + 1);
                    player2.setPoint(player2.getPoint() + 1);
                    player1.setDraws(player1.getDraws() + 1);
                    player2.setDraws(player2.getDraws() + 1);
                    System.out.println("draw");
                    winner = 0;
                    Piece.allPieces.removeAll(Piece.allPieces);
                    Piece.deadPieces.removeAll(Piece.deadPieces);
                    System.gc();
                    MainMenu.runMainMenu();
                }
                else if(winner == 2) {
                    player2.setPoint(player2.getPoint() + 3);
                    player1.setLosses(player1.getLosses() + 1);
                    player2.setWins(player2.getWins() + 1);
                    System.out.println("player " + player2.getUserName() + " with color black won");
                    Piece.allPieces.removeAll(Piece.allPieces);
                    Piece.deadPieces.removeAll(Piece.deadPieces);
                    winner = 0;
                    System.gc();
                    MainMenu.runMainMenu();
                }
                else if(winner == 1) {
                    player1.setPoint(player1.getPoint() + 3);
                    player2.setLosses(player2.getLosses() + 1);
                    player1.setWins(player1.getWins() + 1);
                    System.out.println("player " + player1.getUserName() + " with color white won");
                    Piece.allPieces.removeAll(Piece.allPieces);
                    Piece.deadPieces.removeAll(Piece.deadPieces);
                    winner = 0;
                    System.gc();
                    MainMenu.runMainMenu();
                }
            }
            else if(turn == 0) {
                isSelected = false;
                isDestroyed = false;
                isMoved = false;
                hasUndo = true;
                deadPiece = null;
                turn = 1;
                limit--;
                System.out.println("turn completed");
                if(limit == 0) {
                    player1.setPoint(player1.getPoint() + 1);
                    player2.setPoint(player2.getPoint() + 1);
                    player1.setDraws(player1.getDraws() + 1);
                    player2.setDraws(player2.getDraws() + 1);
                    System.out.println("draw");
                    winner = 0;
                    Piece.allPieces.removeAll(Piece.allPieces);
                    Piece.deadPieces.removeAll(Piece.deadPieces);
                    System.gc();
                    MainMenu.runMainMenu();
                }
                else if(winner == 2) {
                    player2.setPoint(player2.getPoint() + 3);
                    player1.setLosses(player1.getLosses() + 1);
                    player2.setWins(player2.getWins() + 1);
                    System.out.println("player " + player2.getUserName() + " with color black won");
                    Piece.allPieces.removeAll(Piece.allPieces);
                    Piece.deadPieces.removeAll(Piece.deadPieces);
                    winner = 0;
                    System.gc();
                    MainMenu.runMainMenu();
                }
                else if(winner == 1) {
                    player1.setPoint(player1.getPoint() + 3);
                    player2.setLosses(player2.getLosses() + 1);
                    player1.setWins(player1.getWins() + 1);
                    System.out.println("player " + player1.getUserName() + " with color white won");
                    Piece.allPieces.removeAll(Piece.allPieces);
                    Piece.deadPieces.removeAll(Piece.deadPieces);
                    winner = 0;
                    System.gc();
                    MainMenu.runMainMenu();
                }
            }
        }
        else
            System.out.println("you must move then proceed to next turn");
    }

    public void showTern() {
        if(turn == 0) {
            System.out.println("it is player " + player1.getUserName() + " turn with color white");
        }
        if(turn == 1) {
            System.out.println("it is player " + player2.getUserName() + " turn with color black");
        }
    }

    public void undoMove() {
        if(turn == 0)
            undoTheMain(player1);
        else
            undoTheMain(player2);
    }

    public void undoTheMain(Player player) {
        if(player.getUndoTerns() > 0) {
            if(isMoved) {
                if(hasUndo) {
                    if(isDestroyed) {
                        Piece firstPiece = Piece.getByPlace(movedSpotX,movedSpotY);
                        Piece secondPiece = deadPiece;
                        if(turn == 0) {
                            player1.setUndoTerns(player1.getUndoTerns() - 1);
                            removeMovesPlayer1();
                        }
                        if(turn == 1) {
                            player2.setUndoTerns(player2.getUndoTerns() - 1);
                            removeMovesPlayer2();
                        }
                        firstPiece.setX(startSpotX);
                        firstPiece.setY(startSpotY);
                        secondPiece.setX(movedSpotX);
                        secondPiece.setY(movedSpotY);
                        Piece.allPieces.add(secondPiece);
                        Piece.deadPieces.remove(secondPiece);
                        isMoved = false;
                        isDestroyed = false;
                        hasUndo = false;
                        deadPiece = null;
                        winner = 0;
                        System.out.println("undo completed");
                    }
                    else {
                        Piece firstPiece = Piece.getByPlace(movedSpotX,movedSpotY);
                        if(turn == 0) {
                            player1.setUndoTerns(player1.getUndoTerns() - 1);
                            removeMovesPlayer1();
                        }
                        if(turn == 1) {
                            player2.setUndoTerns(player2.getUndoTerns() - 1);
                            removeMovesPlayer2();
                        }
                        firstPiece.setX(startSpotX);
                        firstPiece.setY(startSpotY);
                        isMoved = false;
                        hasUndo = false;
                        deadPiece = null;
                        System.out.println("undo completed");
                    }
                }
                else
                    System.out.println("you have used your undo for this turn");
            }
            else
                System.out.println("you must move before undo");
        }
        else
            System.out.println("you cannot undo anymore");
    }

    public void showBoard() {
        for(int i=8;i>=1;i--) {
            for(int j=1;j<=8;j++) {
                if(Piece.getByPlace(j,i) != null) {
                    System.out.print(Piece.getByPlace(j,i).tellName() + "|");
                }
                else
                    System.out.print("  |");
            }
            System.out.print("\n");
        }

    }

    public void runGameMenu() {
        String inputString;
        inputString = Main.scanner.nextLine();
        if(inputString.matches("select -?\\d+,-?\\d+")) {
                String[] splitString1 = inputString.split("\\s");
                String[] splitString2 = splitString1[1].split(",");
                if(splitString2[0].length() > 7 || splitString2[1].length() > 7 ) {
                    System.out.println("wrong coordination");
                }
                else {
                    select(Integer.parseInt(splitString2[1]),Integer.parseInt(splitString2[0]));
                }

            }
        else if(inputString.equals("deselect")) {
                deselect();
            }
        else if(inputString.matches("move -?\\d+,-?\\d+")) {
            String[] splitString1 = inputString.split("\\s");
            String[] splitString2 = splitString1[1].split(",");
            move(splitString2[1],splitString2[0]);
        }
        else if(inputString.equals("next_turn")) {
                nextTern();
            }
        else if(inputString.equals("show_turn")) {
                showTern();
            }
        else if(inputString.equals("undo")) {
                undoMove();
            }
        else if(inputString.equals("undo_number")) {
                if(turn == 0) {
                    System.out.println("you have " + player1.getUndoTerns() + " undo moves");
                }
                if(turn == 1) {
                    System.out.println("you have " + player2.getUndoTerns() + " undo moves");
                }
            }
        else if(inputString.equals("show_moves")) {
            if(turn == 0) {
                for (String player1Move : player1Moves) {
                    System.out.println(player1Move);
                }
            }
            else {
                for (String player2Move : player2Moves) {
                    System.out.println(player2Move);
                }
            }
        }
        else if(inputString.equals("show_moves -all")) {
            for (String allMove : allMoves) {
                System.out.println(allMove);
            }
        }
        else if(inputString.equals("show_killed")) {
            for (Piece piece : Piece.deadPieces) {
                if(piece.getColor() == turn)
                    System.out.println(piece.tellName() + " killed in spot " + piece.getY() + "," + piece.getX());
            }
        }
        else if(inputString.equals("show_killed -all")) {
                for (Piece piece : Piece.deadPieces) {
                    System.out.println(piece.tellName() + " killed in spot " + piece.getY() + "," + piece.getX());
                }
        }
        else if(inputString.equals("show_board")) {
                showBoard();
            }
        else if(inputString.equals("help")) {
                System.out.println("select [x],[y]\n" +
                        "deselect\n" +
                        "move [x],[y]\n" +
                        "next_turn\n" +
                        "show_turn\n" +
                        "undo\n" +
                        "undo_number\n" +
                        "show_moves [-all]\n" +
                        "show_killed [-all]\n" +
                        "show_board\n" +
                        "help\n" +
                        "forfeit");
            }
        else if(inputString.equals("forfeit")) {
            if(turn == 0) {
                player2.setPoint(player2.getPoint() + 2);
                player1.setPoint(player1.getPoint() - 1);
                player2.setWins(player2.getWins() + 1);
                player1.setLosses(player1.getLosses() + 1);
                System.out.println("you have forfeited");
                System.out.println("player " + player2.getUserName() + " with color black won");
                Piece.allPieces.removeAll(Piece.allPieces);
                Piece.deadPieces.removeAll(Piece.deadPieces);
                System.gc();
                MainMenu.runMainMenu();
            }
            else if(turn == 1) {
                player1.setPoint(player1.getPoint() + 2);
                player2.setPoint(player2.getPoint() - 1);
                player1.setWins(player1.getWins() + 1);
                player2.setLosses(player2.getLosses() + 1);
                System.out.println("you have forfeited");
                System.out.println("player " + player1.getUserName() + " with color white won");
                Piece.allPieces.removeAll(Piece.allPieces);
                Piece.deadPieces.removeAll(Piece.deadPieces);
                System.gc();
                MainMenu.runMainMenu();
            }

        }
        else
            System.out.println("invalid command");
    }

}
