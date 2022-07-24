package com.works.futbol.services;

import com.works.futbol.entities.Player;
import com.works.futbol.repositories.AclubRepository;
import com.works.futbol.repositories.BclubRepository;
import com.works.futbol.repositories.PlayerRepository;
import com.works.futbol.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {
    final PlayerRepository playerRepository;
    final  AClubService aClubService;

    final BClubService bClubService;

    final BclubRepository bclubRepository;

    final AclubRepository aclubRepository;

    public PlayerService(PlayerRepository playerRepository, AClubService aClubService, BClubService bClubService, BclubRepository bclubRepository, AclubRepository aclubRepository) {
        this.playerRepository = playerRepository;

        this.aClubService = aClubService;
        this.bClubService = bClubService;
        this.bclubRepository = bclubRepository;
        this.aclubRepository = aclubRepository;
    }


    public ResponseEntity save(Player player) {
        Map<String, Object> hm = new LinkedHashMap<>();
        aClubService.deleteCclub();
        player.setPassword(Util.md5(player.getPassword()));
       Optional<Player>  player1=playerRepository.findByEmailIs(player.getEmail());
        if (player.getAge()>=18){

            if(player1.isPresent()){
                hm.put("status", false);
                hm.put("message", "farklı mail adresi giriniz.");
            }else{

                if(player.getIstek().toLowerCase().equals("a")){
                    aClubService.deleteCclub();
                    playerRepository.save(player);
                    aClubService.saveClub();

                    if(aclubRepository.existsByPlayer_EmailContainsIgnoreCase(player.getEmail())){
                        hm.put("message", "takıma girebilirsin");
                    }else{
                        hm.put("message", "takıma giremezsin");
                    }

                    hm.put("status", true);
                    hm.put("result", player);
                }else{
                    bClubService.deleteCclub();
                    playerRepository.save(player);
                    bClubService.saveClub();

                    if(bclubRepository.existsByPlayer_EmailContainsIgnoreCase(player.getEmail())){
                        hm.put("message", "takıma girebilirsin");
                    }else{
                        hm.put("message", "takıma giremezsin");
                    }


                    hm.put("status", true);
                    hm.put("result", player);
                }

            }
        }else{
            hm.put("status", false);
            hm.put("message", "yaşınız 18 den büyük olmalıdır.");
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getAll() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", playerRepository.findAll());

        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
