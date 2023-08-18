package dev.waiver.com.util.response;

import dev.waiver.com.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponseWithStatusAndDate<E extends AbstractDTO> {

    private HttpStatus status;

    private LocalDateTime time;

    private List<E> payload;
}
