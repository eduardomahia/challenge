package com.trass.server.adapters.models.gptprocesstext;

import com.trass.server.adapters.utils.GPTConstants;
import lombok.Getter;

import java.io.Serializable;

import static com.trass.server.adapters.utils.GPTConstants.GET_BOOKING_DETAILS_PROMPT_MESSAGE;
import static com.trass.server.adapters.utils.GPTConstants.TEMPERATURE_LEVEL_REALISTIC;

@Getter
public class Request implements Serializable {

    public Request(final String text) {
        final Message prompt = new Message(GET_BOOKING_DETAILS_PROMPT_MESSAGE, GPTConstants.MessageType.SYSTEM.value);
        final Message inputText = new Message(String.format("\"%s\"", text), GPTConstants.MessageType.USER.value);
        this.messages = new Message[]{prompt, inputText};
    }
    private final Message[] messages;
    private final String model = GPTConstants.Models.GPT3_5.value;
    private final int temperature = TEMPERATURE_LEVEL_REALISTIC;
    private final ResponseFormat response_format = new ResponseFormat(GPTConstants.ResponseFormat.JSON.value);
}
