package com.handsof.backend.controller;

import com.handsof.backend.domain.dto.SlackDto;
import com.handsof.backend.model.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatRestController {
    private final ChatService chatService;

    @GetMapping("/chat/slacks/{userId}")
    public List<SlackDto> chatSlacks(@PathVariable String userId) {
        return chatService.findAllByUserId(userId);
    }
}
