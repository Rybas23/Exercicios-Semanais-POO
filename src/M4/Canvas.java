package src.M4;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    //region Atributos

    private List<AbstractFigure> figures;

    //endregion

    //region Construtores

    public Canvas() {
        this.figures = new ArrayList<>();
    }

    //endregion

    //region Getters and Setters

    public List<AbstractFigure> getListFigures() {
        return figures;
    }

    //endregion

    //region Métodos

    /**
     * Adiciona uma figura à lista
     * @param figure
     */
    public void add(AbstractFigure figure) {
        figures.add(figure);
    }

    /**
     * Remove uma figura da lista
     * @param figure
     */
    public void remove(AbstractFigure figure) {
        figures.remove(figure);
    }

    /**
     * Devolve a figura com a maior área
     * @return
     */
    public AbstractFigure biggestArea() {
        if (!figures.isEmpty()) {
            double aux = 0.0;
            int index = 0;

            for (Figure figure : figures) {
                if (figure.isBiggerArea(figure.getArea(), aux)) {
                    aux = figure.getArea();
                    index = figures.indexOf(figure);
                }
            }

            return figures.get(index);
        }
        return null;
    }

    /**
     * Remove a figura com a maior área
     */
    public void removeBiggestArea(){
        if(!figures.isEmpty()) {
            figures.remove(biggestArea());
        }
    }

    /**
     * Devolve a soma de todas as areas
     * @return
     */
    public double sumOfAreas(){
        double sum = 0.0;

        if(!figures.isEmpty()) {
            for (Figure figure : figures) {
                sum += figure.getArea();
            }
        }

        return sum;
    }

    //endregion
}
