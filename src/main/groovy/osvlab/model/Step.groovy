package osvlab.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.ManyToOne

@Entity
class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    @ManyToOne
    Exp exp

    Integer idx

    @Lob
    String comment
}
