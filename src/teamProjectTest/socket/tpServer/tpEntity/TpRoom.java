package teamProjectTest.socket.tpServer.tpEntity;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import teamProjectTest.socket.tpServer.TpConnectedSocket;

@Builder
@Data
public class TpRoom {
	private String roomName;
	private String owner;
	private List<TpConnectedSocket> userList;
}
