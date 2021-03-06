
package vista;

import static boutique.Boutique.prendasFuente;
import modelo.Prenda;
import modelo.ListaPrendas;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

/**
 *
 * @author usu21
 */
public class StockQuitar extends javax.swing.JInternalFrame {
    private ListaPrendas prendas;

    public ListaPrendas getPrendas() {
        return prendas;
    }

    public void setPrendas(ListaPrendas prendas) {
        this.prendas = prendas;
    }
    
    private Prenda prendaCombo;

    public Prenda getPrendaCombo() {
        return prendaCombo;
    }

    public void setPrendaCombo(Prenda prendaCombo) {
        this.prendaCombo = prendaCombo;
    }

    /**
     * Creates new form GUI_StockRetirar
     */
    public StockQuitar() {
        prendas = prendasFuente.selectPrendasTodas();
        prendaCombo = new Prenda();
        initComponents();
        mostrarDatosPrenda();
        
        ItemListener il = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    mostrarDatosPrenda();
                }
            }
        };
        
        jComboBoxPrendas.addItemListener(il);
    }
    
    private void mostrarDatosPrenda() {
        prendaCombo = (Prenda) jComboBoxPrendas.getSelectedItem();
        jTextFieldStockActual.setText(String.valueOf(prendaCombo.getStock()));
        
        if (prendaCombo.getStock() > 0) {
            jTextFieldStockToDel.setEditable(true);
            jButtonAceptar.setEnabled(true);
            jTextFieldStockToDel.requestFocus();
        } else {
            jTextFieldStockToDel.setEditable(false);
            jButtonAceptar.setEnabled(false);
        }
    }
    
    private void colocarCursor() {
        jTextFieldStockToDel.setText("");
        jTextFieldStockToDel.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanelDel = new javax.swing.JPanel();
        jComboBoxPrendas = new javax.swing.JComboBox();
        jTextFieldStockActual = new javax.swing.JTextField();
        jTextFieldStockToDel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setTitle("Retirar Stock");

        jComboBoxPrendas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${prendas.lista}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jComboBoxPrendas);
        bindingGroup.addBinding(jComboBoxBinding);

        jTextFieldStockActual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldStockActual.setEnabled(false);

        jTextFieldStockToDel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel1.setText("Stock Actual:");

        jLabel2.setText("Stock a Retirar:");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDelLayout = new javax.swing.GroupLayout(jPanelDel);
        jPanelDel.setLayout(jPanelDelLayout);
        jPanelDelLayout.setHorizontalGroup(
            jPanelDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDelLayout.createSequentialGroup()
                        .addGroup(jPanelDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldStockToDel)
                            .addComponent(jTextFieldStockActual)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDelLayout.createSequentialGroup()
                        .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxPrendas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDelLayout.setVerticalGroup(
            jPanelDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPrendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldStockActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldStockToDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanelDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        int antiguoStock = prendaCombo.getStock();

        try {
            int nuevoStock = Integer.parseInt(jTextFieldStockToDel.getText());
            if (nuevoStock <= 0) {
                JOptionPane.showMessageDialog(this, "El número tiene que ser superior a 0.",
                    "Stock Incorrecto", JOptionPane.ERROR_MESSAGE);
                colocarCursor();
            } else if (nuevoStock > antiguoStock) {
                JOptionPane.showMessageDialog(this, "El número tiene que ser menor o igual al stock actual.",
                    "Stock Incorrecto", JOptionPane.ERROR_MESSAGE);
                colocarCursor();
            } else {
                dispose();
                prendaCombo.setStock(prendaCombo.getStock() - nuevoStock);
                if (prendasFuente.actualizarPrenda(prendaCombo)) {
                    JOptionPane.showMessageDialog(this, "Stock quitado satisfactoriamente.",
                        "Stock Modificado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha podido modificar el stock.",
                        "Error: Stock NO modificado", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Número de stock incorrecto.",
                "Stock Incorrecto", JOptionPane.ERROR_MESSAGE);
            colocarCursor();
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox jComboBoxPrendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelDel;
    private javax.swing.JTextField jTextFieldStockActual;
    private javax.swing.JTextField jTextFieldStockToDel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
