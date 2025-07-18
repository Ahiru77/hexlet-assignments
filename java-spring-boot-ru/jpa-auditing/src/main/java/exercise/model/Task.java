package exercise.model;

import jakarta.persistence.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

// BEGIN
@Entity
@Table(name = "tasks")
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter

public class Task {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
	
	private String title;
	private String description;
	
	@LastModifiedDate
    private LocalDate updatedAt;

    @CreatedDate
    private LocalDate createdAt;


}
// END
