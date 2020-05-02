package com.cricket.cricketscore.controller;


import com.cricket.cricketscore.model.OutputResponse;
import com.cricket.cricketscore.model.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.QueryParam;

@RestController
public class cricketController {

      RestTemplate restTemplate = new RestTemplate();

            @GetMapping("/matchdetails")
      public Object getDetailsByUniqueId( @QueryParam("uniqueId")Long uniqueId){


            String uri = "http://cricapi.com/api/cricketScore/?apikey=WmPJrX2s3KMyZVPFwlm1vxXLXKw1&unique_id="+uniqueId;


            Response response = restTemplate.getForObject(uri, Response.class);


            int index1 = response.getScore().indexOf(response.team1)+ response.team1.length();
            int index2 = response.getScore().indexOf(response.team2)+response.team2.length();

            int score1 = Integer.parseInt(response.getScore().substring(index1+1,response.getScore().indexOf("/")));

            int score2 = Integer.parseInt(response.getScore().substring(index2+1,response.getScore().lastIndexOf("/")));


            OutputResponse outputResponse = new OutputResponse();

            outputResponse.setTeam1(response.team1);
            outputResponse.setTeam2(response.team2);

            if(score1 > score2)
                  outputResponse.setWinningScore(response.getScore().substring(index1+1,response.getScore().indexOf("/")+2));
            else
                  outputResponse.setWinningScore(response.getScore().substring(index2+1,response.getScore().lastIndexOf("/")+2));

            return outputResponse;

      }

}
