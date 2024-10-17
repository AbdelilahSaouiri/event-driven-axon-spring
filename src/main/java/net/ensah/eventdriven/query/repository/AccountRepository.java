package net.ensah.eventdriven.query.repository;

import net.ensah.eventdriven.query.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
