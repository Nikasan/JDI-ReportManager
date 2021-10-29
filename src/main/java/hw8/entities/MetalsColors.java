package hw8.entities;


import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MetalsColors {
    @SerializedName("summary") //can change name
    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;
    }