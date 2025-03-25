package edu.miu.Lab6_part2;


import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketCalcHandler extends TextWebSocketHandler {

    Calculator cal=new Calculator();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        System.out.println("got message"+ message);
        String result = cal.calc(message.getPayload());
        session.sendMessage(new TextMessage(result));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        //send message back to the client
        session.sendMessage(new TextMessage("Connected !"));

    }
}
