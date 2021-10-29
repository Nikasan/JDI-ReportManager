package hw8.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Odds {
    ONE ("1",1),
    THREE("3",3),
    FIVE("5",5),
    SEVEN("7",7);

    public String odds;
    public Integer value;

}
