
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * Normalization result screen
 * 
 * @author Team 26
 *
 */
public class ResultUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel headerLabel;
	private JPanel panel;
	private JTable table;

	/**
	 * Class constructor which initializes Result screen UI components based on
	 * list of team members
	 * 
	 * @param members
	 *            - List of team members
	 */
	public ResultUI(ArrayList<User> members) {
		super("Normalized Scores");
		initComponents();

		String[] columnNames = { "Name", "Normalized Score" };
		table = new JTable();
		DefaultTableModel dtm = new DefaultTableModel(columnNames, 0) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		table.setModel(dtm);

		TableColumn nameColumn = table.getColumnModel().getColumn(0);
		nameColumn.setPreferredWidth(150);
		TableColumn normalisedColumn = table.getColumnModel().getColumn(1);
		normalisedColumn.setPreferredWidth(200);

		// add rows dynamically into the table
		dtm.addRow(new Object[] { "Name", "Normalized Score" });
		for (User user : members) {
			dtm.addRow(new Object[] { user.getName(), user.getNormalisedScore() });
		}

		panel.add(table);
	}

	/**
	 * Initializes components of the Result screen which do not need input from
	 * previous screen
	 */
	public void initComponents() {
		headerLabel = new JLabel();
		panel = new JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(400, 240));
		getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

		headerLabel.setText("Normalized Scores for the Team");
		headerLabel.setFont(new Font(headerLabel.getFont().getFontName(), Font.BOLD, 16));
		headerLabel.setAlignmentY(TOP_ALIGNMENT);

		panel.add(headerLabel);
		getContentPane().add(panel);

		this.setResizable(false);
		pack();
		this.setLocationRelativeTo(null);
	}
}
