package com.coldwarm7.websocket.service;

import com.coldwarm7.websocket.dao.IntermediateDao;
import com.coldwarm7.websocket.model.Intermediate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntermediateService {
    @Autowired
    private IntermediateDao intermediateDao;

    public Intermediate findByUserIdAndGlossaryId(int user_id, int glossary_id){
        Intermediate intermediate = null;
        try {
            intermediate = intermediateDao.findByGlossary_idAndUser_id(user_id,glossary_id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return intermediate;
    }
    public void addIntermediate(int user_id,int glossary_id){
        Intermediate intermediate = findByUserIdAndGlossaryId(user_id, glossary_id);
        if (intermediate == null){
            intermediate = new Intermediate();
            intermediate.setGlossary_id(glossary_id);
            intermediate.setUser_id(user_id);
            intermediateDao.save(intermediate);
        }
    }
}
