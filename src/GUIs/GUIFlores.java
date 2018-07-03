package GUIs;

import DAOs.DAOFlores;
import DAOs.DAOTipo;
import Entidades.*;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.io.File;
import javax.swing.JFileChooser;
import java.awt.Image;
import javax.swing.JTextField;
import tools.*;

public class GUIFlores extends JFrame {

    ImageIcon iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
    ImageIcon iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
    ImageIcon iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
    ImageIcon iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
    ImageIcon iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
    ImageIcon iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
    ImageIcon iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));
    JButton btnCreate = new JButton(iconeCreate);
    JButton btnRetrieve = new JButton(iconeRetrieve);
    JButton btnUpdate = new JButton(iconeUpdate);
    JButton btnDelete = new JButton(iconeDelete);
    JButton btnSave = new JButton(iconeSave);
    JButton btnCancel = new JButton(iconeCancel);
    JButton btnList = new JButton(iconeListar);
    private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnCentro = new JPanel(new GridLayout(4, 2));
    private JPanel pnSul = new JPanel(new GridLayout(1, 1));
    private JPanel pnE1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel pnE2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel pnE3 = new JPanel(new GridLayout(1, 1));
    private JLabel lbIdFlor = new JLabel("IdFlor");
    private JTextField tfIdFlor = new JTextField(10);
    private JLabel lbNomeFlor = new JLabel("NomeFlor");
    private JTextField tfNomeFlor = new JTextField(10);
    private JLabel lbQuantidadeFlor = new JLabel("QuantidadeFlor");
    private JTextField tfQuantidadeFlor = new JTextField(10);
    private JLabel lbPrecoFlor = new JLabel("PrecoFlor");
    private JTextField tfPrecoFlor = new JTextField(10);
    private JPanel pnIdTipo = new JPanel(new GridLayout(1, 2));
    private JLabel lbIdTipo = new JLabel("IdTipo");
    private JTextField tfIdTipo = new JTextField();
    private JButton btIdTipo = new JButton("Procurar");
    JTextField tfCaminho = new JTextField();
    ScrollPane scroll = new ScrollPane();
    JTextArea jTextArea = new JTextArea();
    JPanel aviso = new JPanel();
    JLabel labelAviso = new JLabel("");
    String qualAcao = "";//variavel para facilitar insert e update
    DAOFlores daoFlores = new DAOFlores();
    Flores flores;
    private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();
    private JPanel pnEsquerda = new JPanel(new BorderLayout());
    private JPanel pnDireita = new JPanel(new BorderLayout());
    private JLabel rotulo = new JLabel();
    private JButton btAbrirImagem = new JButton("Selecionar imagem");
    private String caminho;
    private Image imagemAux;
    private ImageIcon icone;

    public GUIFlores() {
        setSize(900, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("CRUD - Flores");
        Container cp = getContentPane();
        cp = getContentPane();
        btnCreate.setToolTipText("Inserir novo registro");
        btnRetrieve.setToolTipText("Pesquisar por chave");
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        cp.setLayout(new GridLayout(1, 2));
        cp.add(pnEsquerda);
        cp.add(pnDireita);
        try {
            String caminho = "";
            tfCaminho.setText(caminho);
            icone = new ImageIcon(getClass().getResource(caminho));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            rotulo.setIcon(icone);
        } catch (Exception err) {
            System.out.println("erro " + err.getLocalizedMessage());
        }
        pnDireita.add(pnE1, BorderLayout.NORTH);
        pnE1.add(rotulo);
        pnDireita.add(pnE2, BorderLayout.CENTER);
        pnE2.add(btAbrirImagem);
        pnDireita.add(pnE3, BorderLayout.SOUTH);
        pnE3.add(tfCaminho);
        pnEsquerda.add(pnNorte, BorderLayout.NORTH);
        pnEsquerda.add(pnCentro, BorderLayout.CENTER);
        pnEsquerda.add(pnSul, BorderLayout.SOUTH);
        pnNorte.add(lbIdFlor);
        pnNorte.add(tfIdFlor);
        pnNorte.add(btnRetrieve);
        pnNorte.add(btnCreate);
        pnNorte.add(btnUpdate);
        pnNorte.add(btnDelete);
        pnNorte.add(btnSave);
        pnNorte.add(btnList);
        btnCancel.setVisible(false);
        btnDelete.setVisible(false);
        btnCreate.setVisible(false);
        btnSave.setVisible(false);
        btnUpdate.setVisible(false);
        btAbrirImagem.setEnabled(false);
        tfCaminho.setEditable(false);
        pnCentro.add(lbNomeFlor);
        pnCentro.add(tfNomeFlor);
        pnCentro.add(lbQuantidadeFlor);
        pnCentro.add(tfQuantidadeFlor);
        pnCentro.add(lbPrecoFlor);
        pnCentro.add(tfPrecoFlor);
        pnCentro.add(lbIdTipo);
        pnCentro.add(pnIdTipo);
        pnIdTipo.add(tfIdTipo);
        pnIdTipo.add(btIdTipo);
        pnSul.setBackground(Color.red);
        scroll.add(jTextArea);
        pnSul.add(scroll);
        tfCaminho.setEditable(false);
        tfNomeFlor.setEditable(false);
        tfQuantidadeFlor.setEditable(false);
        tfPrecoFlor.setEditable(false);
        tfIdTipo.setEditable(false);
        btIdTipo.setEnabled(false);
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tfIdFlor.setBackground(Color.white);
                    jTextArea.setText("");
                    flores = new Flores();
                    int identificador = Integer.valueOf(tfIdFlor.getText());
                    flores.setIdFlor(identificador);
                    flores = daoFlores.obter(flores.getIdFlor());
                    if (flores == null) {
                        pnNorte.setBackground(Color.red);
                        tfCaminho.setText("");
                        tfNomeFlor.setText("");
                        tfQuantidadeFlor.setText("");
                        tfPrecoFlor.setText("");
                        tfIdTipo.setText("");
                        btnCreate.setVisible(true);
                    } else {
                        pnNorte.setBackground(Color.green);
                        caminho = flores.getCaminho();
                        tfCaminho.setText(caminho);
                        icone = new ImageIcon(caminho);
                        imagemAux = icone.getImage();
                        icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                        rotulo.setIcon(icone);
                        tfNomeFlor.setText(flores.getNomeFlor());
                        tfQuantidadeFlor.setText(String.valueOf(flores.getQuantidadeFlor()));
                        tfPrecoFlor.setText(String.valueOf(flores.getPrecoFlor()));
                        String dao1 = String.valueOf(flores.getIdTipo());
                        String[] aux1 = dao1.split("-");
                        tfIdTipo.setText(aux1[0]);
                        btnUpdate.setVisible(true);
                        btnDelete.setVisible(true);
                        btnCreate.setVisible(false);
                    }
                    btAbrirImagem.setEnabled(false);
                    tfIdFlor.setEditable(false);
                    tfNomeFlor.setEditable(false);
                    tfQuantidadeFlor.setEditable(false);
                    tfPrecoFlor.setEditable(false);
                    btIdTipo.setEnabled(false);
                    tfIdFlor.selectAll();
                } catch (Exception erro) {
                    pnNorte.setBackground(Color.yellow);
                    tfIdFlor.requestFocus();
                    tfIdFlor.setBackground(Color.red);
                    jTextArea.setText("Erro... \n");
                    jTextArea.append(erro.getMessage());
                }
            }
        });
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfIdFlor.setEditable(false);
                tfNomeFlor.requestFocus();
                btnCreate.setVisible(false);
                btnSave.setVisible(true);
                qualAcao = "incluir";
                flores = new Flores();
                tfNomeFlor.setEditable(true);
                tfQuantidadeFlor.setEditable(true);
                tfPrecoFlor.setEditable(true);
                btIdTipo.setEnabled(true);
                tfIdFlor.setEditable(false);
                btAbrirImagem.setEnabled(true);
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jTextArea.setText("");
                    flores = new Flores();
                    flores.setIdFlor(Integer.valueOf(tfIdFlor.getText()));
                    flores.setNomeFlor(tfNomeFlor.getText());
                    flores.setQuantidadeFlor(Integer.valueOf(tfQuantidadeFlor.getText()));
                    flores.setPrecoFlor(Double.valueOf(tfPrecoFlor.getText()));
                    String[] aux0 = tfIdTipo.getText().split("-");
                    DAOTipo daoTipo = new DAOTipo();
                    Tipo d0 = daoTipo.obter(Integer.valueOf(aux0[0]));
                    flores.setIdTipo(d0);
                    caminho = tfCaminho.getText();
                    flores.setCaminho(caminho);
                    caminho = "";
                    icone = new ImageIcon(caminho);
                    rotulo.setIcon(icone);
                    if (qualAcao.equals("incluir")) {
                        daoFlores.inserir(flores);
                    } else {
                        daoFlores.atualizar(flores);
                    }
                    tfIdFlor.setEditable(true);
                    tfIdFlor.requestFocus();
                    tfNomeFlor.setText("");
                    tfQuantidadeFlor.setText("");
                    tfPrecoFlor.setText("");
                    tfIdTipo.setText("");
                    tfCaminho.setText("");
                    btnSave.setVisible(false);
                    pnNorte.setBackground(Color.green);
                    tfNomeFlor.setEditable(false);
                    tfQuantidadeFlor.setEditable(false);
                    tfPrecoFlor.setEditable(false);
                    btIdTipo.setEnabled(false);
                    btAbrirImagem.setEnabled(false);
                } catch (Exception erro) {
                    jTextArea.append("Erro............");
                    tfIdFlor.setEditable(true);
                    pnNorte.setBackground(Color.red);
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);
                btAbrirImagem.setEnabled(true);
                tfNomeFlor.requestFocus();
                btnSave.setVisible(true);
                qualAcao = "editar";
                tfNomeFlor.setEditable(true);
                tfQuantidadeFlor.setEditable(true);
                tfPrecoFlor.setEditable(true);
                btIdTipo.setEnabled(true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + flores.getIdFlor() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    daoFlores.remover(flores);
                    tfIdFlor.requestFocus();
                    tfNomeFlor.setText("");
                    tfQuantidadeFlor.setText("");
                    tfPrecoFlor.setText("");
                    tfIdTipo.setText("");
                    String caminho = "";

                    icone = new ImageIcon(caminho);
                    rotulo.setIcon(icone);

                    tfCaminho.setText("");
                    tfIdFlor.setEditable(true);
                    btnUpdate.setVisible(false);
                    btnDelete.setVisible(false);
                }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIListagemFlores guiListagem = new GUIListagemFlores(daoFlores.list());
            }
        });
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        btAbrirImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (fc.showOpenDialog(pnDireita) == JFileChooser.APPROVE_OPTION) {
                    File img = fc.getSelectedFile();
                    String caminho = fc.getSelectedFile().getAbsolutePath();
                    try {
                        tfCaminho.setText(caminho);
                        icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                        imagemAux = icone.getImage();
                        icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                        rotulo.setIcon(icone);
                    } catch (Exception ex) {
                        System.out.println("Erro: " + ex.getMessage());
                    }
                }
            }
        });
        DAOTipo daoTipo = new DAOTipo();
        btIdTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoTipo.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfIdTipo.setText(aux[0]);
                    } else {
                        jTextArea.setText("Nenhum dado adicionado!");
                    }
                }
            }
        });
        tfIdFlor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoFlores.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfIdFlor.setText(aux[0]);
                        btnRetrieve.doClick();

                    } else {
                        tfIdFlor.requestFocus();
                        tfIdFlor.selectAll();
                    }
                }
            }
        });
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        GUIFlores guiFlores = new GUIFlores();
    }
}
