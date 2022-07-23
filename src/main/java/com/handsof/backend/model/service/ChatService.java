package com.handsof.backend.model.service;

import com.handsof.backend.domain.dto.SlackDto;

import java.util.List;

public interface ChatService {
    public List<SlackDto> findAllByUserId(String userId);
}
