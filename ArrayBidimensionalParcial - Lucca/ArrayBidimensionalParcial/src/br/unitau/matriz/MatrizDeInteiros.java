package br.unitau.matriz;

import java.util.Random;

public class MatrizDeInteiros {

    private int matriz[][];

    public MatrizDeInteiros(int linha, int coluna) {
        matriz = new int[linha][coluna];
    }

//    public void setMatriz() {
//        Random valor = new Random();
//        for (int lin = 0; lin < matriz.length; lin++) {
//            for (int col = 0; col < matriz[lin].length; col++) {
//                matriz[lin][col] = valor.nextInt(10);
//            }
//        }
//    }
//ou
    public void setMatriz() {
        Random valor = new Random();
        for (int vet[] : matriz) {
            for (int col = 0; col < vet.length; col++) {
                vet[col] = valor.nextInt(10);
            }
        }
    }

    public boolean ehQuadrada() {
        return matriz.length == matriz[0].length;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int getTotLin() {
        return matriz.length;
    }

    public int getTotCol() {
        return matriz[0].length;
    }

    public String dados() {
        String dadosMatriz = "Valores armazenados na matriz\n";

        for (int vet[] : matriz) {
            for (int j = 0; j < vet.length; j++) {
                dadosMatriz += vet[j] + "\t";
            }
            dadosMatriz += "\n";
        }

        return dadosMatriz;

    }

    public int[] diagonalPrincipal() {
        int[] diagonal = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            diagonal[i] = matriz[i][i];
        }

        return diagonal;
    }

    public int[] diagonalSecundaria() {
        int col = matriz.length - 1;
        int[] diagonal = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            diagonal[i] = matriz[i][col];
            col--;
        }

        return diagonal;
    }

    public int somaValores() {
        int soma = 0;
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                soma += matriz[linha][coluna];
            }
        }
        return soma;
    }

    public int[] somaLinha() {
        int[] soma = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[i].length; k++) {
                soma[i] += matriz[i][k];
            }
        }
        return soma;
    }

    public int[] somaColuna() {
        int[] soma = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[i].length; k++) {
                soma[i] += matriz[k][i];
            }
        }
        return soma;
    }

    public int[][] Transposta() {

        int[][] transposta = new int[matriz[0].length][matriz.length];

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[0].length; j++) {
                transposta[i][j] = matriz[j][i];
            }

        }
        return transposta;
    }

    public boolean isSimetrica() {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if ((matriz[i][j]) != (matriz[j][i])) {
                    return false;

                }
            }

        }
        return true;
    }

    public void substituiImpar() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] % 2 != 0) {
                    matriz[i][j] = -1;

                }
            }

        }
    }

    public void substituiPar() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {

                if (matriz[i][j] % 2 == 0) {
                    matriz[i][j] = 1;

                }
            }

        }
    }

    public int numerosPares() {
        int numeroPar = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] % 2 == 0) {
                    numeroPar++;
                }
            }

        }
        return numeroPar;
    }

    public int[] par() {
        int qtde = numerosPares();
        int k = 0;
        int resultado[] = null;
        if (qtde > 0) {
            resultado = new int[qtde];
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (matriz[i][j] % 2 == 0) {
                        resultado[k] = matriz[i][j];
                        k++;
                    }
                }
            }
        }
        return resultado;
    }

    public int maiorValor() {
        int maior = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                }
            }
        }
        return maior;
    }

    public int retornaIndice(int numero) {
        int cont = 0;
        for (int linhas = 0; linhas < matriz.length; linhas++) {
            for (int colunas = 0; colunas < matriz[linhas].length; colunas++) {
                if (matriz[linhas][colunas] == numero) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public String retornaPosicao(int numero) {
        StringBuilder valor = new StringBuilder();
        for (int linhas = 0; linhas < matriz.length; linhas++) {
            for (int colunas = 0; colunas < matriz[linhas].length; colunas++) {
                if (matriz[linhas][colunas] == numero) {
                    valor.append("\nColuna: ").append(colunas + 1).append("\nLinha:").append(linhas + 1).append("\n");
                }
            }
        }
        return valor.toString();
    }

    public String vetorToString(int vet[], String msg) {
        StringBuilder saida = new StringBuilder(msg);

        for (int valor : vet) {
            saida.append(valor).append("\t");
        }
        return saida.toString();
    }

    public String matrizToString(int vet[][], String msg) {
        StringBuilder saida = new StringBuilder(msg);

        for (int[] valor : vet) {
            saida.append(valor).append("\t");
        }
        return saida.toString();
    }

    public void inverter() {
        int i = matriz.length;
        for (int j = 0; j < matriz.length; j++) {
            matriz[0][j] = matriz[i-1][j];
        }
    }
    
    public boolean busca(int numero){
        boolean buscado = false;
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                if (matriz[i][j] == numero){
                    buscado = true;
                }
            }
            
        }
        return buscado;
    }
    
    public String valorExiste(int numero){
        String valor = "";
        if (busca(numero) == true){
            valor = "Valor encontrado";
        } else{
            valor = "Valor não encontrado";
        }
        return valor;
    }
}
