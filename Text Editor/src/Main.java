import javax.swing.UIManager;

import Controller.TextEditorController;
import Model.TextEditorModel;
import View.TextEditorView;

public class Main {
    public static void main(String[] args) {
    	try {
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        TextEditorModel model = new TextEditorModel();
        TextEditorView view = new TextEditorView(model);
        TextEditorController controller = new TextEditorController(model, view);
        controller.initController();
    }
    	catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    }
}
