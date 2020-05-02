package com.cricket.cricketscore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OutputResponse {

    @JsonProperty("team-1")
    public String team1;

    @JsonProperty("team-2")
    public String team2;

    @JsonProperty("Winning team’s score:")
    public String winningScore;

    @JsonProperty("Round rotation:")
    public String roundRotation;



}
