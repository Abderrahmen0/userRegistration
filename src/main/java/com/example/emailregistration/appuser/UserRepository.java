package com.example.emailregistration.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {
    Optional<AppUser> findByEmail(String email);

}
