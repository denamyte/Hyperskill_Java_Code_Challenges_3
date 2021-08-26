package task;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PostMapping("/api/products")
    ResponseEntity<Request> getProducts(@RequestBody Request request) {
        return ResponseEntity.ok(request);
    }
}

class Request {
    public String id;
    public String name;
    public String price;
}
