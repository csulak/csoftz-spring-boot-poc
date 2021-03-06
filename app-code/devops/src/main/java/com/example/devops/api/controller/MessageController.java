/*----------------------------------------------------------------------------*/
/* Source File:   MESSAGECONTROLLER.JAVA                                      */
/* Description:   REST Api for Message end-points.                            */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.01/2019                                                 */
/* Last Modified: Mar.16/2019                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.01/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.api.controller;

import com.example.devops.domain.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * REST Api for Message end-points.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.16/2019
 * @since 1.8 (JDK), Mar.01/2019
 */
@RestController
@RequestMapping("/api/v1/msg")
public class MessageController {

    /**
     * Says a message to the world.
     * <p>
     * GET /api/v1/msg/say
     *
     * @return A single Message via Reactor Mono
     */
    @GetMapping("/say")
    public Mono<Message> sayMessage() {
        var s = "JDK Zulu 11 Used";
        Message msg = new Message();
        msg.setDateTime(LocalDateTime.now());
        msg.setMsg(String.format("%s -> %s - %s", s, "Generated", msg.getDateTime().toString()));
        return Mono.just(msg);
    }
}
