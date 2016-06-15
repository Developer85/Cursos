
package boutique;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author usu21
 */
public class GUI_MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public GUI_MenuPrincipal() {
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

        jPanel1 = new javax.swing.JPanel();
        jButtonAlta = new javax.swing.JButton();
        jButtonListado = new javax.swing.JButton();
        jButtonAddDelStock = new javax.swing.JButton();
        jButtonPorColor = new javax.swing.JButton();
        jButtonValStock = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("La Boutique");
        setResizable(false);

        jButtonAlta.setText("Alta de Prenda");
        jButtonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaActionPerformed(evt);
            }
        });

        jButtonListado.setText("Listado de Prendas");
        jButtonListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListadoActionPerformed(evt);
            }
        });

        jButtonAddDelStock.setText("Añadir / Quitar Stock");
        jButtonAddDelStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddDelStockActionPerformed(evt);
            }
        });

        jButtonPorColor.setText("Listado de Prendas por Color");
        jButtonPorColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPorColorActionPerformed(evt);
            }
        });

        jButtonValStock.setText("Valoración del Stock");
        jButtonValStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPorColor, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonAddDelStock, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonValStock, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonListado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlta)
                    .addComponent(jButtonAddDelStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPorColor)
                    .addComponent(jButtonValStock))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaActionPerformed
        GUI_AltaPrenda alta = new GUI_AltaPrenda(this, true);
        alta.setVisible(true);
    }//GEN-LAST:event_jButtonAltaActionPerformed

    private void jButtonListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListadoActionPerformed
        if (Boutique.misPrendas.cantidadPrendas() == 0)
            JOptionPane.showMessageDialog(this, "La Boutique no dispone de prendas.",
                "Sin existencias.", JOptionPane.ERROR_MESSAGE);
        else {        
            GUI_Listado listado = new GUI_Listado(this, true);
            listado.setVisible(true);
        }
    }//GEN-LAST:event_jButtonListadoActionPerformed

    private void jButtonPorColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPorColorActionPerformed
        if (Boutique.misPrendas.cantidadPrendas() == 0)
            JOptionPane.showMessageDialog(this, "La Boutique no dispone de prendas.",
                "Sin existencias.", JOptionPane.ERROR_MESSAGE);
        else {        
            GUI_ColorOpcion eleccion = new GUI_ColorOpcion(this, true);
            eleccion.setVisible(true);
        }
    }//GEN-LAST:event_jButtonPorColorActionPerformed

    private void jButtonAddDelStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddDelStockActionPerformed
        if (Boutique.misPrendas.cantidadPrendas() == 0)
            JOptionPane.showMessageDialog(this, "La Boutique no dispone de prendas.",
                "Sin existencias.", JOptionPane.ERROR_MESSAGE);
        else {        
            GUI_StockOpcion gs = new GUI_StockOpcion(this, true);
            gs.setVisible(true);
        }
    }//GEN-LAST:event_jButtonAddDelStockActionPerformed

    private void jButtonValStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValStockActionPerformed
        if (Boutique.misPrendas.cantidadPrendas() == 0)
            JOptionPane.showMessageDialog(this, "La Boutique no dispone de prendas.",
                "Sin existencias.", JOptionPane.ERROR_MESSAGE);
        else {
            GUI_ValoracionStock vs = new GUI_ValoracionStock(this, true);
            vs.setVisible(true);
        }
    }//GEN-LAST:event_jButtonValStockActionPerformed

    // <editor-fold defaultstate="collapsed" desc="Declaració de Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddDelStock;
    private javax.swing.JButton jButtonAlta;
    private javax.swing.JButton jButtonListado;
    private javax.swing.JButton jButtonPorColor;
    private javax.swing.JButton jButtonValStock;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}