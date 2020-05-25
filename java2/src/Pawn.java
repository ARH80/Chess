import java.util.ArrayList;

public class Pawn extends Piece{

    public static ArrayList<Pawn> allPawns = new ArrayList<>();

    public Pawn(int color, int x, int y) {
        super(color,x,y);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int canMove(int starX, int startY, int distX, int distY) {
        if(color == 0 && startY == 2 && (distY - startY == 2) && distX == starX &&
                Piece.getByPlace(distX,distY) == null && Piece.getByPlace(distX,distY-1) == null) {
            return 1;
        }
        if(color == 1 && startY == 7 && (startY - distY == 2) && distX == starX &&
                Piece.getByPlace(distX,distY) == null && Piece.getByPlace(distX,distY+1) == null) {
            return 1;
        }
        if(color == 0 && Piece.getByPlace(distX,distY) == null && distY - startY == 1 && starX == distX) {
            return 1;
        }
        if(color == 1 && Piece.getByPlace(distX,distY) == null && startY - distY == 1 && starX == distX) {
            return 1;
        }
        if(color == 0 && (distX == starX + 1 || distX == starX - 1) && distY == startY + 1  &&
                Piece.getByPlace(distX,distY) != null && Piece.getByPlace(distX,distY).getColor() == 1) {
            return 2;
        }
        if(color == 1 && (distX == starX + 1 || distX == starX - 1) && distY == startY - 1 &&
                Piece.getByPlace(distX,distY) != null && Piece.getByPlace(distX,distY).getColor() == 0) {
            return 2;
        }
        return 0;
    }

    @Override
    public void setX(int newX) {
        this.x = newX;
    }

    @Override
    public void setY(int newY) {
        this.y = newY;
    }

    @Override
    public String tellName() {
        if(color == 0)
            return "Pw";
        return "Pb";
    }
}
