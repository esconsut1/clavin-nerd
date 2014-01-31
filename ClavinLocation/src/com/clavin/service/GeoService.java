package com.clavin.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
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
public class GeoService implements InitializingBean{
	private static final Logger log = LoggerFactory
			.getLogger(GeoService.class);

	@Autowired
	private MessageSource messageSource;
	private GeoParser parser;
	public List<GeoName> getLocations(String text){
		List<ResolvedLocation> resolvedLocations = null;
		List<GeoName> geoNames = new ArrayList<GeoName>();
		GeoName geoName = null;
		try{
			String upperCase = text.toUpperCase();
				resolvedLocations = parser.parse(upperCase);
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
						geoName.setLocationText(rLocation.location.text);
						geoNames.add(geoName);
					}
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return geoNames;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		
		parser = GeoParserFactory.getDefault(messageSource.getMessage("com.clavin.index.path", null, null), new StanfordExtractor(), 1,1,false);
	}
}