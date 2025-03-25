package edu.miu.Lab6_part1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

    private int id=200;
    @Autowired
    ChatRepository chatRepository;

    @GetMapping(value="/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> getAllChatHistory(){
        return chatRepository.findAll();
    }

    @Scheduled(fixedRate = 3000)
    private void saveNewChat(){
        id++;
        chatRepository.save(new Chat(id,"New Message"+id)).block();
    }


}
