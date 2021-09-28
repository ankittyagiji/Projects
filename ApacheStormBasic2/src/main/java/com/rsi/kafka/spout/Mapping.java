package com.rsi.kafka.spout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mapping class to store the gvuid, vehicleSet, vehicleSetId, country,
 * warehouseKey
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mapping {

	private String id;
	private String userName;
	private String password;
   

}