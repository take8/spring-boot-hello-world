package net.take8.springboothelloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("messages")
public class MessagesController {
  @Autowired
  MessageMapper messageMapper;

  @RequestMapping(method = RequestMethod.GET)
  public List<Message> getMessages() {
    return messageMapper.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public Message postMessages(@RequestBody Message message) {
    messageMapper.create(message);
    return message;
  }
}
