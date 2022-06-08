package com.bolsadeideas.springboot.webflux.app.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.webflux.app.dto.ProductDto;
import java.util.concurrent.ThreadLocalRandom;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class DataSetupService /*implements CommandLineRunner */ {
	/*
	 @Autowired
	    private ProductService service;

	    @Override
	    public void run(String... args) throws Exception {
	        ProductDto p1 = new ProductDto("Pelota", "Bodega CES", 200.00, "Equipo");
	        ProductDto p2 = new ProductDto("Pelota", "Tienda Jutiapa", 129.00, "Equipo");
	        ProductDto p3 = new ProductDto("Camisola", "Bodega CES", 165.00, "Uniforme");
	        ProductDto p4 = new ProductDto("Camisola RM", "Bodega CES", 190.00, "Uniforme");

	        Flux.just(p1, p2, p3, p4)
	                .concatWith(newProducts())
	                .flatMap(p -> this.service.insertProduct(Mono.just(p)))
	                .subscribe(System.out::println);

	    }

	    private Flux<ProductDto> newProducts(){
	        return Flux.range(1, 1000)
	                .delayElements(Duration.ofSeconds(2))
	                .map(i -> new ProductDto("product-" + i, ThreadLocalRandom.current().nextDouble(10, 100)));
	    }*/

}
