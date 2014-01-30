package com.clavin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clavin.model.GeoName;
import com.clavin.service.GeoService;


@Controller
@RequestMapping("/geo")
public class GeoController {

	@Autowired
	private GeoService geoService;
	
		
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody List<GeoName> getGeoLocation(@RequestParam String text){
		
		return geoService.getLocations(text);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<GeoName> initiate(@RequestParam String text){
		return geoService.getLocations(text);
	}
}
