package osvlab.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import osvlab.model.Exp
import osvlab.service.ExpService

@Controller
@RequestMapping('/exp')
class ExpController {

    @Autowired
    ExpService expService

    @GetMapping
    def index(ModelMap modelMap) {
        modelMap.put('expList', this.expService.expDao.findAll())
        return 'exp/index'
    }

    @GetMapping('{id}')
    def show(@PathVariable('id') Integer id, ModelMap modelMap) {
        modelMap.put('exp', this.expService.expDao.findById(id).get())
        return 'exp/show'
    }

    @GetMapping('create')
    def create(ModelMap modelMap) {
        modelMap.put('exp', new Exp())
        return 'exp/edit'
    }

    @GetMapping('{id}/edit')
    def edit(@PathVariable('id') Integer id, ModelMap modelMap) {
        modelMap.put('exp', this.expService.expDao.findById(id).get())
        return 'exp/edit'
    }

    @PostMapping()
    def save(ExpInput input) {
        this.expService.saveFromInput(input)
        return 'redirect:/exp'
    }

}
