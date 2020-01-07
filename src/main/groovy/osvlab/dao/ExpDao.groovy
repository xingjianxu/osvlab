package osvlab.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import osvlab.model.Exp

@Repository
interface ExpDao extends JpaRepository<Exp, Integer> {
}
