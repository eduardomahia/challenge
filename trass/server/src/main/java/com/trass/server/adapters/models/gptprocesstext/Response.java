package com.trass.server.adapters.models.gptprocesstext;

public record Response(String id, String object, int created, String model, String system_fingerprint, Choice[] choices, Usage usage){

}
