
package boutique;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

/**
 *
 * @author usuari
 */
public class GUI_StockDel extends javax.swing.JDialog {
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
     * Creates new form GestionStockGUI
     */
    public GUI_StockDel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        prendas = Boutique.misPrendas;
        prendaCombo = new Prenda();
        initComponents();
        
        llenarCombo();
        mostrarDatosPrenda();
        colocarCursor();
        
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
    
    private void llenarCombo() {
        jComboBoxPrendas.removeAllItems();
        for (Prenda p : prendas.getLista())
            jComboBoxPrendas.addItem(p);
    }
    
    private void mostrarDatosPrenda() {
        prendaCombo = (Prenda) jComboBoxPrendas.getSelectedItem();
        jTextFieldStockActual.setText(String.valueOf(prendaCombo.getStock()));
        
        if (prendaCombo.getStock() == 0) {
            jTextFieldStockToDel.setEnabled(false);
            jButtonAceptar.setEnabled(false);
            jButtonCancelar.requestFocus();
        } else {
            jTextFieldStockToDel.setEnabled(true);
            jButtonAceptar.setEnabled(true);
            jTextFieldStockToDel.requestFocus();
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

        jComboBoxPrendas = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldStockActual = new javax.swing.JTextField();
        jTextFieldStockToDel = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quitar Stock");
        setResizable(false);

        jComboBoxPrendas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Stock Actual:");

        jLabel2.setText("Stock a quitar:");

        jTextFieldStockActual.setEnabled(false);

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldStockToDel, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jTextFieldStockActual)))
                    .addComponent(jComboBoxPrendas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPrendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldStockActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldStockToDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
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
                    "Stock incorrecto", JOptionPane.ERROR_MESSAGE);
                colocarCursor();
            } else if (nuevoStock > antiguoStock) {
                JOptionPane.showMessageDialog(this, "El número tiene que ser menor o igual al stock actual.",
                    "Stock incorrecto", JOptionPane.ERROR_MESSAGE);
                colocarCursor();
            } else {
                dispose();
                prendaCombo.setStock(prendaCombo.getStock() - nuevoStock);
                //Boutique.misPrendas.actualizarPrenda(Boutique.misPrendas.indicePrenda(prendaCombo), prendaCombo);
                Boutique.miFichero.grabar(Boutique.misPrendas);
                JOptionPane.showMessageDialog(this, "Stock quitado satisfactoriamente.",
                        "Stock Modificado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Número de stock incorrecto.",
                    "Stock incorrecto", JOptionPane.ERROR_MESSAGE);
            colocarCursor();
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    // <editor-fold defaultstate="collapsed" desc="Declaració de Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox jComboBoxPrendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldStockActual;
    private javax.swing.JTextField jTextFieldStockToDel;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
