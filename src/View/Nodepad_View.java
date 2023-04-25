package View;

import Controller.Nodepad_Control;
import Model.Nodepad_Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Nodepad_View extends JFrame {
    public JButton save, open;
    public JLabel display;
    public JTextArea input;
    private Nodepad_Model nodepadModel;

    public Nodepad_View(){
        this.nodepadModel  = new Nodepad_Model();
        this.Layout();
    }

    public void Layout(){
        // size, tieu de va vi tri xuat hien cua so
        this.setSize(700,500);
        this.setTitle("Nodepad Mini");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        ActionListener ac = new Nodepad_Control(this);

        // Layout chuong trinh
        display = new JLabel();
        save = new JButton("Save");
        save.addActionListener(ac);
        open = new JButton("Open");
        open.addActionListener(ac);
        input = new JTextArea();
        input.setFont(new Font("Arial", Font.BOLD, 20));
        JPanel buttonSO = new JPanel();
        buttonSO.setLayout(new GridLayout(1,3));
        buttonSO.add(display);
        buttonSO.add(save);
        buttonSO.add(open);

        this.add(input, BorderLayout.CENTER);
        this.add(buttonSO, BorderLayout.SOUTH);


        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
}
