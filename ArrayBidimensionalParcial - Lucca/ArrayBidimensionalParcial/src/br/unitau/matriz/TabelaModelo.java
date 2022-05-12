
package br.unitau.matriz;


import javax.swing.table.AbstractTableModel;
/*AbstractTableModel e uma classe abstrata que implementa a interface
 *TableModel. Ela fornece codigo padrao para disparar TableModelEvents 
 *com os metodos fireTableRowsDeleted(), fireTableCellUpdated() e 
 *fireTableChanged(). Ela tambem gerencia todos os TableModelListeners 
 *registrados em um EventListenerList.O metodo findColumn() procura o 
 *indice de uma coluna com um dado nome. Esta pesquisa e feita de modo 
 *linear e deve ser sobrescrita para modelos de tabelas enormes.Tres metodos 
 *devem ser implementados em subclasses concretas: getRowCount(), 
 *getColumnCount() e getValueAt(int row, int column).*/

public class TabelaModelo extends AbstractTableModel {
    private String colunas[]; 
    private int dados[][];
        
    public TabelaModelo(int mat[][])  {
      colunas=new String[mat[0].length+1];
      setColunas();
      dados = new int [mat.length][mat[0].length+1];
      setDados(mat);
    
    }

    @Override
    public int getRowCount() {
        return dados.length;    }

    @Override
    public int getColumnCount() {
        return colunas.length; 
    }

     
    @Override
    public String getColumnName( int pos){
        return colunas[pos];
    }
   
   public void excluiLinhasTabela(){
       int i = dados.length;
       dados=new int[0][0];
       fireTableRowsDeleted(0, i - 1);   
    }   
   
    private void setColunas() {
        colunas[0] = "";
        int k = 0;
        for (int i = 1; i < colunas.length; i++) {
            colunas[i] = String.valueOf(k);
            k++;
        }
    }

    public String[] getColunas() {
        return colunas;
    }

    public int[][] getDados() {
        return dados;
    }
     
    
   public void setDados (int mat[][]) { 
       int k;
       for (int i=0; i<dados.length; i++){
           k=0;
           for (int j=0; j<dados[0].length; j++){
               if (j==0){
                   dados[i][j]=i;
               }else{
                   dados[i][j]=mat[i][k];
                   k++;
               }
           }
       }
       fireTableStructureChanged();
  }

    @Override
    public Object getValueAt(int linha, int coluna) {
        return dados[linha][coluna];
    }
    
}//fim da classe

