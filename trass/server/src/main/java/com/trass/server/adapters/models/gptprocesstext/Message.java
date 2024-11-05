package com.trass.server.adapters.models.gptprocesstext;

import com.trass.server.adapters.utils.GPTConstants;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class Message implements Serializable {
    Message(final String content, final String role) {
        this.content = content;
        this.role = role;
    }

    private final String content;
    private final String role;

}
