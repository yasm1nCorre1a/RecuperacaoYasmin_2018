package GUIs;




import Entidades.Sexo;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SexoTableModel extends AbstractTableModel {

    private final Class classes[] = new Class[]{Integer.class, String.class};
    private final String colunas[] = new String[]{"id", "Nome"};
    private List<Sexo> dados;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    //private final SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");
  

    public SexoTableModel(List<Sexo> dados) {
        this.dados = dados;
    }

    public void setDados(List<Sexo> dados) {
        this.dados = dados;
    }

    public List<Sexo> getDados() {
        return this.dados;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Sexo s = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getIdSexo();
            case 1:
                return s.getNomeSexo();            
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex==0) {
            return false;
        }
        return true;
    }

  
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

      //  mudou = true;
        Sexo s = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:              
                    s.setIdSexo((Integer) aValue);                
                break;
            case 1:
                s.setNomeSexo((String) aValue);
                break;          
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
        fireTableDataChanged();
    }

    public Sexo getValue(int rowIndex) {
        return dados.get(rowIndex);
    }

    public int indexOf(Sexo tc) {
        return dados.indexOf(tc);
    }

    public void onAdd(Sexo tipoConta) {
        dados.add(tipoConta);
        fireTableRowsInserted(indexOf(tipoConta), indexOf(tipoConta));
    }

    public void onRemove(int[] rowIndex) {
        int x;
        for (x = rowIndex.length - 1; x >= 0; x--) {
            dados.remove(rowIndex[x]);
            fireTableRowsDeleted(rowIndex[x], rowIndex[x]);
        }
    }
}
