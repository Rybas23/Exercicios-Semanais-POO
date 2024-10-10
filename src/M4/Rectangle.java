package src.M4;

public class Rectangle extends AbstractFigure{

    //region Atributos

    private int width;
    private int height;

    //endregion

    //region Construtores

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    //endregion

    //region Getters and Setters

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //endregion

    //region Métodos

    @Override
    public String toString() {
        return "Rectangle {x=" + super.getX() + ", y=" + super.getY() + ", width=" + width + ", height=" + height + '}';
    }

    /**
     * Retorna a area do retangulo
     * @return
     */
    @Override
    public double getArea() {
        return width * height;
    }

    /**
     * Retorna o perimetro do retangulo
     * @return
     */
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    //endregion
}
