public class Rook extends Piece{

    public Rook(int color, int x, int y) {
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

        if(starX == distX || startY == distY) {
            int num1 = Math.abs(distX - starX);
            int num2 = Math.abs(distY - startY);
            if(num1 == 0) {
                if(distY - startY > 0) {
                    for (int i = num2 - 1; i > 0; i--) {
                        if (Piece.getByPlace(starX, startY + i) != null) {
                            return 0;
                        }
                    }
                }
                if(distY - startY < 0) {
                    for (int i = num2 - 1; i > 0; i--) {
                        if (Piece.getByPlace(starX, startY - i) != null) {
                            return 0;
                        }
                    }
                }
            }
            if(num2 == 0) {
                if(distX - starX > 0) {
                    for (int i = num1 - 1; i > 0; i--) {
                        if (Piece.getByPlace(starX + i, startY) != null) {
                            return 0;
                        }
                    }
                }
                if(distX - starX < 0) {
                    for (int i = num1 - 1; i > 0; i--) {
                        if (Piece.getByPlace(starX - i, startY) != null) {
                            return 0;
                        }
                    }
                }
            }
            if (Piece.getByPlace(distX, distY) != null) {
                if (Piece.getByPlace(distX, distY).getColor() != color) {
                    return 2;
                }
                return 0;
            }
            if (Piece.getByPlace(distX,distY) == null) {
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
            return "Rw";
        return "Rb";
    }
}
