/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_scheduling;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author alpha
 */
public class MatakuliahGUI extends GUI {

    private JPanel mainPanel, toolsPanel;
    private JButton btnBack;
    private JScrollPane tablePanel;

    public MatakuliahGUI() {
        super();
        initMainView();
    }

    public MatakuliahGUI(String frameTitle) {
        super(frameTitle);
        initMainView();
    }

    public MatakuliahGUI(String frameTitle, int height, int width) {
        super(frameTitle, height, width);
        initMainView();
    }

    public void showMainView() {
        mainPanel.add(toolsPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        platform.add(mainPanel);
        this.setVisible(true);
    }

    public void initMainView() {
        mainPanel = new JPanel(new BorderLayout());
        btnBack = new JButton("Kembali");
        toolsPanel = new JPanel(new GridLayout(1, 5));
        this.initButtonCRUD();
        toolsPanel.add(this.getBtnAdd());
        toolsPanel.add(this.getBtnEdit());
        toolsPanel.add(this.getBtnDelete());
        toolsPanel.add(Box.createHorizontalStrut(10));
        toolsPanel.add(btnBack);
        this.setPadding(toolsPanel, 0, 0, 5, 0);
        
        String[] column = {"#", "Kode Matakuliah", "Nama Matakuliah"};
        Object[][] row = {};
        this.setDataTable(row, column);
        tablePanel = new JScrollPane(this.getDataTable());
    }
    
    public void addListener(ActionListener listener, MouseListener mouselisten, KeyListener keylisten){
        this.getBtnAdd().addActionListener(listener);
        this.getBtnEdit().addActionListener(listener);
        this.getBtnDelete().addActionListener(listener);
        this.getDataTable().addMouseListener(mouselisten);
        this.getDataTable().addKeyListener(keylisten);
        btnBack.addActionListener(listener);
    }
}
