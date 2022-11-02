package com.emahia.counterapi.controllers.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SearchTextRequest {

    @NonNull
    private List<String> searchText;
}
