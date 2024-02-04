package com.dklb.filius.infrastructure.helpers.models.general;

import jakarta.annotation.Nonnull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import java.io.IOException;
import java.io.InputStream;

public class HttpInputMessageModel implements HttpInputMessage {

    private final HttpHeaders headers;

    private final InputStream body;

    public HttpInputMessageModel(HttpHeaders headers, InputStream body) {
        super();
        this.headers = headers;
        this.body = body;
    }
    @Override
    @Nonnull
    public InputStream getBody() throws IOException {
        return this.body;
    }

    @Override
    @Nonnull
    public HttpHeaders getHeaders() {
        return this.headers;
    }
}
