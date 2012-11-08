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
	private Text text_1;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		parent.setLayout(null);
		
		JdbcLan db = new JdbcLan();

		text = new Text(parent, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Tahoma", 14, SWT.NORMAL));
		text.setBounds(33, 48, 258, 44);
		
		Button btnNewButton = new Button(parent, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Tahoma", 14, SWT.NORMAL));
		btnNewButton.setBounds(321, 48, 151, 44);
		btnNewButton.setText("Найти");
		
		text_1 = new Text(parent, SWT.BORDER);
		text_1.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		text_1.setBounds(33, 151, 159, 32);
		
		Button btnNewButton_1 = new Button(parent, SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		btnNewButton_1.setBounds(212, 151, 106, 32);
		btnNewButton_1.setText("> IP адрес");

	
		
		
		
	
	
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		//viewer.getControl().setFocus();
	}
}