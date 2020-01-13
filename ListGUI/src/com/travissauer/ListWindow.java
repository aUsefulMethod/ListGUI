package com.travissauer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListWindow extends JFrame {

    private JPanel namePanel;
    private JPanel selectedNamePanel;
    private JPanel buttonPanel;
    private JList nameList;
    private JList selectedNameList;
    private JTextField selectedName;
    private JLabel label;

    private String[] names = { "Nuula", "Brock", "Gary", "Triv-Trav", "Chance", "Bobcat", "Towelie", "Butters", "Cartman", "Kyle", "Eric", "Shandeece"};

    public ListWindow(){

        setTitle("List Demonstration");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        buildButtonPanel();
        buildSelectedNamesPanel();
        buildNamePanel();

        nameList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        nameList.setVisibleRowCount(6);

        JScrollPane scrollPane = new JScrollPane(nameList);

        JPanel panel = new JPanel();
        panel.add(scrollPane);

        add(namePanel, BorderLayout.CENTER);
        add(selectedNamePanel, BorderLayout.SOUTH);
        add(panel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.EAST);

        pack();
        setVisible(true);

    }

    private void buildNamePanel(){

        namePanel = new JPanel();

        nameList = new JList(names);

        nameList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        nameList.addListSelectionListener(new ListListener());

        namePanel.add(nameList);

    }

    private void buildSelectedNamesPanel(){

        selectedNamePanel = new JPanel();

        label = new JLabel("You selected: ");

        selectedName = new JTextField(10);

        selectedName.setEditable(false);

        selectedNamePanel.add(label);
        selectedNamePanel.add(selectedName);

        selectedNameList = new JList();

        selectedNameList.setVisibleRowCount(6);

        JScrollPane scrollPane2 = new JScrollPane(selectedName);

        selectedNamePanel.add(scrollPane2);

    }

    private void buildButtonPanel(){

        buttonPanel = new JPanel();

        JButton button = new JButton("Get Selections");

        button.addActionListener(new ButtonListener());

        buttonPanel.add(button);

    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {


        Object[] selections = nameList.getSelectedValues();

        selectedNameList.setListData(selections);
    }

    }

    private class ListListener implements ListSelectionListener{

        public void valueChanged(ListSelectionEvent e){

            String selection = (String) nameList.getSelectedValue();

            selectedName.setText(selection);

            JOptionPane.showMessageDialog(null,selection + " is a towel.");

        }

    }

    public static void main(String[] args) {

        new ListWindow();

    }

}
