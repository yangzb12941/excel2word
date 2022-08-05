package com.wy.excel2word;

import com.wy.form.Excel2wordForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class Excel2wordApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Excel2wordForm excel2wordForm = new Excel2wordForm();
                excel2wordForm.getExcel2wordForm().setVisible(Boolean.TRUE);
            }
        });
        SpringApplication.run(Excel2wordApplication.class, args);
    }
}
