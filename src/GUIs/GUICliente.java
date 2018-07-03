package GUIs;

import DAOs.DAOCliente;
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
import javax.swing.JTextField;
import tools.*;
import DAOs.*;

public class GUICliente extends JFrame {

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
    private JPanel pnCentro = new JPanel(new GridLayout(9, 2));
    private JPanel pnSul = new JPanel(new GridLayout(1, 1));
    private JLabel lbIdCliente = new JLabel("IdCliente");
    private JTextField tfIdCliente = new JTextField(10);
    private JLabel lbNomeCliente = new JLabel("NomeCliente");
    private JTextField tfNomeCliente = new JTextField(10);
    private JLabel lbTelefone = new JLabel("Telefone");
    private JTextField tfTelefone = new JTextField(10);
    private JLabel lbCelular = new JLabel("Celular");
    private JTextField tfCelular = new JTextField(10);
    private JLabel lbEmail = new JLabel("Email");
    private JTextField tfEmail = new JTextField(10);
    private JLabel lbEndereco = new JLabel("Endereco");
    private JTextField tfEndereco = new JTextField(10);
    private JLabel lbCidade = new JLabel("Cidade");
    private JTextField tfCidade = new JTextField(10);
    private JLabel lbCep = new JLabel("Cep");
    private JTextField tfCep = new JTextField(10);
    private JLabel lbBairro = new JLabel("Bairro");
    private JTextField tfBairro = new JTextField(10);
    private JPanel pnIdSexo = new JPanel(new GridLayout(1, 2));
    private JLabel lbIdSexo = new JLabel("IdSexo");
    private JTextField tfIdSexo = new JTextField();
    private JButton btIdSexo = new JButton("Procurar");
    ScrollPane scroll = new ScrollPane();
    JTextArea jTextArea = new JTextArea();
    JPanel aviso = new JPanel();
    JLabel labelAviso = new JLabel("");
    String qualAcao = "";//variavel para facilitar insert e update
    DAOCliente daoCliente = new DAOCliente();
    Cliente cliente;
    private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();

    public GUICliente() {
        setSize(900, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("CRUD - Cliente");
        Container cp = getContentPane();
        cp = getContentPane();
        btnCreate.setToolTipText("Inserir novo registro");
        btnRetrieve.setToolTipText("Pesquisar por chave");
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        cp.setLayout(new BorderLayout());
        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);
        pnNorte.add(lbIdCliente);
        pnNorte.add(tfIdCliente);
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
        pnCentro.add(lbNomeCliente);
        pnCentro.add(tfNomeCliente);
        pnCentro.add(lbTelefone);
        pnCentro.add(tfTelefone);
        pnCentro.add(lbCelular);
        pnCentro.add(tfCelular);
        pnCentro.add(lbEmail);
        pnCentro.add(tfEmail);
        pnCentro.add(lbEndereco);
        pnCentro.add(tfEndereco);
        pnCentro.add(lbCidade);
        pnCentro.add(tfCidade);
        pnCentro.add(lbCep);
        pnCentro.add(tfCep);
        pnCentro.add(lbBairro);
        pnCentro.add(tfBairro);
        pnCentro.add(lbIdSexo);
        pnCentro.add(pnIdSexo);
        pnIdSexo.add(tfIdSexo);
        pnIdSexo.add(btIdSexo);
        pnSul.setBackground(Color.red);
        scroll.add(jTextArea);
        pnSul.add(scroll);
        tfNomeCliente.setEditable(false);
        tfTelefone.setEditable(false);
        tfCelular.setEditable(false);
        tfEmail.setEditable(false);
        tfEndereco.setEditable(false);
        tfCidade.setEditable(false);
        tfCep.setEditable(false);
        tfBairro.setEditable(false);
        tfIdSexo.setEditable(false);
        btIdSexo.setEnabled(false);
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tfIdCliente.setBackground(Color.white);
                    jTextArea.setText("");
                    cliente = new Cliente();
                    int identificador = Integer.valueOf(tfIdCliente.getText());
                    cliente.setIdCliente(identificador);
                    cliente = daoCliente.obter(cliente.getIdCliente());
                    if (cliente == null) {
                        pnNorte.setBackground(Color.red);
                        tfNomeCliente.setText("");
                        tfTelefone.setText("");
                        tfCelular.setText("");
                        tfEmail.setText("");
                        tfEndereco.setText("");
                        tfCidade.setText("");
                        tfCep.setText("");
                        tfBairro.setText("");
                        tfIdSexo.setText("");
                        btnCreate.setVisible(true);
                    } else {
                        pnNorte.setBackground(Color.green);
                        tfNomeCliente.setText(cliente.getNomeCliente());
                        tfTelefone.setText(cliente.getTelefone());
                        tfCelular.setText(cliente.getCelular());
                        tfEmail.setText(cliente.getEmail());
                        tfEndereco.setText(cliente.getEndereco());
                        tfCidade.setText(cliente.getCidade());
                        tfCep.setText(cliente.getCep());
                        tfBairro.setText(cliente.getBairro());
                        String dao1 = String.valueOf(cliente.getIdSexo());
                        String[] aux1 = dao1.split("-");
                        tfIdSexo.setText(aux1[0]);
                        btnUpdate.setVisible(true);
                        btnDelete.setVisible(true);
                        btnCreate.setVisible(false);
                    }
                    tfIdCliente.setEditable(false);
                    tfNomeCliente.setEditable(false);
                    tfTelefone.setEditable(false);
                    tfCelular.setEditable(false);
                    tfEmail.setEditable(false);
                    tfEndereco.setEditable(false);
                    tfCidade.setEditable(false);
                    tfCep.setEditable(false);
                    tfBairro.setEditable(false);
                    btIdSexo.setEnabled(false);
                    tfIdCliente.selectAll();
                } catch (Exception erro) {
                    pnNorte.setBackground(Color.yellow);
                    tfIdCliente.requestFocus();
                    tfIdCliente.setBackground(Color.red);
                    jTextArea.setText("Erro... \n");
                    jTextArea.append(erro.getMessage());
                }
            }
        });
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfIdCliente.setEditable(false);
                tfNomeCliente.requestFocus();
                btnCreate.setVisible(false);
                btnSave.setVisible(true);
                qualAcao = "incluir";
                cliente = new Cliente();
                tfNomeCliente.setEditable(true);
                tfTelefone.setEditable(true);
                tfCelular.setEditable(true);
                tfEmail.setEditable(true);
                tfEndereco.setEditable(true);
                tfCidade.setEditable(true);
                tfCep.setEditable(true);
                tfBairro.setEditable(true);
                btIdSexo.setEnabled(true);
                tfIdCliente.setEditable(false);
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jTextArea.setText("");
                    cliente = new Cliente();
                    cliente.setIdCliente(Integer.valueOf(tfIdCliente.getText()));
                    cliente.setNomeCliente(tfNomeCliente.getText());
                    cliente.setTelefone(tfTelefone.getText());
                    cliente.setCelular(tfCelular.getText());
                    cliente.setEmail(tfEmail.getText());
                    cliente.setEndereco(tfEndereco.getText());
                    cliente.setCidade(tfCidade.getText());
                    cliente.setCep(tfCep.getText());
                    cliente.setBairro(tfBairro.getText());
                    String[] aux0 = tfIdSexo.getText().split("-");
                    DAOSexo daoSexo = new DAOSexo();
                    Sexo d0 = daoSexo.obter(Integer.valueOf(aux0[0]));
                    cliente.setIdSexo(d0);
                    if (qualAcao.equals("incluir")) {
                        daoCliente.inserir(cliente);
                    } else {
                        daoCliente.atualizar(cliente);
                    }
                    tfIdCliente.setEditable(true);
                    tfIdCliente.requestFocus();
                    tfNomeCliente.setText("");
                    tfTelefone.setText("");
                    tfCelular.setText("");
                    tfEmail.setText("");
                    tfEndereco.setText("");
                    tfCidade.setText("");
                    tfCep.setText("");
                    tfBairro.setText("");
                    tfIdSexo.setText("");
                    btnSave.setVisible(false);
                    pnNorte.setBackground(Color.green);
                    tfNomeCliente.setEditable(false);
                    tfTelefone.setEditable(false);
                    tfCelular.setEditable(false);
                    tfEmail.setEditable(false);
                    tfEndereco.setEditable(false);
                    tfCidade.setEditable(false);
                    tfCep.setEditable(false);
                    tfBairro.setEditable(false);
                    btIdSexo.setEnabled(false);
                } catch (Exception erro) {
                    jTextArea.append("Erro............");
                    tfIdCliente.setEditable(true);
                    pnNorte.setBackground(Color.red);
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);
                tfNomeCliente.requestFocus();
                btnSave.setVisible(true);
                qualAcao = "editar";
                tfNomeCliente.setEditable(true);
                tfTelefone.setEditable(true);
                tfCelular.setEditable(true);
                tfEmail.setEditable(true);
                tfEndereco.setEditable(true);
                tfCidade.setEditable(true);
                tfCep.setEditable(true);
                tfBairro.setEditable(true);
                btIdSexo.setEnabled(true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + cliente.getIdCliente() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    daoCliente.remover(cliente);
                    tfIdCliente.requestFocus();
                    tfNomeCliente.setText("");
                    tfTelefone.setText("");
                    tfCelular.setText("");
                    tfEmail.setText("");
                    tfEndereco.setText("");
                    tfCidade.setText("");
                    tfCep.setText("");
                    tfBairro.setText("");
                    tfIdSexo.setText("");
                    tfIdCliente.setEditable(true);
                    btnUpdate.setVisible(false);
                    btnDelete.setVisible(false);
                }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIListagemCliente guiListagem = new GUIListagemCliente(daoCliente.list());
            }
        });
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        DAOSexo daoSexo = new DAOSexo();
        btIdSexo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoSexo.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfIdSexo.setText(aux[0]);
                    } else {
                        jTextArea.setText("Nenhum dado adicionado!");
                    }
                }
            }
        });
        tfIdCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoCliente.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfIdCliente.setText(aux[0]);
                        btnRetrieve.doClick();

                    } else {
                        tfIdCliente.requestFocus();
                        tfIdCliente.selectAll();
                    }
                }
            }
        });
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        GUICliente guiCliente = new GUICliente();
    }
}
