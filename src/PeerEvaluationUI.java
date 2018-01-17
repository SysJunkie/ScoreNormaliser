
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.management.InvalidAttributeValueException;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * Class for Peer and Self-Evaluation screen 
 * It initializes methods for the GUI elements creation and 
 * a listener which transits to the Normalized Result screen.
 * 
 * @author Team 26
 *
 */
public class PeerEvaluationUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private static final String[] teamMemberNames = { "Alan Turing", "Donald Knuth", "Edsger Dijkstra",
			"Dennis Ritchie", "Ada Lovelace", "Claude Shannon", "John von Neumann" };
	private static final String[] columnNames = { "Name", "Professionalism", "Meeting Participation",
			"Work Evaluation" };

	// GUI elements variable declaration
	private JComboBox[][] scoreList;
	private boolean scoreSubmitted;
	private int teamMemberCount;
	private JLabel headerLabel;
	private JButton submitButton;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JSeparator jSeparator1;
	private JTable table;

	/**
	 * Constructor to initialize table in Peer and Self Evaluation screen
	 * based on count of team members and if scores were already entered
	 * 
	 * @param teamMemberCount
	 *            - count of team members
	 * @param isScoreSubmitted
	 *            - specifies if the score for team members was already entered
	 */
	public PeerEvaluationUI(int teamMemberCount, boolean isScoreSubmitted) {

		super("Peer and Self-Evaluation");
		
		this.scoreSubmitted = isScoreSubmitted;
		this.teamMemberCount = teamMemberCount;
		
		initComponents();

		Integer[] scores = { 0, 1, 2, 3, 4, 5 };
		scoreList = new JComboBox[teamMemberCount][3];
		for (int i = 0; i < teamMemberCount; i++) {
			for (int j = 0; j < 3; j++) {
				scoreList[i][j] = new JComboBox<Integer>(scores);
			}
		}

		table = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {

			@Override
			public boolean isCellEditable(int row, int column) {
				if (row == 0 || column == 0) {
					return false;
				} else {
					return true;
				}

			}
		};

		table.setModel(tableModel);
		TableColumn nameColumn = table.getColumnModel().getColumn(0);
		nameColumn.setPreferredWidth(150);
		TableColumn professionalismColumn = table.getColumnModel().getColumn(1);
		professionalismColumn.setPreferredWidth(150);
		TableColumn meetingParticipationColumn = table.getColumnModel().getColumn(2);
		meetingParticipationColumn.setPreferredWidth(150);
		TableColumn workEvaluationColumn = table.getColumnModel().getColumn(3);
		workEvaluationColumn.setPreferredWidth(150);

		// add column headers
		tableModel.addRow(new Object[] { "Name", "Professionalism", "Meeting Participation", "Work Evaluation" });
		
		// add rows dynamically into the table
		for (int count = 1; count < teamMemberCount + 1; count++) {
			if (isScoreSubmitted) {
				tableModel.addRow(new Object[] { teamMemberNames[count - 1], 
												ThreadLocalRandom.current().nextInt(0, 6),
												ThreadLocalRandom.current().nextInt(0, 6), 
												ThreadLocalRandom.current().nextInt(0, 6) 	});
			} else {
				tableModel.addRow(new Object[] { teamMemberNames[count - 1], 0, 0, 0 });
			}
			
			professionalismColumn.setCellEditor(new DefaultCellEditor(scoreList[count - 1][0]));
			meetingParticipationColumn.setCellEditor(new DefaultCellEditor(scoreList[count - 1][1]));
			workEvaluationColumn.setCellEditor(new DefaultCellEditor(scoreList[count - 1][2]));
		}
		
		table.setMinimumSize(new Dimension(600, 600));

		jPanel1.add(table);

	}

	/**
	 * Initializes components on Peer and Self evaluation screen
	 * which are not dependent on previous screen
	 */
	private void initComponents() {

		jSeparator1 = new JSeparator();
		jPanel2 = new JPanel();
		headerLabel = new JLabel();
		jPanel1 = new JPanel();
		jPanel3 = new JPanel();
		submitButton = new JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(700, 400));
		getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

		getContentPane().add(jSeparator1);

		jPanel2.setMaximumSize(new java.awt.Dimension(400, 400));
		jPanel2.setMinimumSize(new java.awt.Dimension(400, 400));

		if(scoreSubmitted) {
			headerLabel.setText("Please update Peer and Self-Evaluation Scores");
		} else {
			headerLabel.setText("Please enter Peer and Self-Evaluation Scores");
		}
		
		headerLabel.setFont(new Font(headerLabel.getFont().getName(), Font.BOLD, 16));
		jPanel2.add(headerLabel);

		getContentPane().add(jPanel2);
		getContentPane().add(jPanel1);

		submitButton.setText("Submit");
		submitButton.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
		submitButton.addActionListener(this);
		jPanel3.add(submitButton);

		getContentPane().add(jPanel3);

		pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Listener for Submit button click.
	 * It sends score to normalize and loads the normalization result screen
	 * If there is error in entering score, it displays the error message
	 * 
	 * @param e Event thrown on submitButton Click
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		try {
			ArrayList<User> members = new ArrayList<>();
			for (int i = 0; i < scoreList.length; i++) {
				User user = new User(
								  table.getModel().getValueAt(i + 1, 0).toString(),
						(Integer) table.getModel().getValueAt(i + 1, 1), 
						(Integer) table.getModel().getValueAt(i + 1, 2),
						(Integer) table.getModel().getValueAt(1 + i, 3));
				members.add(user);
			}
			ArrayList<User> normalisedMembers = Normalization.normalizeScore(members);
			this.setVisible(false);
			final ResultUI frameThree = new ResultUI(normalisedMembers);
			frameThree.setVisible(true);
		} catch (InvalidAttributeValueException e) {
			JOptionPane.showMessageDialog(null, "All scores cannot be 0.","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
