package univ.tuit.uschooladminbot.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "completedUser")
public class CompletedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_sequence")
    private Integer id;

    private Long userId;

    private String username;

    private String name;

    private String surname;

    private String age;

    private String phoneNumber;

    private String status;

    private String registrationTime;
}

