package com.handsof.backend.model.service;

import com.handsof.backend.domain.dto.SlackDto;
import com.handsof.backend.domain.entity.Slack;
import com.handsof.backend.model.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final ReactiveMongoTemplate mongoTemplate;

    @Override
    public List<SlackDto> findAllByUserId(String userId) {
        Criteria criteria = new Criteria("userId");
        criteria.is(userId);

        Query query = new Query(criteria);

//        List<Slack> slacks = mongoTemplate.find(query, Slack.class);
        Flux<Slack> slackFlux = mongoTemplate.find(query, Slack.class);
        List<Slack> slacks = slackFlux.toStream().collect(Collectors.toUnmodifiableList());

//        List<Slack> slacks = chatRepository.findAllByUserId(userId);
        List<SlackDto> slackDtos = new ArrayList<>();
        for (Slack slack : slacks) {
            SlackDto slackDto = new SlackDto();
            slackDto.setDestinationName(slack.getDestinationName());
            slackDto.setWorspaceName(slack.getWorkspace().getWorkspaceName());
            slackDto.setMessage(slack.getMessage());
            slackDto.setCreatedAt(slack.getCreatedAt());
            slackDtos.add(slackDto);
        }

        return slackDtos;
    }
}
