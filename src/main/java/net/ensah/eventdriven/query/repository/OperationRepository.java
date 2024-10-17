package net.ensah.eventdriven.query.repository;

import net.ensah.eventdriven.query.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
