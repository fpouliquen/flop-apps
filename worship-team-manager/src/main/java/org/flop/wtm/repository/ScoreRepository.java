
package org.flop.wtm.repository;

import java.math.BigInteger;

import org.flop.wtm.domain.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScoreRepository extends MongoRepository<Score, BigInteger>, CustomScoreRepository {

}
