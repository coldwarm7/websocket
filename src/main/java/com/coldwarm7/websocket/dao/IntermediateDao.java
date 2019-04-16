package com.coldwarm7.websocket.dao;

import com.coldwarm7.websocket.model.Intermediate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IntermediateDao extends JpaRepository<Intermediate,Integer> {

    @Query("select a from Intermediate a where a.user_id=?1 and a.glossary_id=?2")
    Intermediate findByGlossary_idAndUser_id(int user_id,int glossary_id);

    @Query("select a from Intermediate a where a.user_id=?1")
    List<Intermediate> findByUser_id(int user_id);

    @Modifying
    @Query("delete from Intermediate a where a.user_id=?1 and a.glossary_id=?2")
    void deleteByUser_idAndGlossary_id(int user_id,int glossary_id);
}
