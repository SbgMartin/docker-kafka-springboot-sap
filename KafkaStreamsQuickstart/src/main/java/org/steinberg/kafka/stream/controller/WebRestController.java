package org.steinberg.kafka.stream.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;

	@RestController
	@RequestMapping(value="/steini/kafka/stream")
	public class WebRestController {
		
		
		@GetMapping(value="/wordcount")
		public String producer(@RequestParam("data")String data){
			
			return "Done";
		}
}
