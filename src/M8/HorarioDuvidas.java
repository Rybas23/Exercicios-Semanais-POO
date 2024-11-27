package src.M8;

import java.util.*;

public class HorarioDuvidas implements Iterable<Aluno>{
    private List<Aluno> marcacoes;
    private List<Aluno> chegadas;
    private PriorityQueue<Aluno> pq;

    public HorarioDuvidas() {
        this.marcacoes = new ArrayList<>();
        this.chegadas = new ArrayList<>();
        this.pq = new PriorityQueue<>((aluno1, aluno2) -> {
            if (!marcacoes.isEmpty()) {
                if (marcacoes.contains(aluno2) && !marcacoes.contains(aluno1)) {
                    return 1;
                }
                if (marcacoes.contains(aluno1) && !marcacoes.contains(aluno2)) {
                    return -1;
                }
                if (marcacoes.contains(aluno2) && marcacoes.contains(aluno1)) {
                    if (marcacoes.indexOf(aluno2) > marcacoes.indexOf(aluno1)) {
                        return 1;
                    } else if (marcacoes.indexOf(aluno2) < marcacoes.indexOf(aluno1)) {
                        return -1;
                    }
                } else {
                    if (aluno2.getNumero() < aluno1.getNumero()) {
                        return 1;
                    } else if (aluno2.getNumero() > aluno1.getNumero()) {
                        return -1;
                    }
                }
            }

            return 0;
        });
    }

    void marcacao(Aluno a) {
        marcacoes.add(a);
    }

    void chegada(Aluno a) {
        chegadas.add(a);
        pq.offer(a);
    }

    Aluno proximo() {
        if (!pq.isEmpty()) {
            return pq.poll();
        }
        return null;
    }

    public List<Aluno> getMarcacoes() {
        return marcacoes;
    }

    public List<Aluno> getChegadas() {
        return chegadas;
    }

    public PriorityQueue<Aluno> getPq() {
        return pq;
    }

    @Override
    public Iterator iterator() {
        return new IteratorHorario();
    }

    private class IteratorHorario implements Iterator<Aluno> {
        Aluno current = proximo();

        @Override
        public boolean hasNext() {
            return pq.size() > 0;
        }

        @Override
        public Aluno next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return proximo();
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
