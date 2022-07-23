package com.works.futbol.services;


import com.works.futbol.entities.Aclub;
import com.works.futbol.entities.Bclub;
import com.works.futbol.entities.Player;
import com.works.futbol.repositories.BclubRepository;
import com.works.futbol.repositories.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BClubService {

    final BclubRepository bclubRepository;
    final PlayerRepository playerRepository;

    public BClubService(BclubRepository bclubRepository, PlayerRepository playerRepository) {
        this.bclubRepository = bclubRepository;
        this.playerRepository = playerRepository;
    }


    public void saveClub(){
        List<Player> player=playerRepository.findByIstekContainsIgnoreCaseOrderByAgeAsc("b");

        for (int i=0; i<15;  i++)
        {
            Bclub bclub=new Bclub();
            Player player1=new Player();
            player1=  player.get(i);
            bclub.setPlayer(player1);
            bclubRepository.save(bclub);

        }

    }

    public void deleteCclub(){
        bclubRepository.deleteAll();
    }

    public ResponseEntity getall() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("users", bclubRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);

    }

    public ResponseEntity getAs() {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Player> player=playerRepository.findByIstekContainsIgnoreCaseOrderByAgeAsc("B");
        List<Player> asplayer=new ArrayList<>();

        for (int i=0; i<11;  i++)
        {

            asplayer.add(player.get(i));
        }
        hm.put("as",asplayer);

        return new ResponseEntity(hm, HttpStatus.OK);

    }

    public ResponseEntity getyedek() {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Player> player=playerRepository.findByIstekContainsIgnoreCaseOrderByAgeAsc("B");
        List<Player> asplayer=new ArrayList<>();

        for (int i=11; i<16;  i++)
        {

            asplayer.add(player.get(i));
        }
        hm.put("status",true);
        hm.put("yedek",asplayer);

        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
