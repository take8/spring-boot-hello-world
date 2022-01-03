package net.take8.springboothelloworld;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("messages")
public class MessagesController {
  // 永続化しないでメモリ上に格納する
  final List<Message> messages = new CopyOnWriteArrayList<>();

  @RequestMapping(method = RequestMethod.GET)
  public List<Message> getMessages() {
    return messages;
  }

  @RequestMapping(method = RequestMethod.POST)
  public Message postMessages(@RequestBody Message message) {
    messages.add(message);
    return message;
  }
}
