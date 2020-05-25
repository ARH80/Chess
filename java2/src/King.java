public class King extends Piece{

    public King(int color, int x, int y) {
        super(color, x, y);
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
        if(Math.pow(Math.abs((starX - distX)),2) + Math.pow(Math.abs((startY - distY)),2) <= 2) {
            if (Piece.getByPlace(distX,distY) != null) {
                if (Piece.getByPlace(distX,distY).getColor() != color) {
                    return 2;
                }
                return 0;
            }
            if(Piece.getByPlace(distX,distY) == null) {
                return 1;
            }
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
            return "Kw";
        return "Kb";
    }
}
