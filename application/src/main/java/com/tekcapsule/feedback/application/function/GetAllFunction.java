package com.tekcapsule.feedback.application.function;

import com.tekcapsule.core.domain.EmptyFunctionInput;
import com.tekcapsule.feedback.application.config.AppConstants;
import com.tekcapsule.feedback.domain.model.Feedback;
import com.tekcapsule.feedback.domain.service.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


@Component
@Slf4j
public class GetAllFunction implements Function<Message<EmptyFunctionInput>, Message<List<Feedback>>> {

    private final FeedbackService feedbackService;

    public GetAllFunction(final FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }


    @Override
    public Message<List<Feedback>> apply(Message<EmptyFunctionInput> findAllInputMessage) {
        log.info("Entering get all feedback Function");

        List<Feedback> feedbacks = feedbackService.findAll();
        Map<String, Object> responseHeader = new HashMap<>();
        responseHeader.put(AppConstants.HTTP_STATUS_CODE_HEADER, HttpStatus.OK.value());

        return new GenericMessage<>(feedbacks, responseHeader);
    }
}