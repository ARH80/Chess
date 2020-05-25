import java.util.ArrayList;

public class Player {
    private String userName;
    private String password;
    private int undoTerns = 2;
    private int point;
    private int wins;
    private int draws;
    private int losses;
    private static ArrayList<Player> allPlayers = new ArrayList<>();

    public Player(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setUndoTerns(int undoTerns) {
        this.undoTerns = undoTerns;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getUserName() {
        return userName;
    }

    public int getPoint() {
        return point;
    }

    public String getPassword() {
        return password;
    }

    public static void removePlayer(Player player) {
        allPlayers.remove(player);
    }

    public int getUndoTerns() {
        return undoTerns;
    }

    public static ArrayList<Player> getAllPlayers() {
        return allPlayers;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public static Player getPlayerByName(String name) {
        for (Player player : allPlayers) {
            if(player.getUserName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public static void addAllPlayers(Player player) {
        allPlayers.add(player);
    }
}
