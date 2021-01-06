package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.model.Building;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/buildings")
@Transactional
public class BuildingController {
    private final BuildingDao buildingDao;
    private final RoomDao roomDao;

    public BuildingController(BuildingDao buildingDao, RoomDao roomDao) {
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<BuildingDto> findAll() { return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList()); }

    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building = null;

        if (dto.getId() == null) {
            building = buildingDao.save(new Building(dto.getId(), dto.getName(), dto.getRoomList()));
        }
        else {
            building = buildingDao.getOne(dto.getId());
            building.setName(dto.getName());
        }
        return new BuildingDto(building);
    }

    @GetMapping(path = "/{building_id}")
    public BuildingDto findById(@PathVariable Long building_id) {
        return buildingDao.findById(building_id).map(BuildingDto::new).orElse(null);
    }

    @DeleteMapping(path = "/{building_id}")
    public void delete(@PathVariable Long building_id) {
        roomDao.deleteAllRoomsFromBuilding(building_id);
        buildingDao.deleteById(building_id);
    }
}
