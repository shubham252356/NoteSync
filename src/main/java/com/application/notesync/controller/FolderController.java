package com.application.notesync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.notesync.entities.Folder;
import com.application.notesync.serviceImpl.FolderServiceImpl;

@RestController
@RequestMapping("/api/folders")
public class FolderController {

    @Autowired
    FolderServiceImpl folderService;

    @PostMapping
    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder) {
        Folder createdFolder = folderService.createFolder(folder);
        return ResponseEntity.ok(createdFolder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Folder> getFolderById(@PathVariable Long id) {
        return folderService.getFolderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/subfolders/{parentId}")
    public ResponseEntity<List<Folder>> getSubfolders(@PathVariable Long parentId) {
        List<Folder> subfolders = folderService.getSubfolders(parentId);
        return ResponseEntity.ok(subfolders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Folder> updateFolder(@PathVariable Long id, @RequestBody Folder folder) {
        folder.setId(id);
        Folder updatedFolder = folderService.updateFolder(folder);
        return ResponseEntity.ok(updatedFolder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFolder(@PathVariable Long id) {
        folderService.deleteFolder(id);
        return ResponseEntity.ok().build();
    }
}
