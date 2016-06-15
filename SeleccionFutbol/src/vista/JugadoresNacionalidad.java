/*
 * Consulta de jugadores por nacionalidad
 */
package vista;

import java.util.ArrayList;
import modelo.Jugador;
import modelo.ListaJugadores;

import org.jdesktop.observablecollections.ObservableCollections;
import static seleccionfutbol.SeleccionFutbol.todosJugadores;
import utilidades.DatosComunes;

/**
 *
 * @author mfontana
 */
public class JugadoresNacionalidad extends javax.swing.JInternalFrame {
    private ArrayList<String> paises;
    private ListaJugadores jugadores;
    
    public ArrayList<String> getPaises() {
        return paises;
    }

    public void setPaises(ArrayList<String> paises) {
        this.paises = paises;
    }
    
    public ListaJugadores getJugadores() {
        return jugadores;
    }

    public void setJugadores(ListaJugadores jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Creates new form JugadoresNacionalidad
     */
    public JugadoresNacionalidad() {
        paises = DatosComunes.obtenerPaises();
        // Lista de jugadores para el resultado de la consulta bindeada con la tabla
        // inicialmente una lista vacia
        jugadores = new ListaJugadores();
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jComboBoxNacionalidad = new javax.swing.JComboBox<String>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableJugadores = new javax.swing.JTable();

        setClosable(true);
        setTitle("Listado de Jugadores (Nacionalidad)");

        jComboBoxNacionalidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${paises}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jComboBoxNacionalidad);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBoxNacionalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxNacionalidadItemStateChanged(evt);
            }
        });

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${jugadores.lista}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTableJugadores);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${posicion}"));
        columnBinding.setColumnName("Posición");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nacimiento}"));
        columnBinding.setColumnName("Fecha nacimiento");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${diestro}"));
        columnBinding.setColumnName("Diestro");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTableJugadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxNacionalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxNacionalidadItemStateChanged
        if (jComboBoxNacionalidad.getSelectedIndex() > 0) {
            // Cuando seleccionan un pais
            String pais = (String) jComboBoxNacionalidad.getSelectedItem();
            // Hacemos la consulta en una lista auxiliar
            ListaJugadores aux = todosJugadores.jugadoresPorNacionalidad(pais);
            // Volcamos el resultado de la consulta en nuestra lista bindeada
            // con el metodo setLista, que es el que "avisa" a la vista
            // para que se refresque
            jugadores.setLista(aux.getLista());
        } else {
            // Si no hay elemento seleccionado o seleccionan "Escoge un pais"
            // Vaciamos la lista (hacemos un set de una lista vacia)
            jugadores.setLista(ObservableCollections.observableList(new ArrayList<Jugador>()));
        }
    }//GEN-LAST:event_jComboBoxNacionalidadItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxNacionalidad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableJugadores;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}