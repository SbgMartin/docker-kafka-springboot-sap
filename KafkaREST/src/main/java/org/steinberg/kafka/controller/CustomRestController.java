package org.steinberg.kafka.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.steinberg.kafka.producer.KafkaProducer;
import org.steinberg.kafka.storage.MessageStorage;

@RestController
@RequestMapping(value = "/steini/kafka")
public class CustomRestController {

	private static final Log LOG = LogFactory.getLog(CustomRestController.class);

	@Autowired
	KafkaProducer producer;

	@Autowired
	MessageStorage storage;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("data") String data) {
		LOG.debug("Calling Apache Kafka with " + data);

		producer.send(data);

		LOG.debug("Sent");

		return "Done";
	}

	@GetMapping(value = "/consumer")
	public String getAllRecievedMessage() {
		String messages = storage.toString();
		storage.clear();

		return messages;
	}
}