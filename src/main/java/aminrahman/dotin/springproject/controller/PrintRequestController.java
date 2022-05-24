package aminrahman.dotin.springproject.controller;

import aminrahman.dotin.springproject.aspect.ExecuteTime;
import aminrahman.dotin.springproject.entity.PrintPK;
import aminrahman.dotin.springproject.entity.PrintRequest;
import aminrahman.dotin.springproject.service.PrintRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/print")
public class PrintRequestController {

    @Autowired
    private PrintRequestService service;

    @GetMapping("/get/{ip-address}/{branch-code}")
    @ResponseBody
    @ExecuteTime
    public ResponseEntity<PrintRequest> get(@PathVariable("ip-address") String ipAddress, @PathVariable("branch-code") String branchCode) {
        return new ResponseEntity<>(service.getPrintRequestById(PrintPK.builder().ipAddress(ipAddress).branchCode(branchCode).build()), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    @ResponseBody
    @ExecuteTime
    public ResponseEntity<List<PrintRequest>> getAll() {
        return new ResponseEntity<>((List<PrintRequest>) service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    @ResponseBody
    @ExecuteTime
    public ResponseEntity<PrintRequest> post(@RequestBody PrintRequest printRequest) {
        return new ResponseEntity<>(service.saveRecord(printRequest), HttpStatus.OK);
    }

    @PatchMapping("/patch")
    @ResponseBody
    @ExecuteTime
    public ResponseEntity<PrintRequest> patch(@RequestBody PrintRequest printRequest) {
        return new ResponseEntity<>(service.patch(printRequest), HttpStatus.OK);
    }

    @PutMapping("/put")
    @ResponseBody
    @ExecuteTime
    public ResponseEntity<PrintRequest> put(@RequestBody PrintRequest printRequest) {
        return new ResponseEntity<>(service.update(printRequest), HttpStatus.OK);
    }
}
