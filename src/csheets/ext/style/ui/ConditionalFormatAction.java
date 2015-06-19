package csheets.ext.style.ui;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
@SuppressWarnings("serial")
public class ConditionalFormatAction extends FocusOwnerAction implements SelectionListener {

	static String[] teste = new String[3];
	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * The cell being styled
	 */
	private StylableCell cell;
	private JComponent sideBar;

	/**
	 * Creates a new format action.
	 *
	 * @param uiController the user interface controller
	 */
	public ConditionalFormatAction(UIController uiController) {
		this.uiController = uiController;
		uiController.addSelectionListener(this);
	}

	protected String getName() {
		return "Conditional Formatting";
	}

	protected void defineProperties() {
//		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
//		putValue(SMALL_ICON, new ImageIcon(StyleExtension.class.
//				 getResource("res/img/format.gif")));
	}

	/**
	 * Updates the state of the action when a new cell is selected.
	 *
	 * @param event the selection event that was fired
	 */
	public void selectionChanged(SelectionEvent event) {
		Cell c = event.getCell();
		cell = c == null ? null : (StylableCell) c.
			getExtension(StyleExtension.NAME);
		setEnabled(c == null ? false : cell.isFormattable());
	}

	/**
	 * Lets the user select a format from a chooser. Then applies the format to
	 * the selected cells in the focus owner table.
	 *
	 * @param event the event that was fired
	 */
	public void actionPerformed(ActionEvent event) {
		if (focusOwner == null) {
			return;
		}

		// Lets user select a format
		ConditionalFormatChooser conditionalFormat = null;

		Color color1 = JColorChooser.showDialog(
			null,
			"Choose Background Color for true",
			((StylableCell) focusOwner.getSelectedCell().
			getExtension(StyleExtension.NAME)).getBackgroundColor());

		Color color2 = JColorChooser.showDialog(
			null,
			"Choose Background Color for false",
			((StylableCell) focusOwner.getSelectedCell().
			getExtension(StyleExtension.NAME)).getBackgroundColor());
		try {
			conditionalFormat = new ConditionalFormatChooser(
				(NumberFormat) cell.getFormat().clone(), cell.getValue().
				toNumber()
			).showDialog(null, "Choose Conditional Format");

		} catch (IllegalValueTypeException e) {
		}

		Cell cell = focusOwner.getSelectedCell();
		StylableCell stylableCell = (StylableCell) cell.
			getExtension(
				StyleExtension.NAME);
		try {
			if (conditionalFormat.getChoiseText().equals("<")) {
				if (cell.getValue().toDouble() < Double.
					parseDouble(conditionalFormat.getTextFieldText())) {
					stylableCell.setBackgroundColor(color1);
					teste[0] = cell.getAddress().toString();
					teste[1] = conditionalFormat.getChoiseText() + conditionalFormat.
						getTextFieldText();
					teste[2] = color1.toString();
				} else {
					stylableCell.setBackgroundColor(color2);
				}
			}

			if (conditionalFormat.getChoiseText().equals(">")) {
				if (cell.getValue().toDouble() > Double.
					parseDouble(conditionalFormat.getTextFieldText())) {
					stylableCell.setBackgroundColor(color1);
				} else {
					stylableCell.setBackgroundColor(color2);
				}
			}

			if (conditionalFormat.getChoiseText().equals("=")) {
				if (cell.getValue().toDouble() == Double.
					parseDouble(conditionalFormat.getTextFieldText())) {
					stylableCell.setBackgroundColor(color1);
				} else {
					stylableCell.setBackgroundColor(color2);
				}
			}
		} catch (Exception ex) {
//			Logger.getLogger(ConditionalFormatAction.class.getName()).
//				log(Level.SEVERE, null, ex);
			JOptionPane.
				showMessageDialog(null, "Must imput a number to compare");
		}

		uiController.setWorkbookModified(focusOwner.getSpreadsheet().
			getWorkbook());
		focusOwner.repaint();
	}

	public static String[] valores() {
		return teste;
	}
}
