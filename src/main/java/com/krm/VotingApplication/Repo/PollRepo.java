package com.krm.VotingApplication.Repo;

import com.krm.VotingApplication.Model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepo extends JpaRepository<Poll,Long> {

}
