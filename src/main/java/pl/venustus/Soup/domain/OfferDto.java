package pl.venustus.Soup.domain;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {

    private String name;
    private String url;
    private LocalDateTime dateTime;
}
