//package src.semana5;
//public class MatrixOriginal {
//
//    package src.semana5;
//
//import java.util.Arrays;
//
//    public class Matrix {
//
//        private int[][] matrix;
//
//        public Matrix(int linhas, int colunas) {
//            matrix = newMatrix(linhas, colunas);
//        }
//
//        public Matrix(int linhas) {
//            matrix = newMatrix(linhas, linhas);
//        }
//
//        public int getLinhas() {
//            return matrix.length;
//        }
//
//        public int getColunas() {
//            return matrix[0].length;
//        }
//
//        public int[][] getMatrix() {
//            return matrix;
//        }
//
//        //Devolve o nº da linha e coluna escolhidas
//        public int getNumber(int linha, int coluna) {
//            //checkArguments validada se os parâmetros passados estão dentro do tamanho da matriz
//            checkArguments(linha, coluna);
//            return matrix[linha][coluna];
//        }
//
//        //Altera o nº da linha e coluna escolhidas
//        public void setNumber(int linha, int coluna, int valor) {
//            //checkArguments validada se os parâmetros passados estão dentro do tamanho da matriz
//            checkArguments(linha, coluna);
//            matrix[linha][coluna] = valor;
//        }
//
//        //Multiplicar por escalar
//        public void scale(int scalar) {
//            for (int i = 0; i < matrix.length; i++)
//                for (int j = 0; j < matrix[i].length; j++)
//                    matrix[i][j] = scalar * matrix[i][j];
//        }
//
//        //Saber se a matriz tem a mesma dimensão que outra
//        public boolean isSameSize(src.semana5.Matrix other) {
//            return this.getColunas() == other.getColunas() && this.getLinhas() == other.getLinhas();
//        }
//
//        //Preencher com valores aleatórios até certo valor - não foi pedida
//        public void randomize(int max) {
//            for (int i = 0; i < matrix.length; i++)
//                for (int j = 0; j < matrix[i].length; j++)
//                    matrix[i][j] = (int) (Math.random() * (max+1));
//        }
//
//        //region toString fixe do chatGPT para ter melhor visualização
//        @Override
//        public String toString() {
//            StringBuilder sb = new StringBuilder();
//
//            // Encontrar o número máximo de dígitos
//            int maxNumber = findMaxNumber(matrix);
//            int maxDigits = String.valueOf(maxNumber).length();
//
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix[i].length; j++) {
//                    // Formatar o número com espaços à esquerda e adicionar separador de coluna
//                    sb.append(String.format("%" + maxDigits + "d", matrix[i][j]));
//                    if (j < matrix[i].length - 1) {
//                        sb.append(" | "); // Separador entre colunas
//                    }
//                }
//                sb.append("\n"); // Nova linha após cada linha da matriz
//            }
//            return sb.toString();
//        }
//
//        // Método auxiliar para encontrar o número máximo na matriz
//        private static int findMaxNumber(int[][] matrix) {
//            int max = Integer.MIN_VALUE;
//            for (int[] row : matrix) {
//                for (int num : row) {
//                    if (num > max) {
//                        max = num;
//                    }
//                }
//            }
//            return max;
//        }
//
//        //endregion
//
//        //Auxiliar para criar matrizes a zero dadas as linhas e as colunas
//        private int[][] newMatrix(int linhas, int colunas) {
//            //Valida se os numeros dados são válidos
//            if (linhas > 0 && colunas > 0) {
//                int[][] aux = new int[linhas][colunas];
//                for (int i = 0; i < linhas; i++)
//                    for (int j = 0; j < colunas; j++)
//                        aux[i][j] = 0;
//                return aux;
//            }
//            throw new IllegalArgumentException("Linhas e colunas tem de ser superior a 0");
//        }
//
//        //Auxiliar para verificar se os argumentos são válidos
//        private boolean checkArguments(int p, int q) {
//            if (p >= 0 && q >= 0 && p < getLinhas() && q < getColunas())
//                return true;
//
//            throw new IllegalArgumentException("Argumentos inválidos");
//        }
//
//    }
//
//
//}
