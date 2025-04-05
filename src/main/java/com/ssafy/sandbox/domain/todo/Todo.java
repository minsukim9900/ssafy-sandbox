package com.ssafy.sandbox.domain.todo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todos")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private Boolean completed;

    /**
     * 생성용 정적 팩토리 메서드.
     */
    public static Todo create(String content) {
        return Todo.builder()
                .content(content)
                .completed(false)
                .build();
    }

    /**
     * 완료 여부를 반전시킵니다.
     */
    public void toggleCompleted() {
        this.completed = !this.completed;
    }
}
