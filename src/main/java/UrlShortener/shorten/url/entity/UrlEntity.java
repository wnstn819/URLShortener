package UrlShortener.shorten.url.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UrlEntity {

    @Id
    private Long id;

    @Column
    private String longUrl;

    @Column
    private String shortUrl;


}
