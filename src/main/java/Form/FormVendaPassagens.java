/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Form;

import AeroPorto.Assento;
import AeroPorto.Passageiro;
import AeroPorto.Passagem;
import Utils.FiltrarCampo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import Utils.FormUtils;
import Utils.Output;



/**
 *
 * @author Cleo
 */
public final class FormVendaPassagens extends javax.swing.JInternalFrame {
    //ArrayList com todos os numeros do voos usados no combobox de selecionar voo
    protected ArrayList<String> numVoo = new ArrayList<>();
    
    //ArrayList com todos os assentos do voo
    //usados no combobox de seleção de assentos
    protected ArrayList<String> assentosValidos = new ArrayList<>();
    
    //ArrayList com com todos assentos livres do voo selecionado
    protected ArrayList<Integer> assentosLivres = new ArrayList<>();
    
    //ArrayList com as passagens geradas
    protected ArrayList<Passagem> Passagem = new ArrayList<>();
    
    //contador de quantas passagens está comprado
    //e num de quantas passagens deseja comprar
    protected int contador, numPassagem;

    
    /**
     * Creates new form FormVendaPassagens
     */
    
    private static FormVendaPassagens telaPassagem;
    
    //método que retorna a instância do formulário
    //se estiver aberto ou cria uma instância
    public static FormVendaPassagens getInstancia(){
        if(telaPassagem== null){
            telaPassagem = new FormVendaPassagens();  
        }
        return telaPassagem;
    }
    
    //Método para verificar se o assento está ocupado com isso setar os assentos
    //selecionáveis no combobox
    public void AssentosValidos(){
        assentosValidos.clear();
        for (Assento assento : FormAdicionarVoo.getInstancia().voo.get(selectVoo.getSelectedIndex()).getAssento()) {
            if (!assento.isOcupado()) {
                assentosValidos.add(assento.getFila() + " " + assento.getNumero());
            }
        }
        selectAssento.setModel(new DefaultComboBoxModel(assentosValidos.toArray()));
        
    }
    
    //Adiciona os voos ao combobox de seleção de voos
    public final void AdicionarVoosCombobox(String codVoo){
        numVoo.add(codVoo);
        selectVoo.setModel(new DefaultComboBoxModel(numVoo.toArray()));
        assentosLivres.add(100);
    }
    
    //Chama o método de preecher tabela
    public final void preencherTabela(){
        FormUtils.preencherTabela(tableVoo, FormAdicionarVoo.getInstancia().voo);
    }
    
    //Seta os valores dos campos que mostram os assentos livres e ocupados
    public void MaximoPassagens(){
        txtLivres.setText(String.valueOf(assentosLivres.get(selectVoo.getSelectedIndex())));
        txtOcupado.setText(String.valueOf(100 - assentosLivres.get(selectVoo.getSelectedIndex())));
   }
 
    //Desabilita os campos
    public final void desabilitarCampos(){
        txtNome.setEnabled(false);
        txtCpf.setEnabled(false);
        txtEndereco.setEnabled(false);
        txtFone.setEnabled(false);
        selectAssento.setEnabled(false);
        selectPagamento.setEnabled(false);
        btnComprar.setEnabled(false);
        btnCancelar.setEnabled(false);
        if(FormAdicionarVoo.getInstancia().voo.isEmpty()){
           qntPassagens.setEnabled(false);
           selectVoo.setEnabled(false);
        }
    }
    
    //Limpa todos os campos de texto
    public final void limparCampos(){   
        txtNome.setText(null);
        txtCpf.setText(null);
        txtEndereco.setText(null);
        txtFone.setText(null);
    }
    
    //Habilita os campos
    public final void habilitarCampos(){
        if((Integer)qntPassagens.getValue() > 0){
            txtNome.setEnabled(true);
            txtCpf.setEnabled(true);
            txtEndereco.setEnabled(true);
            txtFone.setEnabled(true);
            selectAssento.setEnabled(true);
            selectPagamento.setEnabled(true);
            btnComprar.setEnabled(true);
            btnCancelar.setEnabled(true);
        } else {
           qntPassagens.setEnabled(true);
           selectVoo.setEnabled(true);
            }
        }
    
    //Método para iniciar o formulário
    public final void iniciar(){
        contador = 0;
        
        //Adiciona o botão x close no canto superior direito da tela
        setClosable(true); 
        
        //Desabilita todos os campos exceto quantidade de passagens e seleção de voo
        desabilitarCampos();
        
        //Nesse primeiro momento ativa os campos passagens e seleção de voo
        habilitarCampos();
        
        
        //Filtra o campo nome
        txtNome.setDocument(new FiltrarCampo("Str"));
        
        if(!FormAdicionarVoo.getInstancia().voo.isEmpty()){
            //Preeche a tabela com os dados do ArreyList
            preencherTabela();

            //Chama o método que atualiza os assentos livres/ocupados
            MaximoPassagens();
            qntPassagens.setModel(new javax.swing.SpinnerNumberModel(numPassagem, 0, 100, 1));

            //Preenche o array de assentos válidos
            //para ser usado no combobox de seleção de assentos
            AssentosValidos();   

            //Seleciona a linha padrão da tabela
            tableVoo.setRowSelectionInterval(selectVoo.getSelectedIndex(), selectVoo.getSelectedIndex());
        } else {
            desabilitarCampos();
        }
    }
    
    public FormVendaPassagens() {
        initComponents();
    }
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel1 = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel2 = new javax.swing.JPanel();
        txtFone = new javax.swing.JFormattedTextField();
        LabelAssento = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        selectPagamento = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        qntPassagens = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        selectVoo = new javax.swing.JComboBox<>();
        LabelVoo = new javax.swing.JLabel();
        selectAssento = new javax.swing.JComboBox<>();
        btnComprar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtLivres = new javax.swing.JTextField();
        txtOcupado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            @Override
            public void paintComponent(Graphics g){
                //Variaveis de controle
                int numCadeira = 0;
                int startPosX = 150;
                int startPosY = 70;
                int tamanhoQuardrado = 20;
                int startPosY2 = startPosY+30;
                int numVoo= 150;
                //Trocando a fonte padrão
                g.setFont(new Font("Arial", Font.BOLD, 24){});
                //Desenha as letras de controle da fileira
                g.drawString("A", startPosX-25, startPosY+18);
                g.drawString("B", startPosX-25, startPosY+48);
                g.drawString("C", startPosX-25, startPosY+108);
                g.drawString("D", startPosX-25, startPosY+138);

                //Setando a cor da fonte
                g.setColor(Color.BLACK);

                //Aqui desenha o retangulo arredondado pra simular o avião
                g.drawRoundRect(startPosX-100, startPosY-60, 1170, 220, 250, 200);
                //Coloca o numero do Vôo no centro
                if(!FormAdicionarVoo.getInstancia().voo.isEmpty()){
                    g.drawString("VOO " + selectVoo.getSelectedItem().toString(), 1170/2, startPosY-20);
                }

                //Loop para adicionar as fileiras
                for(int y = 0; y< 4;y++){

                    //Loop para adicionar os lugares na vertical
                    for(int x = 0; x< 25;x++){

                        //Aqui adiciona os números de controle visual dos assentos
                        if(x < 10) {
                            g.drawString(""+x, startPosX+(x*40)+2, startPosY+79);
                        } else {
                            g.drawString(""+x, startPosX+(x*40)-2, startPosY+79);
                        }
                        //Verifica se o assento está ocupado
                        if(!FormAdicionarVoo.getInstancia().voo.isEmpty()){
                            if(FormAdicionarVoo.getInstancia().voo.get(selectVoo.getSelectedIndex()).getAssento()[numCadeira].isOcupado()) {

                                //Faz a fileira C e D dando separando por um espaço da A e B
                                if(y > 1){
                                    //muda a cor
                                    g.setColor(Color.red);
                                    //Cria o quadrado vermelho simbolizando o assento ocupado
                                    g.fillRect(startPosX+(x*40), startPosY2+(y*30), tamanhoQuardrado, tamanhoQuardrado);
                                    g.setColor(Color.black);

                                    //Faz a fileira A e B
                                } else{
                                    g.setColor(Color.red);
                                    g.fillRect(startPosX+(x*40), startPosY+(y*30), tamanhoQuardrado, tamanhoQuardrado);
                                    g.setColor(Color.black);
                                }
                                //else da checagem da ocupação do assento
                            } else {
                                if(y > 1){
                                    g.setColor(Color.green);
                                    //desenha o quadrado verde simbolizando o assento vago
                                    g.fillRect(startPosX+(x*40), startPosY2+(y*30), tamanhoQuardrado, tamanhoQuardrado);
                                    g.setColor(Color.black);
                                } else{
                                    g.setColor(Color.green);
                                    g.fillRect(startPosX+(x*40), startPosY+(y*30), tamanhoQuardrado, tamanhoQuardrado);
                                    g.setColor(Color.black);
                                }
                            }
                        }
                        numCadeira++;
                    }
                }
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableVoo = new javax.swing.JTable();

        setBorder(null);
        setTitle("VENDA DE PASSAGENS");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1024, 768));

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        try {
            txtFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFone.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFoneActionPerformed(evt);
            }
        });

        LabelAssento.setText("SELECIONE O ASSENTO");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        selectPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DINHEIRO", "PIX", "CARTÃO" }));
        selectPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPagamentoActionPerformed(evt);
            }
        });

        jLabel9.setText("FORMA DE PAGAMENTO");

        qntPassagens.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qntPassagensStateChanged(evt);
            }
        });

        jLabel10.setText("QUANTIDADE DE PASSAGENS");

        selectVoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectVooActionPerformed(evt);
            }
        });

        LabelVoo.setText("SELECIONE O VOO");

        selectAssento.setMaximumRowCount(10);

        btnComprar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        jLabel4.setText("NOME");

        jLabel5.setText("CPF");

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("ENDEREÇO");

        jLabel7.setText("TELEFONE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(37, 37, 37))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(selectPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qntPassagens, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(67, 67, 67)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelVoo)
                                .addComponent(LabelAssento))
                            .addGap(13, 13, 13)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(selectAssento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(selectVoo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNome)
                                    .addComponent(txtEndereco)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(btnComprar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelar)
                            .addGap(135, 135, 135)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(10, 10, 10))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(qntPassagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectVoo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelVoo))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(selectPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectAssento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelAssento))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnComprar)
                        .addComponent(btnCancelar))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        txtLivres.setEditable(false);

        txtOcupado.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/rect-green.png"))); // NOI18N
        jLabel2.setText("ASSENTOS LIVRE");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/rect-red.png"))); // NOI18N
        jLabel3.setText("ASSENTOS OCUPADO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLivres, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtOcupado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(403, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtOcupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLivres, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1233, Short.MAX_VALUE)
        );

        tableVoo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVoo.setColumnSelectionAllowed(true);
        tableVoo.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableVoo);

        jScrollPane1.setViewportView(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDesktopPane1)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)))
                .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFoneActionPerformed

    private void selectPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectPagamentoActionPerformed

    private void qntPassagensStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qntPassagensStateChanged
        if((Integer)qntPassagens.getValue() > 0){
            habilitarCampos();
        } else {
            desabilitarCampos();
        }
    }//GEN-LAST:event_qntPassagensStateChanged

    //Combobox de seleção de voo
    private void selectVooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectVooActionPerformed
        tableVoo.setRowSelectionInterval(selectVoo.getSelectedIndex(), selectVoo.getSelectedIndex());
        AssentosValidos();
        MaximoPassagens();
        
        //Repinta o formulario
        jDesktopPane1.repaint();
    }//GEN-LAST:event_selectVooActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        //variavel temporaria da quantidade de passagens
        int quantidadePassagens = (Integer)qntPassagens.getValue();
        
        //verificação se existe assentos livres no voo selecionado
        if(assentosLivres.get(selectVoo.getSelectedIndex())< 1){
            JOptionPane.showMessageDialog(null, """
                O número de assentos livres do voo acabou
                selecione outro ou cancele a compra!!""","Erro",2);
            } else {
            //verificação se algum campo está vázio
                String msg = "";
                msg += FormUtils.validarCampos(txtNome, "NOME");
                msg += FormUtils.validarCampos(txtCpf, "CPF");
                msg += FormUtils.validarCampos(txtEndereco, "ENDEREÇO");
                msg += FormUtils.validarCampos(txtFone, "TELEFONE");
                if(!msg.isEmpty()){
                    JOptionPane.showMessageDialog(null,msg,"Erro",2);
                }  else {
                    quantidadePassagens--;
                    //desabilita o campo de quantidade de passagens até
                    //finalizar as compras
                    qntPassagens.setEnabled(false);
                    qntPassagens.setValue(quantidadePassagens);
                    int numAssento = 0;
                    
                    //variavel temporiria para armazenar o assento selecionado
                    String[] assento = selectAssento.getSelectedItem().toString().split(" ");
                    
                    //cria peso para as letras da fileira do assento
                    switch (assento[0]) {
                        case "A" -> {
                            numAssento += 0;
                        }
                        case "B" -> {
                            numAssento += 25;
                        }
                        case "C" -> {
                            numAssento += 50;
                        }
                        case "D" -> {
                            numAssento += 75;
                        }
                    }
                    //numero do asento no array
                    numAssento += Integer.parseInt(assento[1]);
                    
                    //Nova instância de passageiro
                    Passageiro passageiro = new Passageiro(txtNome.getText(), txtCpf.getText(), txtEndereco.getText(), txtFone.getText());
                    
                    //Contador de passagens para aplicar o desconto
                    if( contador <= 1){
                        //nova instância de passagen já adicionando diretamento no arrayList
                        Passagem.add(
                            new Passagem(
                                FormAdicionarVoo.getInstancia().voo.get(selectVoo.getSelectedIndex())
                                , passageiro
                                , FormAdicionarVoo.getInstancia().voo.get(selectVoo.getSelectedIndex()).getAssento()[numAssento]
                                , FormAdicionarVoo.getInstancia().voo.get(selectVoo.getSelectedIndex()).getPreco()
                                , selectPagamento.getSelectedItem().toString())
                        );
                    } else {
                        Passagem.add(
                            new Passagem(FormAdicionarVoo.getInstancia().voo.get(selectVoo.getSelectedIndex())
                                , passageiro
                                , FormAdicionarVoo.getInstancia().voo.get(selectVoo.getSelectedIndex()).getAssento()[numAssento]
                                , 0.9*FormAdicionarVoo.getInstancia().voo.get(selectVoo.getSelectedIndex()).getPreco()
                                , selectPagamento.getSelectedItem().toString())
                        );
                    }
                    
                    FormAdicionarVoo.getInstancia().voo.get(selectVoo.getSelectedIndex()).getAssento()[numAssento].setOcupado(true);
                    selectAssento.removeItemAt(selectAssento.getSelectedIndex());
                    assentosLivres.set(selectVoo.getSelectedIndex(),assentosLivres.get(selectVoo.getSelectedIndex())-1);
                    MaximoPassagens();
                    jDesktopPane1.repaint();
                    limparCampos();
                    
                    //Chama o método para escrever o arquivo txt
                    Output.imprimir(Passagem.get(contador));
                    JOptionPane.showMessageDialog(null,Passagem.get(contador),"Confirmação de Compra",1);
                    contador++;
                    
                    //Reativa o quantidade de passagens e limpa o arraylist 
                    if(quantidadePassagens==0) {
                        qntPassagens.setEnabled(true);
                        contador=0;
                        Passagem.clear();
                    }
                }
            }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Limpa a quantidade de passagens
        //Array de passagens
        //Habilita novamente o campo de quantidade de passagens
        limparCampos();
        contador=0;
        Passagem.clear();
        qntPassagens.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAssento;
    private javax.swing.JLabel LabelVoo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner qntPassagens;
    private javax.swing.JComboBox<String> selectAssento;
    private javax.swing.JComboBox<String> selectPagamento;
    private javax.swing.JComboBox<String> selectVoo;
    private javax.swing.JTable tableVoo;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JFormattedTextField txtFone;
    private javax.swing.JTextField txtLivres;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtOcupado;
    // End of variables declaration//GEN-END:variables
}
