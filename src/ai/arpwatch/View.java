package ai.arpwatch;



import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class View extends ViewPart {
	public View() {
	}
	public static final String ID = "ai.arpwatch.view";
	private Text textIP;
	private Text textRes;
	private Text textMAC;
	private Button btnMac;
	private Text textDesc;
	private Button btnDesc;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		parent.setLayout(null);
		
		textIP = new Text(parent, SWT.BORDER);
		textIP.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		textIP.setBounds(33, 33, 159, 32);
		
		final Button btnIP = new Button(parent, SWT.NONE);
		btnIP.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		btnIP.setBounds(212, 33, 106, 32);
		btnIP.setText("> IP адрес");
		
		textMAC = new Text(parent, SWT.BORDER);
		textMAC.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		textMAC.setBounds(33, 86, 159, 32);
		
		btnMac = new Button(parent, SWT.NONE);
		btnMac.setText("> MAC адрес");
		btnMac.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		btnMac.setBounds(212, 86, 122, 32);
		
		textDesc = new Text(parent, SWT.BORDER);
		textDesc.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		textDesc.setBounds(33, 141, 159, 32);
		
		btnDesc = new Button(parent, SWT.NONE);
		btnDesc.setText("> Розетка, описание");
		btnDesc.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		btnDesc.setBounds(212, 141, 179, 32);
		
		textRes = new Text(parent, SWT.WRAP | SWT.V_SCROLL);
		textRes.setEditable(false);
		textRes.setText("-");
		textRes.setBounds(33, 204, 529, 239);
		
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
	
		textIP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {  
				    // connect to mysql db laninfo
				    LanInfoDB lanInfo = new LanInfoDB();
				    // select IP
					String res = lanInfo.sIP(textIP.getText());
					textRes.setText(res);
                }  
			}
		});

		btnMac.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			    // connect to mysql db laninfo
			    LanInfoDB lanInfo = new LanInfoDB();
			    
			    // select MAC
				String res = lanInfo.sMAC(textMAC.getText());
				textRes.setText(res);

			}
		});

		textMAC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {  
				    // connect to mysql db laninfo
				    LanInfoDB lanInfo = new LanInfoDB();
				    // select IP
					String res = lanInfo.sMAC(textMAC.getText());
					textRes.setText(res);
                }  
			}
		});

		btnDesc.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			    // connect to mysql db laninfo
			    LanInfoDB lanInfo = new LanInfoDB();
			    // select MAC
				String res = lanInfo.sDesc(textDesc.getText());
				textRes.setText(res);
			}
		});

		textDesc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {  
				    // connect to mysql db laninfo
				    LanInfoDB lanInfo = new LanInfoDB();
				    // select IP
					String res = lanInfo.sDesc(textDesc.getText());
					textRes.setText(res);
                }  
			}
		});

	
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		//viewer.getControl().setFocus();
		textIP.setFocus();
	}
}