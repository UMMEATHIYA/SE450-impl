package org.example.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;

public class GitHandler {
    public static void cloneRepository(String repositoryUrl, String localPath) throws GitAPIException {
        Git.cloneRepository()
                .setURI(repositoryUrl)
                .setDirectory(new File(localPath))
                .call();
    }
}

