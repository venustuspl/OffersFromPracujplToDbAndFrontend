package pl.venustus.Soup.domain;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OffersDto {

    private String name;
    private String url;
}
