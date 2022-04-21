package com.project.POSTerminal.controller;

import com.project.POSTerminal.dto.LoginWorkerRequestDto;
import com.project.POSTerminal.dto.LoginWorkerResponseDto;
import com.project.POSTerminal.jwt.JwtUtil;
import com.project.POSTerminal.model.Worker;
import com.project.POSTerminal.service.MyUserDetailService;
import com.project.POSTerminal.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("worker")

public class WorkerController {



    @Autowired
    WorkerService workerService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @GetMapping("/")
    public ResponseEntity<?> getWorkers(@RequestParam String year,@RequestParam String month) throws Exception{
        try {
            return new ResponseEntity<>(workerService.findThree(year, month), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("No match",HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginWorkerRequestDto authRequest) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                    authRequest.getPassword()));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        final UserDetails userDetails=myUserDetailService.loadUserByUsername(authRequest.getUsername());
        final String jwt=jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new LoginWorkerResponseDto(jwt));
    }
    @GetMapping("/getUserDetails")
    public ResponseEntity<?> getUsername(@RequestHeader(value="Authorization") String jwtHeader){
        try {
            String username = jwtUtil.extractUsername(jwtHeader.substring(7));

            return ResponseEntity.ok(workerService.findByUsername(username));
        }
        catch(Exception e){
            return new ResponseEntity<>("User doesn't exist",HttpStatus.BAD_REQUEST);
        }

    }


}
