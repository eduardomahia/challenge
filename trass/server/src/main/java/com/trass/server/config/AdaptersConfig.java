package com.trass.server.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AdaptersConfig {

    @Value("${adapters.gpt.completionsUrl}")
    private String gptProcessTextUrl;

    @Value("${adapters.gpt.token}")
    private String gptToken;
}
