package src.M4;

public class Circle extends AbstractFigure {

    //region Atributos

    private int radius;

    //endregion

    //region Construtor

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    //endregion

    //region Getters and Setters

    public int getRadius() {
        return radius;
    }

    //endregion

    //region Métodos

    @Override
    public String toString() {
        return "Circle {x=" + super.getX() + ", y=" + super.getY() + ", radius=" + radius + '}';
    }

    /**
     * Retorna a area do circulo
     * @return
     */
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /**
     * Retorna o perimetro do circulo
     * @return
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    //endregion
}
