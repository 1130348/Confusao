package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.ext.toolbar_buttons.ui.ButtonsToolBar;
import csheets.ext.toolbar_buttons.ui.ButtonsUIExtension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.awt.Component;
import javax.swing.JToggleButton;

/**
 * Creates a new Function ACTIVATE_BUTTON that can active the button that is
 * passed by parameters
 *
 * @author Cristina
 */
public class ActivateToolBarButton implements Function {

	/**
	 * The UIController to get acess to the components
	 */
	private UIController uictrl;

	/**
	 * The function's parameters
	 */
	public static final FunctionParameter[] parameters = new FunctionParameter[]{
		new FunctionParameter(Value.Type.NUMERIC, "buttonNumber", false,
							  "Activate the Button")
	};

	/**
	 * Constructor without parameters
	 */
	public ActivateToolBarButton() {
	}

	/**
	 * Returns the identifier
	 *
	 * @return string
	 */
	@Override
	public String getIdentifier() {

		return "ACTIVATE_BUTTON";
	}

	/**
	 * Applys the action of the function (in this case it should active or
	 * deactivate a button of the toolbar)
	 *
	 * @param args
	 * @return
	 * @throws IllegalValueTypeException
	 */
	@Override
	public Value applyTo(Expression[] args) throws IllegalValueTypeException {
		String button = args[0].evaluate().toString();
		UIExtension[] uie = uictrl.getExtensions();
		ButtonsToolBar b = null;
		for (UIExtension uie1 : uie) {
			if (uie1.getExtension().getName().equals("Buttons")) {
				b = ((ButtonsUIExtension) uie1).getActualToolBar();
				Component[] c = b.getComponents();
				for (Component c1 : c) {
					if (c1.getClass() == JToggleButton.class) {
						if (c1.getName().equals(button)) {
							c1.setEnabled(true);
							return new Value(true);
						}
					}

				}

			}
		}
		return new Value(false);
	}

	/**
	 * Returns the parameters of the function
	 *
	 * @return
	 */
	@Override
	public FunctionParameter[] getParameters() {
		return parameters;
	}

	@Override
	public boolean isVarArg() {
		return false;
	}

	@Override
	public void setUIController(UIController ui) {
		this.uictrl = ui;
	}

}
