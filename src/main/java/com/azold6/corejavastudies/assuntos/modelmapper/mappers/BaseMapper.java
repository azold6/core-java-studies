package com.azold6.corejavastudies.assuntos.modelmapper.mappers;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public abstract class BaseMapper {

    protected Converter<Date, Integer> idadeConverter(){
        return new AbstractConverter<Date, Integer>() {
            @Override
            protected Integer convert(Date date) {
                return Period.between(date.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate(), LocalDate.now()).getYears();
            }
        };
    }
}