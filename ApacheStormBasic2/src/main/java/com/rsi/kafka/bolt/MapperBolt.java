package com.rsi.kafka.bolt;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsi.kafka.spout.MapperMessage;
import com.rsi.kafka.spout.Mapping;

/**
 * Mapper Bolt receives user details from Mappper Kafka Spout and emits the same
 * with a unique id (transaction key) to Review Bolt
 *
 */
public class MapperBolt extends BaseRichBolt {

	private static final long serialVersionUID = 7563504385701476025L;

	private static final Logger LOGGER = LoggerFactory.getLogger(MapperBolt.class);

	private transient OutputCollector collector;

	private ObjectMapper objectMapper = new ObjectMapper();

	public MapperBolt() {
		// Default constructor
	}
	

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}


	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}


	public OutputCollector getCollector() {
		return collector;
	}


	@Override
	public void execute(Tuple tuple) {
System.out.println("Inside execute method of MapperBolt");
		MapperMessage mapperMessage = null;
		try {
			mapperMessage = read(tuple);
		} catch (JsonParseException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (mapperMessage == null) {
			collector.ack(tuple);
			return;
		}

		String id = mapperMessage.getId();
		String userName = mapperMessage.getUserName();
		String password = mapperMessage.getPassword();

		if (id != null && userName != null && password != null) {
			Mapping mapping = new Mapping();
			mapping.setId(id);
			mapping.setUserName(userName);
			mapping.setPassword(password);
			Values values = buildValues(id, UUID.randomUUID().toString(), mapping);

			collector.emit(tuple, values);
		} else {
			String message = "Input Data from spout contains null or empty values.";
			LOGGER.error(message);

		}

		collector.ack(tuple);
	}

	protected MapperMessage read(Tuple tuple) throws JsonParseException, JsonMappingException, IOException {
		byte[] bytes = tuple.getBinaryByField("bytes");
        
		MapperMessage mapperMessage = null;
		try {
			mapperMessage = objectMapper.readValue(bytes, MapperMessage.class);
		} catch (Error e) {
			collector.reportError(new RuntimeErrorException(e, "Error reading the MapperMessage from the Tuple."));
		}

		return mapperMessage;
	}

	/*
	 * @Override public void prepare(Map<String, Object>stormConf, TopologyContext
	 * context, OutputCollector collector) { this.setContext(context);
	 * this.setCollector(collector);
	 * 
	 * }
	 */

	private void setCollector(OutputCollector collector2) {
		this.setCollector(collector);
	}

	private void setContext(TopologyContext context) {

		this.setContext(context);
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields(ReviewTuples.MAPPER_DECLARED_FIELDS));
	}

	private Values buildValues(String id, String transaction, Mapping mapping) {
		Values values = new Values();
		values.add(id);
		values.add(transaction);
		Object mappingValue = mapping;
		values.add(mappingValue);
		return values;

	}

	@Override
	public void prepare(Map<String, Object> stormConf, TopologyContext context, OutputCollector collector) {
		this.setContext(context);
		this.setCollector(collector);
		
	}

}