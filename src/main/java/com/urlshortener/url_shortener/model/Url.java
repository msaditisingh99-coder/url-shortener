package com.urlshortener.url_shortener.model;

import jakarta.persistence.*;

@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String longUrl;
    private String shortCode;

    public Long getId() { return id; }
    public String getLongUrl() { return longUrl; }
    public String getShortCode() { return shortCode; }

    public void setLongUrl(String longUrl) { this.longUrl = longUrl; }
    public void setShortCode(String shortCode) { this.shortCode = shortCode; }
}
