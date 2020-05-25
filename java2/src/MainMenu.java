import java.util.ArrayList;
import java.util.Collections;

public class MainMenu {

    private static ArrayList<Player> loggedIn = new ArrayList<>();

    public static boolean isValidateName(String name) {
        if(name.matches("\\w+")) {
            return true;
        }
        System.out.println("username format is invalid");
        return false;
    }

    public static boolean isValidateLimit(String limit) {
        int answer = Integer.parseInt(limit);
        if(answer >= 0)
            return true;
        System.out.println("number should be positive to have a limit or 0 for no limit");
        return false;
    }

    public static void printInLexicographicalOrder(ArrayList<Player> players) {
        ArrayList<Player> players2 = new ArrayList<>();
        players2.addAll(players);
        for(int i = 0; i < players2.size() - 1; i++) {
            for(int j = i + 1; j < players2.size(); j++) {
                if(players2.get(i).getUserName().compareTo(players2.get(j).getUserName()) > 0) {
                    Collections.swap(players2, i , j);
                }
            }
        }
        for (Player player : players2) {
            System.out.println(player.getUserName());
        }
    }

    public static void sortByWins(ArrayList<Player> players) {
        for(int i = 0; i < players.size() - 1; i++) {
            for(int j = i + 1; j < players.size(); j++) {
                if(players.get(i).getPoint() == players.get(j).getPoint() &&
                        players.get(i).getWins() < players.get(j).getWins()) {
                    Collections.swap(players, i , j);
                }
            }
        }
        sortByDraws(players);
    }

    public static void sortByDraws(ArrayList<Player> players) {
        for(int i = 0; i < players.size() - 1; i++) {
            for(int j = i + 1; j < players.size(); j++) {
                if(players.get(i).getPoint() == players.get(j).getPoint() &&
                        players.get(i).getWins() == players.get(j).getWins() &&
                        players.get(i).getDraws() < players.get(j).getDraws()) {
                    Collections.swap(players, i , j);
                }
            }
        }
        sortByLosses(players);
    }

    public static void sortByLosses(ArrayList<Player> players) {
        for(int i = 0; i < players.size() - 1; i++) {
            for(int j = i + 1; j < players.size(); j++) {
                if(players.get(i).getPoint() == players.get(j).getPoint() &&
                        players.get(i).getWins() == players.get(j).getWins() &&
                        players.get(i).getDraws() == players.get(j).getDraws() &&
                        players.get(i).getLosses() > players.get(j).getLosses()) {
                    Collections.swap(players, i , j);
                }
            }
        }
        sortByLossesAfter(players);
    }

    public static void sortByLossesAfter(ArrayList<Player> players) {
        for(int i = 0; i < players.size() - 1; i++) {
            for(int j = i + 1; j < players.size(); j++) {
                if(players.get(i).getPoint() == players.get(j).getPoint() &&
                        players.get(i).getWins() == players.get(j).getWins() &&
                        players.get(i).getDraws() == players.get(j).getDraws() &&
                        players.get(i).getLosses() == players.get(j).getLosses() &&
                        players.get(i).getUserName().compareTo(players.get(j).getUserName()) > 0) {
                    Collections.swap(players, i , j);
                }
            }
        }
    }

    public static void printScoreBoard(ArrayList<Player> players) {
        ArrayList<Player> players2 = new ArrayList<>(players);
        for(int i = 0; i < players2.size() - 1; i++) {
            for(int j = i + 1; j < players2.size(); j++) {
                if(players2.get(i).getPoint() < players2.get(j).getPoint()) {
                    Collections.swap(players2, i , j);
                }
            }
        }
        sortByWins(players2);
        for (Player player : players2) {
            System.out.println(player.getUserName()+" "+player.getPoint()+" "+player.getWins()+" "
                    +player.getDraws()+" "+player.getLosses());
        }
    }

    public static void runMainMenu() {
        String inputString;
        while(!(inputString = Main.scanner.nextLine()).equals("logout")) {
            if(inputString.matches("new_game \\S+ -?\\d+")) {
                String[] splitString = inputString.split("\\s");
                if(isValidateName(splitString[1])) {
                    if(isValidateLimit(splitString[2])) {
                        if(!(loggedIn.contains(Player.getPlayerByName(splitString[1])))) {
                            if(Player.getAllPlayers().contains(Player.getPlayerByName(splitString[1]))) {
                                int num = Integer.parseInt(splitString[2]);
                                if(num == 0) {
                                    System.out.println("new game started successfully between " +
                                            loggedIn.get(0).getUserName() + " and " + splitString[1]
                                            + " with limit " + splitString[2]);
                                    GameMenu gameMenu = new GameMenu(loggedIn.get(0) ,
                                            Player.getPlayerByName(splitString[1])
                                            , -1);
                                    System.gc();
                                    gameMenu.startUnLimitGame();
                                    System.gc();
                                }
                                else {
                                    System.out.println("new game started successfully between " +
                                            loggedIn.get(0).getUserName()
                                            + " and " + splitString[1] + " with limit " + splitString[2]);
                                    GameMenu gameMenu = new GameMenu(loggedIn.get(0) ,
                                            Player.getPlayerByName(splitString[1])
                                            , num);
                                    System.gc();
                                    gameMenu.startGame();
                                    System.gc();
                                }

                            }
                            else
                                System.out.println("no user exists with this username");
                        }
                        else
                            System.out.println("you must choose another player to start a game");
                    }

                }
            }
            else if(inputString.equals("scoreboard")) {
                printScoreBoard(Player.getAllPlayers());
            }
            else if(inputString.equals("list_users")) {
                printInLexicographicalOrder(Player.getAllPlayers());
            }
            else if(inputString.equals("help")) {
                System.out.println("new_game [username] [limit]\n" +
                        "scoreboard\n" +
                        "list_users\n" +
                        "help\n" +
                        "logout");
            }
            else {
                System.out.println("invalid command");
            }
        }
        System.out.println("logout successful");
        loggedIn.remove(0);
        System.gc();
        FirstMenu.runFirstMenu();
        System.gc();
    }

    public static void addLoggedIn(Player player) {
        loggedIn.add(player);
    }
}
