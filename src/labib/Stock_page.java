package labib;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Stock_page {
    static JPanel p6 = new JPanel();
    JButton add,edit,remove,search;
    JTable table;
    JLabel lbl1,id,name,quantity,price,searchLebel;
    JTextField textId,textName,textQuantity,textPrice,textSearch;
    Stock_page()
    {}
    public void removepan(){
        p6.setVisible(false);
    }
    Stock_page(JPanel p1) {

        p6.setBounds(325, 0, 2000, 2000);
        p6.setBackground(Color.RED);
        p6.setLayout(null);


        table = new JTable();

        Object[] columns = {"Product Id", "Product Name", "Stock Quantity","Stock"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.white);
        table.setForeground(Color.orange);
        table.setFont(new Font("", 1, 22));
        table.setRowHeight(30);


        lbl1 = new JLabel("Stock Information");
        lbl1.setBounds(450, 10, 400, 30);
        lbl1.setFont(new Font("Times New Roman", Font.BOLD + Font.PLAIN, 30));
        lbl1.setForeground(Color.orange);

        id = new JLabel("Id");
        name = new JLabel("Name");
        quantity = new JLabel("Quantity");
        price = new JLabel("Stock");
        searchLebel = new JLabel("Search Stock");

        id.setBounds(80, 500, 50, 30);
        name.setBounds(80, 540, 50, 30);
        quantity.setBounds(80, 580, 80, 30);
        price.setBounds(80, 620, 150, 30);
        searchLebel.setBounds(750, 500, 150, 30);
        id.setFont(new Font("Times New Roman", Font.BOLD, 18));
        name.setFont(new Font("Times New Roman", Font.BOLD, 18));
        quantity.setFont(new Font("Times New Roman", Font.BOLD, 18));
        price.setFont(new Font("Times New Roman", Font.BOLD, 18));
        searchLebel.setFont(new Font("Times New Roman", Font.BOLD, 18));


        id.setForeground(Color.ORANGE);
        name.setForeground(Color.ORANGE);
        quantity.setForeground(Color.ORANGE);
        price.setForeground(Color.ORANGE);
        searchLebel.setForeground(Color.ORANGE);

        textId = new JTextField();
        textName = new JTextField();
        textQuantity = new JTextField();
        textPrice = new JTextField();
        textSearch = new JTextField();

        textId.setBounds(210, 500, 400, 30);
        textName.setBounds(210, 540, 400, 30);
        textQuantity.setBounds(210, 580, 400, 30);
        textPrice.setBounds(210, 620, 400, 30);
        textSearch.setBounds(750, 550, 300, 30);

        textId.setFont(new Font("Times New Roman", Font.BOLD, 18));
        textName.setFont(new Font("Times New Roman", Font.BOLD, 18));
        textQuantity.setFont(new Font("Times New Roman", Font.BOLD, 18));
        textPrice.setFont(new Font("Times New Roman", Font.BOLD, 18));
        textSearch.setFont(new Font("Times New Roman", Font.BOLD, 18));


        add = new JButton("Add");
        add.setBounds(630, 530, 60, 30);
        edit = new JButton("Edit");
        edit.setBounds(630, 570, 60, 30);
        remove = new JButton("Remove");
        remove.setBounds(630, 610, 80, 30);
        search = new JButton("Search");
        search.setBounds(750, 600, 80, 30);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(10, 50, 1130, 400);

        p6.add(add);
        p6.add(edit);
        p6.add(remove);
        p6.add(lbl1);
        p6.add(pane);
        p6.add(id);
        p6.add(name);
        p6.add(quantity);
        p6.add(price);
        p6.add(textId);
        p6.add(textName);
        p6.add(textQuantity);
        p6.add(textPrice);
        p6.add(textSearch);
        p6.add(search);
        p6.add(searchLebel);
        p6.setVisible(true);
        p1.add(p6);


        Object[] row = new Object[4];
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();

                if (obj == add) {

                    row[0] = textId.getText();
                    row[1] = textName.getText();
                    row[2] = textQuantity.getText();
                    row[3] = textPrice.getText();

                    model.addRow(row);

                    textId.setText(null);
                    textName.setText(null);
                    textQuantity.setText(null);
                    textPrice.setText(null);
                    p6.setVisible(false);
                    p6.setVisible(true);
                }
            }
        });


        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();

                if (i >= 0) {
                    model.removeRow(i);
                } else {
                    JOptionPane.showMessageDialog(null, "Remove Error");
                }
            }
        });


        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();

                textId.setText(model.getValueAt(i, 0).toString());
                textName.setText(model.getValueAt(i, 1).toString());
                textQuantity.setText(model.getValueAt(i, 2).toString());
                textPrice.setText(model.getValueAt(i, 3).toString());

            }
        });

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();

                if (i >= 0) {
                    model.setValueAt(textId.getText(), i, 0);
                    model.setValueAt(textName.getText(), i, 1);
                    model.setValueAt(textQuantity.getText(), i, 2);
                    model.setValueAt(textPrice.getText(), i, 3);
                } else {
                    JOptionPane.showMessageDialog(null, "Edit error");
                }


            }
        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();

                if (obj == search) {
                }
            }
        });
    }
}
