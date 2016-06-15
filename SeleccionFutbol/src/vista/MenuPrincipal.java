
package vista;

import modelo.Entrenador;
import modelo.Jugador;

/**
 *
 * @author mfontana
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.setExtendedState(MenuPrincipal.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneBase = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuJugadores = new javax.swing.JMenu();
        jMenuItemAltaJugador = new javax.swing.JMenuItem();
        jMenuItemGestionJugadores = new javax.swing.JMenuItem();
        jMenuItemGestionPersonal = new javax.swing.JMenuItem();
        jMenuEntrenadores = new javax.swing.JMenu();
        jMenuItemAltaEntrenador = new javax.swing.JMenuItem();
        jMenuItemGestionEntrenadores = new javax.swing.JMenuItem();
        jMenuEquipos = new javax.swing.JMenu();
        jMenuItemAddEquipo = new javax.swing.JMenuItem();
        jMenuConsultas = new javax.swing.JMenu();
        jMenuItemJugPorNacionalidad = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("STUGOL - Gestor de Ligas");

        jMenuJugadores.setText("Jugadores");
        jMenuJugadores.setPreferredSize(new java.awt.Dimension(100, 17));

        jMenuItemAltaJugador.setText("Alta de Jugador");
        jMenuItemAltaJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAltaJugadorActionPerformed(evt);
            }
        });
        jMenuJugadores.add(jMenuItemAltaJugador);

        jMenuItemGestionJugadores.setText("Gestión de Jugadores");
        jMenuItemGestionJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionJugadoresActionPerformed(evt);
            }
        });
        jMenuJugadores.add(jMenuItemGestionJugadores);

        jMenuItemGestionPersonal.setText("Gestión de Personal");
        jMenuItemGestionPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionPersonalActionPerformed(evt);
            }
        });
        jMenuJugadores.add(jMenuItemGestionPersonal);

        jMenuBar1.add(jMenuJugadores);

        jMenuEntrenadores.setText("Entrenadores");
        jMenuEntrenadores.setPreferredSize(new java.awt.Dimension(120, 17));

        jMenuItemAltaEntrenador.setText("Alta de Entrenador");
        jMenuItemAltaEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAltaEntrenadorActionPerformed(evt);
            }
        });
        jMenuEntrenadores.add(jMenuItemAltaEntrenador);

        jMenuItemGestionEntrenadores.setText("Gestión de Entrenadores");
        jMenuEntrenadores.add(jMenuItemGestionEntrenadores);

        jMenuBar1.add(jMenuEntrenadores);

        jMenuEquipos.setText("Equipos");
        jMenuEquipos.setPreferredSize(new java.awt.Dimension(100, 17));

        jMenuItemAddEquipo.setText("Añadir un Equipo");
        jMenuItemAddEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddEquipoActionPerformed(evt);
            }
        });
        jMenuEquipos.add(jMenuItemAddEquipo);

        jMenuBar1.add(jMenuEquipos);

        jMenuConsultas.setText("Consultas");

        jMenuItemJugPorNacionalidad.setText("Listado de Jugadores (por nacionalidad)");
        jMenuItemJugPorNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemJugPorNacionalidadActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemJugPorNacionalidad);

        jMenuBar1.add(jMenuConsultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneBase, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneBase, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemAltaJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAltaJugadorActionPerformed
        DatosJugador dj = new DatosJugador(this, true, new Jugador(), "Alta");
        dj.setLocationRelativeTo(null);
        dj.setVisible(true);
    }//GEN-LAST:event_jMenuItemAltaJugadorActionPerformed

    private void jMenuItemAltaEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAltaEntrenadorActionPerformed
        DatosEntrenador de = new DatosEntrenador(this, true, new Entrenador(), "Alta");
        de.setLocationRelativeTo(null);
        de.setVisible(true);
    }//GEN-LAST:event_jMenuItemAltaEntrenadorActionPerformed

    private void jMenuItemGestionJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionJugadoresActionPerformed
        GestionJugadores gj = new GestionJugadores();
        gj.setSize(jDesktopPaneBase.getWidth(), jDesktopPaneBase.getHeight());
        jDesktopPaneBase.add(gj);
        gj.setVisible(true);
    }//GEN-LAST:event_jMenuItemGestionJugadoresActionPerformed

    private void jMenuItemJugPorNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemJugPorNacionalidadActionPerformed
        JugadoresNacionalidad jn = new JugadoresNacionalidad();
        jn.setSize(jDesktopPaneBase.getWidth(), jDesktopPaneBase.getHeight());
        jDesktopPaneBase.add(jn);
        jn.setVisible(true);
    }//GEN-LAST:event_jMenuItemJugPorNacionalidadActionPerformed

    private void jMenuItemGestionPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionPersonalActionPerformed
        GestionPersonal gp = new GestionPersonal();
        gp.setSize(jDesktopPaneBase.getWidth(), jDesktopPaneBase.getHeight());
        jDesktopPaneBase.add(gp);
        gp.setVisible(true);
    }//GEN-LAST:event_jMenuItemGestionPersonalActionPerformed

    private void jMenuItemAddEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddEquipoActionPerformed
        DatosEquipo de = new DatosEquipo(this, true);
        de.setLocationRelativeTo(null);
        de.setVisible(true);
    }//GEN-LAST:event_jMenuItemAddEquipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPaneBase;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConsultas;
    private javax.swing.JMenu jMenuEntrenadores;
    private javax.swing.JMenu jMenuEquipos;
    private javax.swing.JMenuItem jMenuItemAddEquipo;
    private javax.swing.JMenuItem jMenuItemAltaEntrenador;
    private javax.swing.JMenuItem jMenuItemAltaJugador;
    private javax.swing.JMenuItem jMenuItemGestionEntrenadores;
    private javax.swing.JMenuItem jMenuItemGestionJugadores;
    private javax.swing.JMenuItem jMenuItemGestionPersonal;
    private javax.swing.JMenuItem jMenuItemJugPorNacionalidad;
    private javax.swing.JMenu jMenuJugadores;
    // End of variables declaration//GEN-END:variables
}
