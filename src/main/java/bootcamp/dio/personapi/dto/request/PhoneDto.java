package bootcamp.dio.personapi.dto.request;

import bootcamp.dio.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDto {

        private long id;

        @Enumerated(EnumType.STRING)
        private PhoneType type;

        private String number;

}
