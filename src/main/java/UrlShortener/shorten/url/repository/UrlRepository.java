package UrlShortener.shorten.url.repository;


import UrlShortener.shorten.url.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity,Long> {

    Optional<UrlEntity> findById(Long id);
    Optional<UrlEntity> findByLongUrl(String LongUrl);

    Optional<UrlEntity> findByShortUrl(String shortUrl);

}
