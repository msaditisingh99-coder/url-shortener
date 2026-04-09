package com.urlshortener.url_shortener.controller;

import com.urlshortener.url_shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UrlController {

    @Autowired
    private UrlService service;

    @GetMapping("/shorten")
    public String shorten(@RequestParam String url) {
        return service.shortenUrl(url);
    }

    @GetMapping("/{code}")
    public void redirect(@PathVariable String code, HttpServletResponse response) throws IOException {
        String longUrl = service.getLongUrl(code);
        response.sendRedirect(longUrl);
    }
}