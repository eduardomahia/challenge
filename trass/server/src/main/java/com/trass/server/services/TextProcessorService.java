package com.trass.server.services;

import com.trass.server.adapters.GPTAdapter;
import com.trass.server.adapters.models.gptprocesstext.Response;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TextProcessorService {

    public final GPTAdapter adapter;

    public void storeBookingDataFromText(final String text) {
        final Response response = adapter.getBookingDataFromText(text);
        System.out.println(response.choices());

    }
}


