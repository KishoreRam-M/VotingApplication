package com.krm.VotingApplication.Controller;

import com.krm.VotingApplication.Model.Poll;
import com.krm.VotingApplication.Repo.PollRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> createPoll(Poll poll) {
        try {
            return ResponseEntity.ok(repo.save(poll));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();

        }
    }
}
