package com.clavin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bericotech.clavin.resolver.ResolvedLocation;
import com.clavin.model.RawText;
import com.clavin.service.GeoService;


@Controller
@RequestMapping("/geo")
public class GeoController {

	@Autowired
	private GeoService geoService;
	
		
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody List<ResolvedLocation> getGeoLocation(@RequestBody RawText text){
		
		return geoService.getLocations(text.getText());
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody RawText initiate(){
		RawText raw = new RawText();
		raw.setText("hi from San Francisco");
		return raw;
	}
}
