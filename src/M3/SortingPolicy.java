package src.M3;

/**
 * Interface da SortingPolicy
 */
public interface SortingPolicy {
    /**
     * Serve para verificar qual dos elementos fica posicionado antes
     * @param a
     * @param b
     * @return
     */
    boolean isBefore(int a, int b);
}
