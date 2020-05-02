package com.cricket.cricketscore.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Response {

    public String stat;
    public String score;
    public String description;
    public String matchStarted;

    @JsonProperty("team-1")
    public String team1;

    @JsonProperty("team-2")
    public String team2;



}
