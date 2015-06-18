/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.style.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jose
 */
public class ConditionalFormatChooser extends JPanel {

	/**
	 * The maximum number of items to keep in the history list.
	 */
	private static final int HISTORY_SIZE = 50;

	/**
	 * The color for error message.
	 */
	private static final Color ERROR_COLOR = Color.RED;

	/**
	 * The format to configure by this <code>FormatChooser</code>.
	 */
	private Format format;

	/**
	 * A sample value for the "preview" text.
	 */
	private Object value;

	/**
	 * The panel in which to edit the pattern
	 */
//	private final JComboBox choices = new JComboBox();
	private final JComboBox choicesCondition = new JComboBox();
	private final JTextField textCondition = new JTextField("Value to compare", 10);

	/**
	 * The preview label with the <code>value</code> formated using
	 * <code>format</code>
	 */
	private final JLabel previewLabel = new JLabel();

	public String[] getConditionalChosser() {
		String[] operator = new String[]{">", "<", "="};
		return operator;
	}

	/**
	 * Creates a pattern chooser for the given number format.
	 *
	 * @param format the format to configure
	 * @param value the value to format
	 */
	public ConditionalFormatChooser(NumberFormat format, Number value) {
		this(getPatterns(format));

		// Initializes format
		this.value = value;
		this.format = format;
	}

	/**
	 * Creates a pattern chooser for the given format.
	 *
	 * @param patterns the patterns to choose from
	 */
	private ConditionalFormatChooser(String[] patterns) {

		choicesCondition.
			setModel(new DefaultComboBoxModel(getConditionalChosser()));
		choicesCondition.setEditable(true);

		// Creates Condition container
		JPanel conditionPanel = new JPanel();
		conditionPanel.add(choicesCondition);
		conditionPanel.add(textCondition);
		textCondition.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				textCondition.setText("");
			}

			public void focusLost(FocusEvent e) {
				// nothing
			}
		});
		conditionPanel.setBorder(BorderFactory.createTitledBorder("Condition"));

		// Configures preview label
		previewLabel.setHorizontalAlignment(JLabel.CENTER);
		previewLabel.setPreferredSize(new Dimension(70, 50));
		previewLabel.setBorder(
			BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Preview"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)
			));

		setLayout(new BorderLayout(5, 5));
		add(conditionPanel, BorderLayout.NORTH);
		add(previewLabel, BorderLayout.SOUTH);
	}

	/**
	 * Returns a set of patterns for formatting in the given locale,
	 *
	 * @param format for which to get a set of default patterns.
	 * @return the patterns that were found
	 */
	private static synchronized String[] getPatterns(Format format) {
		Locale locale = Locale.getDefault();
		if (format instanceof NumberFormat) {
			return getNumberPatterns(locale);
		} else if (format instanceof DateFormat) {
			return getDatePatterns(locale);
		} else {
			return null;
		}
	}

	/**
	 * Returns a set of patterns for formatting numbers in the given locale.
	 *
	 * @param locale the locale for which to fetch patterns
	 * @return the patterns that were found
	 */
	private static String[] getNumberPatterns(Locale locale) {
		// Collects formats
		NumberFormat[] formats = new NumberFormat[]{
			NumberFormat.getInstance(locale),
			NumberFormat.getNumberInstance(locale),
			NumberFormat.getPercentInstance(locale),
			NumberFormat.getCurrencyInstance(locale)};

		// Collects patterns
		Set<String> patterns = new LinkedHashSet<String>();
		for (int i = 0; i < formats.length; i++) {
			if (formats[i] instanceof DecimalFormat) {
				int digits = -1;
				if (i == 1) {
					digits = 4;
				} else if (i == 2) {
					digits = 2;
				}
				DecimalFormat decimal = (DecimalFormat) formats[i];
				patterns.add(decimal.toLocalizedPattern());
				for (int decimals = 0; decimals <= digits; decimals++) {
					decimal.setMinimumFractionDigits(decimals);
					decimal.setMaximumFractionDigits(decimals);
					patterns.add(decimal.toLocalizedPattern());
				}
			}
		}
		return patterns.toArray(new String[patterns.size()]);
	}

	/**
	 * Returns a set of patterns for formatting dates in the given locale.
	 *
	 * @param locale the locale for which to fetch patterns
	 * @return the patterns that were found
	 */
	private static String[] getDatePatterns(Locale locale) {
		// Collects formats
		Set<DateFormat> formats = new LinkedHashSet<DateFormat>();
		int[] codes = {DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG,
			DateFormat.FULL};
		for (int code : codes) {
			formats.add(DateFormat.getDateInstance(code, locale));
			formats.add(DateFormat.getTimeInstance(code, locale));
			for (int timeCode : codes) {
				formats.add(DateFormat.
					getDateTimeInstance(code, timeCode, locale));
			}
		}

		// Collects patterns
		SortedSet<String> patterns = new TreeSet<String>();
		for (DateFormat format : formats) {
			if (format instanceof SimpleDateFormat) {
				patterns.add(((SimpleDateFormat) format).toLocalizedPattern());
			}
		}
		return patterns.toArray(new String[patterns.size()]);
	}

	/**
	 * Returns the current format.
	 *
	 * @return the current format.
	 */
	public Format getFormat() {
		return format;
	}

	public int getCondition() {
		return Integer.parseInt(textCondition.getText());
	}

	/**
	 * Update the preview text according the current format pattern.
	 */
	private void update() {
//		choices.setSelectedItem(getPattern());
		try {
			previewLabel.setText(value != null ? format.format(value) : null);
			previewLabel.setForeground(getForeground());
		} catch (IllegalArgumentException exception) {
			previewLabel.setText(exception.getLocalizedMessage());
			previewLabel.setForeground(ERROR_COLOR);
		}
	}

	/**
	 * Shows a dialog box requesting input from the user.
	 *
	 * @param owner the parent component for the dialog box
	 * @param title the dialog box title
	 * @return the selected format or, if the user did not press OK, null
	 */
	public ConditionalFormatChooser showDialog(Component owner,
											   String title) {

		int returnValue = JOptionPane.showConfirmDialog(
			owner,
			this,
			title,
			JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.PLAIN_MESSAGE,
			(Icon) null);
		if (returnValue == JOptionPane.OK_OPTION) {
		}
		return this;
	}

	public String getTextFieldText() {
		return textCondition.getText();
	}

	public String getChoiseText() {
		return choicesCondition.getSelectedItem().toString();
	}
}
