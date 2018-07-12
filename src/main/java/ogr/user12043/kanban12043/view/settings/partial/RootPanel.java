package ogr.user12043.kanban12043.view.settings.partial;

import ogr.user12043.kanban12043.utils.Utils;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

/**
 * Created by user12043 on 11.07.2018 - 17:11
 * Part of project: kanban12043
 */
public class RootPanel extends javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_add;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_edit;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable_list;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form KanbanColum
     */
    public RootPanel() {
        initComponents();
    }

    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) jTable_list.getModel();
    }

    public void setTableModel(DefaultTableModel model) {
        jTable_list.setModel(model);
    }

    public void addAddListener(ActionListener listener) {
        jButton_add.addActionListener(listener);
    }

    public void addEditListener(ActionListener listener) {
        jButton_edit.addActionListener(listener);
    }

    public void addDeleteListener(ActionListener listener) {
        jButton_delete.addActionListener(listener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jTable_list = new javax.swing.JTable();
        jButton_add = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jButton_edit = new javax.swing.JButton();

        jTable_list.setEnabled(false);
        jTable_list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane.setViewportView(jTable_list);

        jButton_add.setText(Utils.getTag("options.add"));

        jButton_delete.setText(Utils.getTag("options.delete"));

        jButton_edit.setText(Utils.getTag("options.edit"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton_add)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton_delete)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton_edit)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_add)
                                        .addComponent(jButton_delete)
                                        .addComponent(jButton_edit))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_add.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents
}
