package teamProjectTest.socket.tpClient;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lombok.Getter;
import teamProjectTest.socket.tpClient.dto.RequestBodyDto;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

@Getter
public class TpClient extends JFrame {
	private Socket socket;
	private String username;
	
	//List
	private DefaultListModel<String> roomListModel;
	private DefaultListModel<String> userListModel;

	// Frame
	private CardLayout mainCardLayout;
	private JPanel mainCardPanel;
	private JTextField sendMessageTextField;
	private JTextField chattingRoomTitleTextField;
	private JTextField toSendTextField;
	private JPanel toSendPanel;
	private JPanel chattingRoomTitlePanel;
	private JButton exitRoomButton;
	private JList chattingRoomList;
	private JTextArea messageTextArea;
	private JScrollPane messageScrollPane;
	private JTextArea chattingRoomUsernameList;
	private JScrollPane chattingRoomUsernameScrollPane;
	private JScrollPane chattingRoomListScrollPane;
	private JTextArea clientUsername;
	private JButton createChattingRoomButton;
	private JPanel chattingRoomListPanel;
	private JPanel chattingRoomPanel;
	
	
	
	private static TpClient instance;	
	public static TpClient getInstance() {
		if(instance == null) {
			instance = new TpClient();
		}
		return instance;
	}
	

	
	/**
	 * Launch the application.
	 */
	
	

	
	public static void main(String[] args) {
		System.out.println("Debug text : 클라이언트 실행");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TpClient frame = TpClient.getInstance();
					frame.setVisible(true);

					TpClientReceiver clientReceiver = new TpClientReceiver();
					System.out.println("Debug text : 클라이언트 리시버 실행 시도");
					clientReceiver.start();
					
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("connection", frame.username);
					System.out.println("Debug text : 클라이언트 센더 실행 시도");
					TpClientSender.getInstance().send(requestBodyDto);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TpClient() {
		
		username = JOptionPane.showInputDialog(chattingRoomPanel, "아이디를 입력하세요");
		
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
		mainCardPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainCardPanel.setLayout(mainCardLayout);
		setContentPane(mainCardPanel);
		
		mainCardPanel.setLayout(new CardLayout(0, 0));
		
		chattingRoomListPanel = new JPanel();
		mainCardPanel.add(chattingRoomListPanel, "chattingRoomListPanel");
		chattingRoomListPanel.setLayout(null);
		
		createChattingRoomButton = new JButton("방만들기");
		createChattingRoomButton.setBounds(12, 10, 97, 29);
		createChattingRoomButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Debug ext : 방 생성 시도");
				String roomName = JOptionPane.showInputDialog(chattingRoomListPanel, "방 제목을 입력하세요.");
				
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
				
				RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("createRoom", roomName);
				TpClientSender.getInstance().send(requestBodyDto);
				mainCardLayout.show(mainCardPanel, "chattingRoomPanel");
				requestBodyDto = new RequestBodyDto<String>("join", roomName);
				TpClientSender.getInstance().send(requestBodyDto);
			}
		
		});
		
		
		chattingRoomListPanel.add(createChattingRoomButton);
		
		roomListModel = new DefaultListModel<String>();
		
		
		
		clientUsername = new JTextArea(); //(username)
		clientUsername.setEditable(false);		
		clientUsername.setBounds(319, 12, 93, 29);
		chattingRoomListPanel.add(clientUsername);
		
		chattingRoomListScrollPane = new JScrollPane();
		chattingRoomListScrollPane.setBounds(12, 49, 400, 192);
		chattingRoomListPanel.add(chattingRoomListScrollPane);
		
		chattingRoomList = new JList(roomListModel);
		chattingRoomListScrollPane.setViewportView(chattingRoomList);
		chattingRoomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					String roomName = roomListModel.get(chattingRoomList.getSelectedIndex());
					mainCardLayout.show(mainCardPanel, "chattingRoomPanel");
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("join", roomName);
					TpClientSender.getInstance().send(requestBodyDto);
				}
			}
		});
		
		
		chattingRoomPanel = new JPanel();
		mainCardPanel.add(chattingRoomPanel, "chattingRoomPanel");
		chattingRoomPanel.setLayout(null);
		
		sendMessageTextField = new JTextField();
		sendMessageTextField.setBounds(81, 212, 331, 29);
		chattingRoomPanel.add(sendMessageTextField);
		sendMessageTextField.setColumns(10);
		
		chattingRoomUsernameScrollPane = new JScrollPane();
		chattingRoomUsernameScrollPane.setBounds(321, 44, 91, 158);
		chattingRoomPanel.add(chattingRoomUsernameScrollPane);
		
		chattingRoomUsernameList = new JTextArea();
		chattingRoomUsernameList.setEditable(false);
		chattingRoomUsernameScrollPane.setViewportView(chattingRoomUsernameList);
		
		messageScrollPane = new JScrollPane();
		messageScrollPane.setBounds(12, 44, 297, 158);
		chattingRoomPanel.add(messageScrollPane);
		
		messageTextArea = new JTextArea();
		messageTextArea.setEditable(false);
		messageScrollPane.setViewportView(messageTextArea);
		
		exitRoomButton = new JButton("나가기");
		exitRoomButton.setBounds(321, 10, 91, 24);
		chattingRoomPanel.add(exitRoomButton);
		
		chattingRoomTitlePanel = new JPanel();
		chattingRoomTitlePanel.setBounds(76, 10, 171, 29);
		chattingRoomPanel.add(chattingRoomTitlePanel);
		chattingRoomTitlePanel.setLayout(null);
		
		chattingRoomTitleTextField = new JTextField();
		chattingRoomTitleTextField.setEditable(false);
		chattingRoomTitleTextField.setHorizontalAlignment(SwingConstants.CENTER);
		chattingRoomTitleTextField.setBounds(0, 0, 171, 29);
		chattingRoomTitlePanel.add(chattingRoomTitleTextField);
		chattingRoomTitleTextField.setColumns(10);
		
		toSendPanel = new JPanel();
		toSendPanel.setBounds(12, 212, 60, 29);
		chattingRoomPanel.add(toSendPanel);
		toSendPanel.setLayout(null);
		
		toSendTextField = new JTextField();
		toSendTextField.setEditable(false);
		toSendTextField.setHorizontalAlignment(SwingConstants.CENTER);
		toSendTextField.setBounds(0, 0, 60, 29);
		toSendPanel.add(toSendTextField);
		toSendTextField.setColumns(10);
	}
}
