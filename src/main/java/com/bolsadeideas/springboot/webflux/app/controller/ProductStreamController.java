package com.bolsadeideas.springboot.webflux.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.webflux.app.dto.ProductDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
@CrossOrigin(origins = "file:///C:/ProyectoSpringWebFlux/workspace/spring-boot-webflux-proyecto-1/src/main/resources/static/index.html")
public class ProductStreamController {

	@Autowired
    private Flux<ProductDto> flux;
	private Mono<ProductDto> mono;
	
	 @GetMapping(value = "stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	    public Flux<ProductDto> getProductUpdates(){
	        return this.flux;

	    }
	 
	 /*@GetMapping(value = "stream/{maxPrice}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	    public Flux<ProductDto> getProductUpdates(@PathVariable int maxPrice){
	        return this.flux
	                    .filter(dto -> dto.getPrice() <= maxPrice);
	    }*/
	 @PostMapping(value = "stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	    public Mono<ProductDto> insertProduct(@RequestBody Mono<ProductDto> productDtoMono){
	        return this.mono;
	    }
	
}
