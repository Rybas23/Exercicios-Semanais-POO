package src.M4;

public class Gerente extends Empregado {

    boolean objetivo;

    public Gerente(String nome, int id) {
        super(nome, id);
    }

    public void setObjetivoCumprido() {
        this.objetivo = true;
    }

    @Override
    public double salario() {
        return objetivo ? super.salario() + 200.0 : super.salario();
    }

    @Override
    public String toString() {
        if (objetivo)
            return super.toString() + " - Objetivo cumprido, bónus atribuído 200€";

        return super.toString();
    }
}
