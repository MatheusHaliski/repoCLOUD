package cloudcomputing.service_java

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/java")
class HelloController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello from service-java!"
    }
}
