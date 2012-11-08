package ai.arpwatch;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class View extends ViewPart {
	public View() {
	}
	public static final String ID = "ai.arpwatch.view";
	private Text text;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		parent.setLayout(null);
		
		text = new Text(parent, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Tahoma", 14, SWT.NORMAL));
		text.setBounds(33, 48, 258, 44);
		
		Button btnNewButton = new Button(parent, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Tahoma", 14, SWT.NORMAL));
		btnNewButton.setBounds(321, 48, 151, 44);
		btnNewButton.setText("Найти");

	
		
		
	
	
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		//viewer.getControl().setFocus();
	}
}