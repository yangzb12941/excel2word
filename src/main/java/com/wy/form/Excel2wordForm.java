/*
 * Created by JFormDesigner on Fri Aug 05 14:45:41 CST 2022
 */

package com.wy.form;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

import com.wy.wordWriter.ExcelToWord;
import lombok.Data;
import net.miginfocom.swing.*;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Brainrain
 */
@Data
public class Excel2wordForm {
    public Excel2wordForm() {
        initComponents();
    }

    //打开文件选择框
    private void selectFile(ActionEvent e) {
        if(e.getSource() == fileButton){
            //设置文件选择器只能选择0（文件），1（文件夹）
            //文件选择器
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            //打开文件浏览器，点击取消则返回1
            int status = chooser.showOpenDialog(null);
            if(status == 1){
                return;
            }else{
                //读取选择器选择到的文件
                File file = chooser.getSelectedFile();
                //获取文件绝对路径并写入到文本框内
                textField.setText(file.getAbsolutePath());
            }
        }
    }

    //开始处理
    private void ok(ActionEvent e) {
        if(e.getSource() == okButton){
            String fieldText = textField.getText();
            if(StringUtils.isNotEmpty(fieldText)){
                ExcelToWord instance = ExcelToWord.getInstance();
                instance.excelToWord(fieldText);
                JOptionPane.showMessageDialog(null, "目录:"+System.getProperty("user.dir"),"标题【创建成功】",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    //关闭窗体
    private void cancel(ActionEvent e) {
        if(e.getSource() == cancelButton){
            excel2wordForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            System.exit(0);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        excel2wordForm = new JFrame();
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        fileLable = new JLabel();
        textField = new JTextField();
        fileButton = new JButton();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== excel2wordForm ========
        {
            excel2wordForm.setTitle("excel2word");
            Container excel2wordFormContentPane = excel2wordForm.getContentPane();
            excel2wordFormContentPane.setLayout(new BorderLayout());

            //======== dialogPane ========
            {
                dialogPane.setLayout(new BorderLayout());

                //======== contentPanel ========
                {
                    contentPanel.setLayout(new MigLayout(
                        "insets dialog,hidemode 3",
                        // columns
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]",
                        // rows
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

                    //---- fileLable ----
                    fileLable.setText("\u8bf7\u9009\u62e9\u6587\u4ef6\u5939:");
                    contentPanel.add(fileLable, "cell 1 1");
                    contentPanel.add(textField, "cell 2 1 10 1");

                    //---- fileButton ----
                    fileButton.setText("\u6587\u4ef6\u5939");
                    fileButton.addActionListener(e -> selectFile(e));
                    contentPanel.add(fileButton, "cell 12 1");
                }
                dialogPane.add(contentPanel, BorderLayout.NORTH);

                //======== buttonBar ========
                {
                    buttonBar.setLayout(new MigLayout(
                        "insets dialog,alignx right",
                        // columns
                        "[button,fill]" +
                        "[button,fill]",
                        // rows
                        null));

                    //---- okButton ----
                    okButton.setText("OK");
                    okButton.addActionListener(e -> ok(e));
                    buttonBar.add(okButton, "cell 0 0");

                    //---- cancelButton ----
                    cancelButton.setText("Cancel");
                    cancelButton.addActionListener(e -> cancel(e));
                    buttonBar.add(cancelButton, "cell 1 0");
                }
                dialogPane.add(buttonBar, BorderLayout.SOUTH);
            }
            excel2wordFormContentPane.add(dialogPane, BorderLayout.CENTER);
            excel2wordForm.pack();
            excel2wordForm.setLocationRelativeTo(excel2wordForm.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame excel2wordForm;
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel fileLable;
    private JTextField textField;
    private JButton fileButton;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
