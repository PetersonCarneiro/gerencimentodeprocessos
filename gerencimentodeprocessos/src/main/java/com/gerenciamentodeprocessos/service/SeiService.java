package com.gerenciamentodeprocessos.service;

import com.gerenciamentodeprocessos.domain.sei.Sei;
import com.gerenciamentodeprocessos.dtos.SeiDTO;
import com.gerenciamentodeprocessos.repositories.SeiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SeiService {
    @Autowired
    private SeiRepository seiRepository;

    public SeiDTO saveSei(SeiDTO seiDTO){
        Sei sei = new Sei(seiDTO);
        Sei newSei = seiRepository.save(sei);
        return new SeiDTO(
                newSei.getId(),
                newSei.getCod(),
                newSei.getRequestingUnit(),
                newSei.getRequestingUnit(),
                newSei.getInvestiment(),
                newSei.getCodPdm(),
                newSei.getCatmat(),
                newSei.getCatser(),
                newSei.getCodSubClassCnae(),
                newSei.getDescriptionCnae(),
                newSei.getObject(),
                newSei.getNumberSei(),
                newSei.getUser()

        );

    }

    public List<SeiDTO> listSei(){
        return seiRepository.findAll().stream().map(sei ->
                new SeiDTO(
                        sei.getId(),
                        sei.getCod(),
                        sei.getRequestingUnit(),
                        sei.getRequestingUnit(),
                        sei.getInvestiment(),
                        sei.getCodPdm(),
                        sei.getCatmat(),
                        sei.getCatser(),
                        sei.getCodSubClassCnae(),
                        sei.getDescriptionCnae(),
                        sei.getObject(),
                        sei.getNumberSei(),
                        sei.getUser()
                )
        ).toList();
    }

    public Optional<SeiDTO> findById(String id){
        return seiRepository.findById(id).map(sei->
                new SeiDTO(
                        sei.getId(),
                        sei.getCod(),
                        sei.getRequestingUnit(),
                        sei.getRequestingUnit(),
                        sei.getInvestiment(),
                        sei.getCodPdm(),
                        sei.getCatmat(),
                        sei.getCatser(),
                        sei.getCodSubClassCnae(),
                        sei.getDescriptionCnae(),
                        sei.getObject(),
                        sei.getNumberSei(),
                        sei.getUser()
                )
        );
    }

    public SeiDTO updateSei(String id, SeiDTO seiDTO){
        return seiRepository.findById(id).map(sei -> {
            sei.setId(seiDTO.id());
            sei.setNumberSei(seiDTO.numberSei());
            sei.setUser(seiDTO.user());
            Sei updateSei = seiRepository.save(sei);
            return new SeiDTO(
                    updateSei.getId(),
                    updateSei.getCod(),
                    updateSei.getRequestingUnit(),
                    updateSei.getRequestingUnit(),
                    updateSei.getInvestiment(),
                    updateSei.getCodPdm(),
                    updateSei.getCatmat(),
                    updateSei.getCatser(),
                    updateSei.getCodSubClassCnae(),
                    updateSei.getDescriptionCnae(),
                    updateSei.getObject(),
                    updateSei.getNumberSei(),
                    updateSei.getUser()
            );
        }).orElseThrow(()-> new RuntimeException("Sei not found"));
    }

    public void deleteSei(String id){
        seiRepository.deleteById(id);
    }

    //Regra de negócio

    public List<SeiDTO> findByNumberSei(String numberSei){
        return seiRepository.findByNumberSei(numberSei).stream().
                map(sei->
                new SeiDTO(
                        sei.getId(),
                        sei.getCod(),
                        sei.getRequestingUnit(),
                        sei.getRequestingUnit(),
                        sei.getInvestiment(),
                        sei.getCodPdm(),
                        sei.getCatmat(),
                        sei.getCatser(),
                        sei.getCodSubClassCnae(),
                        sei.getDescriptionCnae(),
                        sei.getObject(),
                        sei.getNumberSei(),
                        sei.getUser()
                )
        ).toList();
    }

}
