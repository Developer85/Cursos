
package vista;

import boutique.Boutique;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author usu21
 */
public class MenuPrincipal extends javax.swing.JFrame {
    public static JInternalFrame internal;
    
    /**
     * Creates new form GUI_Principal
     */
    public MenuPrincipal() {
        initComponents();
        internal = new JInternalFrame();
    }
    
    public void centrarIF(JInternalFrame jif) {
        Dimension desktopSize = jDesktopPaneDesktop.getSize();
        Dimension internalFrameSize = jif.getSize();
        int width = (desktopSize.width - internalFrameSize.width) / 2;
        int height = (desktopSize.height - internalFrameSize.height) / 2;
        jif.setLocation(width, height);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneDesktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuPrenda = new javax.swing.JMenu();
        jMenuItemAlta = new javax.swing.JMenuItem();
        jMenuItemListado = new javax.swing.JMenuItem();
        jMenuItemListadoPorColor = new javax.swing.JMenuItem();
        jMenuStock = new javax.swing.JMenu();
        jMenuItemGestion = new javax.swing.JMenuItem();
        jMenuItemValoracion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("La Boutique");
        setResizable(false);

        jDesktopPaneDesktop.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jDesktopPaneDesktopLayout = new javax.swing.GroupLayout(jDesktopPaneDesktop);
        jDesktopPaneDesktop.setLayout(jDesktopPaneDesktopLayout);
        jDesktopPaneDesktopLayout.setHorizontalGroup(
            jDesktopPaneDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
        );
        jDesktopPaneDesktopLayout.setVerticalGroup(
            jDesktopPaneDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(null);

        jMenuArchivo.setText("Archivo");

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemSalir);

        jMenuBar1.add(jMenuArchivo);

        jMenuPrenda.setText("Prenda");

        jMenuItemAlta.setText("Alta");
        jMenuItemAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAltaActionPerformed(evt);
            }
        });
        jMenuPrenda.add(jMenuItemAlta);

        jMenuItemListado.setText("Listado");
        jMenuItemListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoActionPerformed(evt);
            }
        });
        jMenuPrenda.add(jMenuItemListado);

        jMenuItemListadoPorColor.setText("Listado por Color");
        jMenuItemListadoPorColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoPorColorActionPerformed(evt);
            }
        });
        jMenuPrenda.add(jMenuItemListadoPorColor);

        jMenuBar1.add(jMenuPrenda);

        jMenuStock.setText("Stock");

        jMenuItemGestion.setText("Gestión");
        jMenuItemGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionActionPerformed(evt);
            }
        });
        jMenuStock.add(jMenuItemGestion);

        jMenuItemValoracion.setText("Valoración");
        jMenuItemValoracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemValoracionActionPerformed(evt);
            }
        });
        jMenuStock.add(jMenuItemValoracion);

        jMenuBar1.add(jMenuStock);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneDesktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAltaActionPerformed
        internal.dispose();
        internal = new PrendaAlta();
        jDesktopPaneDesktop.add(internal);
        centrarIF(internal);
        internal.setVisible(true);
    }//GEN-LAST:event_jMenuItemAltaActionPerformed

    private void jMenuItemListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoActionPerformed
        if (Boutique.misPrendas.cantidadPrendas() == 0)
            JOptionPane.showMessageDialog(this, "La Boutique no dispone de prendas.",
                "Sin Existencias.", JOptionPane.ERROR_MESSAGE);
        else {
            internal.dispose();
            internal = new PrendasListado();
            jDesktopPaneDesktop.add(internal);
            try {
                internal.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            internal.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemListadoActionPerformed

    private void jMenuItemListadoPorColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoPorColorActionPerformed
        if (Boutique.misPrendas.cantidadPrendas() == 0)
            JOptionPane.showMessageDialog(this, "La Boutique no dispone de prendas.",
                "Sin Existencias.", JOptionPane.ERROR_MESSAGE);
        else {
            internal.dispose();
            internal = new ColorOpcion(jDesktopPaneDesktop);
            jDesktopPaneDesktop.add(internal);
            centrarIF(internal);
            internal.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemListadoPorColorActionPerformed

    private void jMenuItemValoracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemValoracionActionPerformed
        if (Boutique.misPrendas.cantidadPrendas() == 0)
            JOptionPane.showMessageDialog(this, "La Boutique no dispone de prendas.",
                "Sin Existencias.", JOptionPane.ERROR_MESSAGE);
        else {
            internal.dispose();
            internal = new StockValoracion();
            jDesktopPaneDesktop.add(internal);
            centrarIF(internal);
            internal.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemValoracionActionPerformed

    private void jMenuItemGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionActionPerformed
        if (Boutique.misPrendas.cantidadPrendas() == 0)
            JOptionPane.showMessageDialog(this, "La Boutique no dispone de prendas.",
                "Sin Existencias.", JOptionPane.ERROR_MESSAGE);
        else {
            internal.dispose();
            internal = new StockOpcion(jDesktopPaneDesktop);
            jDesktopPaneDesktop.add(internal);
            centrarIF(internal);
            internal.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemGestionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPaneDesktop;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAlta;
    private javax.swing.JMenuItem jMenuItemGestion;
    private javax.swing.JMenuItem jMenuItemListado;
    private javax.swing.JMenuItem jMenuItemListadoPorColor;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemValoracion;
    private javax.swing.JMenu jMenuPrenda;
    private javax.swing.JMenu jMenuStock;
    // End of variables declaration//GEN-END:variables
}
