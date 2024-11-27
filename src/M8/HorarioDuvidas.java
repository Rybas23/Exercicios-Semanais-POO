package src.M8;

import java.util.*;

public class HorarioDuvidas {
    public List<Aluno> marcacoes;
    public PriorityQueue<Aluno> chegadas;

    public HorarioDuvidas() {
        marcacoes = new ArrayList<>();
        chegadas = new PriorityQueue<>((a1, a2) -> a1.getNumero() - a2.getNumero());
    }

    void marcacao(Aluno a) {
        marcacoes.add(a);
    }

    void chegada(Aluno a) {
        if (!marcacoes.contains(a))
            chegadas.add(a);
    }

    Aluno proximo() {
        if (!marcacoes.isEmpty())
            return marcacoes.removeFirst();
        else if (!chegadas.isEmpty())
            return chegadas.poll();

        return null;
    }

}
