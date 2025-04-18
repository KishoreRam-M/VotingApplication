package com.krm.VotingApplication.Controller;

import com.krm.VotingApplication.Model.Poll;
import com.krm.VotingApplication.Repo.PollRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/polls")
@RequiredArgsConstructor
public class PollController {

    private final PollRepo repo;

    @GetMapping
    public ResponseEntity<List<Poll>> getAllPolls() {
        try {
            return ResponseEntity.ok(repo.findAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllPollById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(repo.findById(id));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();

        }
    }
}
