package Model;

import java.util.ArrayList;
import java.util.List;

import View.TextEditorView;

import java.nio.file.*;
import java.io.*;

public class TextEditorModel {
    private List<String> lines = new ArrayList<>();
    private String filename;
    private TextEditorView view;
    private File currentFile;
    public void addLine() {
        lines.add(view.getText());
    }

    public List<String> getLines() {
        return lines;
    }
    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            lines.stream().forEach(line -> {
                try {
                    writer.write(line);
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException("Error writing to file", e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("Error opening file for writing", e);
        }
    }





    public void loadFromFile(String filename) {
        lines.clear();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            reader.lines().forEach(line -> lines.add(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openFile(String filename) {
        setCurrentFile(new File(filename));
        loadFromFile(filename);
    }
    public void setCurrentFile(File file) {
        this.currentFile = file;
    }

    public File getCurrentFile() {
        return currentFile;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    

}
