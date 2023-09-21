package com.mayamcof.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayamcof.IService.ITerrain;
import com.mayamcof.model.Terrain;


@RestController
@RequestMapping("/mayamcof")
public class TerrainController {

	private ITerrain iTerrain;

	public TerrainController(ITerrain iTerrain) {
		
		this.iTerrain = iTerrain;
	}
	
	@GetMapping("/terrains")
	public List<Terrain>getAll(){
		
		return this.iTerrain.getAll();
	}
	
	@GetMapping("/terrain/{id}")
	public Terrain getTerrain(@PathVariable long id) {
		
		return this.iTerrain.getTerrain(id);
	}
	
	@PostMapping("/terrain")
	public Terrain create(@RequestBody Terrain terrain) {
		
		return this.iTerrain.create(terrain);
	}
	
	@PutMapping("/terrain")
	public Terrain update(@RequestBody Terrain terrain) {
		
		return this.iTerrain.update(terrain);
	}
	
	@DeleteMapping("/terrain/{id}")
	public void delete(@PathVariable Long id) {
		
		this.iTerrain.delete(id);
	}
	
}
