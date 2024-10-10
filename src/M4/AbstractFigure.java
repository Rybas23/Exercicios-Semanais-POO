package src.M4;

public abstract class AbstractFigure implements Figure {
    //region Atributos

    private int x;
    private int y;

    //endregion

    //region Construtores

    public AbstractFigure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //enregion

    //region Getters and Setters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //endregion

    //region Métodos

    @Override
    public String toString() {
        return "AbstractFigure{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Esta implementação do método serve para verificar e a area é maior
     * @param a
     * @param b
     * @return
     */
    @Override
    public boolean isBiggerArea(double a, double b) {
        return a > b;
    }

    //endregion
}
