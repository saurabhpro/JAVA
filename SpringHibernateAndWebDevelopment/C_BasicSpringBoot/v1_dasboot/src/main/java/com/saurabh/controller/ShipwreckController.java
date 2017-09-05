package com.saurabh.controller;

import com.saurabh.model.Shipwreck;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/")      //standard - look at rest video
public class ShipwreckController {

	@GetMapping(value = "shipwrecks")
	public List<Shipwreck> list() {
		return ShipwreckStub.list();
	}

	@PostMapping(value = "shipwrecks")
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return ShipwreckStub.create(shipwreck);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id) {
		return ShipwreckStub.get(id);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		return ShipwreckStub.update(id, shipwreck);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id) {
		return ShipwreckStub.delete(id);
	}

}
