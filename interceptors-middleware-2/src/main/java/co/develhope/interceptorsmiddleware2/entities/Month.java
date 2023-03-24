package co.develhope.interceptorsmiddleware2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Month {
    int monthNumber;
    String italianName;
    String englishName;
    String germanName;
}