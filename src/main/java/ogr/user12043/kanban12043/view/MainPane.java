package ogr.user12043.kanban12043.view;

import ogr.user12043.kanban12043.dao.KanbanColumnDao;
import ogr.user12043.kanban12043.dao.TaskViewDao;
import ogr.user12043.kanban12043.model.*;
import ogr.user12043.kanban12043.utils.Constants;
import ogr.user12043.kanban12043.utils.Utils;
import ogr.user12043.kanban12043.view.settings.SettingsDialog;
import org.springframework.data.domain.Sort;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by user12043 on 05.07.2018 - 10:27
 * Part of project: kanban12043
 */
public class MainPane extends javax.swing.JFrame {
    List<JButton> viewButtons = new ArrayList<>();
    List<TaskView> taskViews;
    private int activeViewIndex = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_addTask;
    private javax.swing.JButton jButton_settings;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JPanel jPanel_mainContentPanel;
    private javax.swing.JPanel jPanel_toolbar;
    private javax.swing.JPanel jPanel_viewButtonsPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form MainPane
     */
    public MainPane() {
        initComponents();
        setSize(800, 600);
        setTitle(Utils.getTag("title"));
        initializeBoard();
        pack();
    }

    private GridBagConstraints getConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        return c;
    }

    public void addContent(Component component) {
        jPanel_mainContentPanel.add(component, getConstraints());
        revalidate();
    }

    private void addViewButton(TaskView taskView) {
        JButton button = Utils.getColorableButton();
        button.setText(taskView.getName());
        button.setForeground(taskView.getForegroundColor());
        button.setBackground(taskView.getBackgroundColor());
        jPanel_viewButtonsPanel.add(button, getConstraints());
        viewButtons.add(button);
        int index = viewButtons.size() - 1;
        button.addActionListener(e -> setActiveView(index, false));
        revalidate();
    }

    private void setActiveView(int activeViewIndex, boolean first) {
        if (!first) {
            // deactivate current
            Font oldActiveFont = viewButtons.get(this.activeViewIndex).getFont();
            viewButtons.get(this.activeViewIndex).setFont(new Font(oldActiveFont.getName(), oldActiveFont.getStyle(), oldActiveFont.getSize() - 4));
        }
        // Activate new
        this.activeViewIndex = activeViewIndex;
        Font activeFont = viewButtons.get(activeViewIndex).getFont();
        viewButtons.get(activeViewIndex).setFont(new Font(activeFont.getName(), Font.BOLD, activeFont.getSize() + 4));

        // Clear current content
        jPanel_mainContentPanel.removeAll();

        // Do filtering according to task views
        for (TaskView taskView : taskViews) {
            for (KanbanColumn kanbanColumn : taskView.getKanbanColumns()) {
                final List<Task> tasks = kanbanColumn.getTasks();
                final List<Tag> tags = taskView.getTags();
                final List<Topic> topics = taskView.getTopics();
                for (ListIterator<Task> iterator = tasks.listIterator(); iterator.hasNext(); ) {
                    Task task = iterator.next();
                    boolean remove = false;

                    // Filter tags
                    for (Tag tag : task.getTags()) {
                        if (tags.indexOf(tag) == -1) {
                            remove = true;
                        }
                    }

                    // Filter topics
                    if (topics.indexOf(task.getTopic()) == -1) {
                        remove = true;
                    }

                    if (remove) {
                        iterator.remove();
                    }
                }

                KanbanContainer container = new KanbanContainer(kanbanColumn.getName());
                for (Task task : tasks) {
                    container.addKanban(new Kanban(task));
                }
                addContent(container);
            }
        }
    }

    public void initializeBoard() {
        // Clear content
        jPanel_viewButtonsPanel.removeAll();
        jPanel_mainContentPanel.removeAll();
        viewButtons.clear();
        final TaskViewDao taskViewDao = Constants.context.getBean("taskViewDao", TaskViewDao.class);
        final KanbanColumnDao kanbanColumnDao = Constants.context.getBean("kanbanColumnDao", KanbanColumnDao.class);
        List<TaskView> taskViews = taskViewDao.findAll(new Sort(Sort.Direction.ASC, "ordinal", "id"));
        List<KanbanColumn> kanbanColumns;
        if (taskViews.isEmpty()) {
            kanbanColumns = kanbanColumnDao.findAll(new Sort(Sort.Direction.ASC, "ordinal", "id"));
            for (KanbanColumn kanbanColumn : kanbanColumns) {
                KanbanContainer container = new KanbanContainer(kanbanColumn.getName());
                final List<Task> tasks = kanbanColumn.getTasks();
                for (Task task : tasks) {
                    Kanban kanban = new Kanban(task);
                    container.addKanban(kanban);
                }
                addContent(container);
            }
        } else {
            this.taskViews = taskViews;
            for (TaskView taskView : taskViews) {
                addViewButton(taskView);
            }
            setActiveView(activeViewIndex, true);
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

        jLabel_title = new javax.swing.JLabel();
        jPanel_mainContentPanel = new javax.swing.JPanel();
        jPanel_toolbar = new javax.swing.JPanel();
        jButton_settings = new javax.swing.JButton();
        jButton_addTask = new javax.swing.JButton();
        jPanel_viewButtonsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(500, 300));

        jLabel_title.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        jLabel_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_title.setText(Utils.getTag("title"));

        jPanel_mainContentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel_mainContentPanel.setLayout(new java.awt.GridBagLayout());

        jPanel_toolbar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton_settings.setText(Utils.getTag("toolbar.settings"));
        jButton_settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_settingsActionPerformed(evt);
            }
        });

        jButton_addTask.setText(Utils.getTag("options.add"));
        jButton_addTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addTaskActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_toolbarLayout = new javax.swing.GroupLayout(jPanel_toolbar);
        jPanel_toolbar.setLayout(jPanel_toolbarLayout);
        jPanel_toolbarLayout.setHorizontalGroup(
                jPanel_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_toolbarLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_addTask)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_settings)
                                .addContainerGap())
        );
        jPanel_toolbarLayout.setVerticalGroup(
                jPanel_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_toolbarLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_settings)
                                        .addComponent(jButton_addTask))
                                .addContainerGap())
        );

        jPanel_viewButtonsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel_viewButtonsPanel.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel_toolbar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel_title)
                                                .addGap(0, 107, Short.MAX_VALUE))
                                        .addComponent(jPanel_mainContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel_viewButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel_title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel_toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel_viewButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel_mainContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_settingsActionPerformed
        SettingsDialog settingsDialog = new SettingsDialog(this, true);
        settingsDialog.setVisible(true);
        initializeBoard();
    }//GEN-LAST:event_jButton_settingsActionPerformed

    private void jButton_addTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addTaskActionPerformed
        KanbanColumnDao kanbanColumnDao = Constants.context.getBean("kanbanColumnDao", KanbanColumnDao.class);
        final long quantity = kanbanColumnDao.count();
        if (quantity < 1) {
            Utils.errorDialog(this, Utils.getTag("messages.error.noColumn"));
            return;
        }
        final TaskDialog taskDialog = new TaskDialog(this, true);
        taskDialog.setTitle(Utils.getTag("options.add"));
        taskDialog.setVisible(true);
        initializeBoard();
    }//GEN-LAST:event_jButton_addTaskActionPerformed
}
