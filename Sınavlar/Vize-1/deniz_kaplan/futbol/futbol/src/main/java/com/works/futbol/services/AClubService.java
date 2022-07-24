package com.works.futbol.services;


import com.works.futbol.entities.Aclub;
import com.works.futbol.entities.Player;
import com.works.futbol.repositories.AclubRepository;
import com.works.futbol.repositories.PlayerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AClubService {
    final AclubRepository aclubRepository;
    final PlayerRepository playerRepository;

    public AClubService(AclubRepository aclubRepository, PlayerRepository playerRepository) {
        this.aclubRepository = aclubRepository;
        this.playerRepository = playerRepository;
    }


    public void saveClub(){
        List<Player> player=playerRepository.findByIstekContainsIgnoreCaseOrderByAgeAsc("a");

        for (int i=0; i<15;  i++)
        {

          Aclub aclub=new Aclub();
          Player player1=new Player();
          player1= player.get(i);
          aclub.setPlayer(player1);
          aclubRepository.save(aclub);
        }
        
    }

    public void deleteCclub(){
        aclubRepository.deleteAll();
    }


    public ResponseEntity getall() {
        Map<String, Object> hm = new LinkedHashMap<>();
        Pageable pageable = PageRequest.of(0, 11 );
        hm.put("status", true);
        hm.put("users", aclubRepository.findAll());

        hm.put("as",aclubRepository.findByOrderByPlayer_AgeAsc(pageable));
        return new ResponseEntity(hm, HttpStatus.OK);

    }

    public ResponseEntity getAs() {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Player> player=playerRepository.findByIstekContainsIgnoreCaseOrderByAgeAsc("a");
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
        List<Player> player=playerRepository.findByIstekContainsIgnoreCaseOrderByAgeAsc("a");
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
