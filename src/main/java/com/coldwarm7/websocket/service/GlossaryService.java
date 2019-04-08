package com.coldwarm7.websocket.service;

import com.coldwarm7.websocket.dao.GlossaryDao;
import com.coldwarm7.websocket.dao.IntermediateDao;
import com.coldwarm7.websocket.model.Glossary;
import com.coldwarm7.websocket.model.Intermediate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GlossaryService {
    @Autowired
    private GlossaryDao glossaryDao;
    @Autowired
    private IntermediateDao intermediateDao;

    public Glossary findByEnglish(String english){
        Glossary glossary = null;
        try {
            glossary = glossaryDao.findByEnglish(english);
        }catch (Exception e){
            e.printStackTrace();
        }
        return glossary;
    }
    public void addGlossary(String english){
        Glossary glossary = findByEnglish(english);
        if (glossary == null){
            glossary = new Glossary();
            glossary.setEnglish(english);
            glossaryDao.save(glossary);
        }
    }
    public List<Optional<Glossary>> findByUserId(int user_id){
        List<Intermediate> intermediates = null;
        try {
            intermediates = intermediateDao.findByUser_id(user_id);
        }catch (Exception e){
            e.printStackTrace();
        }

        List<Optional<Glossary>> glossaries = new ArrayList<>();
        if (intermediates == null){
            return glossaries;
        }
        for (Intermediate i :intermediates){
            glossaries.add(glossaryDao.findById(i.getGlossary_id()));
        }
        return glossaries;
    }
}
