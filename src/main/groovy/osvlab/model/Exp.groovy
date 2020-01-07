package osvlab.model

import javax.persistence.*
import java.time.LocalDateTime

@Entity
class Exp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    @Lob
    String title

    @Lob
    String comment

    LocalDateTime startedAt

    LocalDateTime endedAt

    @OneToMany(mappedBy = 'exp')
    @OrderBy('idx')
    List<Step> steps

    LocalDateTime updatedAt

}
