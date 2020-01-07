package osvlab.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    @GetMapping('/')
    def index() {
        return 'index'
    }

}
