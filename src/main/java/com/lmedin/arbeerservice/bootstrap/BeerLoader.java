package com.lmedin.arbeerservice.bootstrap;

import com.lmedin.arbeerservice.domain.Beer;
import com.lmedin.arbeerservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("localHost")
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
            .beerName("Mango Bobs")
            .beerStyle("IPA")
            .quantityOnHand(200)
            .minOnHand(12)
            .upc(123L)
            .price(new BigDecimal(12.95))
            .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy")
                    .beerStyle("GOLD")
                    .quantityOnHand(200)
                    .minOnHand(12)
                    .upc(124L)
                    .price(new BigDecimal(11.95))
                    .build());
            System.out.println("Loaded Beers " + beerRepository.count());
        }
    }
}
