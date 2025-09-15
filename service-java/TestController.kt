package cloudcomputing.service_java

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Brand new test from service-java!"
    }
}
