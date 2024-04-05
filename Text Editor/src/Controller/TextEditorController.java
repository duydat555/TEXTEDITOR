package Controller;

import Model.TextEditorModel;
import View.TextEditorView;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TextEditorController {
    private TextEditorModel model;
    private TextEditorView view;
    private File file;
    public TextEditorController(TextEditorModel model, TextEditorView view) {
        this.model = model;
        this.view = view;
    }

    public void initController() {
    	view.addOpenMenuItemListener(e -> openFile());
        view.addSaveMenuItemListener(e -> saveText());
        view.addLoadMenuItemListener(e -> loadText());
    }
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            model.openFile(selectedFile.getAbsolutePath());
            StringBuilder sb = new StringBuilder();
            for (String line : model.getLines()) {
                sb.append(line).append("\n");
            }
            view.setText(sb.toString());
        }
    }
    private void saveText() {
        JFileChooser fileChooser = new JFileChooser();
        model.setLines(Arrays.asList(view.getText().split("\\n")));
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            model.saveToFile(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }
    private void loadText() {
        if (model.getCurrentFile() != null) {
            model.setLines(Arrays.asList(view.getText().split("\\n")));
            model.saveToFile(model.getCurrentFile().getAbsolutePath());
            model.loadFromFile(model.getCurrentFile().getAbsolutePath());
            StringBuilder sb = new StringBuilder();
            for (String line : model.getLines()) {
                sb.append(line).append("\n");
            }
            view.setText(sb.toString());
           
        }
    }


}
