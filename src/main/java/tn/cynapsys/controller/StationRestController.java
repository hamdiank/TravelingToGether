package tn.cynapsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.Station;
import tn.cynapsys.services.StationService;


	@RestController
	@RequestMapping(value = "/station")
	public class StationRestController {

		@Autowired
		private StationService stationService;

		@RequestMapping(value = "/all", method = RequestMethod.GET)
		public List<Station> city() {

			return stationService.getAllStation();
		}

		@RequestMapping(value = "/station/{id}", method = RequestMethod.GET)
		public ResponseEntity<Station> cityById(@PathVariable Long id) {
			Station station = stationService.getStationById(id);
			if (station == null) {
				return new ResponseEntity<Station>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<Station>(station, HttpStatus.OK);
			}
		}

		@RequestMapping(value = "/stationDel/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Station> deleteStation(@PathVariable Long id) {

			Station station = stationService.getStationById(id);

			if (station == null) {
				return new ResponseEntity<Station>(HttpStatus.NO_CONTENT);

			} else {

				stationService.deleteStation(station);

				return new ResponseEntity<Station>(station, HttpStatus.OK);
			}
		}

		@RequestMapping(value = "/updateStation/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Station> updateStation(@PathVariable Long id, @RequestBody Station station) {

			Station s = stationService.getStationById(id);

			if (s == null) {
				return new ResponseEntity<Station>(HttpStatus.NO_CONTENT);

			} else {
				System.out.println(id + " " + station);
				System.out.println(station.getNom());
				stationService.updateStation(station);

				System.out.println(stationService.getStationById(id).getNom());
				return new ResponseEntity<Station>(station, HttpStatus.OK);
			}
		}
	}
