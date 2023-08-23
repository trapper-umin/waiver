package dev.waiver.com.dto.responses;

import dev.waiver.com.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailsDTOResp extends AbstractDTO {

    private String name;

    private int age;

    private String email;

    private int points;

    private int missedTasks;

    private int completedTasks;
}
