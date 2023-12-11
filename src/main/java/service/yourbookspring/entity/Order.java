package service.yourbookspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date date;
    private Double totalSum;
    private String status;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "_user",
//            joinColumns = { @JoinColumn(name = "id") },
//            inverseJoinColumns = { @JoinColumn(name = "id") }
//    )
//    Set<Book> books = new HashSet<>();

}
