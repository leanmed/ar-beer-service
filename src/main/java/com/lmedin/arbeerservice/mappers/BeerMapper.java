package com.lmedin.arbeerservice.mappers;

import com.lmedin.arbeerservice.domain.Beer;
import com.lmedin.arbeerservice.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto (Beer beer);
    Beer beerDtoToBeer (BeerDto dto);
}
