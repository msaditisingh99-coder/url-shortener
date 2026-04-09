package com.urlshortener.url_shortener.service;

import com.urlshortener.url_shortener.model.Url;
import com.urlshortener.url_shortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repository;

    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generateShortCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(BASE62.charAt(random.nextInt(BASE62.length())));
        }
        return sb.toString();
    }

    public String shortenUrl(String longUrl) {
        String code = generateShortCode();

        Url url = new Url();
        url.setLongUrl(longUrl);
        url.setShortCode(code);

        repository.save(url);
        return code;
    }

    public String getLongUrl(String code) {
        return repository.findByShortCode(code)
                .map(Url::getLongUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
    }
}
