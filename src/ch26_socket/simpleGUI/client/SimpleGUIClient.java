package ch26_socket.simpleGUI.client;

import java.awt.CardLayout;

import java.awt.EventQueue;

import java.io.IOException;

import java.net.Socket;
import java.util.Objects;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;
import ch26_socket.simpleGUI.client.dto.SendMessage;

import lombok.Getter;


import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

/*
 * 필요한 추가 기능
 * 1. 채팅방 나가기 (완료)
 * 2. 채팅방 목록에서 자신의 아이디 표시 (완료)
 * 3. 채팅방 안에서 채팅방 제목 표시 (완료)
 * 4. 방을 만든사람을 (방장)으로 표시
 * 5. 방장이 나가면 방 폭파 or 방장 인계
 * 6. JLable 활용하여 접속인원 더블클릭시 입력칸에 이름 들어가게 하고 귓속말 기능 활성화/ 아닐때는 전체, 보낸후 전체로 복귀
 */


@Getter
public class SimpleGUIClient extends JFrame {
	private String username;
	private Socket socket;
	
	private CardLayout mainCardLayout;
	private JPanel mainCardPanel;
	
	private JPanel chattingRoomListPanel;
	private JScrollPane roomListScrollPanel;
	private DefaultListModel<String> roomListModel;
	private JList roomList;
	
	private JPanel chattingRoomPanel;
	private JTextField messageTextField;
	private JTextArea chattingTextArea;
	
	
	private static SimpleGUIClient instance;
	private DefaultListModel<String> userListModel;
	private JList userList;			
	private JScrollPane userListScrollPane;
	private JPanel usernamePanel;
	private JTextField usernameTextField;
	private JButton exitChattingRoomButton;
	private JPanel chattingRoomTitlePanel;
	private JTextField chattingRoomTitleTextField;
	private JScrollPane chattingTextAreaScrollPanel;
	
	
	
	public static SimpleGUIClient getInstance() {
		if(instance == null) {
			instance = new SimpleGUIClient();
		}
		return instance;
	}
	
	
//	public void TitleRefresh(String username) {
//		SimpleGUIServer.roomList.forEach(titleName -> {
//			if(titleName.getOwner() == username) {
//				title = titleName.getRoomName();
//			}
//		});
//	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					SimpleGUIClient frame = SimpleGUIClient.getInstance();
					frame.setVisible(true);
					
					ClientReceiver clientReceiver = new ClientReceiver();
					clientReceiver.start();
					
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("connection", frame.username);
					ClientSender.getInstance().send(requestBodyDto);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleGUIClient() {
		
		username = JOptionPane.showInputDialog(chattingRoomPanel, "아이디를 입력하세요.");			
		
		if(Objects.isNull(username)) {
			System.exit(0);
		}
		
		if(username.isBlank()) {
			System.exit(0);
		}
		
		try {
			socket = new Socket("127.0.0.1", 8000);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		mainCardLayout = new CardLayout();
		mainCardPanel = new JPanel();
		mainCardPanel.setLayout(mainCardLayout);
		setContentPane(mainCardPanel);
		
		chattingRoomListPanel = new JPanel();
		chattingRoomListPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		chattingRoomListPanel.setLayout(null);
		mainCardPanel.add(chattingRoomListPanel, "chattingRoomListPanel");
		
		JButton createRoomButton = new JButton("방만들기");
		createRoomButton.setBounds(10, 10, 100, 30);
		createRoomButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String roomName = JOptionPane.showInputDialog(chattingRoomListPanel, "방제목을 입력하세요.");
				if(Objects.isNull(roomName)) {
					return;
				}
				if(roomName.isBlank()) {
					JOptionPane.showMessageDialog(chattingRoomListPanel, "방제목을 입력하세요.", "방만들기 실패", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				for(int i = 0; i < roomListModel.size(); i++) {
					if(roomListModel.get(i).equals(roomName)) {
						JOptionPane.showMessageDialog(chattingRoomListPanel, "이미 존재하는 방제목입니다.", "방만들기 실패", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				chattingRoomTitleTextField.setText(roomName);
				RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("createRoom", roomName);
				ClientSender.getInstance().send(requestBodyDto);
				mainCardLayout.show(mainCardPanel, "chattingRoomPanel");
								
	
				
				requestBodyDto = new RequestBodyDto<String>("join", roomName);
				ClientSender.getInstance().send(requestBodyDto);								
			}
		});
		chattingRoomListPanel.add(createRoomButton);
		
		roomListScrollPanel = new JScrollPane();
		roomListScrollPanel.setBounds(10, 50, 414, 201);
		chattingRoomListPanel.add(roomListScrollPanel);
		
		roomListModel = new DefaultListModel<String>();
		roomList = new JList(roomListModel);
		roomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					String roomName = roomListModel.get(roomList.getSelectedIndex());
					mainCardLayout.show(mainCardPanel, "chattingRoomPanel");
					chattingRoomTitleTextField.setText(roomName);
					RequestBodyDto<String>requestBodyDto = new RequestBodyDto<String>("join", roomName);
					ClientSender.getInstance().send(requestBodyDto);
				}
			}	
		});
		
		
		
		roomListScrollPanel.setViewportView(roomList);
		
		usernamePanel = new JPanel();
		usernamePanel.setBounds(319, 10, 105, 30);
		chattingRoomListPanel.add(usernamePanel);
		usernamePanel.setLayout(null);
		
		usernameTextField = new JTextField(username); 
		usernameTextField.setEditable(false);
		usernameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameTextField.setBounds(0, 0, 105, 30);
		usernamePanel.add(usernameTextField);
		usernameTextField.setColumns(10);
						
		chattingRoomPanel = new JPanel();
		chattingRoomPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		chattingRoomPanel.setLayout(null);
		mainCardPanel.add(chattingRoomPanel, "chattingRoomPanel");
		
		chattingTextAreaScrollPanel = new JScrollPane();
		chattingTextAreaScrollPanel.setBounds(12, 46, 270, 167);
		chattingRoomPanel.add(chattingTextAreaScrollPanel);
		
		chattingTextArea = new JTextArea();
		chattingTextAreaScrollPanel.setViewportView(chattingTextArea);
		
		messageTextField = new JTextField();
		messageTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					SendMessage sendMessage = SendMessage.builder()
							.fromUsername(username)
							.messageBody(messageTextField.getText())
							.build();
					
					RequestBodyDto<SendMessage> requestBodyDto = 
							new RequestBodyDto<>("sendMessage", sendMessage); 
					
					ClientSender.getInstance().send(requestBodyDto);
					messageTextField.setText("");
				}
			}
		});
		
		
		messageTextField.setBounds(12, 223, 410, 28);
		chattingRoomPanel.add(messageTextField);
		messageTextField.setColumns(10);
		
		userListScrollPane = new JScrollPane();
		userListScrollPane.setBounds(294, 46, 128, 167);
		chattingRoomPanel.add(userListScrollPane);
		
		userListModel = new DefaultListModel<>();
		userList = new JList(userListModel);		
		userListScrollPane.setViewportView(userList);

		chattingRoomTitlePanel = new JPanel();
		chattingRoomTitlePanel.setBounds(12, 10, 270, 26);
		chattingRoomPanel.add(chattingRoomTitlePanel);
		chattingRoomTitlePanel.setLayout(null);						
		
		chattingRoomTitleTextField = new JTextField(); // 타이틀 받아오기
		chattingRoomTitleTextField.setHorizontalAlignment(SwingConstants.CENTER);
		chattingRoomTitleTextField.setEditable(false);
		chattingRoomTitleTextField.setBounds(0, 0, 270, 26);
		chattingRoomTitlePanel.add(chattingRoomTitleTextField);
		chattingRoomTitleTextField.setColumns(10);
		
		exitChattingRoomButton = new JButton("나가기");
		exitChattingRoomButton.setBounds(294, 10, 128, 28);
		exitChattingRoomButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int clicked = JOptionPane.showInternalConfirmDialog(mainCardPanel, "나가시겠습니까?");				
				if(clicked == 0) {			
					String roomName = chattingRoomTitleTextField.getText();
					
					RequestBodyDto<String> requestBodyDto = 
							new RequestBodyDto<>("exit", roomName); 
					
					mainCardLayout.show(mainCardPanel, "chattingRoomListPanel");
					ClientSender.getInstance().send(requestBodyDto);
					chattingRoomTitleTextField.setText(roomName);

				}else if(clicked == 1) {
					return;
				}
			}
			
		});
		chattingRoomPanel.add(exitChattingRoomButton);
		
		


		
		
		
	}
}