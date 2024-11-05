package com.trass.server.adapters;

import com.trass.server.adapters.models.gptprocesstext.Request;
import com.trass.server.adapters.models.gptprocesstext.Response;
import com.trass.server.config.AdaptersConfig;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.RestClient;

import static com.trass.server.utils.Constants.getAuthValue;

@Component
@AllArgsConstructor
public class GPTAdapter {
    private final AdaptersConfig config;
    private final RestClient restClient;

    public Response getBookingDataFromText(final String text) {
        return restClient.post()
                .uri(config.getGptProcessTextUrl())
                .header(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON.toString())
                .header(HttpHeaders.ACCEPT, MimeTypeUtils.APPLICATION_JSON.toString())
                .header(HttpHeaders.AUTHORIZATION, getAuthValue(config.getGptToken()))
                .body(new Request(text))
                .retrieve()
                .body(Response.class);
    }
}
