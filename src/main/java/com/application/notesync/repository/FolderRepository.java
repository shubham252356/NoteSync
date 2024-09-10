package com.application.notesync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.notesync.entities.Folder;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findByParentFolderId(Long parentFolderId);
}
