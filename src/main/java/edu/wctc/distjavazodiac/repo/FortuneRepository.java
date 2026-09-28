package edu.wctc.distjavazodiac.repo;

import edu.wctc.distjavazodiac.entity.Fortune;
import org.springframework.data.repository.CrudRepository;

public interface FortuneRepository extends CrudRepository<Fortune, Integer> {
}
