package src.M6;

public class WeekDay {
    //region Atributos

    private String dayOfTheWeek;

    //endregion

    //region Construtores

    public WeekDay(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    //endregion

    //region Métodos

    @Override
    public String toString() {
        return dayOfTheWeek;
    }


    //endregion
}