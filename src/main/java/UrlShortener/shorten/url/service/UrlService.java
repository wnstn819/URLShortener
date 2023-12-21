package UrlShortener.shorten.url.service;


import UrlShortener.shorten.url.entity.UrlEntity;

public interface UrlService {

    //DB에 저장
    String save(String longUrl);

    //LongUrl 검색
    UrlEntity search(String shortUrl);




}
