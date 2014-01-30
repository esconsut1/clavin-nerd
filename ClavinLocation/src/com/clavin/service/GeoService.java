package com.clavin.service;

import java.util.ArrayList;
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
import com.clavin.model.GeoName;

@Repository
@SuppressWarnings("unchecked")
public class GeoService {
	private static final Logger log = LoggerFactory
			.getLogger(GeoService.class);

	@Autowired
	private MessageSource messageSource;

	public List<GeoName> getLocations(String text){
		List<ResolvedLocation> resolvedLocations = null;
		List<GeoName> geoNames = null;
		try{
			String indexPath = messageSource.getMessage("com.clavin.index.path", null, null);
			log.info("index path: "+indexPath);
			GeoParser parser = GeoParserFactory.getDefault(indexPath, new StanfordExtractor(), 1, 1, true);
			resolvedLocations = parser.parse(text.toUpperCase());
			geoNames = new ArrayList<GeoName>();
			GeoName geoName = null;
			for(ResolvedLocation rLocation: resolvedLocations){
				geoName = new GeoName();
				geoName.setAsciiName(rLocation.geoname.asciiName);
				geoName.setGeonameID(rLocation.geoname.geonameID);
				geoName.setLatitude(rLocation.geoname.latitude);
				geoName.setLongitude(rLocation.geoname.longitude);
				geoName.setName(rLocation.geoname.name);
				geoName.setPrimaryCountryCode(rLocation.geoname.primaryCountryCode.name());
				geoName.setPrimaryCountryName(rLocation.geoname.getPrimaryCountryName());
				geoName.setTimezone(rLocation.geoname.timezone.getDisplayName());
				geoName.setAdmin1Code(rLocation.geoname.admin1Code);
				geoName.setAdmin2Code(rLocation.geoname.admin2Code);
				geoNames.add(geoName);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return geoNames;
	}
}