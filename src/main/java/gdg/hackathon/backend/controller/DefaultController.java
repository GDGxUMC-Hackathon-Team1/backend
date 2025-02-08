package gdg.hackathon.backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DefaultController {
    @GetMapping
    /** 헬스 체크용  */
    public ResponseEntity<String> sayHello(@PathVariable(name = "path") String path) {
        return ResponseEntity.ok("Hello " + path + "!");
    }


}
