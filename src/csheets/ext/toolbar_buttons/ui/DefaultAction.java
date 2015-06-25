package csheets.ext.toolbar_buttons.ui;

import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.style.StylableCell;
import csheets.ext.toolbar_buttons.ButtonsExtension;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;

/**
 * Add a new action button operation. And that action is choosen by the user.
 *
 * @author Cristina Lopes
 */
@SuppressWarnings("serial")
public class DefaultAction extends ButtonsAction {

	/**
	 * The name of the button
	 */
	private String name;

	/**
	 * The name of the icon of the button
	 */
	private String icon;

	/**
	 * The code of the macro to run when select the button
	 */
	private String macro;

	/**
	 * Creates a new button action.
	 *
	 * @param uiController the user interface controller
	 */
	public DefaultAction(UIController uiController, String name, String icon,
						 String macro) {
		super(uiController);
		this.name = name;
		this.icon = icon;
		putValue(SMALL_ICON, new ImageIcon(ButtonsExtension.class.
				 getResource("res/img/" + icon + ".gif")));
		this.macro = macro;
	}

	/**
	 * Returns the name of the button
	 *
	 * @return
	 */
	@Override
	protected String getName() {
		return name;
	}

	/**
	 * Defines the mnecomic
	 */
	@Override
	protected void defineProperties() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_A);
	}

	/**
	 * The action that is applie to the button when it is selected
	 *
	 * @param event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			uiController.getActiveCell().setContent("=" + macro);
		} catch (FormulaCompilationException ex) {
			Logger.getLogger(DefaultAction.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Change the content of macros
	 *
	 * @param macros
	 */
	public void setMacros(String macros) {
		this.macro = macros;
	}

	@Override
	protected void applyStyle(StylableCell cell) {

	}
}
