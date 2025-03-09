package com.stockmanagements.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.stream.Stream;

public class DesignTypeCategoryIdGenerator implements IdentifierGenerator {

    private static final String PREFIX = "DT";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        // Query the current max ID from the database
        String query = "SELECT MAX(d.design_id) FROM DesignTypeCategory d";
        Stream<String> maxIdStream = session.createQuery(query, String.class).stream();

        // Find the maximum ID
        String maxId = maxIdStream.findFirst().orElse(null);

        // Generate the next ID
        if (maxId == null) {
            return PREFIX + "0001"; // First ID
        } else {
            // Extract the numeric part of the ID
            String numericPart = maxId.substring(PREFIX.length());
            int nextNumber = Integer.parseInt(numericPart) + 1;

            // Format the next ID with leading zeros
            return PREFIX + String.format("%04d", nextNumber);
        }
    }
}