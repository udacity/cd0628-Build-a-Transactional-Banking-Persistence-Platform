package com.udacity.banking.entity;

import java.math.BigDecimal;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * This class converts the Money class to and from the type BigDecimal for the database storage
 */
@Converter(autoApply = true)
public class MoneyConverter implements AttributeConverter<Money, BigDecimal>{

    @Override
    public BigDecimal convertToDatabaseColumn(Money attribute) {

        if (attribute == null)
        {
            return null;
        } 

        return attribute.getAmount();
    }

    @Override
    public Money convertToEntityAttribute(BigDecimal dbData) {
        
        if (dbData == null)
        {
            return null;
        }
        return new Money(dbData);
    }
    
    
}
