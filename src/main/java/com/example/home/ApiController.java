package com.example.home;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    private List<String> messages = new ArrayList<>();


    /* curl -X GET http://localhost:8080/messages*/
    @GetMapping("messages")
    public List<String> getMessages() {
        return messages;
    }

    /* curl -X POST http://localhost:8080/messages -H 'Content-Type:
   text/plain' -d 'text' */

    @PostMapping("messages")
    public void addMessage(@RequestBody String text) {
        messages.add(text);
    }

    /* curl -X GET http://localhost:8080/messages/0  */
    @GetMapping("messages/{index}")
    public String getMessage(@PathVariable("index") Integer index) {
        return messages.get(index);
    }

    /* curl -X DELETE http://localhost:8080/messages/0 */
    @DeleteMapping("messages/{index}")
    public void deleteText(@PathVariable("index") Integer index) {
        messages.remove((int) index);
    }
  /* curl -X PUT http://localhost:8080/messages/0 -H 'Content-Type:text/plain' -d "text1" */
    @PutMapping("messages/{index}")
    public void updateMessage(
            @PathVariable("index") Integer i,
            @RequestBody String message) {
        messages.remove((int) i);
        messages.add(i, message);
    }
}