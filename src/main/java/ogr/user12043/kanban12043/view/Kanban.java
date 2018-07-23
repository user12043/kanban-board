package ogr.user12043.kanban12043.view;

import ogr.user12043.kanban12043.Main;
import ogr.user12043.kanban12043.dao.DaoUtil;
import ogr.user12043.kanban12043.dao.KanbanColumnDao;
import ogr.user12043.kanban12043.model.KanbanColumn;
import ogr.user12043.kanban12043.model.Tag;
import ogr.user12043.kanban12043.model.Task;
import ogr.user12043.kanban12043.utils.Constants;
import ogr.user12043.kanban12043.utils.Utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user12043 on 05.07.2018 - 16:47
 * Part of project: kanban12043
 */
public class Kanban extends javax.swing.JPanel {
    private Task task;
    private KanbanColumnDao kanbanColumnDao = DaoUtil.getKanbanColumnDao();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_bottomInfo;
    private javax.swing.JMenuItem jMenuItem_delete;
    private javax.swing.JMenuItem jMenuItem_edit;
    private javax.swing.JPanel jPanel_tags;
    private javax.swing.JPopupMenu jPopupMenu_kanban;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JTextArea jTextArea_content;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form Task
     */
    public Kanban() {
        initComponents();
    }

    public Kanban(Task task) {
        this.task = task;
        initComponents();
        setFields();
    }

    /**
     * Set kanban components' content from data
     */
    private void setFields() {
        jTextArea_content.setText(task.getContent());
        int counter = 0;
        for (Tag tag : task.getTags()) {
            JPanel panel = new JPanel();
            panel.setBackground(tag.getColor());
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = counter;
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.fill = GridBagConstraints.BOTH;
            jPanel_tags.add(panel, c);
            counter++;
        }
        jLabel_bottomInfo.setText(Constants.priorities[task.getPriority()] + " | " + ((task.getTopic() != null) ? (task.getTopic().getName() + " | ") : "") + task.getCreatedDate().toLocalDate());

        if (task.getTopic() != null) {
            setForeground(task.getTopic().getForegroundColor());
            setBackground(task.getTopic().getBackgroundColor());
            jTextArea_content.setForeground(task.getTopic().getForegroundColor());
            jTextArea_content.setBackground(task.getTopic().getBackgroundColor());
            jLabel_bottomInfo.setForeground(task.getTopic().getForegroundColor());
            jLabel_bottomInfo.setBackground(task.getTopic().getBackgroundColor());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu_kanban = new javax.swing.JPopupMenu();
        jMenuItem_edit = new javax.swing.JMenuItem();
        jMenuItem_delete = new javax.swing.JMenuItem();
        jSeparator = new javax.swing.JSeparator();
        jPanel_tags = new javax.swing.JPanel();
        jLabel_bottomInfo = new javax.swing.JLabel();
        jTextArea_content = new javax.swing.JTextArea();

        jPopupMenu_kanban.setLabel(Utils.getTag("options"));

        jMenuItem_edit.setText(Utils.getTag("options.edit"));
        jMenuItem_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_editActionPerformed(evt);
            }
        });
        jPopupMenu_kanban.add(jMenuItem_edit);

        jMenuItem_delete.setText(Utils.getTag("options.delete"));
        jMenuItem_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_deleteActionPerformed(evt);
            }
        });
        jPopupMenu_kanban.add(jMenuItem_delete);

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setComponentPopupMenu(jPopupMenu_kanban);

        jPanel_tags.setLayout(new java.awt.GridBagLayout());

        jLabel_bottomInfo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel_bottomInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_bottomInfo.setText("initial");

        jTextArea_content.setEditable(false);
        jTextArea_content.setColumns(20);
        jTextArea_content.setLineWrap(true);
        jTextArea_content.setRows(5);
        jTextArea_content.setText("initial");
        jTextArea_content.setWrapStyleWord(true);
        jTextArea_content.setBorder(null);
        jTextArea_content.setInheritsPopupMenu(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel_tags, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel_bottomInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextArea_content, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextArea_content, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_bottomInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addComponent(jPanel_tags, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_deleteActionPerformed
        if (task != null) {
            /*
             * Since the OneToMany association between KanbanColumn and Task is bidirectional, deleting directly the task will not do the job.
             * Nothing happening on:
             * taskDao.delete(task)
             * So deleting operation must be done on parent of the association (KanbanColumn)
             */
            KanbanColumn kanbanColumn = task.getKanbanColumn();
            kanbanColumn.getTasks().remove(task); // Now task is not have any column.
            /*
             * The
             * orphanRemoval = true
             * property in @OneToMany is true. So the task will be deleted on kanbanColumn save
             */
            kanbanColumnDao.save(kanbanColumn);
            Main.mainPane.initializeBoard(false);
        }
    }//GEN-LAST:event_jMenuItem_deleteActionPerformed

    private void jMenuItem_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_editActionPerformed
        if (task != null) {
            TaskDialog taskDialog = new TaskDialog(Main.mainPane, true);
            taskDialog.setTask(task);
            taskDialog.setTitle(Utils.getTag("options.edit"));
            taskDialog.setVisible(true);
            Main.mainPane.initializeBoard(false);
        }
    }//GEN-LAST:event_jMenuItem_editActionPerformed
}
