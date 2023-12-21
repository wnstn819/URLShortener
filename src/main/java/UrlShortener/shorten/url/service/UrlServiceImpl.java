package UrlShortener.shorten.url.service;


import UrlShortener.shorten.url.entity.UrlEntity;
import UrlShortener.shorten.url.repository.UrlRepository;
import UrlShortener.shorten.url.util.BaseConversion;
import UrlShortener.shorten.url.util.SnowFlake;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;
    private final BaseConversion base;
    @Override
    public String save(String longUrl) {
        //longUrl
        Optional<UrlEntity> url = urlRepository.findByLongUrl(longUrl);

        if(url.isPresent()){
            return url.get().getShortUrl();
        }else{
            SnowFlake snowFlake = new SnowFlake(1,1);
            Long id = snowFlake.nextId();
            String str = base.encode(id);
            UrlEntity entity = new UrlEntity(snowFlake.nextId(),longUrl,str);
            urlRepository.save(entity);
            return entity.getShortUrl();
        }


    }

    @Override
    public UrlEntity search(String shortUrl) {
        Optional<UrlEntity> url =  urlRepository.findByShortUrl(shortUrl);
        return url.get();
    }
}
