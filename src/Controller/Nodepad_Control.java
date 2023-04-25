package Controller;

import View.Nodepad_View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class Nodepad_Control implements ActionListener {
    private Nodepad_View nodepadView;

    public Nodepad_Control(Nodepad_View nodepadView){
        this.nodepadView = nodepadView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String sourceButton = e.getActionCommand();
        JFileChooser jFileChooser = new JFileChooser();
        switch (sourceButton){
            case "Open":
                int rtValue = jFileChooser.showDialog(this.nodepadView, "Choose File");
                switch (rtValue) {
                    case JFileChooser.APPROVE_OPTION:
                        File file = jFileChooser.getSelectedFile();
                        if(file.getName().endsWith(".txt")){
                            try {
                                this.nodepadView.display.setText(file.getName() + ": " + file.getAbsolutePath());
                                List<String> allString = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
                                String result = "";
                                for(String s : allString){
                                    result += s + "\n";
                                }
                                String newString = result.substring(0, result.length() - 1);
                                this.nodepadView.input.setText(newString);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(this.nodepadView, "File khong hop le!", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                }
                break;
            case "Save":
                if(this.nodepadView.display.getText().length() > 0){
                    String path = this.nodepadView.display.getText();
                    int index = path.indexOf(" ", 0);
                    String path1 = path.substring(index + 1);
                    try {
                        PrintWriter pw = new PrintWriter(path1, "UTF-8");
                        pw.print(this.nodepadView.input.getText());
                        pw.flush();
                        pw.close();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (UnsupportedEncodingException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    int savevalue = jFileChooser.showSaveDialog(this.nodepadView);
                    switch (savevalue){
                        case JFileChooser.APPROVE_OPTION:
                            File file = jFileChooser.getSelectedFile();
                            try {
                                PrintWriter pw = new PrintWriter(file.getAbsolutePath(), "UTF-8");
                                pw.print(this.nodepadView.input.getText());
                                pw.flush();
                                pw.close();
                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            } catch (UnsupportedEncodingException ex) {
                                throw new RuntimeException(ex);
                            }
                    }
                }
        }
    }
}
