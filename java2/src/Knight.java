public class Knight extends Piece{

    public Knight(int color, int x,int y) {
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
        int number1 = Math.abs(distX - starX);
        int number2 = Math.abs(distY - startY);
        if(number1 * number2 == 2) {
            if(Piece.getByPlace(distX,distY) == null) {
                return 1;
            }
            if(Piece.getByPlace(distX,distY) != null && Piece.getByPlace(distX,distY).getColor() != color) {
                return 2;
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
            return "Nw";
        return "Nb";
    }
}
