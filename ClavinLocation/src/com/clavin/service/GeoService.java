package com.clavin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

import com.bericotech.clavin.GeoParser;
import com.bericotech.clavin.GeoParserFactory;
import com.bericotech.clavin.nerd.StanfordExtractor;
import com.bericotech.clavin.resolver.ResolvedLocation;

@Repository
@SuppressWarnings("unchecked")
public class GeoService {
	private static final Logger log = LoggerFactory
			.getLogger(GeoService.class);

	@Autowired
	private MessageSource messageSource;

	public List<ResolvedLocation> getLocations(String text){
		List<ResolvedLocation> resolvedLocations = null;
		try{
			String indexPath = messageSource.getMessage("com.clavin.index.path", null, null);
			log.info("index path: "+indexPath);
			GeoParser parser = GeoParserFactory.getDefault(indexPath, new StanfordExtractor(), 1, 1, false);
			resolvedLocations = parser.parse(text);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return resolvedLocations;
	}
}