package com.sharad.ridersspot.controller;

import com.sharad.ridersspot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("/frames")
//    ResponseEntity<FrameDTO> addFrame(@RequestBody FrameDTO frameDTO) throws IdAlreadyExistsException {
//        FrameDTO addedFrameDto = frameService.addFrame(frameDTO);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("desc", "Added a frame");
//        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(addedFrameDto);
//    }

}
