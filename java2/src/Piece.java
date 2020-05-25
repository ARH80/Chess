import java.util.ArrayList;

public abstract class Piece {
    protected int x;
    protected int y;
    protected int color;
    public static ArrayList<Piece> allPieces = new ArrayList<>();
    public static ArrayList<Piece> deadPieces = new ArrayList<>();

    public Piece(int color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract int getColor();

    public abstract int getY();

    public abstract int getX();

    public static Piece getByPlace(int distX , int distY) {
        for (Piece piece : Piece.allPieces) {
            if(piece.getX()==distX && piece.getY()==distY)
                return piece;
        }
        return null;
    }

    public abstract int canMove(int starX,int startY,int distX,int distY);

    public abstract void setX(int newX);

    public abstract void setY(int newY);

    public abstract String tellName();
}
