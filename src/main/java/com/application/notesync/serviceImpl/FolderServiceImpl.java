package com.application.notesync.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.notesync.entities.Folder;
import com.application.notesync.repository.FolderRepository;

@Service
public class FolderServiceImpl {

    @Autowired
    FolderRepository folderRepository;

    public Folder createFolder(Folder folder) {
        return folderRepository.save(folder);
    }

    public Optional<Folder> getFolderById(Long id) {
        return folderRepository.findById(id);
    }

    public List<Folder> getSubfolders(Long parentFolderId) {
        return folderRepository.findByParentFolderId(parentFolderId);
    }

    public Folder updateFolder(Folder folder) {
        return folderRepository.save(folder);
    }

    public void deleteFolder(Long id) {
        folderRepository.deleteById(id);
    }
}
