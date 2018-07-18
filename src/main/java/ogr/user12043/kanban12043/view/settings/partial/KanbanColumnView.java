package ogr.user12043.kanban12043.view.settings.partial;

import ogr.user12043.kanban12043.dao.DaoUtil;
import ogr.user12043.kanban12043.dao.KanbanColumnDao;
import ogr.user12043.kanban12043.model.KanbanColumn;
import ogr.user12043.kanban12043.utils.Constants;
import ogr.user12043.kanban12043.utils.Utils;

/**
 * Created by user12043 on 12.07.2018 - 17:59
 * Part of project: kanban12043
 */
public class KanbanColumnView extends javax.swing.JDialog {
    private KanbanColumn kanbanColumn;
    private int currentOrdinal;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JButton jButton_save;
    private javax.swing.JLabel jLabel_limit;
    private javax.swing.JLabel jLabel_name;
    private javax.swing.JSpinner jSpinner_limit;
    private javax.swing.JTextField jTextField_name;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form KanbanColumnView
     */
    public KanbanColumnView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setKanbanColum(KanbanColumn kanbanColumn) {
        this.kanbanColumn = kanbanColumn;
        jTextField_name.setText(kanbanColumn.getName());
        jSpinner_limit.setValue(kanbanColumn.getColumnLimit());
        jTextField_name.selectAll();
    }

    public void setOrdinal(int ordinal) {
        this.currentOrdinal = ordinal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_save = new javax.swing.JButton();
        jButton_cancel = new javax.swing.JButton();
        jTextField_name = new javax.swing.JTextField();
        jLabel_name = new javax.swing.JLabel();
        jLabel_limit = new javax.swing.JLabel();
        jSpinner_limit = Utils.getSpinner(0, -1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setResizable(false);

        jButton_save.setText(Utils.getTag("options.save"));
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jButton_cancel.setText(Utils.getTag("options.cancel"));
        jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelActionPerformed(evt);
            }
        });

        jLabel_name.setText(Utils.getTag("entity.common.name") + "\t: ");

        jLabel_limit.setText(Utils.getTag("entity.kanbanColumn.columnLimit") + "\t: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton_save)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton_cancel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel_limit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField_name, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addComponent(jSpinner_limit, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_limit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSpinner_limit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_save)
                                        .addComponent(jButton_cancel))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_jButton_cancelActionPerformed

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        final KanbanColumnDao dao = DaoUtil.getKanbanColumnDao();
        if (kanbanColumn == null) {
            kanbanColumn = new KanbanColumn();
        }
        String name = jTextField_name.getText();
        kanbanColumn.setName((name.isEmpty()) ? Constants.defaultName : name);
        kanbanColumn.setColumnLimit((Integer) jSpinner_limit.getValue());
        kanbanColumn.setOrdinal(currentOrdinal);

        dao.save(kanbanColumn);
        dispose();
    }//GEN-LAST:event_jButton_saveActionPerformed
}
