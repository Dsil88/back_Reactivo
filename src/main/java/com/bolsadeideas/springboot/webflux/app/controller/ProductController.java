package com.bolsadeideas.springboot.webflux.app.controller;

import javax.annotation.PostConstruct;

import com.bolsadeideas.springboot.webflux.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;

import com.bolsadeideas.springboot.webflux.app.dto.ProductDto;
import com.bolsadeideas.springboot.webflux.app.service.ProductService;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("product")
public class ProductController {

	// conexion a cliente de kafka

    /* -------------------------------------------------------------------------------------------------------------- */
    @PostConstruct
    private void createProcessor() {
		EmitterProcessor<ProductDto> notificationProcessor = EmitterProcessor.<ProductDto>create();
    }
	
	 @Autowired
	    private ProductService service;
	 
	 

	    @GetMapping("all")
	    public Flux<ProductDto> all(){
	        return this.service.getAll();
	    }

	/*  @GetMapping("price-range")
	    public Flux<ProductDto> getByPriceRange(@RequestParam("min") int min,
	                                            @RequestParam("max") int max){
	        return this.service.getProductByPriceRange(min, max);
	    } */

	    @GetMapping("{id}")
	    public Mono<ResponseEntity<ProductDto>> getProductById(@PathVariable String id){
	       
	        return this.service.getProductById(id)
	                            .map(ResponseEntity::ok)
	                            .defaultIfEmpty(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Mono<ProductDto> insertProduct(@RequestBody Mono<ProductDto> productDtoMono){
	        return this.service.insertProduct(productDtoMono);
	    }

	/*@RequestMapping(
			path = "/create",
			method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ProductDto entityParam) {

		// cuando se crea una nueva persona.... notificar esta accion al emisor
		System.out.println("Notificando nueva persona:" + entityParam.getNombre());
		// 0....1........................4.3..5

		notificationProcessor.onNext(entityParam);

		return new ResponseEntity<>(entityParam, HttpStatus.OK);
	}*/



	    @PutMapping("{id}")
	    public Mono<ResponseEntity<ProductDto>> updateProduct(@PathVariable String id, @RequestBody Mono<ProductDto> productDtoMono){
	       return this.service.updateProduct(id, productDtoMono)
	                    .map(ResponseEntity::ok)
	                    .defaultIfEmpty(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("{id}")
	    public Mono<Void> deleteProduct(@PathVariable String id){
	        return this.service.deleteProduct(id);
	    }
	    
	  /*  private Flux<ServerSentEvent<ProductDto>> getPersonaSSE() {

	        // SSE
	        // notification processor retorna un FLUX en el cual podemos estar "suscritos" cuando este tenga otro valor ...
	        return notificationProcessor
	                .log()
	                .map(
	                        (persona) -> {
	                            System.out.println("Sending Persona:" + persona.getId());
	                            return ServerSentEvent.<Persona>builder()
	                                    .id(UUID.randomUUID().toString())
	                                    .event("persona-result")
	                                    .data(persona)
	                                    .build();
	                        }
	                )
	                .concatWith(Flux.never());
	    }*/

}
