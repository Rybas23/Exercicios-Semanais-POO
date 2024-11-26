package src.M5.AiTunas;

public final class Time implements Comparable<Time>{
    //region Atributos

    private final int totalSeconds;

    //endregion

    //region Construtores

    /**
     * Construtor Completo com inteiros
     * @param minutes
     * @param seconds
     */
    public Time(int minutes, int seconds) {
        if(minutes > 59 || seconds > 59) {
            throw new IllegalArgumentException("Time must be between '0:0' and '59:59'");
        }

        this.totalSeconds = minutes * 60 + seconds;
    }

    /**
     * Construtor Completo a partir da string com formato 'mm:ss'
     * @param time
     */
    public Time(String time) {
        if(!time.contains(":") || time.length() > 5 || time.length() < 3) {
            throw new IllegalArgumentException("Time must contain ':'");
        }

        String[] times = time.split(":");

        if(Integer.parseInt(times[0]) > 59 || Integer.parseInt(times[0]) > 59) {
            throw new IllegalArgumentException("Time must be between '0:0' and '59:59'");
        }

        this.totalSeconds = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    //endregion

    //region Getters

    public int getTotalSeconds() {
        return totalSeconds;
    }

    //endregion

    //region Métodos

    public int getOnlySeconds() {
        return totalSeconds % 60;
    }

    public int getOnlyMinutes() {
        return totalSeconds / 60;
    }

    @Override
    public String toString() {
        return getOnlyMinutes() + ":" + getOnlySeconds();
    }

    public Time add(Time t) {
        return new Time((totalSeconds / 60) + (t.getTotalSeconds() / 60), (totalSeconds % 60) + (t.getTotalSeconds() % 60));
    }

    public Time sub(Time t) {
        return new Time((totalSeconds / 60) - (t.getTotalSeconds() / 60), (totalSeconds % 60) - (t.getTotalSeconds() % 60));
    }

    public boolean isLessThan(Time t) {
        return totalSeconds < t.getTotalSeconds();
    }

    public boolean isGreaterThan(Time t) {
        return totalSeconds > t.getTotalSeconds();
    }

    @Override
    public int compareTo(Time o) {
        return Integer.compare(totalSeconds, o.getTotalSeconds());
    }

    //endregion
}
