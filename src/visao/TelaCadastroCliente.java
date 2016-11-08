/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import genus.Funcoes;
import genus.Tipos.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author GilbertoSoares
 */
public class TelaCadastroCliente extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroCliente
     */
    public static int idFuncionario;
    
    public TelaCadastroCliente(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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

        labelCadastroCliente = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelNomeCliente = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        labelCPF = new javax.swing.JLabel();
        textFieldCPF = new javax.swing.JTextField();
        labelSoNumeros = new javax.swing.JLabel();
        buttonCadastrar = new javax.swing.JButton();
        buttonRetornar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelCadastroCliente.setFont(new java.awt.Font("Vijaya", 1, 36)); // NOI18N
        labelCadastroCliente.setText("Cadastro de cliente");

        labelNomeCliente.setText("Nome do cliente:");

        textFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNomeActionPerformed(evt);
            }
        });

        labelCPF.setText("CPF:");

        textFieldCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCPFActionPerformed(evt);
            }
        });

        labelSoNumeros.setText("(somente números)");

        buttonCadastrar.setText("Cadastrar");
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });

        buttonRetornar.setText("Retornar");
        buttonRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRetornarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelCadastroCliente)
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRetornar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCadastrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCPF)
                            .addComponent(labelNomeCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(textFieldCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelSoNumeros)))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeCliente)
                    .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCPF)
                    .addComponent(textFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSoNumeros))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(buttonCadastrar)
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonRetornar)
                        .addGap(14, 14, 14))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNomeActionPerformed

    private void textFieldCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCPFActionPerformed

    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarActionPerformed
        // TODO add your handling code here:
        Funcoes funcoes = new Funcoes();
        
        long cpf;
        String nome = textFieldNome.getText();
        
        try {
            cpf = Long.parseLong(textFieldCPF.getText());
        }
        catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar cliente!\n"
                    + "CPF inválido, insira apenas números.", "Erro ao adicionar cliente", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(cpf < 0 ){
            JOptionPane.showMessageDialog(this, "Erro ao adicionar cliente!\n"
                    + "CPF inválido, não pode ser negativo.", "Erro ao adicionar cliente", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(nome.equals("")){
            JOptionPane.showMessageDialog(this, "Erro ao adicionar cliente!\n"
                    + "Insira o nome do cliente.", "Erro ao adicionar cliente", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Cliente cliente;
        cliente = new Cliente(cpf,nome);
        
        if(funcoes.cadastrarCliente(cliente)){
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        }
        else{
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar cliente!\n"
                    + "Cliente já existe.", "Erro ao cadastrar cliente", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonCadastrarActionPerformed

    private void buttonRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRetornarActionPerformed
        // TODO add your handling code here:
            TelaVendedor tela = new TelaVendedor(idFuncionario);
            tela.setVisible(true);
            dispose();
    }//GEN-LAST:event_buttonRetornarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCliente(idFuncionario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonRetornar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelCadastroCliente;
    private javax.swing.JLabel labelNomeCliente;
    private javax.swing.JLabel labelSoNumeros;
    private javax.swing.JTextField textFieldCPF;
    private javax.swing.JTextField textFieldNome;
    // End of variables declaration//GEN-END:variables
}