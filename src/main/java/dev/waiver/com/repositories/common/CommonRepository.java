package dev.waiver.com.repositories.common;

import dev.waiver.com.models.common.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository <E extends AbstractEntity> extends JpaRepository<E, Integer> {
}
