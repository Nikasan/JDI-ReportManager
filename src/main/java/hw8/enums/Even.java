package hw8.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Even {
    TWO("2",2),
    FOUR("4",4),
    SIX("6",6),
    EIGHT("8",8);
    public final String even;
    public final Integer val;

}
