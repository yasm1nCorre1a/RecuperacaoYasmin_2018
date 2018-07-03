
package GUIs;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import tools.CentroDoMonitorMaior;


public class GUIMenu extends JFrame {

    ImageIcon iconeLogo = new ImageIcon(getClass().getResource("/icones/logo.jpg"));
    JLabel logo = new JLabel(iconeLogo);

    public GUIMenu() {
        setTitle("Menu Floricultura");
        Container cp = getContentPane();
        cp = getContentPane();
        cp.add(logo);
        // Cria uma barra de menu para o JFrame
        JMenuBar menuBar = new JMenuBar();

        // Adiciona a barra de menu ao  frame
        setJMenuBar(menuBar);

        // Define e adiciona dois menus drop down na barra de menus
        JMenu fileMenu = new JMenu("GUIs");
        menuBar.add(fileMenu);

        // Cria e adiciona um item simples para o menu
        JMenuItem sexo = new JMenuItem("GUISexo");
        JMenuItem tipo = new JMenuItem("GUITipo");
        JMenuItem flores = new JMenuItem("GUIFlores");
        JMenuItem cliente = new JMenuItem("GUICliente");
        JMenuItem pedido = new JMenuItem("GUIPedido");
        //JMenuItem pedidoflores = new JMenuItem("GUIPedidoFlores");

        
        fileMenu.add(flores);
        fileMenu.add(sexo);
        fileMenu.add(tipo);
        fileMenu.add(cliente);
        fileMenu.add(pedido);
        setVisible(true);

        flores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIFlores guiFlores = new GUIFlores();
            }
        });

        sexo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUISexo guiSexo = new GUISexo();
            }
        });

        tipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUITipo guiTipo = new GUITipo();
            }
        });

        cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUICliente guiCliente = new GUICliente();
            }
        });

        pedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIPedido guiPedido = new GUIPedido();
                //GUIPedidoFloresPK guiPedidoFloresPK = new GUIPedidoFloresPK();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        pack();
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
    }
}
