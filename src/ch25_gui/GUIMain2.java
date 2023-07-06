package ch25_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class GUIMain2 extends JFrame {
	private final String ADMIN_USERNAME = "admin";
	private final String ADMIN_PASSWORD = "1234";
	
	
	private JPanel mainCardPane;
	private CardLayout mainCardLayout;
	private JTextField userId;
	private JPasswordField password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain2 frame = new GUIMain2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIMain2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		// <<< mainCardPane >>> // 
//		mainCardPane.setLayout(new CardLayout(0, 0)); 
		mainCardLayout = new CardLayout(0, 0);
		mainCardPane = new JPanel();
		
		mainCardPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainCardPane.setLayout(mainCardLayout);
		
		setContentPane(mainCardPane);	
		
		// <<< subPanel1 >>> // 
		JPanel subPanel1 = new JPanel();
		mainCardPane.add(subPanel1, "subPanel1");
		subPanel1.setLayout(null);
		
		JButton subPanel2ShowBtn = new JButton("→");
		subPanel2ShowBtn.setBounds(315, 111, 97, 23);
		subPanel1.add(subPanel2ShowBtn);
		
		userId = new JTextField();
		userId.setBounds(26, 112, 116, 21);
		subPanel1.add(userId);
		userId.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(154, 112, 105, 22);
		subPanel1.add(password);
		
		subPanel2ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username1 = userId.getText();
				String password1 = password.getText();
				if(!username1.equals(ADMIN_USERNAME) || !password1.equals(ADMIN_PASSWORD)) {
					JOptionPane.showMessageDialog(mainCardPane, "사용자 정보가 일치하지 않습니다.", "로그인 오류", JOptionPane.ERROR_MESSAGE);
					System.out.println("사용자 정보가 일치하지 않습니다.");
					return;
				}
				mainCardLayout.show(mainCardPane, "subPanel2");
			}
		});
		
		// <<< subPanel2 >>> // 
		JPanel subPanel2 = new JPanel();
		mainCardPane.add(subPanel2, "subPanel2");
		subPanel2.setLayout(null);
		
		JButton subPanel1ReshowBtn = new JButton("←");
		subPanel1ReshowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel1");
			}
		});
		subPanel1ReshowBtn.setBounds(12, 102, 97, 23);
		subPanel2.add(subPanel1ReshowBtn);
		
		JButton subPanel3ShowBtn = new JButton("→");
		subPanel3ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel3");
			}
		});
		subPanel3ShowBtn.setBounds(315, 102, 97, 23);
		subPanel2.add(subPanel3ShowBtn);
		
		// <<< subPanel3 >>> //
		JPanel subPanel3 = new JPanel();
		mainCardPane.add(subPanel3, "subPanel3");
		subPanel3.setLayout(null);
		
		JButton subPanel2ReshowBtn = new JButton("New button");
		subPanel2ReshowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel2");
			}
		});
		subPanel2ReshowBtn.setBounds(12, 110, 97, 23);
		subPanel3.add(subPanel2ReshowBtn);
		
		
	}
}
