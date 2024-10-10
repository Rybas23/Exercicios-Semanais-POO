package src.M4;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    List<Empregado> empregados;

    public Empresa() {
        empregados = new ArrayList<Empregado>();
    }

    public void add(Empregado e){
        empregados.add(e);
    }

    public double calcularSalarios() {
        double salarios = 0.0;

        if (!empregados.isEmpty()) {
            for (Empregado e : empregados) {
                salarios += e.salario();
            }
        }

        return salarios;
    }

}
