# Faircorp Backend
[Deployed Backend on Clever-Cloud](https://faircorp-alexandre-verdet.cleverapps.io/)

- Author : Alexandre Verdet
- Backend of the 2020 Web & Mobile Programing project for [EMSE's Computer Science Major](https://ci.mines-stetienne.fr/m-info/wmp/)
- Based on [Guillaume Ehret's course](https://dev-mind.fr/formations.html)

## Context

The goal of the 2020 Web & Mobile Programing project is to implement a fully functionnal Building management system (especially rooms, windows and heaters controllers).\
The project is composed of a [Java SpringBoot Backend server](https://github.com/averdet/faircorp-spring-app), an [Android Kotlin Application](https://github.com/averdet/faircorp-android-app) and a [VueJS Frontend server](https://github.com/averdet/faircorp-vue-app) interacting together. An extension of this project can be made with Arduinos Controlers in the [IoT course](https://ci.mines-stetienne.fr/m-info/iot/), in order to actually control devices.

## Project setup

Clone the repo and run

```bash
./gradlew bootRun
```

You can now access the backend on [localhost:8080](http://localhost:8080) or on the [Deployed server](https://faircorp-alexandre-verdet.cleverapps.io/)

## Project API

You can experiment with the API on [localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/) or on the [Deployed server](https://faircorp-alexandre-verdet.cleverapps.io/swagger-ui/)

### Buildings API

- GET `/api/buildings` findAll
- POST `/api/buildings` create
- GET `/api/buildings/{building_id}` findById
- DELETE `/api/buildings/{building_id}` delete

### Rooms API

- GET `/api/rooms` findAll
- POST `/api/rooms` create
- GET `/api/rooms/{room_id}` findById
- DELETE `/api/rooms/{room_id}` delete
- PUT `/api/rooms/{room_id}/switchHeaters` switchHeatersStatus
- PUT `/api/rooms/{room_id}/switchWindow` switchWindowStatus

### Windows API

- GET `/api/windows` findAll
- POST `/api/windows` create
- GET `/api/windows/{window_id}` findById
- DELETE `/api/windows/{window_id}` delete
- PUT `/api/windows/{window_id}/switch` switchStatus
- GET `/api/windows/building/{building_id}` findByRoomBuildingId
- GET `/api/windows/room/{room_id}`

### Heaters API

- GET `/api/heaters` findAll
- POST `/api/heaters` create
- GET `/api/heaters/{heater_id}` findById
- DELETE `/api/heaters/{heater_id}` delete
- PUT `/api/heaters/{heater_id}/{power}` setPower
- PUT `/api/heaters/{heater_id}/switch` switchStatus
- GET `/api/heaters/building/{building_id}` findByRoomBuildingId
- GET `/api/heaters/room/{room_id}` findByRoomId
