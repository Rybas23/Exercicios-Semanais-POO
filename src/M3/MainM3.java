package src.M3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainM3 {
    public static void main(String[] args) {
        //region 3.1

        SortedIntArray sortedArray = new SortedIntArray(new SortedIntArray.Descending());

        sortedArray.add(1);
        sortedArray.add(4);
        sortedArray.add(2);
        sortedArray.add(8);

        for(int i = 0; i < sortedArray.size(); i++) {
            System.out.println(sortedArray.get(i));
        }

        //endregion

        //region 3.2

        ArrayList<Aluno> alunos = new ArrayList<>();

        Aluno a1 = new Aluno(1, "Ana", 2020, 1990);
        Aluno a2 = new Aluno(10, "João", 2020, 1990);
        Aluno a3 = new Aluno(230, "Nuno", 2030, 2003);
        Aluno a4 = new Aluno(120, "Daniel", 2025, 1995);
        Aluno a5 = new Aluno(15, "Jorge", 2031, 2003);
        Aluno a6 = new Aluno(800, "Pedro", 2024, 1995);
        Aluno a7 = new Aluno(10, "Zaza", 2023, 1995);
        Aluno a8 = new Aluno(1000, "Xispo", 2020, 1990);

        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        alunos.add(a4);
        alunos.add(a5);
        alunos.add(a6);
        alunos.add(a7);
        alunos.add(a8);

        System.out.println("");
        System.out.println("Lista Desordenada:");
        for(Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        alunos.sort(new Aluno.AlunoComparatorNumero());

        System.out.println("");
        System.out.println("Lista Ordenada por Número:");
        for(Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        alunos.sort(new Aluno.AlunoComparatorNome());

        System.out.println("");
        System.out.println("Lista Ordenada por Nome:");
        for(Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        alunos.sort(new Aluno.AlunoComparatorAnoNascimento());

        System.out.println("");
        System.out.println("Lista Ordenada por Ano de Nascimento:");
        for(Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        //endregion

        //region 3.3

        List<String> strings = new ArrayList<>();
        strings.add("Ana");
        strings.add("Jorge");
        strings.add("Nuno");
        strings.add("Armando");
        strings.add("Daniel");
        strings.add("Pedro");
        strings.add("Zaza");
        strings.add("Xispo");

        System.out.println("");
        System.out.println("Desornada:");
        for(String palavra : strings) {
            System.out.println(palavra);
        }

        List<String> stringsFiltradas = Filter.filterWords(strings, new Filter.PrefixA());

        System.out.println("");
        System.out.println("Filtrada Prefixo:");
        for(String palavra : stringsFiltradas) {
            System.out.println(palavra);
        }

        List<String> strings2 = new ArrayList<>();
        strings.add("Ana");
        strings.add("Jorge");
        strings.add("Nuno");
        strings.add("Armando");
        strings.add("Daniel");
        strings.add("Pedro");
        strings.add("Zaza");
        strings.add("Za");
        strings.add("B");
        strings.add("Xispo");

        List<String> stringsFiltradas2 = Filter.filterWords(strings, new Filter.SizeLess3());

        System.out.println("");
        System.out.println("Filtrada menor que 3:");
        for(String palavra : stringsFiltradas2) {
            System.out.println(palavra);
        }

        //endregion

        //region 3.4

        ArrayList<String> stringsToWordArray = new ArrayList<>();
        stringsToWordArray.add("Ana");
        stringsToWordArray.add("Jorge");
        stringsToWordArray.add("Nuno");
        stringsToWordArray.add("Armando");
        stringsToWordArray.add("Daniel");
        stringsToWordArray.add("Pedro");

        LinkedList<String> stringsToWordLinked = new LinkedList<>();
        stringsToWordLinked.add("Ana");
        stringsToWordLinked.add("Jorge");
        stringsToWordLinked.add("Nuno");
        stringsToWordLinked.add("Armando");
        stringsToWordLinked.add("Daniel");
        stringsToWordLinked.add("Pedro");

        String text = StringsToText.separatedBy(stringsToWordArray, ", ");
        String text2 = StringsToText.separatedBy(stringsToWordLinked, ":");

        System.out.println("");
        System.out.println(text);

        System.out.println("");
        System.out.println(text2);

        //endregion

        //region 3.5

        List<Operator> operators = new ArrayList<>();
        operators.add(new ExpressionEvaluator.Addition());
        operators.add(new ExpressionEvaluator.Power());

        String[] expression = { "(", "(", "2", "^", "8", ")", "+", "2", ")" };

        ExpressionEvaluator calc = new ExpressionEvaluator(operators);

        int result = calc.evaluate(expression); // 258

        System.out.println("");
        System.out.println("Operators: ");
        for(Operator operator : operators) {
            System.out.print(operator.getSymbol());
        }

        System.out.println("");
        System.out.println("Expression: ");
        for (String s : expression) {
            System.out.print(s);
        }

        System.out.println("");
        System.out.println("Result: " + result);

        //endregion
    }
}