package com.mqservice.resource;

import com.mqservice.common.request.MessageRequest;
import com.mqservice.mq.MqService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("publish")
public class MqController {

    private final MqService mqService;

    @PostMapping
    public ResponseEntity<String> publishMessage(@RequestBody MessageRequest request) {
        mqService.publish(request.getMessage(), request.getTo());
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
