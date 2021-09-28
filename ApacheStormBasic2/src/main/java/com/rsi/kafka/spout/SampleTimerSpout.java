package com.rsi.kafka.spout;

import java.util.Map;
import java.util.UUID;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SampleTimerSpout extends BaseRichSpout{

	private static final long serialVersionUID = -8205164758930452215L;

	 

    private SpoutOutputCollector collector;
    private ObjectMapper objectMapper = new ObjectMapper();
    private long lastEmit =  System.currentTimeMillis();
    
    private long interval = 1000;
    private long sleep = 1000;

    /**
     * Construct a TimerSpout with the specified interval and sleep
     * @param interval in milliseconds between timestamp {@link Tuple} emits
     * @param sleep in milliseconds between nextTuple() calls
     */
    public SampleTimerSpout(long interval, long sleep) {
        super();
        this.interval = interval;
        this.sleep = sleep;
    }
    
    /**
     * Construct a TimerSpout with the specified interval.
     * @param interval in milliseconds between timestamp {@link Tuple} emits
     */
    public SampleTimerSpout(long interval) {
        super();
        this.interval = interval;
    }

 

    
    /**
     * Construct a TimerSpout
     */
    public SampleTimerSpout() {
        super();
    }
    
    @Override
    public void open(@SuppressWarnings("rawtypes") Map stormConf, 
                        TopologyContext context,
                        SpoutOutputCollector collector) {
        this.collector = collector;
    }

 

    @Override
    public void nextTuple() {
    	
		Mapping mapping = new Mapping();
		mapping.setId("1");
		mapping.setUserName("Ankitt");
		mapping.setPassword("Tyagii");
		
		Values values = buildValues(mapping);

		collector.emit(new Values(values));
       
        Utils.sleep(sleep);
    }

 

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("timestamp"));
        
    }

 

    public long getInterval() {
        return interval;
    }

 

    public void setInterval(long interval) {
        this.interval = interval;
    }

 

    public long getSleep() {
        return sleep;
    }

 

    public void setSleep(long sleep) {
        this.sleep = sleep;
    }
    
   
    private Values buildValues(Mapping trackerMessage) {
        Values values = new Values();
        try {
            values.add(objectMapper.writeValueAsBytes(trackerMessage));
            return values;
        } catch (JsonProcessingException je) {
            //LOGGER.error("Error in vin :" + trackerMessage.getVinPattern() + "error:" + je.getMessage(), je.getCause());
            return null;
        }

 

    }
	
}
