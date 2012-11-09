package ai.arpwatch;


import java.sql.SQLException;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class View extends ViewPart {
	public View() {
	}
	public static final String ID = "ai.arpwatch.view";
	private Text textFind;
	private Text textIP;
	private Text textRes;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		parent.setLayout(null);

		
		
		textFind = new Text(parent, SWT.BORDER);
		textFind.setFont(SWTResourceManager.getFont("Tahoma", 14, SWT.NORMAL));
		textFind.setBounds(33, 48, 258, 44);
		
		Button btnFind = new Button(parent, SWT.NONE);
		btnFind.setFont(SWTResourceManager.getFont("Tahoma", 14, SWT.NORMAL));
		btnFind.setBounds(321, 48, 151, 44);
		btnFind.setText("Найти");
		
		textIP = new Text(parent, SWT.BORDER);
		textIP.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		textIP.setBounds(33, 151, 159, 32);
		
		final Button btnIP = new Button(parent, SWT.NONE);
		btnIP.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		btnIP.setBounds(212, 151, 106, 32);
		btnIP.setText("> IP адрес");
		
		textRes = new Text(parent, SWT.WRAP);
		textRes.setEditable(false);
		textRes.setText("-");
		textRes.setBounds(33, 211, 529, 232);
		
		
		btnIP.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			    // connect to mysql db laninfo
			    LanInfoDB lanInfo = new LanInfoDB();
			    
			    // select IP
				String res = lanInfo.sIP(textIP.getText());
				textRes.setText(res);
			
			}
		});
	
		
		
		
	
	
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		//viewer.getControl().setFocus();
	}
}