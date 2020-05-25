import java.util.ArrayList;
import java.util.Collections;

public class FirstMenu {

    public static boolean isValidateName(String name) {
        if(name.matches("\\w+")) {
            return true;
        }
        else
            System.out.println("username format is invalid");
        return false;
    }

    public static boolean isValidatePass(String pass) {
        if(pass.matches("\\w+")) {
            return true;
        }
        else
            System.out.println("password format is invalid");
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

    public static void runFirstMenu() {
        String inputString;
        while(!(inputString = Main.scanner.nextLine()).equals("exit")) {
            if(inputString.matches("register \\S+ \\S+")) {
                String[] splitString = inputString.split("\\s");
                if(isValidateName(splitString[1])) {
                    if (isValidatePass(splitString[2])) {
                        if(Player.getPlayerByName(splitString[1]) == null) {
                            Player player = new Player(splitString[1],splitString[2]);
                            Player.addAllPlayers(player);
                            System.out.println("register successful");
                        }
                        else
                            System.out.println("a user exists with this username");
                    }
                }
            }
            else if(inputString.matches("login \\S+ \\S+")) {
                String[] splitString = inputString.split("\\s");
                if(isValidateName(splitString[1])) {
                    if(isValidatePass(splitString[2])) {
                        if(Player.getPlayerByName(splitString[1]) != null) {
                            if(Player.getPlayerByName(splitString[1]).getPassword().equals(splitString[2])) {
                                MainMenu.addLoggedIn(Player.getPlayerByName(splitString[1]));
                                System.out.println("login successful");
                                MainMenu.runMainMenu();
                            }
                            else
                                System.out.println("incorrect password");
                        }
                        else
                            System.out.println("no user exists with this username");
                    }
                }
            }
            else if(inputString.matches("remove \\S+ \\S+")) {
                String[] splitString = inputString.split("\\s");
                if(isValidateName(splitString[1])) {
                    if(isValidatePass(splitString[2])) {
                        if(Player.getPlayerByName(splitString[1]) != null) {
                            if(Player.getPlayerByName(splitString[1]).getPassword().equals(splitString[2])) {
                                Player.removePlayer(Player.getPlayerByName(splitString[1]));
                                System.out.println("removed " + splitString[1] + " successfully");
                            }
                            else
                                System.out.println("incorrect password");
                        }
                        else
                            System.out.println("no user exists with this username");
                    }
                }
            }
            else if(inputString.equals("list_users")) {
                printInLexicographicalOrder(Player.getAllPlayers());
            }
            else if(inputString.equals("help")) {
                System.out.println("register [username] [password]\n" +
                        "login [username] [password]\n" +
                        "remove [username] [password]\n" +
                        "list_users\n" +
                        "help\n" +
                        "exit");
            }
            else {
                System.out.println("invalid command");
            }
        }
        System.out.println("program ended");
        System.exit(0);
    }
}
