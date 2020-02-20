import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Class to compare a text box of Strings.
 */
public abstract class SortText {
	final String sampleText = "xyz\nuvw\nabc\nefg\nefgh\nefgi";

	/**
	 * Provides the GUI and calls the necessary methods for sorting.
	 */
	public SortText() {
		JFrame f = new JFrame("Sorter");
		f.setLayout(new FlowLayout(FlowLayout.RIGHT));
		final JTextArea ta = new JTextArea(sampleText, 10,
				50);
		JScrollPane scrollPane = new JScrollPane(ta);
		scrollPane.setPreferredSize(new Dimension(300, 300));
		scrollPane.setSize(scrollPane.getPreferredSize());
		f.add(scrollPane);
		JButton b = new JButton("Sort");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] text = stringToArray(ta.getText());
				sortText(text, false);
				ta.setText(arrayToString(text));
			}
		});
		f.add(b);
		b = new JButton("Sort Reverse");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] text = stringToArray(ta.getText());
				sortText(text, true);
				ta.setText(arrayToString(text));
			}
		});
		f.add(b);
		f.pack();
		f.setVisible(true);
	}

	/**
	 * Sorts the given text array in alphabetical order, if not other specified.<br/>
	 * The given array will be modified to store the sorted text.
	 * 
	 * @param txt
	 *            text array to be sorted
	 * @param descending
	 *            if <code>false</code> sort in alphabetical ascending order,
	 *            else in descending order.
	 */
	abstract void sortText(String[] txt, boolean descending);

	/**
	 * Helper method to split a single String separated by linebreak characters
	 * "\n" to a String array.
	 * 
	 * @param str
	 *            String separated by linebreak characters "\n"
	 * @return single String array
	 */
	abstract String[] stringToArray(String str);

	/**
	 * Helper method to convert a String array to a single String separated by
	 * linebreak characters "\n".
	 * 
	 * @param array
	 *            String array
	 * @return single String separated by linebreak characters "\n"
	 */
	abstract String arrayToString(String[] array);
}
