package pl.venustus.Soup.domain;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {

    private String name;
    private String url;
}
