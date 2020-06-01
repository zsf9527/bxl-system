package com.zsf.zuul.hystrix;

import org.bouncycastle.util.encoders.UTF8;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.stereotype.Component;
import sun.nio.cs.UTF_32;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class MyFallBackProvider implements FallbackProvider {
    @Override
    public String getRoute() {//对哪个服务进行熔断
        return "bxl-consumer";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {//具体逻辑
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "ok";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("服务器繁忙".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                return new HttpHeaders();
            }
        };
    }
}
