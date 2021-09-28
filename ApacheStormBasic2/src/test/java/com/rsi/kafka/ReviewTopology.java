package com.rsi.kafka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.storm.flux.Flux;


public class ReviewTopology {

	public static void main(String[] args) throws Exception {
		// Get the original args
        List<String> argList = new ArrayList<String>(Arrays.asList(args));
        String file = ReviewTopology.class.getClassLoader().getResource("review-storm.yaml").getFile();
        argList.add("--local");
        argList.add(file);
        
        file = ReviewTopology.class.getClassLoader().getResource("application.properties").getFile();
        argList.add("--filter");
        argList.add(file);
        argList.add("--sleep");
        argList.add("3000000");
        
        System.setProperty("storm.jar", "C:\\MyEclipseWorkspace\\ApacheStormBasic2\\target\\ApacheStormBasic2-0.0.1-SNAPSHOT.jar");  
        String[] fluxArgs = argList.toArray(new String[argList.size()]);
        
        

        /*
         * Same as calling
         * storm jar mytopology.jar org.apache.storm.flux.Flux --local config.yaml
         */
        Flux.main(fluxArgs);
	}
}
