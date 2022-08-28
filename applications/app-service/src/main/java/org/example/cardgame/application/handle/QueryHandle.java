package org.example.cardgame.application.handle;


import org.example.cardgame.application.handle.model.JuegoListViewModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class QueryHandle {

    private final ReactiveMongoTemplate template;

    public QueryHandle(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @Bean
    public RouterFunction<ServerResponse> listarJuego() {
        return route(
                GET("/api/juego/listar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.find(filterByUId(request.pathVariable("id")), JuegoListViewModel.class, "gameview")
                        .collectList()
                        .flatMap(list -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Flux.fromIterable(list), JuegoListViewModel.class)))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getTablero() {
        return route(
               GET("/api/juego/getTablero/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.findOne(filterById(request.pathVariable("id")), TableroViewModel.class, "gameveiw")
                        .flatMap(element -> ServerResponse.ok())
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromPublisher(Mono.just(elem), TableroViewModel.class)))
            );
    }

    //TODO: obtener mazo
    @Bean
    public RouterFunction<ServerResponse> getMazo() {
        return route(
                GET("/juego/mazo/{uid}/{juegoId}").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.findOne(filterByJuegoIddAndUid(request.pathVariable("uid"),request.pathVariable("juegoId")), MazoViewModel.class, "mazoview")
                        .flatMap(elem ->ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Mono.just(elem),MazoViewModel.class)))
        );
    }

    private Query filterByUId(String uid) {
        return new Query(
                Criteria.where("uid").is(uid)
        );
    }


}
