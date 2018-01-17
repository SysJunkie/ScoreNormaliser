
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


/**
 * Class representing first screen of Team Details
 * 
 * @author Team 26
 *
 */
public class TeamDetailsUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
		
	//GUI elements variable declaration
    private JButton enter;
    private JComboBox<Integer> membersNum;
    private JComboBox<String> memberScoresExist;
    private JLabel membersNumLabel;
    private JPanel panel;
    private JLabel prevEval;

        /**
	     * Default constructor
	     */
	    public TeamDetailsUI() {
	    	super("Team Details");
	        initComponents();
	    }
	    
	    /**
	     * Initializes all components of the first screen
	     */
	    private void initComponents() {

	        panel = new JPanel();
	        membersNumLabel = new JLabel();
	        enter = new JButton();
	        prevEval = new JLabel();
	        membersNum = new JComboBox<>();
	        memberScoresExist = new JComboBox<>();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        membersNumLabel.setText("Number of Team Members:");
	        membersNumLabel.setFont(new Font(membersNumLabel.getFont().getName(), Font.PLAIN, 16));
	        membersNumLabel.setHorizontalTextPosition(SwingConstants.RIGHT);

	        enter.setText("Enter");
	        enter.addActionListener(this);


	        prevEval.setText("Were scores entered previously?");
	        prevEval.setFont(new Font(prevEval.getFont().getName(), Font.PLAIN, 16));
	        
	        membersNum.setModel(new DefaultComboBoxModel<>(new Integer[] { 2, 3, 4, 5, 6, 7 }));

	        memberScoresExist.setModel(new DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

	        GroupLayout jPanel1Layout = new GroupLayout(panel);
	        panel.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(40, 40, 40)
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
	                    .addComponent(enter)
	                    .addComponent(membersNumLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(prevEval, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addGap(44, 44, 44)
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addComponent(membersNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(memberScoresExist, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(90, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(54, 54, 54)
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                            .addComponent(membersNumLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
	                            .addComponent(membersNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(29, 29, 29)
	                        .addComponent(memberScoresExist, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                    .addComponent(prevEval, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
	                .addComponent(enter)
	                .addGap(54, 54, 54))
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        
	        this.setResizable(false);
	        pack();
	        this.setLocationRelativeTo(null);
	    }

	    /**
	     * On button click, initializes the second screen
	     * 
	     * @param e event when some action is performed
	     * 
	     */
	    @Override
		public void actionPerformed(ActionEvent e) {
			int teamMemberCount = (int)membersNum.getSelectedItem();
	        boolean scoreSubmitted = memberScoresExist.getSelectedItem() == "Yes";
	        this.setVisible(false);
	        final PeerEvaluationUI frameTwo = new PeerEvaluationUI(teamMemberCount, scoreSubmitted);
	        frameTwo.setVisible(true);
		}
	    
	    /**
	     * Main method to initializes first screen
	     * 
	     * @param args	command line arguments
	     */
	    public static void main(String args[]) {
	        try {
	            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(TeamDetailsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(TeamDetailsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(TeamDetailsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(TeamDetailsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new TeamDetailsUI().setVisible(true);
	            }
	        });
	    }
	}