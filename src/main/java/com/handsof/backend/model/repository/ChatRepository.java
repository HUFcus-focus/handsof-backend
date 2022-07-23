package com.handsof.backend.model.repository;

import com.handsof.backend.domain.dto.SlackDto;
import com.handsof.backend.domain.entity.Slack;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends ReactiveMongoRepository<Slack, String> {
    public List<Slack> findAllByUserId(String userId);
}
