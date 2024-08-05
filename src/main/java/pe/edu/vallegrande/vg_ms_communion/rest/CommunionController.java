package pe.edu.vallegrande.vg_ms_communion.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.vallegrande.vg_ms_communion.dto.CommunionAdminDto;
import pe.edu.vallegrande.vg_ms_communion.dto.CommunionUserDto;
import pe.edu.vallegrande.vg_ms_communion.model.Communion;
import pe.edu.vallegrande.vg_ms_communion.service.impl.CommunionAdminServiceImp;
import pe.edu.vallegrande.vg_ms_communion.service.impl.CommunionUserServiceImp;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/communions")
public class CommunionController {

    private final CommunionAdminServiceImp comunionService;
    private final CommunionUserServiceImp userComunionService;

    @Autowired
    public CommunionController(CommunionAdminServiceImp comunionService, CommunionUserServiceImp userComunionService) {
        this.comunionService = comunionService;
        this.userComunionService = userComunionService;
    }

    @PostMapping("/user")
    public Mono<ResponseEntity<Communion>> createCommunionFromUserDto(@ModelAttribute CommunionUserDto communionUserDto,
                                                                      @RequestPart("files") MultipartFile[] files) {
        return userComunionService.createCommunionFromUserDto(communionUserDto, files)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }


    //ADMIN
    @Autowired
    private CommunionAdminServiceImp adminService;

    //Listar todos desde admin
    @GetMapping("/total/admin")
    public Flux<Communion> getTotalCommunionsAsAdminDto() {
        return adminService.getAllCommunions();
    }

    //Listar APROBADOS desde admin
    @GetMapping("/approved/admin")
    public Flux<Communion> getApprovedCommunionsAsAdminDto() {
        return adminService.getApprovedCommunions();
    }

    //Listar RECHAZADOS desde admin
    @GetMapping("/rejected/admin")
    public Flux<Communion> getRejectedCommunionsAsAdminDto() {
        return adminService.getRejectedCommunions();
    }

    //Listar PENDIENTES desde admin
    @GetMapping("/pending/admin")
    public Flux<Communion> getPendingCommunionsAsAdminDto() {
        return adminService.getPendingCommunions();
    }

    //Listar por ID desde admin
    @GetMapping("/admin/{id}")
    public Mono<ResponseEntity<Communion>> getCommunionByIdAsAdminDto(@PathVariable String id) {
        return adminService.getCommunionById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    //Actualizar por ID al User Creado
    @PatchMapping("/admin/{id}")
    public Mono<ResponseEntity<Communion>> patchCommunionFromAdminDto(@PathVariable String id, @RequestBody CommunionAdminDto adminDto) {
        return adminService.patchCommunion(id, adminDto)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


}
