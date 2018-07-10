/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ogr.user12043.kanban12043.view;

import java.awt.*;
import ogr.user12043.kanban12043.utils.Constants;

/**
 * Created by user12043 on 05.07.2018 - 14:11
 * Part of project: kanban12043
 */
public class KanbanContainer extends javax.swing.JPanel {

    private int last = 0;
    private boolean addVertical = false;

    /**
     * Creates new form KanbanContainer
     */
    public KanbanContainer() {
        initComponents();
        removeAll();
    }

    public KanbanContainer(String name) {
        setName(name);  
        initComponents();
        removeAll();
    }

    public Component addKanban(Component comp) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = last;
        c.gridx = 0;
        last++;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.insets = new Insets(0, 3, 10, 3);
//        c.weighty = 1;
        jPanel_content.add(comp, c);
        return comp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_name = new javax.swing.JLabel();
        jPanel_content = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(0, 0));

        jLabel_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_name.setText(getName());
        jLabel_name.setToolTipText("");

        jPanel_content.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addComponent(jPanel_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_content, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_name;
    private javax.swing.JPanel jPanel_content;
    // End of variables declaration//GEN-END:variables
}
