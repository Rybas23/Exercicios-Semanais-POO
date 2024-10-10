package src.M4;

public class Diretor extends Empregado{

    private double lucro;

    public Diretor(String nome, int id) {
        super(nome, id);
        this.lucro = 0.0;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    @Override
    public double salario(){
        return super.salario() * 2 + 0.01 * lucro;
    }

    @Override
    public String toString() {
        return super.toString() + " - Lucro da região: " + lucro ;
    }
}
