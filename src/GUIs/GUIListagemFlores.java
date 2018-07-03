package GUIs;
import Entidades.Flores;
import tools.*;import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
public class GUIListagemFlores extends JDialog {
JPanel painelTa = new JPanel();
JScrollPane scroll = new JScrollPane();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
public GUIListagemFlores(List<Flores> texto) {
setTitle("Listagem de Flores");
setSize(600, 300);//tamanho da janela
setDefaultCloseOperation(DISPOSE_ON_CLOSE);//libera ao sair (tira da memÃ³ria a classe
setLayout(new BorderLayout());//informa qual gerenciador de layout serÃ¡ usado
setBackground(Color.CYAN);//cor do fundo da janela
setModal(true);
Container cp = getContentPane();//container principal, para adicionar nele os outros componentes
JToolBar toolBar = new JToolBar();

String[] colunas = new String[]{"IdFlor", "NomeFlor", "QuantidadeFlor", "PrecoFlor", "IdTipo", };
String[][] dados = new String[0][3];
DefaultTableModel model = new DefaultTableModel(dados, colunas);
JTable tabela = new JTable(model);
scroll.setViewportView(tabela);
for (int i = 0; i < texto.size(); i++) {
String[] linha = new String[]{String.valueOf(texto.get(i).getIdFlor()), String.valueOf(texto.get(i).getNomeFlor()), String.valueOf(texto.get(i).getQuantidadeFlor()), String.valueOf(texto.get(i).getPrecoFlor()), String.valueOf(texto.get(i).getIdTipo()), };
model.addRow(linha);
}
painelTa.add(scroll);
cp.add(toolBar, BorderLayout.NORTH);
cp.add(scroll, BorderLayout.CENTER);
CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
setVisible(true);
}
}
