package com.rsi.kafka.bolt;

import java.util.Arrays;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

/**
 * Class for Reviews Tuples configurations
 */
public final class ReviewTuples {

    // Spout
    public static final String BYTES = "bytes";

    // Mapper
    public static final String ID = "id";
    public static final String TRANSACTION = "transaction";    
    public static final String MAPPIING = "mapping";
    
    //Declared Fields
    
    static final String[] MAPPER_DECLARED_FIELDS = new String[] { ID, TRANSACTION, MAPPIING };
    
    private ReviewTuples(){
    	
    }
    
    /**
     * newValues
     * @param tuple
     * @param values
     * @return
     */
    public static Values newValues(Tuple tuple, Object... values) {
        Values tupleValues = new Values();
        tupleValues.addAll(tuple.getValues());
        tupleValues.addAll(Arrays.asList(values));
        return tupleValues;

    }
    
}