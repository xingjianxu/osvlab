package osvlab.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import osvlab.controller.ExpInput
import osvlab.dao.ExpDao
import osvlab.model.Exp

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class ExpService {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern('yyyy-MM-dd HH:mm:ss')

    @Autowired
    ExpDao expDao

    Exp saveFromInput(ExpInput input) {
        Exp exp = input.id ? this.expDao.findById(input.id).get() : new Exp()

        exp.title = input.title
        exp.comment = input.comment
        LocalDateTime[] range = input.seRange.split('~').collect {
            return LocalDateTime.parse(it.strip(), dateTimeFormatter)
        }

        exp.startedAt = range[0]
        exp.endedAt = range[1]

        this.expDao.save(exp)
    }

}
