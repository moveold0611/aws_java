package ch26_socket.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.BindException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApplication extends JFrame {
	private Socket socket;
	
	private JPanel mainPanel;
	private JTextField ipTextField;
	private JTextField portTextField;
	private JTextField messageTextField;
	private JButton messsageSendButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientApplication frame = new ClientApplication();
					frame.setVisible(true);					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}
	

	/**
	 * Create the frame.
	 */
	public ClientApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 531);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		
		// 채팅 내용
		JScrollPane chatTextAreaScrollPane = new JScrollPane();
		chatTextAreaScrollPane.setBounds(12, 10, 264, 399);
		mainPanel.add(chatTextAreaScrollPane);
		
		JTextArea chatTextArea = new JTextArea();
		chatTextArea.setEditable(false);
		chatTextAreaScrollPane.setViewportView(chatTextArea);
		
		// 채팅 연결
		ipTextField = new JTextField();
		ipTextField.setBounds(288, 13, 134, 21);
		mainPanel.add(ipTextField);
		ipTextField.setColumns(10);
		
		portTextField = new JTextField();
		portTextField.setBounds(288, 44, 134, 21);
		mainPanel.add(portTextField);
		portTextField.setColumns(10);
		
		// 접속 버튼
		JButton connectedButton = new JButton("접속");
		connectedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String serverIp = ipTextField.getText();
				String serverPort = portTextField.getText();
				
				if(serverIp.isBlank() || serverPort.isBlank()) {
					JOptionPane.showMessageDialog(
							mainPanel,
							"IP또는 Port번호를 입력해주세요",
							"접속오류",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					socket = new Socket(serverIp, Integer.parseInt(serverPort));
					JOptionPane.showMessageDialog(
							mainPanel,
							"서버와의 연결에 성공하였습니다.",
							"접속 완료",
							JOptionPane.PLAIN_MESSAGE);
					messageTextField.setEditable(true); // 접속 시 채팅창 활성화
					messsageSendButton.setEnabled(true);	// 접속 시 전송버튼 활성화
				} catch (NumberFormatException e1) {				
					e1.printStackTrace();
				} catch (UnknownHostException e1) {					
					e1.printStackTrace();
				} catch (IOException e1) {					
					e1.printStackTrace();
				}
				
			}
		});
		connectedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		connectedButton.setBounds(288, 75, 134, 23);
		mainPanel.add(connectedButton);
		
		// 접속자
		JScrollPane connectedUserListScrollPane = new JScrollPane();
		connectedUserListScrollPane.setBounds(288, 114, 134, 295);
		mainPanel.add(connectedUserListScrollPane);
		
		JList connectedUserList = new JList();
		connectedUserListScrollPane.setViewportView(connectedUserList);
		
		// 메세지 입력 및 전송
		messageTextField = new JTextField();
		messageTextField.addKeyListener(
		new KeyAdapter() {			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("전송");
				}
			}
		});
		
		messageTextField.setBounds(12, 419, 326, 63);
		messageTextField.setEditable(false);
		mainPanel.add(messageTextField);
		messageTextField.setColumns(10);
		
		// 전송 버튼
		messsageSendButton = new JButton("전송");
		messsageSendButton.setBounds(350, 419, 72, 63);
		messsageSendButton.setEnabled(false);
		mainPanel.add(messsageSendButton);
	}
}
