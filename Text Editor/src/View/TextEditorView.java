package View;

import Model.TextEditorModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class TextEditorView {
    private TextEditorModel model;
    private JFrame frame;
    private JTextArea textArea;
    private JMenuItem saveMenuItem , loadMenuItem , openMenuItem;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JPanel contentPane;
    public TextEditorView(TextEditorModel model) {
        this.model = model;
        frame = new JFrame();
        
      //  setBounds(100, 100, 960, 574);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//setContentPane(contentPane);
		//contentPane.setLayout(null);
      //  contentPane.add(textArea);
        textArea = new JTextArea(20, 40);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        
         menuBar = new JMenuBar();
         fileMenu = new JMenu("File");
         openMenuItem = new JMenuItem("Open");
         saveMenuItem = new JMenuItem("Save");
         loadMenuItem = new JMenuItem("Load");
        
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }
    public void addSaveMenuItemListener(ActionListener listener) {
        saveMenuItem.addActionListener(listener);
    }

    public void addLoadMenuItemListener(ActionListener listener) {
        loadMenuItem.addActionListener(listener);
    }
    public void addOpenMenuItemListener(ActionListener listener) {
    	openMenuItem.addActionListener(listener);
    }
}
