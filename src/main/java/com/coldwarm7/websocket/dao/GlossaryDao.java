package com.coldwarm7.websocket.dao;

import com.coldwarm7.websocket.model.Glossary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GlossaryDao  extends JpaRepository<Glossary,Integer> {
    Glossary findByEnglish(String english);

    @Query(value = "insert into glossary_table (english) value (?1)",nativeQuery = true)
    void addGlossary(String english);

}
