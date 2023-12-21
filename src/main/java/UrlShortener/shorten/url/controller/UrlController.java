package UrlShortener.shorten.url.controller;



import UrlShortener.shorten.support.ApiResponse;
import UrlShortener.shorten.support.ApiResponseGenerator;
import UrlShortener.shorten.support.MessageCode;
import UrlShortener.shorten.url.entity.UrlEntity;
import UrlShortener.shorten.url.model.request.LongUrlRequest;
import UrlShortener.shorten.url.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/data")
public class UrlController {

    private final UrlService urlService;
    @PostMapping("/shorten")
    public ApiResponse<ApiResponse.SuccessBody<String>> join(@RequestBody LongUrlRequest request) {
        String shortUrl =  urlService.save(request.longURL);
        return ApiResponseGenerator.success(shortUrl,HttpStatus.OK, MessageCode.SUCCESS);
    }


    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> login(@PathVariable String shortUrl) {
        UrlEntity url = urlService.search(shortUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url.getLongUrl()));
        return new ResponseEntity(headers, HttpStatus.MOVED_PERMANENTLY);

    }
}
