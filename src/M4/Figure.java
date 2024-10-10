package src.M4;

/**
 * Interface Figure
 */
public interface Figure {
    /**
     * Retorna o x da figura
     * @return
     */
    int getX();

    /**
     * Retorna o y da figura
     * @return
     */
    int getY();

    /**
     * Retorna a area da figura
     * @return
     */
    double getArea();

    /**
     * Retorna o perimetro da figura
     * @return
     */
    double getPerimeter();

    /**
     * Serve para verificar qual das figuras tem maior área
     * @param a
     * @param b
     * @return
     */
    boolean isBiggerArea(double a, double b);
}
