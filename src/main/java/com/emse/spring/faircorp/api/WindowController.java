package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController // (1)
@CrossOrigin
@RequestMapping("/api/windows") // (2)
@Transactional // (3)
public class WindowController {

    private final WindowDao windowDao;

    public WindowController(WindowDao windowDao, RoomDao roomDao) { // (4)
        this.windowDao = windowDao;
    }

    @GetMapping // (5)
    public List<WindowDto> findAll() {
        return windowDao.findAll().stream().map(WindowDto::new).collect(Collectors.toList());  // (6)
    }

    @GetMapping(path = "/{window_id}")
    public WindowDto findById(@PathVariable Long window_id) {
        return windowDao.findById(window_id).map(WindowDto::new).orElse(null); // (7)
    }

    @GetMapping(path = "/room/{room_id}")
    public List<WindowDto> findByRoomId(@PathVariable Long room_id) {
        return windowDao.findByRoomId(room_id).stream().map(WindowDto::new).collect(Collectors.toList());  // (6)
    }

    @GetMapping(path = "/building/{building_id}")
    public List<WindowDto> findByRoomBuildingId(@PathVariable Long building_id) {
        return windowDao.findByRoomBuildingId(building_id).stream().map(WindowDto::new).collect(Collectors.toList());  // (6)
    }

    @PutMapping(path = "/{window_id}/switch")
    public WindowDto switchStatus(@PathVariable Long window_id) {
        Window window = windowDao.findById(window_id).orElseThrow(IllegalArgumentException::new);
        window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED : WindowStatus.OPEN);
        return new WindowDto(window);
    }

    @PostMapping // (8)
    public WindowDto create(@RequestBody WindowDto dto) {
        // WindowDto must always contain the window room
        Room room = dto.getRoom();
        Window window = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            window = windowDao.save(new Window(dto.getName(), dto.getWindowStatus(), room));
        } else {
            window = windowDao.getOne(dto.getId());  // (9)
            window.setWindowStatus(dto.getWindowStatus());
        }
        return new WindowDto(window);
    }

    @DeleteMapping(path = "/{window_id}")
    public void delete(@PathVariable Long window_id) {
        windowDao.deleteById(window_id);
    }
}