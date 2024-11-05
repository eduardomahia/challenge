package com.trass.server.adapters.models.gptprocesstext;

public record Usage(int prompt_tokens, int completion_tokens, int total_tokens) {
}