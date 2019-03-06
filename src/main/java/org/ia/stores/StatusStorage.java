package org.ia.stores;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusStorage extends JpaRepository<Status, Long> {

}
