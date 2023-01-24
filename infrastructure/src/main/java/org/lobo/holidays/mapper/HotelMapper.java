package org.lobo.holidays.mapper;

import org.lobo.holidays.adapter.driven.persistence.model.HotelEntity;
import org.lobo.holidays.domain.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper extends BaseMapper<Hotel, HotelEntity>{

}
