package com.trass.server.adapters.models.gptprocesstext;

public record Choice(int index, Message message, String finish_reason) {
}
