package src.M5;

public class Matrix {
    //region Atributos

    private int[] data;
    private int columns;

    //endregion

    //region Construtores

    public Matrix(int linhas, int colunas) {
        data = newMatrix(linhas, colunas);
        this.columns = colunas;
    }

    public Matrix(int linhas) {
        data = newMatrix(linhas, linhas);
        this.columns = linhas;
    }

    //endregion

    //region Getters and Setters

    public int getLinhas() {
        return data.length / columns;
    }

    public int getColunas() {
        return columns;
    }

    public int[] getMatrix() {
        return data;
    }

    //endregion

    //region Métodos

    //Devolve o nº da linha e coluna escolhidas
    public int getNumber(int linha, int coluna) {
        //checkArguments validada se os parâmetros passados estão dentro do tamanho da matriz
        checkArguments(linha, coluna);
        return data[linha * columns + coluna];
    }

    //Altera o nº da linha e coluna escolhidas
    public void setNumber(int linha, int coluna, int valor) {
        //checkArguments validada se os parâmetros passados estão dentro do tamanho da matriz
        checkArguments(linha, coluna);
        data[linha * columns + coluna] = valor;
    }

    //Multiplicar por escalar
    public void scale(int scalar) {
        for (int i = 0; i < data.length; i++) {
            data[i] *= scalar;
        }
    }

    //Saber se a matriz tem a mesma dimensão que outra
    public boolean isSameSize(Matrix other) {
        return this.getColunas() == other.getColunas() && this.getLinhas() == other.getLinhas();
    }

    //Preencher com valores aleatórios até certo valor - não foi pedida
    public void randomize(int max) {
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * (max + 1));
        }
    }

    // toString fixe do chatGPT para ter melhor visualização
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int rows = data.length / columns; // Calcula o número de linhas
        int maxVal = findMaxValue(data); // Usa o método correto para encontrar o valor máximo
        int maxDigits = String.valueOf(maxVal).length(); // Conta os dígitos do maior valor

        for (int i = 0; i < rows; i++) {
            sb.append("[ ");
            for (int j = 0; j < columns; j++) {
                String valueStr = String.valueOf(data[i * columns + j]); // Converte o número em string
                int padding = maxDigits - valueStr.length(); // Calcula a diferença de dígitos
                int leftPadding = padding / 2; // Espaços à esquerda
                int rightPadding = padding - leftPadding; // Espaços à direita

                // Adiciona os espaços à esquerda, o valor, e os espaços à direita
                sb.append(" ".repeat(leftPadding))
                        .append(valueStr)
                        .append(" ".repeat(rightPadding));

                if (j < columns - 1) {
                    sb.append(", "); // Separador de colunas
                }
            }
            sb.append(" ]\n"); // Fim da linha
        }

        return sb.toString();
    }

    private static int findMaxValue(int[] data) {
        int max = Integer.MIN_VALUE;

        for (int num : data) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    //Auxiliar para criar matrizes a zero dadas as linhas e as colunas
    private int[] newMatrix(int linhas, int colunas) {
        if(linhas < 0 || colunas < 0) {
            throw new IllegalArgumentException("Linhas ou colunas < 0 ");
        }

        int[] result = new int[linhas * colunas];

        for (Integer i : result) {
            result[i] = 0;
        }

        return result;
    }

    //Auxiliar para verificar se os argumentos são válidos
    private boolean checkArguments(int p, int q) {
        if (p >= 0 && q >= 0 && p < getLinhas() && q < getColunas()) {
            return true;
        }

        throw new IllegalArgumentException("Argumentos inválidos");
    }

    //endregion
}