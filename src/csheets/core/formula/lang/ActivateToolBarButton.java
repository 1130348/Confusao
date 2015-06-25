package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;

/**
 * Creates a new Function ACTIVATE_BUTTON that can active the button that is
 * passed by parameters
 *
 * @author Cristina
 */
public class ActivateToolBarButton implements Function {

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
//		for (Component l1 : l) {
//			if (l1.getClass() == JToggleButton.class) {
//				if (l1.getName().equals(button)) {
//					l1.setEnabled(false);
//					return new Value(true);
//				}
//			}
//		}
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

}
