package com.example.message.service;

import com.example.message.model.Message;
import com.example.message.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public List<Message> getMessages() {
        return repository.getAllMessages();
    }

    public Message findMessageById(int id, String caps) {
        Message message = repository.findMessageById(id);
        if (message == null) {
            return null;
        }
        if (caps != null && caps.equals("yes")) {
            return new Message(message.getId(), message.getContent().toUpperCase());
        }
        return message;
    }
}
