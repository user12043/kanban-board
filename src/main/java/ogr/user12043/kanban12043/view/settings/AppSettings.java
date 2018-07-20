package ogr.user12043.kanban12043.view.settings;

import ogr.user12043.kanban12043.utils.Constants;
import ogr.user12043.kanban12043.utils.Properties;
import ogr.user12043.kanban12043.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by user12043 on 14.07.2018 - 17:06
 * Part of project: kanban12043
 */
public class AppSettings extends javax.swing.JPanel {

    private static final Logger LOGGER = LogManager.getLogger(AppSettings.class);
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_apply;
    private javax.swing.JComboBox<String> jComboBox_language;
    private javax.swing.JComboBox<String> jComboBox_theme;
    private javax.swing.JLabel jLabel_fontSize;
    private javax.swing.JLabel jLabel_language;
    private javax.swing.JLabel jLabel_theme;
    private javax.swing.JSpinner jSpinner_fontSize;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form AppSettings
     */
    public AppSettings() {
        initComponents();
        setName(Utils.getTag("options"));
        for (int i = 0; i < Constants.languages.length; i++) {
            if (Properties.lang.equals(Constants.languages[i])) {
                jComboBox_language.setSelectedIndex(i);
            }
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

        jLabel_theme = new javax.swing.JLabel();
        jComboBox_theme = Utils.getComboBox();
        jButton_apply = new javax.swing.JButton();
        jLabel_language = new javax.swing.JLabel();
        jComboBox_language = Utils.getComboBox();
        jLabel_fontSize = new javax.swing.JLabel();
        jSpinner_fontSize = Utils.getSpinner(8, 25);

        jLabel_theme.setText(Utils.getTag("settings.theme") + "\t:");

        jComboBox_theme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nimbus", "Metal", "Darcula", "Seaglass", "WebLaF"}));
        jComboBox_theme.setSelectedIndex(Properties.theme);

        jButton_apply.setText(Utils.getTag("options.saveChanges"));
        jButton_apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_applyActionPerformed(evt);
            }
        });

        jLabel_language.setText(Utils.getTag("settings.language") + "\t:");

        jComboBox_language.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"English (US)", "Türkçe"}));

        jLabel_fontSize.setText(Utils.getTag("settings.fontSize") + "\t: ");

        jSpinner_fontSize.setValue(Properties.fontSize);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton_apply)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel_theme)
                                                        .addComponent(jLabel_language)
                                                        .addComponent(jLabel_fontSize))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox_language, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jComboBox_theme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jSpinner_fontSize))
                                                .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_theme)
                                        .addComponent(jComboBox_theme, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_language)
                                        .addComponent(jComboBox_language, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_fontSize)
                                        .addComponent(jSpinner_fontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(jButton_apply)
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_applyActionPerformed
        // Set theme
        final int themeIndex = jComboBox_theme.getSelectedIndex();
        Properties.updateProperty(Constants.args_themeArgumentName, themeIndex);
        Properties.theme = themeIndex;

        // Set language
        final int languageIndex = jComboBox_language.getSelectedIndex();
        Properties.updateProperty(Constants.args_languageArgumentName, Constants.languages[languageIndex]);
        Properties.lang = Constants.languages[languageIndex];

        // Set font size
        final int fontSize = (int) jSpinner_fontSize.getValue();
        Properties.updateProperty(Constants.args_fontSizeArgumentName, fontSize);
        Properties.fontSize = fontSize;

        Utils.infoDialog(this, Utils.getTag("messages.info.settingsSave"));
    }//GEN-LAST:event_jButton_applyActionPerformed
}
