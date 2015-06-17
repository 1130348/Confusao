package csheets.ext.style.ui;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;

/**
 *
 * @author Jose
 */
@SuppressWarnings("serial")
public class ConditionalFormatAction extends FocusOwnerAction implements SelectionListener {

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * The cell being styled
	 */
	private StylableCell cell;

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
		Format format = null;
		try {
			if (cell.getValue().getType() == Value.Type.NUMERIC) {
				format = new ConditionalFormatChooser(
					(NumberFormat) cell.getFormat().clone(), cell.getValue().
					toNumber()
				).showDialog(null, "Conditional Format");
			} else if (cell.getValue().getType() == Value.Type.DATE) {
				format = new ConditionalFormatChooser(
					(DateFormat) cell.getFormat().clone(), cell.getValue().
					toDate()
				).showDialog(null, "Conditional Format");
			}
		} catch (IllegalValueTypeException e) {
		}

		if (format != null) {
			// Changes the format of each selected cell
			for (Cell[] row : focusOwner.getSelectedCells()) {
				for (Cell cell : row) {
//					if (cell.getValue() <) {
//
//					}
					StylableCell stylableCell = (StylableCell) cell.
						getExtension(
							StyleExtension.NAME);
					stylableCell.setFormat(
						stylableCell.isFormattable() ? format : null);
				}
			}

			uiController.setWorkbookModified(focusOwner.getSpreadsheet().
				getWorkbook());
			focusOwner.repaint();
		}
	}
}
